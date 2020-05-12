/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lmv.agenciabancaria.database;

import com.lmv.agenciabancaria.model.Funcionario;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Marcus
 */
public class TFuncionario extends DAO<Integer, Funcionario>{

    public TFuncionario() {
        super("funcionario");
    }
    
    @Override
    protected Funcionario convert(ResultSet r) throws SQLException {
        Funcionario f;
        f = new Funcionario(
                r.getInt("num_func"),
                r.getString("ag_nome"),
                r.getInt("supervisor_num"),
                r.getString("nome"),
                r.getDate("d_admissao"),
                r.getString("telefone")
        );
        return f;
    }

    @Override
    protected Integer getKey(Funcionario t) {
        return t.getNum();
    }

    @Override
    public int add(Funcionario t) throws SQLException {
        if (t == null) 
            throw new IllegalArgumentException("Funcionario is null");
        
        if (data == null)
            refresh();
        
        String sql = 
                "INSERT INTO funcionario "
                + "(ag_nome, supervisor_num, nome, telefone) "
                + "VALUES "
                + "(?,?,?,?)";
        
        PreparedStatement pstm;
        pstm = DBConnection.get().prepareStatement(sql);
        
        pstm.setString(1, t.getNomeAgencia());
        pstm.setInt(2, t.getIdSupervisor());
        pstm.setString(3, t.getNome());
        pstm.setString(4, t.getTelefone());
        
        int r = pstm.executeUpdate();
        pstm.close();
        if (r > 0) {
            t.setNum(this.getCurrval("num_func"));
            data.put(t.getNum(), t);
        }
        pstm.close();
        return r;
    }

    @Override
    public int delete(Funcionario t) throws SQLException {
        if (t == null)
            throw new IllegalArgumentException("Funcionario is null");
        
        if (data == null)
            refresh();
  
        String sql = "DELETE FROM funcionario WHERE num_func = ?";
        
        PreparedStatement pstm;
        pstm = DBConnection.get().prepareStatement(sql);
        
        pstm.setInt(1, t.getNum());
        
        int r = pstm.executeUpdate();
        pstm.close();
        if (r > 0) {
            data.remove(t.getNum());
        }       
        return r;
    }

    @Override
    public int update(Funcionario t) throws SQLException {
        if (t == null)
            throw new IllegalArgumentException("Funcionario is null");
        
        if (data == null)
            refresh();
        
        String sql = 
                "UPDATE funcionario SET "
                + "supervisor_num=?, telefone=? "
                + "WHERE num_func = $";
        sql = sql.replace("$", "" + t.getNum());
        
        PreparedStatement pstm;
        pstm = DBConnection.get().prepareStatement(sql);
        
        pstm.setInt(1, t.getIdSupervisor());
        pstm.setString(2, t.getTelefone());
        
        int r = pstm.executeUpdate();
        pstm.close();
        if (r > 0) {
            data.replace(t.getNum(), t);
        }       
        return r;
    }
}