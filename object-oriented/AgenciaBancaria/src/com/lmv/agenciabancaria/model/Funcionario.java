/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lmv.agenciabancaria.model;

import java.sql.Date;
import java.util.Calendar;

/**
 *
 * @author marcus
 */
public class Funcionario {
    private int num;
    private String nomeAgencia;
    private int idSupervisor;
    private String nome, telefone;
    private Date dataAdmissao;
    private long tempoServico = -1;

    public Funcionario(int num, String nomeAgencia, int idSupervisor, String nome, Date dataAdmissao, String telefone) {
        this.num = num;
        this.nomeAgencia = nomeAgencia;
        this.idSupervisor = idSupervisor;
        this.nome = nome;
        this.telefone = telefone;
        this.dataAdmissao = dataAdmissao;
    }

    public Funcionario() {
        
    }
    
    final public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public void setNomeAgencia(String nomeAgencia) {
        this.nomeAgencia = nomeAgencia;
    }

    public void setIdSupervisor(int idSupervisor) {
        this.idSupervisor = idSupervisor;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setDataAdmissao(Date dataAdmissao) {
        this.dataAdmissao = dataAdmissao;
    }

    public void setTempoServico(long tempoServico) {
        this.tempoServico = tempoServico;
    }
    
    final public String getNomeAgencia() {
        return nomeAgencia;
    }

    final public int getIdSupervisor() {
        return idSupervisor;
    }

    final public String getNome() {
        return nome;
    }

    final public Date getDataAdmissao() {
        return dataAdmissao;
    }

    final public long getTempoServico() {
        if (tempoServico == -1) {
            tempoServico 
                  = Calendar.getInstance().getTimeInMillis() - 
                    this.dataAdmissao.getTime();
        }
        return tempoServico;
    } 

    final public String getTelefone() {
        return telefone;
    }
    
    final public void setTelefone(String telefone) {
        this.telefone = telefone;
    }
}
