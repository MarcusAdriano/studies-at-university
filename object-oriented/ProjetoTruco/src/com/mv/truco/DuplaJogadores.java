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
package com.mv.truco;

import com.mv.truco.gui.JJogador;
import java.io.Serializable;

public class DuplaJogadores implements Serializable{
    private JJogador mJogador1, mJogador2;
    private String mNome;
    private int tentos;
    private int rodadasGanhas;
    private int quedas;
    
    public DuplaJogadores (String nome, JJogador j1, JJogador j2) {
        this.mJogador1 = j1;
        this.mJogador2 = j2;
        this.mNome = nome;
        this.tentos = 0;
        this.rodadasGanhas = 0;
        this.quedas = 0;
    }

    public JJogador getJogador1() {
        return mJogador1;
    }

    public JJogador getJogador2() {
        return mJogador2;
    }

    public String getNome() {
        return mNome;
    }
    
    public void addTentos(int t){
        tentos += t;
    }
    
    public int getTentos() {
        return this.tentos;
    }
    
    public void addRodada() {
        rodadasGanhas ++;
    }
    
    public int getRodadasGanhas() {
        return rodadasGanhas;
    }
    
    public void zerarRodadas() {
        rodadasGanhas = 0;
    }
    
    public void setRodada(int n) {
        rodadasGanhas = n;
    }
    
    public void addQueda() {
        quedas++;
    }
    
    public void zerarQuedas() {
        quedas = 0;
    }
    
    public int getQuedas() {
        return this.quedas;
    }
    
    public void reset() {
        zerarRodadas();
        zerarQuedas();
        zerarTentos();
    }
    
    public void zerarTentos() {
        tentos = 0;
    }
}