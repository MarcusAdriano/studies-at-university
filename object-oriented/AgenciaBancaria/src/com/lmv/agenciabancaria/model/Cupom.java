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
public class Cupom {
    private int num, opId;
    private Date validade;

    public Cupom() {
    }
    
    public Cupom(int num, int opId, Date validade) {
        this.num = num;
        this.opId = opId;
        this.validade = validade;
    }

    public int getOpId() {
        return opId;
    }

    public void setOpId(int opId) {
        this.opId = opId;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public void setValidade(Date validade) {
        this.validade = validade;
    }
    
    final public int getNum() {
        return num;
    }

    final public Date getValidade() {
        return validade;
    }
}
