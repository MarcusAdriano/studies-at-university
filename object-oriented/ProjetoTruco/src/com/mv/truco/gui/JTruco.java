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
import com.mv.baralho.Baralho;
import com.mv.baralho.Carta;
import com.mv.baralho.TipoTrucoMineiro;
import com.mv.truco.listeners.GameHandler;
import com.mv.truco.listeners.JogadorClickListener;
import com.mv.util.StatusBar;
import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.Serializable;
import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class JTruco extends JFrame implements Serializable, JogadorClickListener, GameHandler{
     
    private StatusBar statusBar;
    private JPanel panelJogadores;
    private JJogador j1, j2, j3, j4;
    private DuplaJogadores d1, d2;
    private JMesa mesa;
    private Baralho mBaralho;
    private JPontos panelPontosD1, panelPontosD2;
    
    public void startGame(DuplaJogadores d1, DuplaJogadores d2) {
        this.d1 = d1;
        this.d2 = d2;
        
        mesa = new JMesa(d1, d2, this);         
        setupListeners();        
        mBaralho = new Baralho(TipoTrucoMineiro.SUJO);        
        create();
    }
    
    private void setupListeners() {
        j1 = d1.getJogador1();
        j2 = d1.getJogador2();
        j3 = d2.getJogador1();
        j4 = d2.getJogador2();
        
        j1.addJogadorClickListener(this);
        j2.addJogadorClickListener(this);
        j3.addJogadorClickListener(this);
        j4.addJogadorClickListener(this);
        
        j1.addJogadorClickListener(mesa); j1.setTrucoHandler(mesa);
        j2.addJogadorClickListener(mesa); j2.setTrucoHandler(mesa);
        j3.addJogadorClickListener(mesa); j3.setTrucoHandler(mesa);
        j4.addJogadorClickListener(mesa); j4.setTrucoHandler(mesa);
        
        j1.setNomeDupla(d1.getNome());
        j2.setNomeDupla(d1.getNome());
        j3.setNomeDupla(d2.getNome());
        j4.setNomeDupla(d2.getNome());
    }
    
    private void create() {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(new BorderLayout(20, 20));
        this.getRootPane().setBorder(BorderFactory.createEmptyBorder(0, 20, 0, 20));
        this.setTitle("TRUCO");
        
        //MENU BAR
        JMenuBar menuBar = new JMenuBar();
        JMenu menuGame, menuAbout, menuHelp;
        JMenuItem gameSave, gameExit, gameNew, gameLoad,
                  about,
                  help;
        
        // MENU GAME
        menuGame = new JMenu("Jogo");
        gameExit = new JMenuItem("Sair");       
        gameNew = new JMenuItem("Novo Jogo");
        
        menuGame.add(gameNew);
        menuGame.addSeparator();
        menuGame.addSeparator();
        menuGame.add(gameExit);
        
         // MENU SOBRE
        menuAbout = new JMenu("Sobre");        
        about = new JMenuItem("Sobre...");
        
        ActionListener abouGame = e -> {
            JOptionPane.showMessageDialog(this, 
                    "Desenvolvido por Marcus Adriano e Vitor Hugo (C) 2016. "
                            + "Todos os Direitos Reservados.");
        };
        about.addActionListener(abouGame);
        
        menuAbout.add(about);
        
        menuBar.add(menuGame);
        menuBar.add(menuAbout);
        
        super.setJMenuBar(menuBar);
        
        ActionListener newGame = e -> {
            int res = JOptionPane.showConfirmDialog(this, "Deseja realmente começar um novo jogo?", "Novo Jogo", JOptionPane.YES_NO_OPTION);
            if (res == JOptionPane.YES_OPTION)
                this.reset();
        };
        
        ActionListener exitGame = e -> {
            exitGame();
        };     
        
        gameNew.addActionListener(newGame);
        gameExit.addActionListener(exitGame);
        // MENU $$$
        
        Container content = this.getContentPane();
        statusBar = new StatusBar(content);
        panelPontosD1 = new JPontos(d1);
        panelPontosD2 = new JPontos(d2);
        
        panelJogadores = new JPanel();
        GridLayout gridJogadores = new GridLayout(3,3);
        gridJogadores.setHgap(15);
        gridJogadores.setVgap(15);
        panelJogadores.setLayout(gridJogadores);
        
        distribuirCartas();
        
        panelJogadores.add(new JPanel());
        panelJogadores.add(d1.getJogador1());
        panelJogadores.add(panelPontosD2);
        panelJogadores.add(d2.getJogador1());
        panelJogadores.add(mesa); // mesa
        panelJogadores.add(d2.getJogador2());
        panelJogadores.add(panelPontosD1); // contador de pontos
        panelJogadores.add(d1.getJogador2());
        panelJogadores.add(new JPanel());
        
        content.add(panelJogadores, BorderLayout.CENTER);        
        content.add(statusBar, BorderLayout.SOUTH);
        
        mesa.comecarJogo();
        
        this.addWindowListener(new WindowListener() {
            @Override
            public void windowOpened(WindowEvent e) {
            }

            @Override
            public void windowClosing(WindowEvent e) {
                exitGame();
            }

            @Override
            public void windowClosed(WindowEvent e) {
            }

            @Override
            public void windowIconified(WindowEvent e) {
            }

            @Override
            public void windowDeiconified(WindowEvent e) {
            }

            @Override
            public void windowActivated(WindowEvent e) {
            }

            @Override
            public void windowDeactivated(WindowEvent e) {
            }
        });
        
        this.pack();
        this.setMinimumSize(this.getSize());
        this.setVisible(true);
        this.setLocationRelativeTo(null);
    }

    private void exitGame() {
        int res = JOptionPane.showConfirmDialog(this, "Deseja realmente sair?", "Sair", JOptionPane.YES_NO_OPTION);
            if (res == JOptionPane.YES_OPTION)
                this.dispose();
            else
                setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
    }
    
    @Override
    public void onJogadorClicked(JCarta source, Carta c, JJogador j) {
        //statusBar.clear();
    }
    
    private void reset() {
        mesa.reset();
        distribuirCartas();
        
    }

    @Override
    public void onGameError(String mensagem) {
        statusBar.setError(mensagem);
    }

    @Override
    public void onGameStatusChange(Object o, GameHandlerStatus status) {
        atualizarPainelPontos();
        switch (status) {                
            case ARG_NOVA_RODADA:                
                JJogador j = null;
                if (o instanceof JJogador) {
                    j = (JJogador) o;
                    statusBar.setMensagem("Começou uma nova rodada! Por favor, comece jogando " + j.getNome());
                }
                break;
                
            case ARG_FIM_QUEDA:
                DuplaJogadores d1 = null;
                if (o instanceof DuplaJogadores) {
                    d1 = (DuplaJogadores) o;
                    JOptionPane.showMessageDialog(rootPane, "A dupla " + d1.getNome() + " ganhou!! Continue jogando!\n\nNúmero de quedas ganhas: " + d1.getQuedas());
                }
                break;
        }
    }   

    @Override
    public void onGameStatusChange(GameHandlerStatus status) {
        atualizarPainelPontos();
        switch (status) {
            case FIM_DA_RODADA:
                break;
                
            case FIM_DA_MAO:
                distribuirCartas();                
                break;
        }
    }

    @Override
    public void onGameTurnChange(JJogador j) {
        
    }
    
    public void distribuirCartas() {
        d1.getJogador1().descartarCartas();
        d1.getJogador2().descartarCartas();
        d2.getJogador1().descartarCartas();
        d2.getJogador2().descartarCartas();
        
        mBaralho.recriarBaralho();
        mBaralho.embaralhar();
        
        for (int i = 0; i < 3; i++) {
            d1.getJogador1().addCarta(mBaralho.pegarCarta());
            d1.getJogador2().addCarta(mBaralho.pegarCarta());
            d2.getJogador1().addCarta(mBaralho.pegarCarta());
            d2.getJogador2().addCarta(mBaralho.pegarCarta());            
        }
    }
    
    public void atualizarPainelPontos() {
        panelPontosD1.atualizar();
        panelPontosD2.atualizar();
    }
    
    
}
