/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lmv.agenciabancaria.model;

/**
 *
 * @author Marcus
 */
public class Emprestimo {
    private int id;
    private double valor;
    private int parcelas;
    private String nomeAgencia;

    public Emprestimo(int id, String nomeAgencia, double valor, int parcelas) {
        this.id = id;
        this.valor = valor;
        this.parcelas = parcelas;
        this.nomeAgencia = nomeAgencia;
    }
    
    public Emprestimo() {
        
    }

    public String getNomeAgencia() {
        return nomeAgencia;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public void setParcelas(int parcelas) {
        this.parcelas = parcelas;
    }
    
    

    public void setNomeAgencia(String nomeAgencia) {
        this.nomeAgencia = nomeAgencia;
    }

    public int getId() {
        return id;
    }

    public double getValor() {
        return valor;
    }

    public int getParcelas() {
        return parcelas;
    }
    
    
}
