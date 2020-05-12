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
import com.mv.util.R;
import com.mv.util.StatusBar;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class JTrucoLauncher extends JFrame{
    
    public static void main (String args[]) {  
        new JTrucoLauncher();
    }
    
    private JJogador j1, j2, j3, j4;

    public JTrucoLauncher() {
         create();
    }

    private void create() {
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setLayout(new BorderLayout(10, 10));
        this.getRootPane().setBorder(BorderFactory.createEmptyBorder(20, 20, 0, 20));
        GridLayout grid;      
        
        this.setTitle("Iniciar Partida de Truco");
        
        StatusBar bar = new StatusBar(this);
        
        JPanel panelInfoJogadores = new JPanel();
        grid = new GridLayout(8,1);
        grid.setHgap(15);
        grid.setVgap(15);
        panelInfoJogadores.setBorder(BorderFactory.createEtchedBorder(Color.black, Color.blue));
        panelInfoJogadores.setLayout(grid);
        
        JTextField txtJ1, txtJ2, txtJ3, txtJ4;
        txtJ1 = new JTextField(20);
        txtJ2 = new JTextField(20);
        txtJ3 = new JTextField(20);
        txtJ4 = new JTextField(20);
        
        panelInfoJogadores.add(new JLabel("Jogador 1 (DUPLA A)"));
        panelInfoJogadores.add(txtJ1);
        panelInfoJogadores.add(new JLabel("Jogador 2 (DUPLA A)"));
        panelInfoJogadores.add(txtJ2);
        panelInfoJogadores.add(new JLabel("Jogador 1 (DUPLA B)"));
        panelInfoJogadores.add(txtJ3);
        panelInfoJogadores.add(new JLabel("Jogador 2 (DUPLA B)"));
        panelInfoJogadores.add(txtJ4);

        JPanel panelControles = new JPanel();
        grid = new GridLayout(2,1);
        grid.setHgap(20);
        grid.setVgap(10);
        panelControles.setLayout(grid);
        
        ActionListener jogar = e -> {
            String j1 = txtJ1.getText().trim();
            String j2 = txtJ2.getText().trim();
            String j3 = txtJ3.getText().trim();
            String j4 = txtJ4.getText().trim();
            
            if (j1.length() == 0 || j1.length() > 20) {
                JOptionPane.showMessageDialog(this, 
                        "Jogador 1 (DUPLA A) muito pequeno ou muito grande!", 
                        "Atenção", JOptionPane.WARNING_MESSAGE);
                return;
            }
            
            if (j2.length() == 0 || j2.length() > 20) {
                JOptionPane.showMessageDialog(this, 
                        "Jogador 2 (DUPLA A) muito pequeno ou muito grande!", 
                        "Atenção", JOptionPane.WARNING_MESSAGE);
                return;
            }
            
            if (j3.length() == 0 || j3.length() > 20) {
                JOptionPane.showMessageDialog(this, 
                        "Jogador 1 (DUPLA B) muito pequeno ou muito grande!", 
                        "Atenção", JOptionPane.WARNING_MESSAGE);
                return;
            }
            
            if (j3.length() == 0 || j3.length() > 20) {
                JOptionPane.showMessageDialog(this, 
                        "Jogador 2 (DUPLA B) muito pequeno ou muito grande!", "Atenção", 
                        JOptionPane.WARNING_MESSAGE);
                return;
            }
            
            String dupla1 = JOptionPane.showInputDialog(this, "Nome da DUPLA A");
            String dupla2 = JOptionPane.showInputDialog(this, "Nome da DUPLA B");
            
            dupla1 = dupla1.isEmpty() ? "DUPLA A" : dupla1;
            dupla2 = dupla2.isEmpty() ? "DUPLA B" : dupla2;
            
            DuplaJogadores d1 = new DuplaJogadores(dupla1, new JJogador(j1), new JJogador(j2));
            DuplaJogadores d2 = new DuplaJogadores(dupla2, new JJogador(j3), new JJogador(j4));
            
            JTruco t = new JTruco();
            t.startGame(d1, d2);
            this.dispose();
        };

        ActionListener sair = e -> {
            dispose();
        };

        JButton btnJogar, btnCarregarJogo, btnSair;
        btnJogar = new JButton();
        btnSair = new JButton("Sair");
        getRootPane().setDefaultButton(btnJogar);
        
        btnJogar.addActionListener(jogar);
        btnSair.addActionListener(sair);
        
        btnJogar.setIcon(new ImageIcon(R.PATH + "play.png"));
        btnSair.setIcon(new ImageIcon(R.PATH + "sair.png"));
        
        btnJogar.setToolTipText("iniciar novo jogo");
        btnSair.setToolTipText("Seria uma pena se você não jogasse");
        
        panelControles.add(btnJogar);
        panelControles.add(btnSair);
        
        bar.setMensagem("Todos os Direitos Reservados. Marcus, Vitor (C) 2016");
        
        JLabel logo = new JLabel();
        logo.setIcon(new ImageIcon(R.PATH + "truco.png"));
        
        this.add(panelInfoJogadores, BorderLayout.EAST);
        this.add(panelControles, BorderLayout.CENTER);
        this.add(bar, BorderLayout.SOUTH);
        this.add(logo, BorderLayout.WEST);
        
        this.setResizable(false);
        this.pack();
        this.setMinimumSize(this.getSize());
        this.setLocationRelativeTo(null);
        this.setVisible(true);     
    }
}
