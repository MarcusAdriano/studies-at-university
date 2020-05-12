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
import java.awt.GridLayout;
import java.io.Serializable;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class JPontos extends JPanel implements Serializable{
    
    private DuplaJogadores d1;
    private JLabel[] labels;
    
    public JPontos (DuplaJogadores d1) {
        super();
        this.d1 = d1;
        
        create();
    }
    
    private void create() {
        labels = new JLabel[3];
        
        for (int i = 0; i < labels.length; i++) {
            labels[i] = new JLabel();
        }
        
        JPanel elementos = new JPanel();
        GridLayout grid = new GridLayout(4,2);
        elementos.setLayout(grid);
        
        JLabel l = new JLabel(d1.getNome());        
        l.setFont(R.getFont().deriveFont(22f));
        
        elementos.add(l);
        elementos.add(new JLabel(""));
        
        l = new JLabel("QUEDAS :: ");
        //l.setFont(R.getFont().deriveFont(18f));
        
        elementos.add(l);
        elementos.add(labels[0]);
        
        l = new JLabel("TENTOS :: ");
        //l.setFont(R.getFont().deriveFont(18f));
        
        elementos.add(l);
        elementos.add(labels[1]);
        
        l = new JLabel("RODADAS :: ");
        //l.setFont(R.getFont().deriveFont(18f));
        
        elementos.add(l);
        elementos.add(labels[2]);
        
        atualizar();        
        super.add(elementos);
    }
    
    public void atualizar() {
        labels[0].setText("" + d1.getQuedas());
        labels[1].setText("" + d1.getTentos());
        labels[2].setText("" + d1.getRodadasGanhas());
    }
    
}
