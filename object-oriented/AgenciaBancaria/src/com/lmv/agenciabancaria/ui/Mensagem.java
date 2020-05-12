/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lmv.agenciabancaria.ui;

import javax.swing.JOptionPane;

/**
 *
 * @author Marcus
 */
public class Mensagem {
    private Mensagem() {
        
    }
    
    /**
     * Exibe uma simples mensagem de atenção para o usuário
     * @param parent o Frame da qual a mensagem pertence
     * @param mensagem A mensagem que será exibida na tela
     */
    public static void atencao(java.awt.Frame parent, 
            String mensagem) {
        JOptionPane.showMessageDialog(parent, 
                    mensagem, 
                    "Atenção", 
                    JOptionPane.WARNING_MESSAGE);
    } 
    
    /**
     * Exibe uma simples mensagem de erro na tela
     * @param parent o Frame da qual a mensagem pertence
     * @param mensagem A mensagem que será exibida na tela
     */
    public static void erro(java.awt.Frame parent,
            String mensagem) {
        JOptionPane.showMessageDialog(parent, 
                    mensagem, 
                    "Erro", 
                    JOptionPane.ERROR_MESSAGE);
    }
    
    /**
     * Mostra uma simples mensagem na tela
     * @param parent o Frame da qual a mensagem pertence
     * @param mensagem A mensagem que será exibida na tela
     */
    public static void informacao(java.awt.Frame parent,
            String mensagem) {
        JOptionPane.showMessageDialog(parent, 
                    mensagem, 
                    "Informação", 
                    JOptionPane.INFORMATION_MESSAGE);
    }
    
    /**
     * Mostra uma mensagem para usuário responder sim ou não, por exemplo "Deseja
     * sair? Sim ou não?
     * @param parent o Frame da qual a mensagem pertence
     * @param mensagem mensagem que será informada ao usuário, uma pergunta por 
     * exemplo.
     * @return verdadeiro caso o usuário clicar em sim, caso contrário retorna
     * falso
     */
    public static boolean confirmar(java.awt.Frame parent, 
            String mensagem) {
        int r = JOptionPane.showConfirmDialog(parent, 
                mensagem, 
                "Informação", 
                JOptionPane.YES_NO_OPTION,
                JOptionPane.QUESTION_MESSAGE);
        return r == JOptionPane.YES_OPTION;
    }
}
