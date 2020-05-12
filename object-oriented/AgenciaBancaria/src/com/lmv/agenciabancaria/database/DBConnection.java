/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lmv.agenciabancaria.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author marcus
 */
public class DBConnection {
    
    final private static String USER = "postgres";
    final private static String PASS = "root";
    final private static String HOST = 
            "jdbc:postgresql://localhost:5432/postgres?currentSchema=sistema_bancario";
    
    private static Connection current = null;
    
    private DBConnection() {
        
    }
       
    final public static synchronized Connection get() throws SQLException {
        if (current == null) {
            current = DriverManager.getConnection(HOST, USER, PASS);
        }        
        return current;
    }
    
    final public static synchronized void close() throws SQLException {
        if (current != null)
            current.close();
    }
}
