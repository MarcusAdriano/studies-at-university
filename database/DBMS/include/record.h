/**
 * Created by Marcus Adriano, 2017
 * <a href="mailto:marcusadriano.pereira@gmail.com" target="_top">send an email</a>
 */
#ifndef RECORD_H
#define RECORD_H

#include "field.h"
#include <stdlib.h>

/**
 *  Represent a complete record with header, the record is:
 *    --------------------------------------------
 *   | s | f1 | f2 | .. | fn | v1 | v2 | ... | vn |
 *    --------------------------------------------
 *    where:
 *    s    = number of fields
 *    f1   =  offset where start the first record's value
 *    f2   = offset where start the second record's value
 *
 *    size of v1 = f2 - f1 (bytes)
 *
 *    fn-1 = offset where start the value n-1 (last value)
 *    fn   = offset where ends record
 */

/**
 * Represents an end-user cursor to retrieve any fields from
 * record.
 */
struct _record {
    field_t*         fields;      // fields
    unsigned short  nfields;      // number of fields
    unsigned short*  header;      // header of record
    unsigned short   pageId;      // page id
    unsigned short       id;      // record id (position in the page)
    struct _record    *next;      // used for list in dbms.h
};

// DEFINITIONS ==============================
typedef struct _record record_t;
// END DEFINITIONS ==========================

/**
 * Get an integer data information from a record at position index.
 * @param rec the record
 * @param index position of the field/column
 * @param result pointer to store the value
 * @return -1 -> record is NULL<br>
 *          0 -> result retrieve with success<br>
 *          1 -> index doesn't exists
 *          2 -> index isn't a integer
 */
int record_get_int(record_t* rec, int index, int* result);

/**
 * Get a String data information from a record at position index with explict size
 * @param rec the record
 * @param index position of the column
 * @param size size of the string
 * @param result pointer to store result
 * @return -1 -> record is NULL<br>
 *          0 -> result retrieve with success<br>
 *          1 -> index doesn't exists
 *          2 -> index isn't a integer
 */
int record_get_string(record_t* rec, int index, char* result);

/** TODO <==================
 * Get an integer data information from a record at position index.
 * @param name name of the field/column
 * @return the value of the field
 */
int record_get_int_from(char*name);

/** TODO <===================
 * Get a String data information from a record at position index with explict size
 * @param name name of the column
 * @param size size of the string
 * @return a string
 */
char* record_get_string_from(char*name);

/**
 * Set a string value from record at position <b>index</b>
 * @param record record where the field to update is stored
 * @param index position of the string field
 * @param src value to set
 * @return 0 or negative for errors <br>
 *         1
 */
int record_set_string(record_t* record, int index, char* src);

/**
 * Makes an empty record.
 * @return a pointer to new record
 */
record_t* record_create_empty();

/**
 * Add new field on field list of a record.
 * @param flag indicate if the header of the record will be updated with param flag
 * @param rec a record definition
 * @param f a field (int or varchar)
 */
void record_add_field(record_t *rec, const field_t *f, int flag);

/**
 * Add new field on field list of a record.
 * @param rec a record definition
 * @param f a field (int or varchar)
 */
void record_add_field_v1(record_t *rec, const field_t *f);

/**
 * add new field on field's list of a record and not update the header
 * @param rec record src
 * @param f new field of the record.
 */
void record_add_field_v2(record_t* rec, const field_t* f);

/**
 * Get size of record in bytes
 * @param record - the record to calculate size in bytes
 * @return
 */
size_t record_get_length(record_t*record);

int record_equals(record_t* r1, record_t* r2);

void record_destroy(record_t**record);

#endif // RECORD_H