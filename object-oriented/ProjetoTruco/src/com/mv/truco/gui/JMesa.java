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

import com.mv.truco.DuplaJogadores;
import com.mv.baralho.Carta;
import com.mv.truco.listeners.GameHandler;
import com.mv.truco.listeners.JogadorClickListener;
import com.mv.truco.listeners.TrucoHandler;
import com.mv.util.Queue;
import com.mv.util.R;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.io.Serializable;
import java.util.Random;
import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;


public class JMesa extends JPanel implements JogadorClickListener, TrucoHandler, Serializable{
    
    private int tentosRodada;
    private Carta maiorCarta = null;
    private int indexMaiorJogador; 
    private int indexProxJogador;
    private int indexJogadorTruco;
    private DuplaJogadores d1, d2;
    private Queue<JJogador> fMesa; 
    private JPanel panelCartasJogadas;
    private GameHandler g;
    private boolean isTruco;
    private JLabel labelTentos;
    
    public JMesa(DuplaJogadores d1, DuplaJogadores d2, GameHandler g) {
        this.d1 = d1;
        this.d2 = d2;
        fMesa = new Queue<>();
        this.g = g;
        this.isTruco = false;
        
        d1.getJogador1().setIndex(0);
        d1.getJogador2().setIndex(2);
        d2.getJogador1().setIndex(1);        
        d2.getJogador2().setIndex(3);
                
        create();        
    }
    
    private void create() {
        super.setLayout(new BorderLayout(10, 10));
        super.setBorder(BorderFactory.createLineBorder(Color.BLACK)); 
        
        labelTentos = new JLabel();
        labelTentos.setHorizontalAlignment(JLabel.CENTER);
        labelTentos.setFont(R.getFont().deriveFont(65f));
        
        panelCartasJogadas = new JPanel();        
        GridLayout grid = new GridLayout(1,3);
        grid.setHgap(10); grid.setVgap(10);   
        panelCartasJogadas.setLayout(grid);
        
        setBackground(Color.green);
        
        panelCartasJogadas.add(labelTentos);
        panelCartasJogadas.add(new JPanel());
        panelCartasJogadas.add(new JPanel());
        
        super.add(panelCartasJogadas, BorderLayout.CENTER);
    }
    
    private void addCarta(Carta c) {
        JCarta j = new JCarta(c);
        j.setImage(JCarta.CardsImageCode.MINI);
        panelCartasJogadas.remove(1);
        panelCartasJogadas.add(j, 1);
    }
    
    private void enfileirarJogadores(int index) {
        for (int i = 0; i < 4; i++) {
            fMesa.enqueue(getJogador(index));
            index++;
            index = index % 4;
        }
        g.onGameStatusChange(fMesa.peek(), GameHandler.GameHandlerStatus.ARG_NOVA_RODADA);
    }
    
    private boolean ehMesmaDupla (int a, int b) {
        return (a % 2) == (b % 2);
    }
    
    private JJogador getJogador (int index) {
        switch (index) {
            case 0:
                return d1.getJogador1();
                
            case 1:
                return d2.getJogador1();
                
            case 2:
                return d1.getJogador2();
                
            case 3:
                return d2.getJogador2();
        }
        throw new RuntimeException("Índice inválido!");
    }   
    
    @Override
    public void onJogadorClicked(JCarta source, Carta c, JJogador j) {
        if (fMesa.peek().getIndex() == j.getIndex()) {
            fMesa.dequeue();
            if (maiorCarta == null) {
                maiorCarta = c;
                indexMaiorJogador = j.getIndex();
            } else {
                if (c.getPeso() >= maiorCarta.getPeso()) {
                    if (c.getPeso() == maiorCarta.getPeso() && !ehMesmaDupla(indexMaiorJogador, j.getIndex())){
                        indexMaiorJogador = j.getIndex() + 10;
                    } else {
                        maiorCarta = c;
                        indexMaiorJogador = j.getIndex();
                    }
                }
            }
            
            addCarta(maiorCarta);
            source.setVisible(false);
            
            if (fMesa.isEmpty()) {
                fimRodada();
                if (g != null)
                    g.onGameStatusChange(GameHandler.GameHandlerStatus.FIM_DA_RODADA);
            }
        } else {
            g.onGameError("NÃO É A SUA VEZ " + j.getNome().toUpperCase());
        }
        
        j.fimTurnoJogador();
        fMesa.peek().turnoJogador();
        
        if (isTruco) {
            if (!ehMesmaDupla(fMesa.peek().getIndex(), indexJogadorTruco)) {
                fMesa.peek().setBtnTrucarEnabled(isTruco);
                fMesa.peek().setBtnCorrerEnabled(isTruco);
            }
            else
                fMesa.peek().setButtonsEnabled(false);
        } else {
            fMesa.peek().setButtonsEnabled(false);
            fMesa.peek().setBtnTrucarEnabled(true);
        }        
    }
    
    public void reset() {
        d1.reset();
        d2.reset();        
        comecarJogo();
    }
    
    private void fimRodada() {
        limparMesa();
        
        if (indexMaiorJogador == 0 || indexMaiorJogador == 2)
            d1.addRodada();
        else if (indexMaiorJogador == 1 || indexMaiorJogador == 3)                    
            d2.addRodada();
        else {
            d1.addRodada();
            d2.addRodada();
            indexMaiorJogador -= 10;
        }
        
        //Verificar se a rodada já acabou
        if (rodadasAcabaram()) {
            novaMao();
            return;
        }

        enfileirarJogadores(indexMaiorJogador);
    }
    
    private void novaMao() {
        enfileirarJogadores(indexProxJogador);
        indexProxJogador = (indexProxJogador + 1) % 4;
        maiorCarta = null;
        isTruco = false;
        
        d1.zerarRodadas();
        d2.zerarRodadas();
        
        fMesa.peek().turnoJogador();
        fMesa.peek().setBtnTrucarEnabled(true);
    }
    
    private boolean rodadasAcabaram() {
        if ((d1.getRodadasGanhas() >= 2 || d2.getRodadasGanhas() >= 2) && d1.getRodadasGanhas() != d2.getRodadasGanhas()) {
            if (d1.getRodadasGanhas() > d2.getRodadasGanhas())
                d1.addTentos(tentosRodada);
            else
                d2.addTentos(tentosRodada);
            
            if (d1.getTentos() >= 12) {
                d1.addQueda();
                d1.zerarRodadas();
                d1.zerarTentos();
                d2.zerarRodadas();
                d2.zerarTentos();
                
                g.onGameStatusChange(d1, GameHandler.GameHandlerStatus.ARG_FIM_QUEDA);
            } else if (d2.getTentos() >= 12) {
                d1.zerarRodadas();
                d1.zerarTentos();
                d2.addQueda();
                d2.zerarRodadas();
                d2.zerarTentos();
                
                g.onGameStatusChange(d2, GameHandler.GameHandlerStatus.ARG_FIM_QUEDA);
            }
            
            g.onGameStatusChange(GameHandler.GameHandlerStatus.FIM_DA_MAO);
            tentosRodada = 1;
            labelTentos.setText("" + tentosRodada);
            return true;
        }
        return false;
    }
    
    private void limparMesa() {
        labelTentos.setText("" + tentosRodada);
        panelCartasJogadas.remove(1);
        panelCartasJogadas.add(new JPanel(), 1);
        maiorCarta = null;
    }
    
    public void comecarJogo() {
        limparMesa();
        if (!fMesa.isEmpty()) { 
            fMesa.peek().fimTurnoJogador();
            fMesa.clear();
        }
        
        Random rand = new Random(); 
        tentosRodada = 1;
        int r = rand.nextInt(4); 
        enfileirarJogadores(r);
        indexProxJogador = (r + 1) % 4;
        fMesa.peek().turnoJogador();
        fMesa.peek().setBtnTrucarEnabled(true);
        labelTentos.setText("" + tentosRodada);
    }
    
    public JJogador getProximoJogador() {
        return getJogador((fMesa.peek().getIndex() + 1) % 4);
    }

    @Override
    public void onCallTruco(int status, JJogador j) {        
        JJogador jAux;
        
        switch (status) {
            case TrucoHandler.ACEITAR_TRUCO:
                isTruco = true;
                labelTentos.setText("" + tentosRodada);
                j.setButtonsEnabled(false);
                break;
                
            case TrucoHandler.CHAMAR_TRUCO:
                if(tentosRodada == 1)
                    tentosRodada = 3;
                else if(tentosRodada != 1)
                    tentosRodada +=3; 
                
                indexJogadorTruco = j.getIndex();
                if (getProximoJogador().getIndex() == j.getIndex()) 
                    jAux = fMesa.peek();
                 else
                    jAux = getProximoJogador();
                
                j.setEnabled(false);
                j.setButtonsEnabled(false);                
                jAux.setButtonsEnabled(true);            
                break;
                
            case TrucoHandler.CORRER_TRUCO:
                if (!isTruco) {
                    if (tentosRodada <= 3)
                        tentosRodada = 1;
                    else
                        tentosRodada -= 3;
                }
                
                if (j.getIndex() % 2 == 0)  
                    d2.setRodada(20);
                else
                    d1.setRodada(20);
                
                fMesa.peek().fimTurnoJogador();
                fMesa.clear();
                
                j.setButtonsEnabled(false);
                fimRodada();
                g.onGameStatusChange(GameHandler.GameHandlerStatus.FIM_DA_RODADA);               
                break;
        }
    }
}
