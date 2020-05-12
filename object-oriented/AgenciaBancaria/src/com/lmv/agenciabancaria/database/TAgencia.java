/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lmv.agenciabancaria.database;

import com.lmv.agenciabancaria.exception.AgenciaBancariaException;
import com.lmv.agenciabancaria.model.Agencia;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Marcus
 */
public class TAgencia extends DAO<String, Agencia> {
    
    public TAgencia() {
        super("agencia");
    }

    @Override
    public Agencia convert(ResultSet r) throws SQLException {
        return new Agencia(
                r.getString("nome"), 
                r.getString("estado"), 
                r.getString("cidade"));
    }

    @Override
    public String getKey(Agencia a) {
        return a.getNome();
    }
    
    @Override
    public int add(Agencia a) throws SQLException {
        if (a == null) 
            throw new IllegalArgumentException("Agencia is null");
        
        if (data == null)
            refresh();
        
        String sql = "INSERT INTO agencia(nome, cidade, estado) VALUES (?,?,?)";
        PreparedStatement pstm;
        pstm = DBConnection.get().prepareStatement(sql);
        pstm.setString(1, a.getNome());
        pstm.setString(2, a.getCidade());
        pstm.setString(3, a.getEstado());
        
        int r = pstm.executeUpdate();
        if (r > 0)
            data.put(a.getNome(), a);
        pstm.close();
        return r;
    } 
    
    @Override
    public int update(Agencia a) throws SQLException {
        return update((Agencia) a, ((Agencia) (a)).getNome());
    }
    
    final public int update(Agencia a, String nome) throws SQLException {
        if (a == null || nome.trim().isEmpty())
            throw new IllegalArgumentException("Agencia is null");
        
        if (data == null)
            refresh();
        
        String sql = "UPDATE agencia SET nome=?,cidade=?,estado=? WHERE nome = '$key'";
        sql = sql.replace("$key", a.getNome());
        
        PreparedStatement pstm;
        pstm = DBConnection.get().prepareStatement(sql);
        pstm.setString(1, nome);
        pstm.setString(2, a.getCidade());
        pstm.setString(3, a.getEstado());
        
        int r = pstm.executeUpdate();
        pstm.close();
        if (r > 0) {
            if (a.getNome().equals(nome)) {
                data.replace(nome, a);
            } else {
                data.remove(a.getNome());
                a.setNome(nome);
                data.put(a.getNome(), a);
            }
        }       
        return r;
    }
    
    @Override
    public int delete(Agencia a) throws SQLException {
        if (a == null)
            throw new IllegalArgumentException("Agencia is null");
  
        if (data == null)
            refresh();
        
        String sql = "DELETE FROM agencia WHERE nome = ?";
        
        PreparedStatement pstm;
        pstm = DBConnection.get().prepareStatement(sql);
        pstm.setString(1, a.getNome());
        
        int r = pstm.executeUpdate();
        pstm.close();
        if (r > 0) {
            data.remove(a.getNome());
        }       
        return r;
    }

    @Override
    public Agencia get(String k) throws SQLException, AgenciaBancariaException {
        return (Agencia) super.get(k);
    }
}