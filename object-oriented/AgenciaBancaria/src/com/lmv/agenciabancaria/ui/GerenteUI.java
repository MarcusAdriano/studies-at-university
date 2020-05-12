package com.lmv.agenciabancaria.ui;

import com.lmv.agenciabancaria.model.Funcionario;

public class GerenteUI extends javax.swing.JDialog {
    
    private final java.awt.Frame parent;
    private final Funcionario funcionario;
    
    public GerenteUI(java.awt.Frame parent, boolean modal, Funcionario funcionario) {
        super(parent, modal);
        this.parent = parent;
        this.funcionario = funcionario;
        beforeInitComponents();
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        trabalho = new javax.swing.JButton();
        contas = new javax.swing.JButton();
        sair = new javax.swing.JButton();
        contas1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Gerente");
        setMaximumSize(new java.awt.Dimension(280, 303));
        setMinimumSize(new java.awt.Dimension(280, 303));
        setModalExclusionType(null);
        setResizable(false);

        trabalho.setFont(new java.awt.Font("Roboto", 0, 18)); // NOI18N
        trabalho.setText("Informações");
        trabalho.setMaximumSize(new java.awt.Dimension(150, 36));
        trabalho.setMinimumSize(new java.awt.Dimension(150, 36));
        trabalho.setPreferredSize(new java.awt.Dimension(150, 36));
        trabalho.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                trabalhoActionPerformed(evt);
            }
        });

        contas.setFont(new java.awt.Font("Roboto", 0, 18)); // NOI18N
        contas.setText("Novo Cliente");
        contas.setMaximumSize(new java.awt.Dimension(150, 36));
        contas.setMinimumSize(new java.awt.Dimension(150, 36));
        contas.setPreferredSize(new java.awt.Dimension(150, 36));
        contas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                contasActionPerformed(evt);
            }
        });

        sair.setFont(new java.awt.Font("Roboto", 0, 18)); // NOI18N
        sair.setText("Sair");
        sair.setMaximumSize(new java.awt.Dimension(150, 36));
        sair.setMinimumSize(new java.awt.Dimension(150, 36));
        sair.setPreferredSize(new java.awt.Dimension(150, 36));
        sair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sairActionPerformed(evt);
            }
        });

        contas1.setFont(new java.awt.Font("Roboto", 0, 18)); // NOI18N
        contas1.setText("Nova Agência");
        contas1.setMaximumSize(new java.awt.Dimension(150, 36));
        contas1.setMinimumSize(new java.awt.Dimension(150, 36));
        contas1.setPreferredSize(new java.awt.Dimension(150, 36));
        contas1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                contas1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(65, 65, 65)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(trabalho, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(contas, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(sair, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(contas1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(65, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(trabalho, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(contas, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(contas1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(sair, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents
    private void beforeInitComponents() {
        initComponents();
    }
    private void contasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_contasActionPerformed
        NovoClienteUI c = new NovoClienteUI(parent, true);
        c.setGerente(this.funcionario);
        c.setVisible(true);
    }//GEN-LAST:event_contasActionPerformed

    private void sairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sairActionPerformed
        this.dispose();
    }//GEN-LAST:event_sairActionPerformed

    private void trabalhoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_trabalhoActionPerformed
        new FuncionarioUI(parent, true, this.funcionario).setVisible(true);
    }//GEN-LAST:event_trabalhoActionPerformed

    private void contas1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_contas1ActionPerformed
        new NovaAgenciaUI(parent, true).setVisible(true);
    }//GEN-LAST:event_contas1ActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton contas;
    private javax.swing.JButton contas1;
    private javax.swing.JButton sair;
    private javax.swing.JButton trabalho;
    // End of variables declaration//GEN-END:variables
}
