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
public class Conta {
    private int clienteId;
    private int id;
    private Date dataCriacao, dataAcesso;
    private double saldo;
    private String nomeAgencia;

    public Conta() {}

    public Conta(int clienteId, int id, String agencia, Date dAcesso, Date dCriacao, double saldo) {
        this.id = id;
        this.clienteId = clienteId;
        this.dataCriacao = dCriacao;
        this.dataAcesso = dAcesso;
        this.saldo = saldo;
        this.nomeAgencia = agencia;
    }

    public int getClienteId() {
        return clienteId;
    }

    public void setClienteId(int clienteId) {
        this.clienteId = clienteId;
    }
    
    

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getDataCriacao() {
        return dataCriacao;
    }

    public void setDataCriacao(Date dataCriacao) {
        this.dataCriacao = dataCriacao;
    }

    public Date getDataAcesso() {
        return dataAcesso;
    }

    public void setDataAcesso(Date dataAcesso) {
        this.dataAcesso = dataAcesso;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public String getNomeAgencia() {
        return nomeAgencia;
    }

    public void setNomeAgencia(String nomeAgencia) {
        this.nomeAgencia = nomeAgencia;
    }
    
    
}
