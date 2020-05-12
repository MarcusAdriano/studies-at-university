/**
 * Created by Marcus Adriano, 2017
 * <a href="mailto:marcusadriano.pereira@gmail.com" target="_top">send an email</a>
 */
#include "include/buffer_manager.h"

// LOCAL FUNCTIONS

page_t *buffer_get_last_page(buffer_t *buffer) {
    return buffer->pages[buffer->npages - 1];
}

/**
 * Append new page on the buffer
 * @param buffer where append new page
 */
void buffer_append_page(buffer_t *buffer) {
    // allocate new page
    page_t *new_page = page_create_empty();
    int factor = 0, lastFactor = 0;

    // set id!
    new_page->id = (unsigned short) (buffer_get_last_page(buffer)->id + 1);

    // is necessary allocate space for buffer?
    factor = (buffer->npages + 1) / BUFFER_ALLOCATOR_SIZE;
    lastFactor = (int) buffer->npages / BUFFER_ALLOCATOR_SIZE;

    if (factor > lastFactor) {
        buffer->pages = (page_t**) realloc(buffer->pages, sizeof(page_t*) * (BUFFER_ALLOCATOR_SIZE * (factor + 1)));
        if (buffer->pages == NULL) {
            // what do when not has more memory to allocate???
            // TODO
        }
    }

    // save new page
    buffer->pages[(int) buffer->npages] = new_page;
    buffer->npages++;
}

// END LOCAL FUNCTIONS

int buffer_init(buffer_t **buffer, FILE *fd) {
    if (fd == NULL) {
        fprintf(stderr, "[buffer_init] File is NULL!\n");
        return 0;
    }

    // variables
    buffer_t *ref = NULL;
    page_t **pages = NULL, *paux;
    int i, allocatorFactor = 0, lastAllocator = 0;

    // allocate pages and buffer
    ref = (buffer_t*) malloc(sizeof(buffer_t));
    ref->npages = 0;
    
    pages = (page_t**) malloc(sizeof(page_t*) * BUFFER_ALLOCATOR_SIZE);

    // load pages
    for (i = 1; ; i++) {
        paux = page_read(i, fd); // read pages when exists
        if (paux == NULL) {      // page i don't exist! Break loop
            break;
        }

        allocatorFactor = (i - 1) / BUFFER_ALLOCATOR_SIZE;
        if (allocatorFactor > lastAllocator) {
            pages = (page_t**) realloc(pages, sizeof(page_t*) * (BUFFER_ALLOCATOR_SIZE * (allocatorFactor + 1)));
            if (pages == NULL) {
                // what do when not has more memory to allocate???
                // TODO
                exit(5);
            }
        }
        pages[i - 1] = paux;
        ref->npages++;           // increment number of pages
    }

    // exist page? When i = 1, then don't exist any page!
    // make an empty page!
    if (i == 1) {
        paux = page_create_empty();
        paux->id = 1;

        pages[0] = paux;
        page_write(pages[0], fd); // write first page
        ref->npages ++;
    }

    // set pointers
    ref->pages = pages;
    *buffer = ref;
    return 1;
}

page_t* buffer_get_page_by_id(buffer_t *buffer, int id) {
    // invalid or buffer is null
    if (buffer == NULL || id <= 0) {
        return NULL;
    }

    // verify if page exist
    if (id > buffer->npages) {
        return NULL;
    }

    // retrieve target page!
    return buffer->pages[id - 1];
}

int buffer_insert_v1(buffer_t *buffer, record_t *rec, FILE *fd) {
    // variables
    long seek = 0;
    page_t *lastPage;
    field_t *faux = NULL;

    // retrieve last page
    lastPage = buffer_get_last_page(buffer);

    // is necessary add new page?
    if (!page_has_space(lastPage, rec)) {
        buffer_append_page(buffer);               // add new page
        return buffer_insert_v1(buffer, rec, fd); // and try again =D
    }

    // calculate where is location for new record
    seek = page_seek_free_space(lastPage, rec);

    // set record id, is the value of the position in data file of
    // the record
    rec->id = (unsigned short) (seek - (lastPage->id - 1) * PAGE_SIZE);

    // move file cursor to free space
    fseek(fd, seek, SEEK_SET);

    // write header of file
    fwrite(rec->header, sizeof(unsigned short), rec->nfields, fd);

    // write field per field
    for (faux = rec->fields; faux != NULL; faux = faux->next) {
        fflush(fd);
        fwrite(field_get_value(faux), faux->length, 1, fd);
    }

    // up a new record
    lastPage->nentry++;

    if (lastPage->nentry == 1) {                // verify it is the first entry
        lastPage->dir = (unsigned short*) malloc(sizeof(unsigned short)); // allocate directory
    } else {
        lastPage->dir = (unsigned short*) realloc(lastPage->dir, sizeof(unsigned short) * lastPage->nentry);
    }

    lastPage->dir[lastPage->nentry - 1] = rec->id; // the record is in the last free space pointer

    // set page id on record
    rec->pageId = lastPage->id;

    // write changes
    page_write(lastPage, fd);
    return 1;
}

// Created by Lucas Felipe
int buffer_update_v1(buffer_t *buffer, record_t *rec, FILE *fd) {
    if (buffer == NULL || rec == NULL || fd == NULL) {
        return 0;
    }

    // is range of id correct?
    if (rec->id <= 0 || rec->id >= 4095) {
        return -1;
    }

    // variables
    field_t* field = NULL;
    page_t *page = NULL;
    long seekPosition = 0;

    // retrieve target page and verify if is valid!
    page = buffer_get_page_by_id(buffer, rec->pageId);
    if (page == NULL) {
        return -2;
    }

    // find record on page
    seekPosition = PAGE_SIZE * (page->id - 1) + (rec->id + rec->nfields * sizeof(unsigned short));
    fseek(fd, seekPosition, SEEK_SET);

    for (field = rec->fields; field != NULL; field = field->next) {
        fflush(fd);
        fwrite(field_get_value(field), field->length, 1, fd);
    }
    return 1;
}

