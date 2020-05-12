/**
 * Created by Marcus Adriano, 2017
 * <a href="mailto:marcusadriano.pereira@gmail.com" target="_top">send an email</a>
 */
#include <stdlib.h>
#include "include/page.h"

page_t *page_create_empty() {
    page_t *ref = (page_t*) malloc(sizeof(page_t));
    ref->dir = NULL;
    ref->nentry = 0;
    ref->id = 0;
}

int page_has_space(page_t *page, record_t *record) {
    // page is empty, then there are space!
    if (page->nentry == 0 && record_get_length(record) < PAGE_SIZE) {
        return 1;
    }

    // calculate total space with + 1 entry
    long free, headerSpace = (long)
                      sizeof(unsigned short) + // # entry on page
                      sizeof(unsigned short) * (page->nentry + 1); // # pointers on directory

    // free space in bytes
    free = page->dir[page->nentry - 1] - headerSpace;

    // fetch length of record + directory length
    size_t rec_len = record_get_length(record);
    rec_len += sizeof(unsigned short) * record->nfields;

    return free > 0 && (rec_len - free) > 0;
}

long page_seek_free_space(page_t *page, record_t *rec) {
    long seek = 0;

    // calculate seek position
    seek = (long) (page->id - 1) * PAGE_SIZE; // move to page start
    if (page->nentry == 0) {
        seek += PAGE_SIZE - 1;
    } else {
        seek += page->dir[page->nentry - 1];
    }

    // add size of record + size of header of record on seek
    seek -= (long) record_get_length(rec) + sizeof(unsigned short) * rec->nfields;
    return seek;
}

void page_write(page_t *page, FILE *fd) {
    if (page == NULL) {
        fprintf(stderr, "[page_write] invalid id!\n");
        return;
    }

    if (fd == NULL) {
        fprintf(stderr, "[page_write] file is NULL!\n");
        return;
    }

    long seek = (long) (page->id - 1) * PAGE_SIZE;

    fseek(fd, seek, SEEK_SET);

    // write changes
    // write number of entry of the page
    fwrite(&page->nentry, sizeof(unsigned short), 1, fd);

    // write directory
    fwrite(page->dir, sizeof(unsigned short), page->nentry, fd);

    // flush file
    fflush(fd);
}

page_t *page_read(int id, FILE *fd) {
    if (id <= 0) {
        fprintf(stderr, "[page_read] invalid id!\n");
        return NULL;
    }

    if (fd == NULL) {
        fprintf(stderr, "[page_read] file is NULL!\n");
        return NULL;
    }

    // ref page to return
    page_t *ref = page_create_empty();

    // seek to target page
    fseek(fd, (long) (id - 1) * PAGE_SIZE, SEEK_SET);

    // read number of entry
    if (fread(&ref->nentry, sizeof(unsigned short), 1, fd) == 0) {
        fprintf(stderr, "[page_read] the page of id %d don't exist!\n", id);
        free(ref);
        return NULL;
    }

    // page exist
    if (ref->nentry > 0) {
        ref->dir = (unsigned short*) malloc(sizeof(unsigned short) * ref->nentry);
    }

    // read directory of page
    fread(ref->dir, sizeof(unsigned short), ref->nentry, fd);
    ref->id = (unsigned short) id;
    return ref;
}
