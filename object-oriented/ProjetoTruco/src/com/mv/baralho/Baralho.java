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
package com.mv.baralho;

import com.mv.util.Stack;
import java.io.Serializable;
import java.util.LinkedList;
import java.util.Random;


public class Baralho implements Serializable{
    
    final protected Stack<Carta> mBaralho;
    private LinkedList<Carta> cartasDescartadas;
    private TipoTrucoMineiro mTipoBaralho;
    
    public Baralho (TipoTrucoMineiro t) {
        cartasDescartadas = new LinkedList<>();
        mBaralho = new Stack<>();   
        mTipoBaralho = t;
        create();
    }
    
    private void create() {
        if (mTipoBaralho == TipoTrucoMineiro.BARALHO_52) {
            Naipe[] naipes = {Naipe.COPAS, Naipe.ESPADAS, Naipe.OUROS, Naipe.PAUS};
            for (int i = 1; i <= 13; i++) {
                for (Naipe n: naipes) 
                    mBaralho.push(new Carta(n, i, 1));
            }
        } else {
            Naipe[] naipes = {Naipe.COPAS, Naipe.ESPADAS, Naipe.OUROS, Naipe.PAUS};
            int[] cartas = {Carta.CARTA_4, Carta.CARTA_5, Carta.CARTA_6, Carta.CARTA_7,
                            Carta.CARTA_Q, Carta.CARTA_J, Carta.CARTA_K, Carta.CARTA_A,
                            Carta.CARTA_2, Carta.CARTA_3};
            
            mBaralho.push(new Carta(Naipe.PAUS, Carta.CARTA_4, cartas.length + 4));
            mBaralho.push(new Carta(Naipe.COPAS, Carta.CARTA_7, cartas.length + 3));
            mBaralho.push(new Carta(Naipe.ESPADAS, Carta.CARTA_A, cartas.length + 2));
            mBaralho.push(new Carta(Naipe.OUROS, Carta.CARTA_7, cartas.length + 1));
            
            if (mTipoBaralho == TipoTrucoMineiro.SUJO) {
                for (int i = 0; i < cartas.length; i++) {
                    for (Naipe p: naipes) {
                        if (p == Naipe.PAUS && cartas[i] == Carta.CARTA_4) continue;
                        if (p == Naipe.COPAS && cartas[i] == Carta.CARTA_7) continue;
                        if (p == Naipe.ESPADAS && cartas[i] == Carta.CARTA_A) continue;
                        if (p == Naipe.OUROS && cartas[i] == Carta.CARTA_7) continue;
                        mBaralho.push(new Carta(p, cartas[i], i));
                    }
                }                
            } else { // baralho limpo
                for (int i = 4; i < cartas.length; i++) {
                    for (Naipe p: naipes) {
                        if (p == Naipe.PAUS && cartas[i] == Carta.CARTA_4) continue;
                        if (p == Naipe.COPAS && cartas[i] == Carta.CARTA_7) continue;
                        if (p == Naipe.ESPADAS && cartas[i] == Carta.CARTA_A) continue;
                        if (p == Naipe.OUROS && cartas[i] == Carta.CARTA_7) continue;
                        mBaralho.push(new Carta(p, cartas[i], i));
                    }
                } 
            }
        }
    }
    
    final public void embaralhar() {        
        cartasDescartadas.addAll(mBaralho.getAll());
        
        mBaralho.clear();
        
        Random rand = new Random();
        
        while (!cartasDescartadas.isEmpty()) {
            int r = rand.nextInt(cartasDescartadas.size());
            Carta c = cartasDescartadas.get(r);
            cartasDescartadas.remove(r);
            
            mBaralho.push(c);
        }
        cartasDescartadas.clear();
    }
    
    final public Carta pegarCarta() {
        Carta c = mBaralho.pop();
        cartasDescartadas.add(c);
        return c;
    }
    
    final public int tamanho() {
        return mBaralho.size();
    }
    
    public void recriarBaralho() {
        for (Carta c : cartasDescartadas)
            mBaralho.push(c);
        
        cartasDescartadas.clear();        
        embaralhar();
    }
}