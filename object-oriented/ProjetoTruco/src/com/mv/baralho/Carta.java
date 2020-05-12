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

import java.io.Serializable;

public class Carta implements Serializable{
    final private Naipe naipe;
    final private int valor;
    private int peso;
    
    final public static int CARTA_A = 0;
    final public static int CARTA_2 = 1;
    final public static int CARTA_3 = 2;
    final public static int CARTA_4 = 3;
    final public static int CARTA_5 = 4;
    final public static int CARTA_6 = 5;
    final public static int CARTA_7 = 6;
    final public static int CARTA_8 = 7;
    final public static int CARTA_9 = 8;
    final public static int CARTA_10 = 9;
    final public static int CARTA_Q = 10;
    final public static int CARTA_J = 11;
    final public static int CARTA_K = 12;
    
    public Carta(Naipe naipe, int valor, int p) {
        if (valor < CARTA_A || valor > CARTA_K)
            throw new RuntimeException("Valor da carta inválido!");
        
        this.naipe = naipe;
        this.valor = valor;
        this.peso = p;
    }    
    
    public Naipe getNaipe() {
        return naipe;
    }
    
    public int getValor() {
        return valor;
    }
    
    public int getPeso() {
        return peso;
    }
}