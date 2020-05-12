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

public enum Naipe implements Serializable{
    PAUS(1), COPAS(2), ESPADAS(3), OUROS(4);
    
    final public int id;
    
    private Naipe(int id) {
        this.id = id;
    }
}
