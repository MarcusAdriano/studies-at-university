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
import com.mv.util.R;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.LinkedList;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import com.mv.truco.listeners.CartaClickListener;
import java.io.Serializable;

public class JCarta extends JLabel implements Serializable{
    
    private LinkedList<CartaClickListener> mListeners;
    private Carta mCarta;
    private ImageIcon icon;
    private CardsImageCode mCode;
    private JCarta jCarta = this;
    
    public JCarta (Carta carta) {
        this.mCarta = carta;
        mListeners = new LinkedList<>();      
        create();
    }
    
    private void create() {
        setImage(CardsImageCode.LARGE);
        
        addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (!isEnabled()) return;
                
                for (CartaClickListener l : mListeners) 
                    l.onClick(jCarta, mCarta);
            }

            @Override
            public void mousePressed(MouseEvent e) {
                if (mCode == CardsImageCode.LARGE)
                    setImage(CardsImageCode.MINI);
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                setImage(CardsImageCode.LARGE);
            }

            @Override
            public void mouseEntered(MouseEvent e) {
            }

            @Override
            public void mouseExited(MouseEvent e) {
            }
        });
    }
    
    public void addEventListener(CartaClickListener l) {
        mListeners.add(l);
    }
    
    public void setImage(CardsImageCode c) {
        switch (c) {
            case MINI:
                icon = new ImageIcon(R.PATH_MINI_CARDS + 
                        mCarta.getValor() + "_" + 
                        mCarta.getNaipe().id +".png");
                super.setIcon(icon);
                break;
                
            case LARGE:
                icon = new ImageIcon(R.PATH_LARGE_CARDS + 
                        mCarta.getValor() + "_" + 
                        mCarta.getNaipe().id +".png");
                super.setIcon(icon);
                break;
        }
        this.mCode = c;
    }
    
    public enum CardsImageCode {
        MINI, LARGE;
    }
    
    public Carta getCarta() {
        return this.mCarta;
    }
    
    public void setCarta(Carta c) {
        mCarta = c;
        setImage(mCode);
    }
}
