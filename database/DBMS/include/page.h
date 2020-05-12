/**
 * Created by Marcus Adriano, 2017
 * <a href="mailto:marcusadriano.pereira@gmail.com" target="_top">send an email</a>
 */
#ifndef PAGE_H
#define PAGE_H

#include <stdio.h>
#include "record.h"

#define PAGE_SIZE 4096

struct _page {
    // write in file
    unsigned short nentry;  // number of records
    unsigned short     id;  // id of page! ie page 7 is SIZE_OF_PAGE * 7
    unsigned short   *dir;  // directory
};

typedef struct _page page_t;

/**
 * Create an empty page
 * @return return the reference to empty page
 */
page_t *page_create_empty();

/**
 * Verify if the page contains space to store
 * a new record
 * @param page page when the record will be save
 * @param record record to save, is necessary to calculate the record's length
 * @return true if has space, otherwise false
 */
int page_has_space(page_t *page, record_t *record);

// page I/O operations
/**
 *
 * @param page
 * @param fd
 */
void page_write(page_t *page, FILE *fd);

/**
 * Read a page from id
 * @param id id of the page to read
 * @param fd the file where is page is stored
 * @return page or NULL when page don't exist
 */
page_t *page_read(int id, FILE *fd);

/**
 * Find free space on page for a new record
 * @param page page to seek position
 * @param record record to seek the correct position
 * @return the value of position to store the record
 */
long page_seek_free_space(page_t *page, record_t *record);

#endif // PAGE_H