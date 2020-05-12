/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lmv.agenciabancaria.model;

/**
 *
 * @author marcus
 */
public class Agencia {
    private String nome, estado, cidade;

    public Agencia(String nome, String estado, String cidade) {
        this.nome = nome.trim();
        this.estado = estado.trim();
        this.cidade = cidade.trim();
    }
    
    public Agencia() {
        
    }
    
    public String getNome() {
        return nome;
    }
    
    public void setNome(String nome) {
        this.nome = nome;
    } 
    
    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    @Override
    public String toString() {
        return nome;
    }
}
