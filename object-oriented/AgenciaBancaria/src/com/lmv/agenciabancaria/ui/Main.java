package com.lmv.agenciabancaria.ui;

import com.lmv.agenciabancaria.database.DBConnection;
import java.sql.SQLException;

public class Main {
    public static void main(String[] args) {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("GTK+".equals(info.getName()) || "Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            System.out.println(ex.getMessage());
        }
        
        try {
            DBConnection.get();
        } catch (SQLException ex) {
            Mensagem.erro(null, 
                    "Não foi possível se conectar ao banco de dados!\n" + ex.getMessage());
            System.exit(0);
        } 
        
        new TelaInicialUI().setVisible(true);
    }
}
