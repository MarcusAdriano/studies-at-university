/**
 * Created by Marcus Adriano, 2017
 * <a href="mailto:marcusadriano.pereira@gmail.com" target="_top">send an email</a>
 */
#include "include/dbms.h"

#include <string.h>

#define REOPEN_FILE_FACTOR 100

/// LOCAL FUNCTIONS ========================================

/**
 * Read metadata
 * @param ref
 */
void read_model(dbms_t* ref) {
    FILE* fd = fopen(strcat(ref->name, ".model"), "r");

    if (fd == NULL) {
        fprintf(stderr, "Metadata table not found!");
        exit(1);
    }

    ref->model = (model_t*) malloc(sizeof(model_t));
    ref->model->name = (char**) malloc(sizeof(char*));
    ref->model->type = (unsigned short*) malloc(sizeof(unsigned short));

    char* line = NULL, *naux = NULL, *taux = NULL;
    int nlines = 0, i, j;
    size_t len = 0;


    for ( i = 0; (getline(&line, &len, fd)) != EOF ; i++, nlines++) {
        naux = strtok(line, ":");
        taux = strtok(NULL, ":");

        // allocate space for new data type
        if (nlines > 0) {
            ref->model->name = (char **) realloc(ref->model->name, (nlines) * sizeof(char *));
            ref->model->type = realloc(ref->model->type, (nlines) * sizeof(unsigned short));
        }

        // remove  break line characters Windows \r\n or Linux \n
        for (j = 0; j < strlen(taux); j++) {
            if (taux[j] == '\n' || taux[j] == '\r') {
                taux[j] = '\0';
                break;
            }
        }

        ref->model->name[nlines] = malloc(strlen(naux) + 1);
        strcpy(ref->model->name[nlines], naux);

        if (strcmp("text", taux) == 0) {
            ref->model->type[nlines] = 0;
        } else if (strcmp("int", taux) == 0) {
            ref->model->type[nlines] = 1;
        } else {
            printf("Type of data not supported");
        }
    }

    ref->model->nfields = nlines;
    ref->name[strlen(ref->name) - 6] = '\0'; // removes .model extension from the table name

    // free space and close the file
    free(line);
    fclose(fd);
}

/**
 * Verify if exists a database with <b>name</b>. For negative case, so
 * create new database file.
 * @param name of the database
 * @return 0 when database is created with success<br>
 *         1 when there is an error to create new database.
 */
int file_create_empty(char *name) {
    FILE *f = fopen(name, "r+a"); // open file for read
    int r = f == NULL;            // verify if file is null

    if (f != NULL) {
        fclose(f);
    }

    if (r) {                         // file not exists => create empty file
        FILE *f = fopen(name, "wb"); // create an empty file
        fclose(f);
    }
    return r;
}

/**
 * Add a record on the records list
 * @param db
 * @param rec
 */
void add_record(dbms_t *db, record_t* rec) {
    record_t* raux = db->records;
    if (db->records == NULL) {
        db->records = rec;
    } else {
        while (raux->next != NULL) {
            raux = raux->next;
        }
        raux->next = rec;
    }

    db->nentry ++;
}

/**
 * Load record's page
 * @param db the database reference
 * @param page page to read
 */
void load_records_from_page(dbms_t *db, page_t *page) {
    // variables
    record_t *raux;     // record helper
    field_t *faux;      // field helper
    char *textaux;      // helper for text fields
    int i, j, intaux;   // helper for int fields

    for (i = 0; i < page->nentry; i++) {
        // create empty record
        raux = record_create_empty();

        // move to record start position
        fseek(db->fd, page->dir[i] + (page->id - 1) * PAGE_SIZE, SEEK_SET);

        // set record id
        raux->id = page->dir[i]; // id is the position in data file

        // set page id of record
        raux->pageId = page->id;

        // read record header
        raux->header = (unsigned short*) malloc(sizeof(db->model->nfields));
        fread(raux->header, sizeof(unsigned short), db->model->nfields, db->fd);

        for (j = 0; j < db->model->nfields; j++) {
            size_t size = raux->header[j]; // get size of the field j

            if (size == 0) { // is an INT with size 4 bytes
                fread(&intaux, sizeof(unsigned short), 1, db->fd);
                faux = field_create_int(intaux);
            } else { // is a varchar with size header[j] bytes
                textaux = (char*) malloc(size);
                fread(textaux, sizeof(char), size, db->fd);
                faux = field_create_varchar_v1(textaux, raux->header[j]);
                free(textaux);
            }

            record_add_field_v2(raux, faux);
            free(faux);
        }

        add_record(db, raux); // add record on the list
    }
}

/**
 * Load all record in the page
 * @param db
 */
void load_records(dbms_t *db) {
    int i, j;
    page_t *paux;

    for (i = 1; i <= db->buffer->npages; i++) {
        paux = buffer_get_page_by_id(db->buffer, i);
        if (paux != NULL) {
            load_records_from_page(db, paux);
        }
    }
}
//}

/// END LOCAL FUNCTIONS

int db_open(char *name, dbms_t **db) {
    dbms_t* ref = (dbms_t*) malloc(sizeof(dbms_t));

    if (ref == NULL) {
        return 0;
    }

    file_create_empty(name);
    ref->fd = fopen(name, "r+b");
    if (ref->fd == NULL) {
        fprintf(stderr, "An error ocurred when open db file");
        free(ref);
        return 0;
    }

    // reset number of entry
    ref->nentry = 0;

    // start buffer
    buffer_init(&ref->buffer, ref->fd);

    // records NULL
    ref->records = NULL;

    // table name
    ref->name = (char*) malloc(sizeof(char) * strlen(name));
    strcpy(ref->name, name);

    // read table model
    read_model(ref);

    // load records
    load_records(ref);

    // return database reference
    *db = ref;
    return 1;
}

int db_insert_v1(dbms_t *db, record_t *rec) {
    if (db == NULL || rec == NULL) {
        return 0;
    }

    // TODO lock and unlock files
    // verify record and model, is it similar?
    // get fields reference
    field_t* faux;
    faux = rec->fields;
    int i;

    for (i = 0; faux != NULL; faux = faux->next, i++) {
        if (db->model->type[i] != faux->type) {
            return -2;
        }
    }

    int r;
    if (!(r = buffer_insert_v1(db->buffer, rec, db->fd))) {
        fprintf(stderr, "[db_insert_v1] Error to insert record! Error Code = %d\n", r);
        return 0;
    }

    // update number of entry
    db->nentry++;
    // add record to list
    add_record(db, rec);


    // reopen file?
    if (db->nentry % REOPEN_FILE_FACTOR == 0) {
        fclose(db->fd);
        db->fd = fopen(db->name, "r+b");
    }

    return 1;
}

//int db_delete_v1(dbms_t* db, record_t** record) {
//    if (db == NULL || record == NULL || *record == NULL) {
//        return 0;
//    }
//
//    // variables
//    int i = 0, j;
//    unsigned int *new_dir = NULL;
//    record_t* before = NULL, *aux = NULL;
//
//    // is range of id correct?
//    if ((*record)->id <= 0 || (*record)->id >= 4095) {
//        return -1;
//    }
//
//    // search record
//    aux = db->records;
//    for (; aux != NULL; aux = aux->next) {
//        if ((*record)->id == aux->id) {
//
//            // is first record?
//            if (before == NULL) {
//                db->records = aux->next;
//                break;
//            }
//
//            before->next = aux->next;
//            break;
//        }
//        before = aux;
//    }
//
//    // update page header
//    new_dir = (unsigned int*)
//            malloc((db->page->nentry - 1) * sizeof(unsigned int));
//
//    // i = position in current directory, j = position in new directory
//    for (i = 0, j = 0; i < db->page->nentry; i++) {
//        // copy directory, except position to delete
//        if ((*record)->id != db->page->dir[i]) {
//            new_dir[j] = db->page->dir[i];
//            j++;
//        }
//    }
//
//    free(db->page->dir);
//    db->page->nentry--;
//
//    // new directory
//    db->page->dir = (unsigned int*)
//            malloc(sizeof(unsigned int) * db->page->nentry);
//
//    // copy new directory
//    memcpy(db->page->dir, new_dir, sizeof(unsigned int) * db->page->nentry);
//
//    // free aux variable
//    free(new_dir);
//
//    // destroy record
//    record_destroy(record);
//
//    // write header of page
//    page_write_header(db);
//
//    return 1;
//}

int db_update_v1(dbms_t* db, record_t* record){
    if (db == NULL || record == NULL) {
        return 0;
    }

    return buffer_update_v1(db->buffer, record, db->fd);
}

