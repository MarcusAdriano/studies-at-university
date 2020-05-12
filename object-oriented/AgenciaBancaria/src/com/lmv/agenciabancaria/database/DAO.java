/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lmv.agenciabancaria.database;

import com.lmv.agenciabancaria.exception.AgenciaBancariaException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

/**
 *
 * @author Marcus
 * @param <K>
 * @param <T>
 */
public abstract class DAO<K,T> {
    
    private final String tablename;
    protected Map<K, T> data = null;
    
    public DAO (final String tablename) throws IllegalArgumentException {
        if (tablename.isEmpty()) 
            throw new IllegalArgumentException("Invalid table name '" + tablename + "'");
        
        for (char c: tablename.toCharArray()) {
            if (!Character.isLetter(c) && c != '_')
                throw new IllegalArgumentException
                          ("There is a invalid character in table name '" + tablename + "'");
        }
        
        this.tablename = tablename;
    }
    
    protected abstract T convert(ResultSet r) throws SQLException;
    protected abstract K getKey(T t);
    public abstract int add(T t) throws SQLException, IllegalArgumentException;
    public abstract int delete(T t) throws SQLException, IllegalArgumentException;
    public abstract int update(T t) throws SQLException, IllegalArgumentException;
    
    final public Object[] getAll() throws SQLException {
        if (data == null)   
            refresh();
        
        LinkedList<T> items = new LinkedList<>();
        for (Map.Entry<K,T> item: data.entrySet()) {
            items.add(item.getValue());
        }
        return items.toArray();
    } 
    
    final public int getCurrval(final String key) throws SQLException {
        String sql = "SELECT currval(pg_get_serial_sequence(?, ?))";
        PreparedStatement pstm;
        
        pstm = DBConnection.get().prepareStatement(sql);
        
        pstm.setString(1, this.tablename);
        pstm.setString(2, key);
        
        ResultSet rs = pstm.executeQuery();
        
        int r = -1; 
        while (rs.next()) {
            r = rs.getInt("currval"); 
        }
        pstm.close();
        return r;
    }
    
    final public void refresh() throws SQLException {
        String sql = "SELECT * FROM $";
        sql = sql.replace("$", tablename);
        
        PreparedStatement pstm;
        ResultSet rs;
        
        pstm = DBConnection.get().prepareStatement(sql);
        rs = pstm.executeQuery();
        
        if (data == null) {
            data = new HashMap<>();
        }
        
        K ktemp;
        T vtemp;
        while (rs.next()) {
            vtemp = convert(rs);
            ktemp = getKey(vtemp);
            data.put(ktemp,  vtemp);
        }
        
        rs.close();
        pstm.close();
    }
    
    final public int count() throws SQLException {
        if (data == null) {
            refresh();
        }
        return data.size();
    }
    
    final public boolean exists(K key) throws SQLException, 
            AgenciaBancariaException {
        return get(key) != null;
    }
    
    public T get(K k)throws SQLException, AgenciaBancariaException {
        if (data == null) {
            refresh();
        }
        if (data.isEmpty())
            throw new AgenciaBancariaException(
                    "There isn't items on " + this.tablename);
        
        T temp;
        temp = data.get(k);
        if (temp == null) {
            throw new AgenciaBancariaException(
                    k.toString() + " not found on " + this.tablename);
        }   
        return temp;
    }
}
