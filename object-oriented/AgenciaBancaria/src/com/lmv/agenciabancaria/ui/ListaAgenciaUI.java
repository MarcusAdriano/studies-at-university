package com.lmv.agenciabancaria.ui;

import com.lmv.agenciabancaria.database.helper.DBHelper;
import com.lmv.agenciabancaria.model.Agencia;
import java.awt.Cursor;
import java.sql.SQLException;
import javax.swing.table.DefaultTableModel;

public class ListaAgenciaUI extends javax.swing.JDialog {

    private java.awt.Frame parent;
    private DefaultTableModel tabAgencias;
    
    public ListaAgenciaUI(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        this.parent = parent;
        beforeInitComponents();
        
        tabAgencias = (DefaultTableModel) tblListaAgencia.getModel();
        refreshTable();
    }
    @SuppressWarnings("unchecked")
    private void beforeInitComponents() {
        initComponents();
    }
    
    private void addOnTable(Agencia a) {
        Object[] rowData = {
                a.getNome(),
                a.getCidade(),
                a.getEstado()
            };
        tabAgencias.addRow(rowData);
    }
    
    private void refreshTable() {
        Thread t1 = new Thread() {
            @Override
            public void run() {
                try {
                    btnNovo.setEnabled(false);
                    btnSair.setEnabled(false);
                    
                    while (tabAgencias.getRowCount() > 0)
                        tabAgencias.removeRow(0);
                    
                    setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
                    for (Agencia a: DBHelper.getInstance().getAllAgencia()) {
                        addOnTable(a);
                    }
                } catch (SQLException ex) {
                    Mensagem.erro(parent, "Erro ao carregar dados! Detalhes:\n" + ex.getMessage());
                } finally {
                    setCursor(Cursor.getDefaultCursor());
                    btnNovo.setEnabled(true);
                    btnSair.setEnabled(true);
                }
            }            
        };
        
        t1.start();
    }
    
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        spListaAgencia = new javax.swing.JScrollPane();
        tblListaAgencia = new javax.swing.JTable();
        btnNovo = new javax.swing.JButton();
        btnSair = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Agências");
        setMaximumSize(new java.awt.Dimension(500, 320));
        setMinimumSize(new java.awt.Dimension(500, 320));
        setModal(true);
        setModalExclusionType(null);
        setResizable(false);
        setSize(new java.awt.Dimension(500, 320));
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        spListaAgencia.setMaximumSize(new java.awt.Dimension(476, 255));
        spListaAgencia.setMinimumSize(new java.awt.Dimension(476, 255));
        spListaAgencia.setPreferredSize(new java.awt.Dimension(476, 255));

        tblListaAgencia.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        tblListaAgencia.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nome", "Cidade", "Estado"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class
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
        tblListaAgencia.setEnabled(false);
        tblListaAgencia.setMaximumSize(new java.awt.Dimension(476, 261));
        tblListaAgencia.setMinimumSize(new java.awt.Dimension(476, 261));
        tblListaAgencia.setPreferredSize(new java.awt.Dimension(476, 261));
        tblListaAgencia.setRowHeight(20);
        tblListaAgencia.getTableHeader().setReorderingAllowed(false);
        spListaAgencia.setViewportView(tblListaAgencia);
        if (tblListaAgencia.getColumnModel().getColumnCount() > 0) {
            tblListaAgencia.getColumnModel().getColumn(0).setResizable(false);
            tblListaAgencia.getColumnModel().getColumn(1).setResizable(false);
            tblListaAgencia.getColumnModel().getColumn(1).setPreferredWidth(20);
            tblListaAgencia.getColumnModel().getColumn(2).setResizable(false);
            tblListaAgencia.getColumnModel().getColumn(2).setPreferredWidth(5);
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
                    .addComponent(spListaAgencia, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(btnNovo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnSair, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(spListaAgencia, javax.swing.GroupLayout.DEFAULT_SIZE, 321, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSair, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnNovo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnNovoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNovoActionPerformed
        new NovaAgenciaUI(parent, true).setVisible(true);
        refreshTable();
    }//GEN-LAST:event_btnNovoActionPerformed

    private void btnSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSairActionPerformed
        dispose();
    }//GEN-LAST:event_btnSairActionPerformed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        // TODO add your handling code here:
        if (!btnNovo.isEnabled()) {
            setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
            Mensagem.atencao(parent, "Aguarde até carregar todos as agencias para sair!");
        }
    }//GEN-LAST:event_formWindowClosing

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnNovo;
    private javax.swing.JButton btnSair;
    private javax.swing.JScrollPane spListaAgencia;
    private javax.swing.JTable tblListaAgencia;
    // End of variables declaration//GEN-END:variables
}
