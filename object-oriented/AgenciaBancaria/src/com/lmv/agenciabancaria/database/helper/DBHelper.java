/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lmv.agenciabancaria.database.helper;

import com.lmv.agenciabancaria.database.TAgencia;
import com.lmv.agenciabancaria.database.TCliente;
import com.lmv.agenciabancaria.database.TContaCorrente;
import com.lmv.agenciabancaria.database.TContaPoupanca;
import com.lmv.agenciabancaria.database.TCupom;
import com.lmv.agenciabancaria.database.TDependente;
import com.lmv.agenciabancaria.database.TEmprestimo;
import com.lmv.agenciabancaria.database.TFuncionario;
import com.lmv.agenciabancaria.database.TGerente;
import com.lmv.agenciabancaria.database.TOperacaoBancaria;
import com.lmv.agenciabancaria.exception.AgenciaBancariaException;
import com.lmv.agenciabancaria.model.Agencia;
import com.lmv.agenciabancaria.model.Cliente;
import com.lmv.agenciabancaria.model.Conta;
import com.lmv.agenciabancaria.model.ContaCorrente;
import com.lmv.agenciabancaria.model.ContaPoupanca;
import com.lmv.agenciabancaria.model.Cupom;
import com.lmv.agenciabancaria.model.Dependente;
import com.lmv.agenciabancaria.model.Emprestimo;
import com.lmv.agenciabancaria.model.Funcionario;
import java.sql.SQLException;

/**
 *
 * @author Marcus
 */
public class DBHelper {
    
    private static DBHelper current = null;
    
    private TAgencia agencias;
    private TCliente clientes;
    private TContaCorrente contasCorrente;
    private TContaPoupanca contasPoupanca;
    private TCupom cupons;
    private TDependente dependentes;
    private TEmprestimo emprestimos;
    private TFuncionario funcionarios;
    private TOperacaoBancaria operacoes;
    private TGerente gerentes;
    
    private DBHelper() throws SQLException {
        agencias = new TAgencia();
        clientes = new TCliente();
        contasCorrente = new TContaCorrente();
        contasPoupanca = new TContaPoupanca();
        cupons = new TCupom();
        dependentes = new TDependente();
        emprestimos = new TEmprestimo();
        funcionarios = new TFuncionario();
        operacoes = new TOperacaoBancaria();
        gerentes = new TGerente();
    }
    
    public static synchronized DBHelper getInstance() throws SQLException {
        if (current == null) {
            current = new DBHelper();
        }        
        return current;
    }    

    public synchronized int addAgencia(Agencia a) throws SQLException {
        return agencias.add(a);
    }
    
    public synchronized Agencia[] getAllAgencia() throws SQLException {
        Object[] objs = agencias.getAll();
        Agencia[] ags = new Agencia[objs.length];
        for (int i = 0; i < objs.length; i++) {
            ags[i] = (Agencia) objs[i];
        }
        return ags;
    }

    public synchronized Cliente getCliente(int numCliente) throws SQLException, 
            AgenciaBancariaException {
        return clientes.get(numCliente);
    }

    public synchronized Funcionario getFuncionario(int numFuncionario) throws
            SQLException, AgenciaBancariaException{
        return funcionarios.get(numFuncionario);
    }

    public synchronized boolean gerenteExists(int cod) throws SQLException,
            AgenciaBancariaException {
        return gerentes.exists(cod);
    }

    public synchronized Dependente[] getAllDependenteFuncionario(Funcionario funcionario) 
            throws SQLException {
        Object[] objs = dependentes.getAllFromFuncionario(funcionario);
        Dependente[] dps = new Dependente[objs.length];
        for (int i = 0; i < objs.length; i++) {
            dps[i] = (Dependente) objs[i]; 
        }
        return dps;
    }
    
    public synchronized int addCliente(Cliente c) throws SQLException{
        return clientes.add(c);
    }
    
    public synchronized ContaCorrente getContaCorrente(String agencia, int conta) 
            throws SQLException, AgenciaBancariaException {
        return contasCorrente.get(conta + "." + agencia);
    }
    
    public synchronized ContaPoupanca getContaPoupanca(String agencia, int conta) 
            throws SQLException, AgenciaBancariaException {
        return contasPoupanca.get(conta + "." + agencia);
    }
    
    public synchronized Cupom[] getCuponsFromConta(Conta c) throws SQLException {
        Object[] objs = cupons.getFromConta(c);
        Cupom[] dps = new Cupom[objs.length];
        for (int i = 0; i < objs.length; i++) {
            dps[i] = (Cupom) objs[i]; 
        }
        return dps;
    }
    
    public synchronized int addEmprestimo(Emprestimo t) throws SQLException {
        return emprestimos.add(t);
    }
}
