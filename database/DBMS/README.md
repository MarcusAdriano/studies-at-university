# Database Management System

Home work for course of Database Management System, of the Federal University of Uberlandia, lecturer [Ilmério](http://www.facom.ufu.br/~ilmerio), from Faculdade de Computação (FACOM).

Features :+1::

 * Heap File
 * Insert a record in file without modify others records
 * Update a record, without modify others
 * delete a record, without modify others
 * Dynamic pages

TODO :-1::

 * Dynamic index (Hash or B+ tree)

# Default Data Types

* text - size of PAGE_SIZE or minus
* int  - size of 4 bytes, default integer

# How is it works?

1. First time is necessary setup metadatas for a table, metadas are files in the same directory where this software is running
2. Metadata has the same name of the table and an extension ***.model**


For example, a friend list is saved on file called ***friends.table***, but for it's works is necessary a ***friends.table.model*** file, like as:

```text
name : text
age  : int
```

# Page and Records

Each page has a fixed size of **4096** bytes and contains a number of records and a directory to store pointer where's records on page. More datails can be find at (third edition) **Raghu Ramakrishnan and Johannes Gehrke. 2000. Database Management Systems (2nd ed.). Osborne/McGraw-Hill, Berkeley, CA, USA.**

To optimize space of each page is used primitive data types:
 * *unsigned short* number of records in page **2 bytes**. each page's begin contain this field.
 * *unsigned short* for each element in directory, before number of records
 * *text* are primitive C string and a string length ***N*** has ***N + 1*** bytes
 * *int* default C int with ***4 bytes***

Each record has a *header* with details about record's fields. *Header's* elements are* unsigned short* because it take less space instead of int. 

# Case Study

ie ***friends.table***, to save my name and my old years ("Marcus", 20) is necessary 7 bytes for **text** and 4 bytes for **int**. Record's header is a vector of *unsigned short* with values **7** e **0**. 7 is a **text** of 7 bytes and any **0** in anywhere header is a **int**. Then, space used to save ("Marcus", 20) is **15 bytes** = 11 bytes records's field and 4 bytes record's header.

