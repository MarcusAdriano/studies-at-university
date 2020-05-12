package com.lmv.agenciabancaria.ui;

import com.lmv.agenciabancaria.database.DBConnection;
import java.sql.SQLException;

public class TelaInicialUI extends javax.swing.JFrame {
    public TelaInicialUI() {
        beforeInitComponents();
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel_principal = new javax.swing.JLabel();
        jButton_cliente = new javax.swing.JButton();
        jButton_funcionario = new javax.swing.JButton();
        jButton_gerente = new javax.swing.JButton();
        jButton_agencia = new javax.swing.JButton();
        jButton_sair = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle("Início");
        setMaximumSize(new java.awt.Dimension(250, 300));
        setMinimumSize(new java.awt.Dimension(250, 300));
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        jLabel_principal.setFont(new java.awt.Font("Roboto", 0, 18)); // NOI18N
        jLabel_principal.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel_principal.setText("Sistema Bancário");
        jLabel_principal.setMaximumSize(new java.awt.Dimension(150, 36));
        jLabel_principal.setMinimumSize(new java.awt.Dimension(150, 36));

        jButton_cliente.setFont(new java.awt.Font("Roboto", 0, 18)); // NOI18N
        jButton_cliente.setText("Cliente");
        jButton_cliente.setFocusPainted(false);
        jButton_cliente.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton_cliente.setMaximumSize(new java.awt.Dimension(150, 36));
        jButton_cliente.setMinimumSize(new java.awt.Dimension(150, 36));
        jButton_cliente.setPreferredSize(new java.awt.Dimension(60, 36));
        jButton_cliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_clienteActionPerformed(evt);
            }
        });

        jButton_funcionario.setFont(new java.awt.Font("Roboto", 0, 18)); // NOI18N
        jButton_funcionario.setText("Funcionário");
        jButton_funcionario.setFocusPainted(false);
        jButton_funcionario.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton_funcionario.setMaximumSize(new java.awt.Dimension(150, 36));
        jButton_funcionario.setMinimumSize(new java.awt.Dimension(150, 36));
        jButton_funcionario.setPreferredSize(new java.awt.Dimension(60, 30));
        jButton_funcionario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_funcionarioActionPerformed(evt);
            }
        });

        jButton_gerente.setFont(new java.awt.Font("Roboto", 0, 18)); // NOI18N
        jButton_gerente.setText("Gerente");
        jButton_gerente.setFocusPainted(false);
        jButton_gerente.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton_gerente.setMaximumSize(new java.awt.Dimension(150, 36));
        jButton_gerente.setMinimumSize(new java.awt.Dimension(150, 36));
        jButton_gerente.setPreferredSize(new java.awt.Dimension(60, 30));
        jButton_gerente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_gerenteActionPerformed(evt);
            }
        });

        jButton_agencia.setFont(new java.awt.Font("Roboto", 0, 18)); // NOI18N
        jButton_agencia.setText("Agência");
        jButton_agencia.setFocusPainted(false);
        jButton_agencia.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton_agencia.setMaximumSize(new java.awt.Dimension(150, 36));
        jButton_agencia.setMinimumSize(new java.awt.Dimension(150, 36));
        jButton_agencia.setPreferredSize(new java.awt.Dimension(60, 30));
        jButton_agencia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_agenciaActionPerformed(evt);
            }
        });

        jButton_sair.setFont(new java.awt.Font("Roboto", 0, 18)); // NOI18N
        jButton_sair.setText("Sair");
        jButton_sair.setFocusPainted(false);
        jButton_sair.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton_sair.setMaximumSize(new java.awt.Dimension(150, 36));
        jButton_sair.setMinimumSize(new java.awt.Dimension(150, 36));
        jButton_sair.setPreferredSize(new java.awt.Dimension(60, 30));
        jButton_sair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_sairActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(65, 65, 65)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton_agencia, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton_gerente, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton_funcionario, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton_cliente, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel_principal, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton_sair, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(65, 65, 65))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(jLabel_principal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(jButton_cliente, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(jButton_funcionario, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(jButton_gerente, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(jButton_agencia, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(jButton_sair, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents
    private void beforeInitComponents() {
        this.setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        
        initComponents();
    }
    private void jButton_agenciaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_agenciaActionPerformed
        new AgenciaUI(this, true).setVisible(true);
    }//GEN-LAST:event_jButton_agenciaActionPerformed

    private void jButton_gerenteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_gerenteActionPerformed
        new AcessoFuncionarioUI(this, true, 1).setVisible(true);
    }//GEN-LAST:event_jButton_gerenteActionPerformed

    private void jButton_funcionarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_funcionarioActionPerformed
        new AcessoFuncionarioUI(this, true, 0).setVisible(true);
    }//GEN-LAST:event_jButton_funcionarioActionPerformed

    private void jButton_clienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_clienteActionPerformed
        new AcessoClienteUI(this, true).setVisible(true);
    }//GEN-LAST:event_jButton_clienteActionPerformed

    private void jButton_sairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_sairActionPerformed
        this.dispose();
    }//GEN-LAST:event_jButton_sairActionPerformed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        if (!Mensagem.confirmar(this, "Deseja realmente sair?")) {
            return;
        }
        try {
            DBConnection.close();
        } catch (SQLException ex) {
            Mensagem.erro(this, "Não foi possível fechar corretamente o BD! " + ex.getMessage());
        } finally {
            System.exit(0);
        }
       
    }//GEN-LAST:event_formWindowClosing

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton_agencia;
    private javax.swing.JButton jButton_cliente;
    private javax.swing.JButton jButton_funcionario;
    private javax.swing.JButton jButton_gerente;
    private javax.swing.JButton jButton_sair;
    private javax.swing.JLabel jLabel_principal;
    // End of variables declaration//GEN-END:variables
}
