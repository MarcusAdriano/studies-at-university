/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lmv.agenciabancaria.database;

import com.lmv.agenciabancaria.model.Dependente;
import com.lmv.agenciabancaria.model.Funcionario;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;

/**
 *
 * @author Marcus
 */
public class TDependente extends DAO<String, Dependente>{

    public TDependente()  {
        super("dependente");
    }

    @Override
    protected Dependente convert(ResultSet r) throws SQLException {
        Dependente d;
        d = new Dependente(
                r.getInt("func_num"),
                r.getString("nome")
        );
        return d;
    }

    @Override
    protected String getKey(Dependente t) {
        return t.getNome() + "." + t.getNumFuncionario();
    }

    @Override
    public int add(Dependente t) throws SQLException {
        if (t == null) 
            throw new IllegalArgumentException("Dependente is null");
        
        if (data == null)
            refresh();
        
        String sql = 
                  "INSERT INTO dependente "
                + "(nome, func_num) "
                + "VALUES "
                + "(?, ?)";
        
        PreparedStatement pstm;
        pstm = DBConnection.get().prepareStatement(sql);
        
        pstm.setString(1, t.getNome());
        pstm.setInt(2, t.getNumFuncionario());
        
        int r = pstm.executeUpdate();
        pstm.close();
        if (r > 0) {
            data.put(getKey(t),t);
        }
        return r;
    }

    @Override
    public int delete(Dependente t) throws SQLException {
        if (t == null)
            throw new IllegalArgumentException("Dependente is null");
        
        if (data == null)
            refresh();
  
        String sql = "DELETE FROM dependente WHERE nome=? AND func_num=?";
        
        PreparedStatement pstm;
        pstm = DBConnection.get().prepareStatement(sql);
        
        pstm.setString(1, t.getNome());
        pstm.setInt(2, t.getNumFuncionario());
        
        int r = pstm.executeUpdate();
        pstm.close();
        if (r > 0) {
            data.remove(getKey(t));
        }       
        return r;
    }

    @Override
    public int update(Dependente t) throws SQLException {
        if (t == null)
            throw new IllegalArgumentException("Dependente is null");
        
        if (data == null)
            refresh();
        
        String sql = 
                  "UPDATE dependente SET "
                + "nome=?,func_num=? "
                + "WHERE nome = $1 AND func_num = $2";
        
        sql = sql.replace("$1", "'" + t.getNome() + "'");
        sql = sql.replace("$2", "" + t.getNumFuncionario());
        
        PreparedStatement pstm;
        pstm = DBConnection.get().prepareStatement(sql);
        
        pstm.setString(1, t.getNome());
        pstm.setInt(2, t.getNumFuncionario());
        
        int r = pstm.executeUpdate();
        pstm.close();
        if (r > 0) {
            data.remove(getKey(t), t);
        }       
        return r;
    }
    
    public Object[] getAllFromFuncionario(Funcionario f) 
            throws SQLException {
        if (f == null)
            throw new IllegalArgumentException("Funcionario is null");
        
        if (data == null)
            refresh();
        
        String sql = "SELECT * FROM dependente WHERE func_num = ?";
        PreparedStatement pstm;
        pstm = DBConnection.get().prepareCall(sql);
        
        pstm.setInt(1, f.getNum());
        ResultSet rs = pstm.executeQuery();
        LinkedList<Object> objs = new LinkedList<>();
        while (rs.next()) {
            objs.add(convert(rs));
        }
        pstm.close();
        return objs.toArray();
    }
}
