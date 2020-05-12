/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lmv.agenciabancaria.database;

import com.lmv.agenciabancaria.exception.AgenciaBancariaException;
import com.lmv.agenciabancaria.model.Emprestimo;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Marcus
 */
public class TEmprestimo extends DAO<Integer, Emprestimo>{

    public TEmprestimo() {
        super("emprestimo");
    }
    
    @Override
    protected Emprestimo convert(ResultSet r) throws SQLException {
        Emprestimo t;
        t = new Emprestimo(
                r.getInt("id"),
                r.getString("agencia_nome"),
                r.getDouble("valor"),
                r.getInt("qtd_parcelas")
        );
        return t;
    }

    @Override
    protected Integer getKey(Emprestimo t) {
        return t.getId();
    }

    @Override
    public Emprestimo get(Integer k) throws SQLException, AgenciaBancariaException {
        return (Emprestimo) super.get(k);
    }

    @Override
    public int add(Emprestimo t) throws SQLException {
        if (t == null) 
            throw new IllegalArgumentException("Emprestimo is null");
        
        if (data == null)
            refresh();
        
        String sql = 
                "INSERT INTO emprestimo "
                + "(agencia_nome, valor, qtd_parcelas) "
                + "VALUES "
                + "(?,?,?)";
        
        PreparedStatement pstm;
        pstm = DBConnection.get().prepareStatement(sql);
        
        pstm.setString(1, t.getNomeAgencia());
        pstm.setDouble(2, t.getValor());
        pstm.setInt(3, t.getParcelas());
        
        int r = pstm.executeUpdate();
        pstm.close();
        if (r > 0) {
            t.setId(this.getCurrval("id"));
            data.put(t.getId(), t);
        }
        pstm.close();
        return r;
    }

    @Override
    public int delete(Emprestimo t) throws SQLException {
        if (t == null)
            throw new IllegalArgumentException("Emprestimo is null");
        
        if (data == null)
            refresh();
  
        String sql = "DELETE FROM emprestimo WHERE id = ?";
        
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
    public int update(Emprestimo t) throws SQLException {
        if (t == null)
            throw new IllegalArgumentException("Emprestimo is null");
        
        if (data == null)
            refresh();
        
        String sql = "UPDATE emprestimo SET "
                + "agencia_nome=?,valor=?,qtd_parcelas=? "
                + "WHERE id = $";
        sql = sql.replace("$", "" + t.getId());
        
        PreparedStatement pstm;
        pstm = DBConnection.get().prepareStatement(sql);
        
        pstm.setString(1, t.getNomeAgencia());
        pstm.setDouble(2, t.getValor());
        pstm.setInt(3, t.getParcelas());
        
        int r = pstm.executeUpdate();
        pstm.close();
        if (r > 0) {
            data.replace(t.getId(), t);
        }       
        return r;
    }   
}
