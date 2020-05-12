cmake_minimum_required(VERSION 3.8)
project(DBMS)

set(CMAKE_C_STANDARD 99)

set(SOURCE_FILES zmain.c dbms.c field.c record.c buffer_manager.c page.c)
add_executable(DBMS ${SOURCE_FILES})