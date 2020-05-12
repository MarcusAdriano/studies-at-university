/**
 * Created by Marcus Adriano, 2017
 * <a href="mailto:marcusadriano.pereira@gmail.com" target="_top">send an email</a>
 */
#ifndef DBMS_BUFFER_MANAGER_H
#define DBMS_BUFFER_MANAGER_H

#include "page.h"
#include "record.h"

#define BUFFER_ALLOCATOR_SIZE 10

struct _buffer {
    page_t          **pages;
    unsigned int     npages;
};

// definition of buffer manager
typedef struct _buffer buffer_t;

/**
 * Init an empty buffer and load all pages in file
 * @param buffer buffer to return reference
 * @param fd file to load pages
 * @return 0 when file is null <br>
 *         1 buffer initialized
 */
int buffer_init(buffer_t **buffer, FILE *fd);

/**
 * Retrieve a page from buffer by id
 * @param buffer buffer to examine pages
 * @param id id to find the page
 * @return NULL when page don't exist or ID is invalid <br>
 *         page reference
 */
page_t* buffer_get_page_by_id(buffer_t *buffer, int id);

// basic operations

/**
 * Insert a new record on buffer and file
 * @param buffer buffer to store new record
 * @param record record to store
 * @param fd file where record will be save
 * @return 0 or any negative number for errors <br>
 *         1 operations executed with success
 */
int buffer_insert_v1(buffer_t *buffer, record_t *record, FILE *fd);

/**
 * Update a record of buffer
 * @param buffer buffer with contain that record
 * @param record record to update
 * @param fd file where is storage record
 * @return 0  - record or buffer or file is null <br>
 *         -1 - record's id is out of range (id < 0 or id >= 4095) <br>
 *         -2 - page where record is stored don't exist <br>
 *         1  - record is updated
 */
int buffer_update_v1(buffer_t *buffer, record_t *record, FILE *fd);

/**
 * Delete a record of buffer
 * @param buffer where is record
 * @param record the record to delete
 * @param fd file where buffer/record is stored
 * @return 0  - record or buffer or file is null <br>
 *         -1 - record's id is out of range (id < 0 or id >= 4095) <br>
 *         -2 - page where record is stored don't exist <br>
 *         1  - record is updated
 */
int buffer_delete_v1(buffer_t *buffer, record_t *record, FILE *fd);

/**
 * Free up space of buffer
 * @param buffer buffer to clean
 */
void buffer_destroy(buffer_t **buffer);


#endif //DBMS_BUFFER_MANAGER_H