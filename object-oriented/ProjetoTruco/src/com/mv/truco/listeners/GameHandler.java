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

public interface GameHandler extends Serializable {
    
    public enum GameHandlerStatus {
        ARG_NOVA_RODADA("Começou um nova rodada!"),
        FIM_DA_RODADA("Fim da rodada!"),
        FIM_DA_MAO("Fim da mão!"),
        ARG_FIM_QUEDA("Fim da queda!");
    
        private String mensagem;
    
        private GameHandlerStatus(String msg) {
            mensagem = msg;
        }
    }
    
    public void onGameStatusChange(GameHandlerStatus status);
    public void onGameStatusChange(Object arg, GameHandlerStatus status);
    public void onGameError(String mensagem);
    public void onGameTurnChange(JJogador j);
}
