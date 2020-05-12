package com.lmv.agenciabancaria.ui;

import com.lmv.agenciabancaria.database.helper.DBHelper;
import com.lmv.agenciabancaria.model.Conta;
import com.lmv.agenciabancaria.model.Cupom;
import com.lmv.agenciabancaria.model.Dependente;
import java.awt.Cursor;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import javax.swing.table.DefaultTableModel;

public class ListaCupomUI extends javax.swing.JDialog {
    
    private java.awt.Frame parent;
    private Conta conta;
    private DefaultTableModel tabCupons;
    private SimpleDateFormat dateFormat;
    
    public ListaCupomUI(java.awt.Frame parent, boolean modal, Conta c) {
        super(parent, modal);
        this.parent = parent;
        this.conta = c;
        beforeInitComponents();
        
        dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        tabCupons = (DefaultTableModel) tblCupom.getModel();
        refreshTable();
    }
    
    private void addOnTable(Cupom cupom) {
        Object[] rowData = {
                cupom.getNum(),
                conta.getId(),
                conta.getNomeAgencia(),
                dateFormat.format(cupom.getValidade())
            };
        tabCupons.addRow(rowData);
    }
    
    private void refreshTable() {
        Thread t1 = new Thread() {
            @Override
            public void run() {
                try {              
                    btnSair.setEnabled(false);
                    while (tabCupons.getRowCount() > 0)
                        tabCupons.removeRow(0);
                    
                    setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
                    for (Cupom c: DBHelper.getInstance().getCuponsFromConta(conta)) {
                        addOnTable(c);
                    }
                } catch (SQLException ex) {
                    Mensagem.erro(parent, "Erro ao carregar dados! Detalhes:\n" + ex.getMessage());
                } finally {
                    btnSair.setEnabled(true);
                    setCursor(Cursor.getDefaultCursor());
                }
            }            
        };
        
        t1.start();
    }
    
    private void beforeInitComponents() {
        initComponents();
    }
   @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        spCupom = new javax.swing.JScrollPane();
        tblCupom = new javax.swing.JTable();
        btnSair = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Cupons");
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

        tblCupom.setAutoCreateRowSorter(true);
        tblCupom.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        tblCupom.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Número", "Conta", "Agência", "Validade"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.Integer.class, java.lang.String.class, java.lang.Object.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblCupom.setEnabled(false);
        tblCupom.setMaximumSize(new java.awt.Dimension(476, 261));
        tblCupom.setMinimumSize(new java.awt.Dimension(476, 261));
        tblCupom.setName(""); // NOI18N
        tblCupom.setPreferredSize(new java.awt.Dimension(476, 261));
        tblCupom.setRowHeight(20);
        tblCupom.getTableHeader().setReorderingAllowed(false);
        spCupom.setViewportView(tblCupom);
        if (tblCupom.getColumnModel().getColumnCount() > 0) {
            tblCupom.getColumnModel().getColumn(0).setResizable(false);
            tblCupom.getColumnModel().getColumn(0).setPreferredWidth(5);
            tblCupom.getColumnModel().getColumn(1).setResizable(false);
            tblCupom.getColumnModel().getColumn(1).setPreferredWidth(5);
            tblCupom.getColumnModel().getColumn(2).setResizable(false);
            tblCupom.getColumnModel().getColumn(3).setResizable(false);
            tblCupom.getColumnModel().getColumn(3).setPreferredWidth(15);
        }

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
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnSair, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(spCupom, javax.swing.GroupLayout.DEFAULT_SIZE, 476, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(spCupom, javax.swing.GroupLayout.PREFERRED_SIZE, 286, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnSair, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSairActionPerformed
        dispose();
    }//GEN-LAST:event_btnSairActionPerformed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        // TODO add your handling code here:
        if(!btnSair.isEnabled())
            setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
    }//GEN-LAST:event_formWindowClosing

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnSair;
    private javax.swing.JScrollPane spCupom;
    private javax.swing.JTable tblCupom;
    // End of variables declaration//GEN-END:variables
}
