/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lmv.agenciabancaria.database;

import com.lmv.agenciabancaria.model.Operacao;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Marcus
 */
public class TOperacaoBancaria extends DAO<Integer,Operacao>{
    
    public TOperacaoBancaria() {
        super("op_bancaria");
    }

    @Override
    protected Operacao convert(ResultSet r) throws SQLException {
        Operacao t;
        t = new Operacao(
                r.getInt("id_seq"),
                r.getInt("id"),
                r.getString("ag_nome"),
                r.getString("descricao"),
                r.getDouble("valor"),
                r.getDate("data")
        );
        return t;
    }

    @Override
    protected Integer getKey(Operacao t) {
        return t.getId();
    }

    @Override
    public int add(Operacao t) throws SQLException {
        if (t == null)
            throw new IllegalArgumentException("Operacao is null");
        
        if (data == null)
            refresh();
        
        String sql = 
                  "INSERT INTO op_bancaria "
                + "(id,ag_nome,descricao,valor,date) VALUES "
                + "(?,?,?,?,?)";
        
        PreparedStatement pstm;
        pstm = DBConnection.get().prepareCall(sql);
        
        pstm.setInt(1, t.getIdContaCorrente());
        pstm.setString(1, t.getNomeAgencia());
        pstm.setString(1, t.getDescricao());
        pstm.setDouble(1, t.getValor());
        pstm.setDate(1, t.getData());
        
        int r = pstm.executeUpdate();
        pstm.close();
        if (r > 0) {
            
        }
        return r;
    }

    @Override
    public int delete(Operacao t) throws SQLException {
        if (t == null)
            throw new IllegalArgumentException("Operacao is null");
        
        if (data == null)
            refresh();
  
        String sql = "DELETE FROM op_bancaria WHERE id_seq = ?";
        
        PreparedStatement pstm;
        pstm = DBConnection.get().prepareStatement(sql);
        
        pstm.setInt(1, t.getId());
        
        int r = pstm.executeUpdate();
        pstm.close();
        if (r > 0) {
            data.remove(t.getId());
        }       
        return r;
    }

    @Override
    public int update(Operacao t) throws SQLException {
        throw new SQLException("Operation not permited with 'cupom'!");
    }
}
