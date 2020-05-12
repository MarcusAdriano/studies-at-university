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
public class ContaPoupanca extends Conta {
    private double taxaJuros;

    public ContaPoupanca() {
        
    }

    public ContaPoupanca(int clienteId, int id, String agencia, Date dataCriacao, Date dataAcesso, double saldo, 
            double juros) {
        super(clienteId, id, agencia, dataAcesso, dataAcesso, saldo);
        this.taxaJuros = juros;
    }
    
    public double getTaxaJuros() {
        return taxaJuros;
    }

    public void setTaxaJuros(double taxaJuros) {
        this.taxaJuros = taxaJuros;
    }
}
