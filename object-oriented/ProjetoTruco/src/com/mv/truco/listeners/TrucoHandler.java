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
package com.mv.truco.listeners;

import com.mv.truco.gui.JJogador;
import java.io.Serializable;

public interface TrucoHandler extends Serializable{
    
    public final static int CHAMAR_TRUCO = 0;
    public final static int ACEITAR_TRUCO = 1;
    public final static int CORRER_TRUCO = 2;
    
    public void onCallTruco(int status, JJogador j);
    
}
