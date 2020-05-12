/**
 * Created by Marcus Adriano, 2017
 * <a href="mailto:marcusadriano.pereira@gmail.com" target="_top">send an email</a>
 */
#ifndef FIELD_H
#define FIELD_H

#include <stdlib.h>

#define FIELD_VARCHAR 0
#define FIELD_INT     1

/**
 * An internal definition about fields.
 * A field has name, data type, value (bytes), size (number of bytes) and a pointer to next field of the record.
 * This is used only for Record's user, in another words, end-user cannot deal with this.
 */
struct _field{
    int            type; // type of column
    union value {
        int* i;
        char* s;
    } value;
    size_t       length; // length of data in bytes
    struct _field* next; // used to store the next field on record struct head of a linked list
};

// DEFINITIONS ==============================
typedef struct _field field_t;
// END DEFINITIONS ==========================

/**
 * Create an int field from with a name and value
 * @param name name of the field
 * @param value value assign
 * @return new field pointer
 */
field_t* field_create_int(const int value);

/**
 * Create a varchar field with a value
 * @param name name of the field
 * @param value value assign
 * @return new field pointer
 */
field_t* field_create_varchar(const char* value);

/**
 * Create a varchar field with a value and default size
 * @param value string to store
 * @param len size of string to store
 * @return NULL when len is <= of strlen(value) <br>
 *         reference to new field
 */
field_t* field_create_varchar_v1(const char* value, int len);

/**
 * Retrieve bytes from a field
 * @return bytes
 */
void* field_get_value(field_t *);

/**
 * Compare 2 fields and determine if it's equals
 * @param f1 first field to compare
 * @param f2 second field to compare
 * @return 0 for fields aren't equals <br>
 *         1 for equals fields
 */
int field_equals(field_t* f1, field_t* f2);

/**
 * Free up reference to a field
 * @param field to clean
 */
void field_destroy(field_t**field);
#endif