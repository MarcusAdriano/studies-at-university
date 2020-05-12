/**
 * Created by Marcus Adriano, 2017
 * <a href="mailto:marcusadriano.pereira@gmail.com" target="_top">send an email</a>
 */
#ifndef DBMS_H
#define DBMS_H

#include <stdio.h>
#include "page.h"
#include "record.h"
#include "buffer_manager.h"

struct _model {
    char            **name; // list of table's columns
    unsigned short   *type; // list of columns' type
    unsigned short nfields; // number of fields
};

struct _dbms {
    char*             name; // name of database
    buffer_t       *buffer; // buffer manager
    struct _model   *model; // model for table
    record_t*      records; // list of records, linked list (head)
    FILE*               fd; // file to save all information
    unsigned int    nentry; // number of entry
};

typedef struct _dbms dbms_t;
typedef struct _model model_t;

/**
 * Create new database with:
 * @param name name of the database
 * @param db reference
 * @return 1 - database was created<br>
 *         0     - error to create new database
 **/
int db_open(char *, dbms_t **);

/**
 * Insert new record on database 
 * @db     - db reference
 * @record - record reference
 * @return   0 - db or record is null <br>
 *           1 - Success to insert the record <br>
 *          -2 - Data type is different of metadata <br>
 *          -1 - new page is necessary
 **/
int db_insert_v1(dbms_t *, record_t *);

/**
 * Delete a database's record
 * @param db database where file is stored
 * @param record record to delete
 * @return 0 or negative for errors <br>
 *         1 success to delete
 */
int db_delete_v1(dbms_t* db, record_t** record);

/**
 * Update a database's record
 * @param db database where record is stored
 * @param record to update
 * @return 0 or negative errors <br>
 *         1 success to delete
 */
int db_update_v1(dbms_t* db, record_t* record);

#endif // DBMS_H