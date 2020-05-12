/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lmv.agenciabancaria.database;

import com.lmv.agenciabancaria.exception.AgenciaBancariaException;
import com.lmv.agenciabancaria.model.ContaPoupanca;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Marcus
 */
public class TContaPoupanca extends DAO<String, ContaPoupanca>{
    
    public TContaPoupanca() {
        super("contapoupanca");
    }

    @Override
    protected ContaPoupanca convert(ResultSet r) throws SQLException {
        ContaPoupanca c;
        c = new ContaPoupanca(
                r.getInt("cliente_id"),
                r.getInt("id"),
                r.getString("ag_nome"),
                r.getDate("d_acesso"),
                r.getDate("d_criacao"),
                r.getDouble("saldo"),
                r.getDouble("tx_juros")
        );
        return c;
    }

    @Override
    public ContaPoupanca get(String k) throws SQLException, AgenciaBancariaException {
        return super.get(k); //To change body of generated methods, choose Tools | Templates.
    }

    
    
    @Override
    protected String getKey(ContaPoupanca t) {
        return t.getId() + "." + t.getNomeAgencia();
    }

    @Override
    public int add(ContaPoupanca t) throws SQLException {
        if (t == null) 
            throw new IllegalArgumentException("ContaPoupanca is null");
        
        if (data == null)
            refresh();
        
        String sql = 
                  "INSERT INTO conta "
                + "(ag_nome) "
                + "VALUES "
                + "(?)";
        
        PreparedStatement pstm;
        pstm = DBConnection.get().prepareStatement(sql);
        
        pstm.setString(2, t.getNomeAgencia());
        
        int r = pstm.executeUpdate();
        pstm.close();
        if (r > 0) {
            t.setId(getCurrval("id"));
            return addContaPoupanca(t);
        }
        return r;
    }

    @Override
    public int delete(ContaPoupanca t) throws SQLException {
        if (t == null)
            throw new IllegalArgumentException("ContaPoupanca is null");
        
        if (data == null)
            refresh();
  
        String sql = "DELETE FROM conta WHERE id = ? AND ag_nome = ?";
        
        PreparedStatement pstm;
        pstm = DBConnection.get().prepareStatement(sql);
        
        pstm.setInt(1, t.getId());
        pstm.setString(2, t.getNomeAgencia());
        
        int r = pstm.executeUpdate();
        pstm.close();
        if (r > 0) {
            data.remove(t.getId() + "." + t.getNomeAgencia());
        }       
        return r;
    }

    @Override
    public int update(ContaPoupanca t) throws SQLException {
        if (t == null)
            throw new IllegalArgumentException("ContaPoupanca is null");
        
        if (data == null)
            refresh();
        
        String sql = 
                  "UPDATE conta SET "
                + "saldo=?,d_acesso=? "
                + "WHERE id = $1 AND ag_nome = $2";
        
        sql = sql.replace("$1", "" + t.getId());
        sql = sql.replace("$2", t.getNomeAgencia());
        
        PreparedStatement pstm;
        pstm = DBConnection.get().prepareStatement(sql);
        
        pstm.setDouble(1, t.getSaldo());
        pstm.setDate(2, t.getDataAcesso());
        
        int r = pstm.executeUpdate();
        pstm.close();
        if (r > 0) {
            return updateContaPoupanca(t);
        }       
        return r;
    }
    
    private int updateContaPoupanca (ContaPoupanca t) throws SQLException {
        String sql = 
                  "UPDATE corrente SET "
                + "tx_juros=? "
                + "WHERE id = $1 AND ag_nome = $2";
        
        sql = sql.replace("$1", "" + t.getId());
        sql = sql.replace("$2", t.getNomeAgencia());
        
        PreparedStatement pstm;
        pstm = DBConnection.get().prepareStatement(sql);
        
        pstm.setDouble(1, t.getTaxaJuros());
        
        int r = pstm.executeUpdate();
        pstm.close();
        if (r > 0) {
            data.replace(t.getId() + "." + t.getNomeAgencia(), t);
        }       
        return r;
    }
    
    private int addContaPoupanca(ContaPoupanca t) throws SQLException {        
        String sql = 
                "INSERT INTO poupanca "
                + "(id, ag_nome, tx_juros) "
                + "VALUES "
                + "(?,?,?)";
        
        PreparedStatement pstm;
        pstm = DBConnection.get().prepareStatement(sql);
        
        pstm.setInt(1, t.getId());
        pstm.setString(2, t.getNomeAgencia());
        pstm.setDouble(3, t.getTaxaJuros());
        
        int r = pstm.executeUpdate();
        pstm.close();
        if (r > 0) {
            data.put(t.getId() + "." + t.getNomeAgencia(), t);
        }
        return r;
    }
    
}
