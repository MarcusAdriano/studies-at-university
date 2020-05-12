/*
 * /* Copyright 2016 Marcus Adriano, Vitor Hugo
 * *
 * *   Licensed under the Apache License, Version 2.0 (the "License");
 * *   you may not use this file except in compliance with the License.
 * *   You may obtain a copy of the License at
 *
 * *       http://www.apache.org/licenses/LICENSE-2.0
 *
 * *   Unless required by applicable law or agreed to in writing, software
 * *   distributed under the License is distributed on an "AS IS" BASIS,
 * *   WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * *   See the License for the specific language governing permissions and
 * *   limitations under the License.
 */
package com.mv.truco.gui;

import com.mv.baralho.Carta;
import com.mv.truco.listeners.CartaClickListener;
import com.mv.truco.listeners.JogadorClickListener;
import com.mv.truco.listeners.TrucoHandler;
import com.mv.util.StatusBar;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.io.Serializable;
import java.util.Collection;
import java.util.LinkedList;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JPanel;

public class JJogador extends JPanel implements Serializable, CartaClickListener {
    private String nome;    
    private int index;
    protected LinkedList<JCarta> mJCartas;
    protected LinkedList<Carta> mCartas;
    private int qtdeCartas;
    private JPanel panelCartas, panelButtons;
    private LinkedList<JogadorClickListener> listeners;
    private StatusBar bar;
    private JButton btnCorrer, btnTrucar, btnAceitar;
    private TrucoHandler t;
    
    public JJogador (String nome) {
        this.nome = nome;
        listeners = new LinkedList<>();
        mCartas = new LinkedList<>();
        mJCartas = new LinkedList<>();
        panelCartas = new JPanel();
        panelButtons = new JPanel();
        create();
    }
    
    public void setTrucoHandler(TrucoHandler t) {
        this.t = t;
    }
    
    private void create() {
        super.setLayout(new BorderLayout(10, 10));
        
        btnCorrer = new JButton("Correr");
        btnTrucar = new JButton("Trucar");
        btnAceitar = new JButton("Aceitar");
                
        ActionListener clickCorrer = e -> {
            if (t != null)
                t.onCallTruco(TrucoHandler.CORRER_TRUCO, this);
        };
        
        ActionListener clickTrucar = e -> {
            if (t != null)
                t.onCallTruco(TrucoHandler.CHAMAR_TRUCO, this);
        };
        
        ActionListener clickAceitar = e -> {
            if (t != null)
                t.onCallTruco(TrucoHandler.ACEITAR_TRUCO, this);
        };
        
        btnCorrer.addActionListener(clickCorrer);
        btnTrucar.addActionListener(clickTrucar);
        btnAceitar.addActionListener(clickAceitar);
        
        setButtonsEnabled(false);
        
        bar = new StatusBar(this);
        bar.setCleanable(false);
        bar.setMensagem(nome);     
        
        panelButtons.add(btnTrucar);
        panelButtons.add(btnAceitar);
        panelButtons.add(btnCorrer);
        
        GridLayout grid = new GridLayout(1,3);
        grid.setHgap(10); grid.setVgap(10);
        panelCartas.setLayout(grid);
        panelCartas.setAlignmentX(CENTER_ALIGNMENT);
        
        super.add(bar, BorderLayout.NORTH);  
        super.add(panelCartas, BorderLayout.CENTER);
        super.add(panelButtons, BorderLayout.SOUTH);
    }    
    
    public Collection<Carta> getCartas() {        
        return mCartas;
    }    
    
    public int getQtdeCartas() {
        return mCartas.size();
    }
    
    public void addCarta(Carta c) {
        JCarta j = new JCarta(c);
        j.addEventListener(this);
        panelCartas.add(j);
        mJCartas.add(j);
        mCartas.add(c);
    }
    
    public int qtdeCartas() {
        return this.qtdeCartas;
    }
    
    public void setIndex(int i) {
        this.index = i;
    }
    
    public int getIndex() {
        return this.index;
    }
    
    public void addJogadorClickListener(JogadorClickListener j) {
        listeners.add(j);
    }
    
    public String getNome() {
        return this.nome;
    }

    @Override
    public void onClick(JCarta source, Carta carta) {
        for (JogadorClickListener j : listeners) 
            j.onJogadorClicked(source, carta, this);
    }
    
    public void descartarCartas() {
        mCartas.clear();
        mJCartas.clear();        
        panelCartas.removeAll();
    }
    
    public void setNomeDupla(String dupla) {
        bar.setMensagem(nome + " - " + dupla);
    }
    
    public void turnoJogador () {
        super.setBorder(BorderFactory.createEtchedBorder(Color.black, Color.blue));
    }
    
    public void fimTurnoJogador() {
        super.setBorder(BorderFactory.createEmptyBorder());
        setButtonsEnabled(false);
    }
    
    public void setBtnCorrerEnabled(boolean t) {
        btnCorrer.setEnabled(t);
    }
    
    public void setBtnTrucarEnabled(boolean t) {
        btnTrucar.setEnabled(t);
    }
    
    public void setBtnAceitarEnabled(boolean t) {
        btnAceitar.setEnabled(t);
    }
    
    public void setButtonsEnabled(boolean t) {
        btnAceitar.setEnabled(t);
        btnCorrer.setEnabled(t);
        btnTrucar.setEnabled(t);
    }
}