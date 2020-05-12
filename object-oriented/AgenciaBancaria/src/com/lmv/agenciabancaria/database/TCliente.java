/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lmv.agenciabancaria.database;

import com.lmv.agenciabancaria.exception.AgenciaBancariaException;
import com.lmv.agenciabancaria.model.Cliente;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Marcus
 */
public class TCliente extends DAO<Integer, Cliente>{

    public TCliente() throws IllegalArgumentException {
        super("cliente");
    }

    @Override
    public Cliente convert(ResultSet r) throws SQLException {
        Cliente c;
        c = new Cliente(
                r.getInt("id"),
                r.getInt("ger_num"),
                r.getString("cpf"),
                r.getString("cidade"),
                r.getString("endereco"),
                r.getString("estado"),
                r.getString("nome"),
                r.getDate("d_niver"));
        return c;
    }

    @Override
    public Integer getKey(Cliente t) {
        Cliente c = (Cliente) t;
        return c.getId();
    }

    @Override
    public Cliente get(Integer k) throws SQLException, AgenciaBancariaException {
        return (Cliente) super.get(k);
    }

    @Override
    public int add(Cliente c) throws SQLException {
        if (c == null) 
            throw new IllegalArgumentException("Cliente is null");
        
        if (data == null)
            refresh();
        
        String sql = 
                "INSERT INTO cliente "
                + "(ger_num, cpf, cidade, endereco, estado, nome, d_niver) "
                + "VALUES "
                + "(?,?,?,?,?,?,?)";
        
        PreparedStatement pstm;
        pstm = DBConnection.get().prepareStatement(sql);
        
        pstm.setInt(1, c.getGerenteNum());
        pstm.setString(2, c.getCpf());
        pstm.setString(3, c.getCidade());
        pstm.setString(4, c.getEndereco());
        pstm.setString(5, c.getEstado());
        pstm.setString(6, c.getNome());
        pstm.setDate(7, c.getDataNiver());
        
        int r = pstm.executeUpdate();
        pstm.close();
        if (r > 0) {
            c.setId(this.getCurrval("id"));
            data.put(c.getId(), c);
        }
        return r;
    }

    @Override
    public int delete(Cliente c) throws SQLException {
        if (c == null)
            throw new IllegalArgumentException("Cliente is null");
        
        if (data == null)
            refresh();
  
        String sql = "DELETE FROM cliente WHERE id = ?";
        
        PreparedStatement pstm;
        pstm = DBConnection.get().prepareStatement(sql);
        pstm.setInt(1, c.getId());
        
        int r = pstm.executeUpdate();
        pstm.close();
        if (r > 0) {
            data.remove(c.getId());
        }       
        return r;
    }

    @Override
    public int update(Cliente c) throws SQLException {
        if (c == null)
            throw new IllegalArgumentException("Cliente is null");
        
        if (data == null)
            refresh();
        
        String sql = "UPDATE cliente SET "
                + "ger_num=?,cpf=?,cidade=?,endereco=?,estado=?,nome=?,d_niver=? "
                + "WHERE id = $";
        sql = sql.replace("$", "" + c.getId());
        
        PreparedStatement pstm;
        pstm = DBConnection.get().prepareStatement(sql);
        
        pstm.setInt(1, c.getGerenteNum());
        pstm.setString(2, c.getCpf());
        pstm.setString(3, c.getCidade());
        pstm.setString(4, c.getEndereco());
        pstm.setString(5, c.getEstado());
        pstm.setString(6, c.getNome());
        pstm.setDate(7, c.getDataNiver());
        
        int r = pstm.executeUpdate();
        pstm.close();
        if (r > 0) {
            data.replace(c.getId(), c);
        }       
        return r;
    }
}
