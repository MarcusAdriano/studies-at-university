package com.lmv.agenciabancaria.ui;

import com.lmv.agenciabancaria.model.Cliente;
import com.lmv.agenciabancaria.model.ContaCorrente;

public class ClienteUI extends javax.swing.JDialog {
    
    private java.awt.Frame parent;
    private ContaCorrente conta;
    private Cliente cliente;
    
    public ClienteUI(java.awt.Frame parent, boolean modal, 
            Cliente cliente, ContaCorrente c) {
        super(parent, modal);
        this.parent = parent;
        this.conta = c;
        this.cliente = cliente;
        beforeInitComponents();
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        nova_op = new javax.swing.JButton();
        cupons = new javax.swing.JButton();
        emprestimos = new javax.swing.JButton();
        sair = new javax.swing.JButton();
        cupons1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Cliente");
        setMaximumSize(new java.awt.Dimension(280, 303));
        setMinimumSize(new java.awt.Dimension(280, 303));
        setModal(true);
        setModalExclusionType(null);
        setResizable(false);

        nova_op.setFont(new java.awt.Font("Roboto", 0, 18)); // NOI18N
        nova_op.setText("Nova Operação");
        nova_op.setMaximumSize(new java.awt.Dimension(150, 36));
        nova_op.setMinimumSize(new java.awt.Dimension(150, 36));
        nova_op.setPreferredSize(new java.awt.Dimension(150, 36));
        nova_op.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nova_opActionPerformed(evt);
            }
        });

        cupons.setFont(new java.awt.Font("Roboto", 0, 18)); // NOI18N
        cupons.setText("Cupons");
        cupons.setMaximumSize(new java.awt.Dimension(150, 36));
        cupons.setMinimumSize(new java.awt.Dimension(150, 36));
        cupons.setPreferredSize(new java.awt.Dimension(150, 36));
        cupons.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cuponsActionPerformed(evt);
            }
        });

        emprestimos.setFont(new java.awt.Font("Roboto", 0, 18)); // NOI18N
        emprestimos.setText("Empréstimos");
        emprestimos.setMaximumSize(new java.awt.Dimension(150, 36));
        emprestimos.setMinimumSize(new java.awt.Dimension(150, 36));
        emprestimos.setPreferredSize(new java.awt.Dimension(150, 36));
        emprestimos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                emprestimosActionPerformed(evt);
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

        cupons1.setFont(new java.awt.Font("Roboto", 0, 18)); // NOI18N
        cupons1.setText("Informações");
        cupons1.setMaximumSize(new java.awt.Dimension(150, 36));
        cupons1.setMinimumSize(new java.awt.Dimension(150, 36));
        cupons1.setPreferredSize(new java.awt.Dimension(150, 36));
        cupons1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cupons1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(65, 65, 65)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(nova_op, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cupons, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(emprestimos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(sair, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cupons1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(65, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(nova_op, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(cupons1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(cupons, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(emprestimos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(sair, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(26, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents
    private void beforeInitComponents() {
        initComponents();
    }
    
    private void cuponsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cuponsActionPerformed
        new ListaCupomUI(parent, true, this.conta).setVisible(true);
    }//GEN-LAST:event_cuponsActionPerformed

    private void emprestimosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_emprestimosActionPerformed
        new ListaEmprestimoUI(parent, true, conta).setVisible(true);
    }//GEN-LAST:event_emprestimosActionPerformed

    private void sairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sairActionPerformed
         this.dispose();
    }//GEN-LAST:event_sairActionPerformed

    private void nova_opActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nova_opActionPerformed
        new NovaOpUI(parent, true).setVisible(true);
    }//GEN-LAST:event_nova_opActionPerformed

    private void cupons1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cupons1ActionPerformed
        //new ClienteInfUI(parent, true).setVisible(true);
        new ClienteInfUI(parent, true, 
                            cliente,
                            conta).setVisible(true);
    }//GEN-LAST:event_cupons1ActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton cupons;
    private javax.swing.JButton cupons1;
    private javax.swing.JButton emprestimos;
    private javax.swing.JButton nova_op;
    private javax.swing.JButton sair;
    // End of variables declaration//GEN-END:variables
}
