#include<stdio.h>

#include "include/record.h"
#include "include/dbms.h"

record_t* makerecord(char* name, int age){

    record_t* rec = record_create_empty();
    field_t *f1 = field_create_varchar(name);
    field_t *f2 = field_create_int(age);

    record_add_field_v1(rec, f1);
    record_add_field_v1(rec, f2);

    return rec;
}

int main() {
    dbms_t* db;
    db_open("friends.table", &db);

//    int  i;
//    for (i = 0; i < 300; i++)
//        db_insert_v1(db, makerecord("MARCUS", 20));

    record_t* rec = db->records;
    char buffer[150];
    int age;

    do {
        record_get_string(rec, 0, buffer);
        record_get_int(rec, 1, &age);
//////
//        if (rec->pageId == 2 && rec->id == 3300) {
//            record_set_string(rec, 0, "Joao P");
//            db_update_v1(db, rec);
//        }
////
        record_get_string(rec, 0, buffer);
        record_get_int(rec, 1, &age);
//////
        printf("Record id = %u | Page id = %u\t", rec->id, rec->pageId);
        printf("name = %s\tage = %d\n", buffer, age);
        rec = rec->next;
    } while (rec != NULL);

    printf("Total of records: %u\n", db->nentry);

    page_t *lastPage = db->buffer->pages[0];
    printf("Total of pages..: %u\n", db->buffer->npages);
    return 0;
}