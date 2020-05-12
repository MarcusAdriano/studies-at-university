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
public class Dependente {
    private int numFuncionario;
    private String nome;

    public Dependente(int numFuncionario, String nome) {
        this.numFuncionario = numFuncionario;
        this.nome = nome;
    }

    public Dependente() {
        
    }
    
    public int getNumFuncionario() {
        return numFuncionario;
    }

    public void setNumFuncionario(int numFuncionario) {
        this.numFuncionario = numFuncionario;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
    
    
}
