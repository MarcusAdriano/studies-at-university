/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lmv.agenciabancaria.database;

import com.lmv.agenciabancaria.model.Gerente;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Vitor
 */
public class TGerente extends DAO<Integer, Gerente>{
    
    public TGerente () {
        super("gerente");
    }

    @Override
    protected Gerente convert(ResultSet r) throws SQLException {
        Gerente g;
        g = new Gerente(r.getInt("ger_num"));
        return g;
    }

    @Override
    protected Integer getKey(Gerente t) {
        return t.getId();
    }

    @Override
    public int add(Gerente t) throws SQLException, IllegalArgumentException {
        if (t == null) 
            throw new IllegalArgumentException("Gerente is null");
        
        if (data == null)
            refresh();
        
        String sql = 
                "INSERT INTO gerente "
                + "(ger_num) "
                + "VALUES "
                + "(?)";
        
        PreparedStatement pstm;
        pstm = DBConnection.get().prepareStatement(sql);
        
        pstm.setInt(1, t.getId());
        
        int r = pstm.executeUpdate();
        pstm.close();
        if (r > 0) {
            data.put(t.getId(), t);
        }
        pstm.close();
        return r;
    }

    @Override
    public int delete(Gerente t) throws SQLException, IllegalArgumentException {
        if (t == null)
            throw new IllegalArgumentException("Gerente is null");
        
        if (data == null)
            refresh();
  
        String sql = "DELETE FROM gerente WHERE ger_num = ?";
        
        PreparedStatement pstm;
        pstm = DBConnection.get().prepareStatement(sql);
        
        pstm.setInt(1, t.getId());
        
        int r = pstm.executeUpdate();
        pstm.close();
        if (r > 0) {
            data.remove(t.getNum());
        }       
        return r;
    }

    @Override
    public int update(Gerente t) throws SQLException, IllegalArgumentException {
        throw new SQLException("Operation not permited on 'gerente'");
    }
}
