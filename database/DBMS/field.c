/**
 * Created by Marcus Adriano, 2017
 * <a href="mailto:marcusadriano.pereira@gmail.com" target="_top">send an email</a>
 */
#include "include/field.h"

#include <string.h>

field_t* field_create_int(const int value) {
    field_t* f = (field_t*) malloc(sizeof(field_t));

    // set values
    f->type = FIELD_INT;
    f->length = sizeof(int);
    f->next = NULL;

    // allocate nfields for int
    f->value.i = (int*) malloc(sizeof(int));
    *f->value.i = value;
    return f;
}

field_t* field_create_varchar(const char* value) {
    field_t* f = (field_t*) malloc(sizeof(field_t));

    // set values
    f->type = FIELD_VARCHAR;
    f->length = strlen(value) + 1;
    f->next = NULL;

    f->value.s = malloc(f->length);
    strcpy(f->value.s, value);
    return f;
}

field_t* field_create_varchar_v1(const char* value, int len) {
    field_t* f = (field_t*) malloc(sizeof(field_t));

    // set values
    f->type = FIELD_VARCHAR;
    f->length = len;
    f->next = NULL;

    f->value.s = malloc(f->length);

    // verify if the len is valid and if not clean and return NULL
    if (f->length <= strlen(value)) {
        free(f->value.s);
        free(f);
        return NULL;
    }

    strcpy(f->value.s, value);
    return f;
}

void* field_get_value(field_t *field) {
    if (field->type == FIELD_INT) {
        return (void*)(__intptr_t) field->value.i;
    } else {
        return (void*) field->value.s;
    }
}

int field_equals(field_t* f1, field_t* f2) {
    if (f1->type == f2->type && f1->length == f2->length) {
        if (f1->type == FIELD_INT) {
            if (*f1->value.i == *f2->value.i) {
                return 1;
            }
        } else if (f1->type == FIELD_VARCHAR) {
            if (strcmp(f1->value.s, f2->value.s) == 0) {
                return 1;
            }
        }
    }

    return 0;
}

void field_destroy(field_t**field) {
    // variables
    field_t* aux = NULL;

    if (field == NULL || (*field) == NULL) {
        return;
    }

    if ((*field)->type == FIELD_INT) {
        free((*field)->value.i);
    } else if((*field)->type == FIELD_VARCHAR) {
        free((*field)->value.s);
    }

    // retrieve next field=
    aux = (*field)->next;

    free((*field));
    *field = aux;
}