/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lmv.agenciabancaria.model;

import java.sql.Date;

/**
 *
 * @author Marcus
 */
public class ContaCorrente extends Conta {
    private double taxaMensal;

    public ContaCorrente(int clienteId, int id, String agencia, Date dAcesso, Date dCriacao, 
            double saldo, double taxaMensal) {
        super(clienteId, id, agencia, dAcesso, dCriacao, saldo);
        this.taxaMensal = taxaMensal;
    }
    
    public ContaCorrente() {
        
    }
    
    public double getTaxaMensal() {
        return taxaMensal;
    }

    public void setTaxaMensal(double taxaMensal) {
        this.taxaMensal = taxaMensal;
    }
}
