/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lmv.agenciabancaria.database;

import com.lmv.agenciabancaria.model.Conta;
import com.lmv.agenciabancaria.model.Cupom;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;

/**
 *
 * @author Marcus
 */
public class TCupom extends DAO<Integer, Cupom> {
    
    public TCupom() {
        super("cupom");
    }

    @Override
    protected Cupom convert(ResultSet r) throws SQLException {
        Cupom c;
        c = new Cupom(
                r.getInt("num"),
                r.getInt("op_id_seq"),
                r.getDate("validade")
        );
        return c;
    }

    @Override
    protected Integer getKey(Cupom t) {
        return t.getNum();
    }

    @Override
    public int add(Cupom t) throws SQLException {
        if (t == null)
            throw new IllegalArgumentException("Cupom is null");
        
        if (data == null)
            refresh();
        
        String sql = 
                  "INSERT INTO cupom "
                + "(op_id_seq, validade) VALUES "
                + "(?,?)";
        PreparedStatement pstm;
        pstm = DBConnection.get().prepareCall(sql);
        
        pstm.setInt(1, t.getOpId());
        pstm.setDate(2, t.getValidade());
        
        int r = pstm.executeUpdate();
        pstm.close();
        if (r > 0) {
            t.setNum(this.getCurrval("num"));
            data.put(getKey(t), t);
        }
        return r;
    }

    @Override
    public int delete(Cupom t) throws SQLException {
        if (t == null) 
            throw new IllegalArgumentException("Cupom is null");
        
        if (data == null) 
            refresh();
        
        String sql = 
                "DELETE FROM cupom WHERE num = ?";
        PreparedStatement pstm;
        pstm = DBConnection.get().prepareCall(sql);
        
        pstm.setInt(1, t.getNum());
        
        int r = pstm.executeUpdate();
        pstm.close();
        if (r > 0) {
            data.remove(getKey(t));
        }
        return r;
    }

    @Override
    public int update(Cupom t) throws SQLException {
        throw new SQLException("Operation not permited with 'cupom'!");
    }
    
    public Object[] getFromConta(Conta c) throws SQLException {
        if (c == null)
            throw new IllegalArgumentException("Conta is null");
        
        if (data == null)
            refresh();
        
        String sql = "SELECT * FROM cupom WHERE "
                + "op_ag_nome = ? AND "
                + "op_id = ?";
        
        PreparedStatement pstm;
        pstm = DBConnection.get().prepareCall(sql);
        
        pstm.setString(1, c.getNomeAgencia());
        pstm.setInt(2, c.getId());        
        
        ResultSet rs = pstm.executeQuery();
        LinkedList<Object> objs = new LinkedList<>();
        while (rs.next()) {
            objs.add(convert(rs));
        }
        pstm.close();
        return objs.toArray();
    }
    
    
}
