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
public class Cliente {
    private String cpf, cidade, endereco, estado, nome;
    private Date dataNiver;
    private int id, gerNum;

    public Cliente(int id, int ger_num, String cpf, String cidade,
            String endereco, String estado, String nome, Date dNiver) {
        this.cpf = cpf;
        this.gerNum = ger_num;
        this.cidade = cidade;
        this.endereco = endereco;
        this.estado = estado;
        this.nome = nome;
        this.dataNiver = dNiver;
        this.id = id;
    }

    public Cliente(String cpf, String cidade, String endereco, String estado, String nome, Date dataNiver, int gerNum) {
        this.cpf = cpf;
        this.cidade = cidade;
        this.endereco = endereco;
        this.estado = estado;
        this.nome = nome;
        this.dataNiver = dataNiver;
        this.gerNum = gerNum;
    }
    
    public Cliente() {
        
    }
    
    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setDataNiver(Date dataNiver) {
        this.dataNiver = dataNiver;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    final public String getCpf() {
        return cpf;
    }
    
    final public int getGerenteNum() {
        return this.gerNum;
    }
    
    final public void setGerenteNum(int ger) {
        this.gerNum = ger;
    }

    final public String getCidade() {
        return cidade;
    }

    final public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    final public String getEndereco() {
        return endereco;
    }

    final public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    final public String getEstado() {
        return estado;
    }

    final public void setEstado(String estado) {
        this.estado = estado;
    }

    final public String getNome() {
        return nome;
    }

    final public Date getDataNiver() {
        return dataNiver;
    }
    
    final public int getId() {
        return id;
    }
    
    @Override
    public String toString() {
        return "" + id;
    }
}
