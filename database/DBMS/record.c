/**
 * Created by Marcus Adriano, 2017
 * <a href="mailto:marcusadriano.pereira@gmail.com" target="_top">send an email</a>
 */
#include "include/record.h"

#include <stdint.h>
#include <string.h>

/**
 * Update header of a record when new record was add
 * @param record
 */
void update_header_add(record_t *record) {
    if (record->header == NULL) {
        record->header = (unsigned short*) malloc(sizeof(unsigned short) * record->nfields);

    } else {
        record->header = (unsigned short*) realloc(record->header, sizeof(unsigned short) * record->nfields);
    }

    field_t* aux = record->fields;
    int i;
    for(i = 0; aux != NULL; i++, aux = aux->next) {
        if (aux->type == FIELD_INT) {
            record->header[i] = 0;
        } else {
            record->header[i] = aux->length;
        }
    }
}

record_t* record_create_empty() {
    record_t* rec = (record_t*) malloc(sizeof(record_t));
    rec->fields = NULL;
    rec->nfields = 0;
    rec->header = NULL;
    rec->id = 0;
    rec->pageId = 0;
    rec->next = NULL;
    return rec;
}

void record_add_field(record_t *record, const field_t *field, int flag) {
    // copy field data
    field_t* aux, *f = (field_t*) malloc(sizeof(field_t));
    f->length = field->length;
    f->value = field->value;
    f->type = field->type;
    f->next = NULL;

    if (record->nfields == 0) {
        record->fields = f;
    } else {
        aux = record->fields;
        while (aux->next != NULL) {
            aux = aux->next;
        }

        aux->next = f;
    }
    record->nfields++;

    // update header?
    if (flag == 1) {
        update_header_add(record);
    }
}

void record_add_field_v1(record_t *rec, const field_t *f) {
    record_add_field(rec, f, 1);
}

void record_add_field_v2(record_t* rec, const field_t* f) {
    record_add_field(rec, f, 0);
}

int record_get_int(record_t* record, int index, int* result) {
    if (record == NULL) {
        return -1;
    }

    if (index >= record->nfields) {
        return -2;
    }

    int i;
    field_t* aux = record->fields;

    for (i = 0; i < index; i++) {
         aux = aux->next;
    }

    if (aux->type != FIELD_INT) {
        return -3;
    }

    *result = (int)(intptr_t) *aux->value.i;
    return 1;
}

int record_get_string(record_t* record, int index, char* result) {
    if (record == NULL) {
        return -1;
    }

    if (index >= record->nfields) {
        return -2;
    }

    int i;
    field_t* aux = record->fields;

    for (i = 0; i < index; i++) {
        aux = aux->next;
    }

    if (aux->type != FIELD_VARCHAR) {
        return -3;
    }

    strcpy(result, aux->value.s);
    return 1;
}

int record_set_string(record_t* record, int index, char* src){
    if (record == NULL) {
        return -1;
    }

    if (index >= record->nfields) {
        return -2;
    }

    int i;
    field_t* aux = record->fields;

    for (i = 0; i < index; i++) {
        aux = aux->next;
    }

    if (aux->type != FIELD_VARCHAR) {
        return -3;
    }

    if (record->header[index] <= strlen(src)){
        return -4;
    }

    strcpy(aux->value.s, src);
    return 1;
}

int record_set_int(record_t* record, int index, int value) {
    if (record == NULL) {
        return -1;
    }

    if (index >= record->nfields) {
        return -2;
    }

    int i;
    field_t* aux = record->fields;

    for (i = 0; i < index; i++) {
        aux = aux->next;
    }

    if (aux->type != FIELD_INT) {
        return -3;
    }

    *aux->value.i = value;
    return 1;
}

size_t record_get_length(record_t*record) {
    if (record == NULL) {
        return 0;
    }

    size_t size = 0;
    field_t* first = record->fields;

    while (first != NULL) {
        size += first->length;
        first = first->next;
    }

    return size;
}

int record_equals(record_t* r1, record_t* r2) {
    if (r1->id == r2->id && r1->pageId == r2->pageId &&
            r2->nfields == r1->nfields) {

        field_t* aux1 = r1->fields, * aux2 = r2->fields;
        int i;
        for (; aux1 != NULL; aux1 = aux1->next, aux2 = aux2->next) {
            if (field_equals(aux1, aux2) == 0) {
                return 0;
            }
        }
    }

    return 1;
}

void record_destroy(record_t**record) {
    record_t* next = NULL;

    if (record == NULL || (*record) == NULL) {
        return;
    }

    field_t* faux = (*record)->fields;

    while (faux != NULL) {
        // destroy retrieve the next field of the field list
        field_destroy(&faux);
    }

    // retrieve the next record
    next = (*record)->next;

    free((*record));
    *record = next;
}