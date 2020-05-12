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
public class Operacao {
    private int id, idContaCorrente;
    private String nomeAgencia;
    private String descricao;
    private double valor;
    private Date data;

    public Operacao(int id, int idContaCorrente, String nomeAgencia, String descricao, double valor, Date data) {
        this.id = id;
        this.idContaCorrente = idContaCorrente;
        this.nomeAgencia = nomeAgencia;
        this.descricao = descricao;
        this.valor = valor;
        this.data = data;
    }

    public Operacao() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdContaCorrente() {
        return idContaCorrente;
    }

    public void setIdContaCorrente(int idContaCorrente) {
        this.idContaCorrente = idContaCorrente;
    }

    public String getNomeAgencia() {
        return nomeAgencia;
    }

    public void setNomeAgencia(String nomeAgencia) {
        this.nomeAgencia = nomeAgencia;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    
}
