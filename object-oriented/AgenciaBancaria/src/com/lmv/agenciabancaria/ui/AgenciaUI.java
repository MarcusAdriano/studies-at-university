package com.lmv.agenciabancaria.ui;
public class AgenciaUI extends javax.swing.JDialog {
    private java.awt.Frame parent;
    public AgenciaUI(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        this.parent = parent;
        beforeInitComponents();
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        nova_agencia = new javax.swing.JButton();
        agencias = new javax.swing.JButton();
        sair = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Gerenciador de Agência");
        setMinimumSize(new java.awt.Dimension(280, 219));
        setModal(true);
        setModalExclusionType(null);
        setResizable(false);

        nova_agencia.setFont(new java.awt.Font("Roboto", 0, 18)); // NOI18N
        nova_agencia.setText("Criar agência");
        nova_agencia.setMaximumSize(new java.awt.Dimension(150, 36));
        nova_agencia.setMinimumSize(new java.awt.Dimension(150, 36));
        nova_agencia.setPreferredSize(new java.awt.Dimension(150, 36));
        nova_agencia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nova_agenciaActionPerformed(evt);
            }
        });

        agencias.setFont(new java.awt.Font("Roboto", 0, 18)); // NOI18N
        agencias.setText("Agências");
        agencias.setMaximumSize(new java.awt.Dimension(150, 36));
        agencias.setMinimumSize(new java.awt.Dimension(150, 36));
        agencias.setPreferredSize(new java.awt.Dimension(150, 36));
        agencias.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                agenciasActionPerformed(evt);
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

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(65, 65, 65)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(nova_agencia, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(agencias, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(sair, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(65, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(nova_agencia, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(agencias, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(sair, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(50, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents
    private void beforeInitComponents() {
        initComponents();
    }
    private void nova_agenciaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nova_agenciaActionPerformed
        new NovaAgenciaUI(parent, true).setVisible(true);
    }//GEN-LAST:event_nova_agenciaActionPerformed

    private void agenciasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_agenciasActionPerformed
        new ListaAgenciaUI(parent, true).setVisible(true);
    }//GEN-LAST:event_agenciasActionPerformed

    private void sairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sairActionPerformed
        this.dispose();
    }//GEN-LAST:event_sairActionPerformed
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton agencias;
    private javax.swing.JButton nova_agencia;
    private javax.swing.JButton sair;
    // End of variables declaration//GEN-END:variables
}
