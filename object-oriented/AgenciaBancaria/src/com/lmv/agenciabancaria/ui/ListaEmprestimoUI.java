package com.lmv.agenciabancaria.ui;

import com.lmv.agenciabancaria.model.Conta;

public class ListaEmprestimoUI extends javax.swing.JDialog {
    
    private java.awt.Frame parent;
    private Conta conta;
    
    public ListaEmprestimoUI(java.awt.Frame parent, boolean modal, Conta conta) {
        super(parent, modal);
        this.parent = parent;
        this.conta = conta;
        beforeInitComponents();
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        spListaEmprestimo = new javax.swing.JScrollPane();
        tblListaEmprestimo = new javax.swing.JTable();
        btnNovo = new javax.swing.JButton();
        btnSair = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Empréstimos");
        setMaximumSize(new java.awt.Dimension(500, 355));
        setMinimumSize(new java.awt.Dimension(500, 355));
        setModal(true);
        setModalExclusionType(null);
        setResizable(false);
        setSize(new java.awt.Dimension(500, 355));

        spListaEmprestimo.setMaximumSize(new java.awt.Dimension(476, 255));
        spListaEmprestimo.setMinimumSize(new java.awt.Dimension(476, 255));
        spListaEmprestimo.setPreferredSize(new java.awt.Dimension(476, 255));

        tblListaEmprestimo.setAutoCreateRowSorter(true);
        tblListaEmprestimo.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        tblListaEmprestimo.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Número", "Valor", "Qtd_parcelas"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.Integer.class, java.lang.Integer.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblListaEmprestimo.setEnabled(false);
        tblListaEmprestimo.setMaximumSize(new java.awt.Dimension(476, 261));
        tblListaEmprestimo.setMinimumSize(new java.awt.Dimension(476, 261));
        tblListaEmprestimo.setPreferredSize(new java.awt.Dimension(476, 261));
        tblListaEmprestimo.setRowHeight(20);
        tblListaEmprestimo.getTableHeader().setReorderingAllowed(false);
        spListaEmprestimo.setViewportView(tblListaEmprestimo);
        if (tblListaEmprestimo.getColumnModel().getColumnCount() > 0) {
            tblListaEmprestimo.getColumnModel().getColumn(0).setResizable(false);
            tblListaEmprestimo.getColumnModel().getColumn(1).setResizable(false);
            tblListaEmprestimo.getColumnModel().getColumn(2).setResizable(false);
        }

        btnNovo.setFont(new java.awt.Font("Roboto", 0, 18)); // NOI18N
        btnNovo.setText("Novo");
        btnNovo.setMaximumSize(new java.awt.Dimension(75, 36));
        btnNovo.setMinimumSize(new java.awt.Dimension(75, 36));
        btnNovo.setPreferredSize(new java.awt.Dimension(75, 36));
        btnNovo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNovoActionPerformed(evt);
            }
        });

        btnSair.setFont(new java.awt.Font("Roboto", 0, 18)); // NOI18N
        btnSair.setText("Sair");
        btnSair.setMaximumSize(new java.awt.Dimension(75, 36));
        btnSair.setMinimumSize(new java.awt.Dimension(75, 36));
        btnSair.setPreferredSize(new java.awt.Dimension(75, 36));
        btnSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSairActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(spListaEmprestimo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnNovo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnSair, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(spListaEmprestimo, javax.swing.GroupLayout.DEFAULT_SIZE, 289, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnNovo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSair, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents
    private void beforeInitComponents() {
        initComponents();
    }
    private void btnNovoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNovoActionPerformed
        new NovoEmprestimoUI(parent, true, conta).setVisible(true);
    }//GEN-LAST:event_btnNovoActionPerformed

    private void btnSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSairActionPerformed
        dispose();
    }//GEN-LAST:event_btnSairActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnNovo;
    private javax.swing.JButton btnSair;
    private javax.swing.JScrollPane spListaEmprestimo;
    private javax.swing.JTable tblListaEmprestimo;
    // End of variables declaration//GEN-END:variables
}
