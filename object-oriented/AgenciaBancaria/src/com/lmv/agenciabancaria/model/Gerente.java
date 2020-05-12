/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lmv.agenciabancaria.model;

import java.sql.Date;

/**
 *
 * @author marcus
 */
public class Gerente extends Funcionario {

    private int id;
    
    public Gerente(int num, String nomeAgencia, int idSupervisor, String nome, Date dataAdmissao, String telefone) {
        super(num, nomeAgencia, idSupervisor, nome, dataAdmissao, telefone);
    }

    public Gerente() {
        
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    public Gerente (int ger_num) {
        this.id = ger_num;
    }
}
