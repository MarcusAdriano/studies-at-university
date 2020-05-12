package com.lmv.agenciabancaria.ui;

import com.lmv.agenciabancaria.database.helper.DBHelper;
import com.lmv.agenciabancaria.model.Conta;
import com.lmv.agenciabancaria.model.Emprestimo;
import java.awt.Cursor;
import java.sql.SQLException;

public class NovoEmprestimoUI extends javax.swing.JDialog {
    private java.awt.Frame parent;
    private Conta conta;
    
    public NovoEmprestimoUI(java.awt.Frame parent, boolean modal, Conta conta) {
        super(parent, modal);
        this.parent = parent;
        this.conta = conta;
        beforeInitComponents();
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lbValor = new javax.swing.JLabel();
        txtValor = new javax.swing.JTextField();
        lbParcelas = new javax.swing.JLabel();
        txtParcelas = new javax.swing.JTextField();
        btnOK = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Novo Empréstimo");
        setMaximumSize(new java.awt.Dimension(348, 303));
        setMinimumSize(new java.awt.Dimension(348, 303));
        setModal(true);
        setModalExclusionType(null);
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        lbValor.setFont(new java.awt.Font("Roboto", 0, 18)); // NOI18N
        lbValor.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbValor.setText("Valor");
        lbValor.setMaximumSize(new java.awt.Dimension(100, 40));
        lbValor.setMinimumSize(new java.awt.Dimension(100, 40));
        lbValor.setPreferredSize(new java.awt.Dimension(100, 40));

        txtValor.setFont(new java.awt.Font("Roboto", 0, 18)); // NOI18N
        txtValor.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtValor.setMaximumSize(new java.awt.Dimension(100, 40));
        txtValor.setMinimumSize(new java.awt.Dimension(100, 40));
        txtValor.setPreferredSize(new java.awt.Dimension(100, 40));

        lbParcelas.setFont(new java.awt.Font("Roboto", 0, 18)); // NOI18N
        lbParcelas.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbParcelas.setText("Parcelas");
        lbParcelas.setMaximumSize(new java.awt.Dimension(100, 40));
        lbParcelas.setMinimumSize(new java.awt.Dimension(100, 40));
        lbParcelas.setPreferredSize(new java.awt.Dimension(100, 40));

        txtParcelas.setFont(new java.awt.Font("Roboto", 0, 18)); // NOI18N
        txtParcelas.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtParcelas.setMaximumSize(new java.awt.Dimension(100, 40));
        txtParcelas.setMinimumSize(new java.awt.Dimension(100, 40));
        txtParcelas.setPreferredSize(new java.awt.Dimension(100, 40));

        btnOK.setFont(new java.awt.Font("Roboto", 0, 18)); // NOI18N
        btnOK.setText("OK");
        btnOK.setMaximumSize(new java.awt.Dimension(100, 40));
        btnOK.setMinimumSize(new java.awt.Dimension(100, 40));
        btnOK.setPreferredSize(new java.awt.Dimension(100, 40));
        btnOK.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnOKActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(65, 65, 65)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnOK, javax.swing.GroupLayout.DEFAULT_SIZE, 218, Short.MAX_VALUE)
                    .addComponent(lbParcelas, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtValor, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtParcelas, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lbValor, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(65, 65, 65))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(lbValor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtValor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(lbParcelas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtParcelas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnOK, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents
    private void beforeInitComponents() {
        initComponents();
    }
    
    private void btnOKActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnOKActionPerformed
        try{
            double  valor = 0;
            int parcelas = 0;
            
            valor = Float.parseFloat(txtValor.getText().trim());
            parcelas = Integer.parseInt(txtParcelas.getText().trim());
            if(valor <= 0){
                Mensagem.atencao(parent, "Por favor, insira um valor real.");
                txtValor.requestFocus();
                txtValor.selectAll();
                return;
            }
            if(parcelas <= 0){
                Mensagem.atencao(parent, "Por favor, insira um valor real.");
                txtParcelas.requestFocus();
                txtParcelas.selectAll();
                return;
            }
            
            Emprestimo t = new Emprestimo();
            t.setNomeAgencia(conta.getNomeAgencia());
            t.setValor(valor);
            t.setParcelas(parcelas);
            new Thread() {

                @Override
                public void run() {
                    try {
                        btnOK.setEnabled(false);
                        setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
                        DBHelper.getInstance().addEmprestimo(t);
                        Mensagem.informacao(parent, "Empréstimo efetuado com sucesso!");
                        dispose();
                    } catch (SQLException ex) {
                        Mensagem.erro(parent, ex.getMessage());
                    } finally {
                        setCursor(Cursor.getDefaultCursor());
                        btnOK.setEnabled(true);
                    }
                }

            }.start();
        } catch (NumberFormatException ex) {
            Mensagem.atencao(parent,"ATENÇÃO: Insira um valor!");
        }
    }//GEN-LAST:event_btnOKActionPerformed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        // TODO add your handling code here:
        if (!btnOK.isEnabled())
            setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
    }//GEN-LAST:event_formWindowClosing

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnOK;
    private javax.swing.JLabel lbParcelas;
    private javax.swing.JLabel lbValor;
    private javax.swing.JTextField txtParcelas;
    private javax.swing.JTextField txtValor;
    // End of variables declaration//GEN-END:variables
}
