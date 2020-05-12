package com.lmv.agenciabancaria.ui;
public class NovaOpUI extends javax.swing.JDialog {
    private java.awt.Frame parent;
    public NovaOpUI(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        this.parent = parent;
        beforeInitComponents();
        btnTipo.add(btnCredito);
        btnTipo.add(btnDebito);
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnTipo = new javax.swing.ButtonGroup();
        btnCredito = new javax.swing.JRadioButton();
        btnDebito = new javax.swing.JRadioButton();
        txtValor = new javax.swing.JTextField();
        txtDescricao = new javax.swing.JTextField();
        lbDescricao = new javax.swing.JLabel();
        lbValor = new javax.swing.JLabel();
        btnOK = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Nova Operação Bancária");
        setMaximumSize(new java.awt.Dimension(348, 356));
        setMinimumSize(new java.awt.Dimension(348, 356));
        setModal(true);
        setModalExclusionType(null);
        setResizable(false);

        btnCredito.setFont(new java.awt.Font("Roboto", 0, 18)); // NOI18N
        btnCredito.setText("Crédito");
        btnCredito.setMaximumSize(new java.awt.Dimension(100, 40));
        btnCredito.setMinimumSize(new java.awt.Dimension(100, 40));
        btnCredito.setPreferredSize(new java.awt.Dimension(100, 40));
        btnCredito.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCreditoActionPerformed(evt);
            }
        });

        btnDebito.setFont(new java.awt.Font("Roboto", 0, 18)); // NOI18N
        btnDebito.setText("Débito");
        btnDebito.setMaximumSize(new java.awt.Dimension(100, 40));
        btnDebito.setMinimumSize(new java.awt.Dimension(100, 40));
        btnDebito.setPreferredSize(new java.awt.Dimension(100, 40));

        txtValor.setFont(new java.awt.Font("Roboto", 0, 18)); // NOI18N
        txtValor.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtValor.setMaximumSize(new java.awt.Dimension(100, 40));
        txtValor.setMinimumSize(new java.awt.Dimension(100, 40));
        txtValor.setPreferredSize(new java.awt.Dimension(100, 40));
        txtValor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtValorActionPerformed(evt);
            }
        });

        txtDescricao.setFont(new java.awt.Font("Roboto", 0, 18)); // NOI18N
        txtDescricao.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtDescricao.setMaximumSize(new java.awt.Dimension(100, 40));
        txtDescricao.setMinimumSize(new java.awt.Dimension(100, 40));
        txtDescricao.setPreferredSize(new java.awt.Dimension(100, 40));
        txtDescricao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtDescricaoActionPerformed(evt);
            }
        });

        lbDescricao.setFont(new java.awt.Font("Roboto", 0, 18)); // NOI18N
        lbDescricao.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbDescricao.setText("Descrição");
        lbDescricao.setMaximumSize(new java.awt.Dimension(100, 40));
        lbDescricao.setMinimumSize(new java.awt.Dimension(100, 40));
        lbDescricao.setPreferredSize(new java.awt.Dimension(100, 40));

        lbValor.setFont(new java.awt.Font("Roboto", 0, 18)); // NOI18N
        lbValor.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbValor.setText("Valor");
        lbValor.setMaximumSize(new java.awt.Dimension(100, 40));
        lbValor.setMinimumSize(new java.awt.Dimension(100, 40));
        lbValor.setPreferredSize(new java.awt.Dimension(100, 40));

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
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnOK, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lbDescricao, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtValor, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(btnCredito, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnDebito, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(txtDescricao, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lbValor, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(65, 65, 65))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(lbValor, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtValor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCredito, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnDebito, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(lbDescricao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtDescricao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnOK, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(25, 25, 25))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents
    private void beforeInitComponents() {
        initComponents();
    }
    private void txtValorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtValorActionPerformed
    }//GEN-LAST:event_txtValorActionPerformed

    private void txtDescricaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtDescricaoActionPerformed
    }//GEN-LAST:event_txtDescricaoActionPerformed

    private void btnCreditoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCreditoActionPerformed
    
    }//GEN-LAST:event_btnCreditoActionPerformed

    private void btnOKActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnOKActionPerformed
        float  valor;
        String pagamento,
               desc = txtDescricao.getText().trim();
        try{
            valor = Float.parseFloat(txtValor.getText().trim());
            
            if(valor <= 0){
                Mensagem.atencao(parent, "Por favor, insira um valor real.");
                txtDescricao.requestFocus();
                txtDescricao.selectAll();
                return;
            }
            if(!btnCredito.isSelected() && !btnDebito.isSelected()){
                Mensagem.atencao(parent, "Por favor, selecione a opção de pagamento.");
                btnCredito.requestFocus();
                return;
            }
            
            if (desc.length() > 20) {
                Mensagem.atencao(parent, "Por favor, insira uma descrição até 20 caracteres!");
                txtDescricao.requestFocus();
                txtDescricao.selectAll();
                return;
            }
            if(btnCredito.isSelected()){
                pagamento = btnCredito.getText();
            } 
            if(btnDebito.isSelected()){
                pagamento = btnDebito.getText();
            }
            dispose();
        } catch (NumberFormatException ex) {
                Mensagem.atencao(parent,"ATENÇÃO: Insira um valor!");
                txtValor.setText("");
            }
    }//GEN-LAST:event_btnOKActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JRadioButton btnCredito;
    private javax.swing.JRadioButton btnDebito;
    private javax.swing.JButton btnOK;
    private javax.swing.ButtonGroup btnTipo;
    private javax.swing.JLabel lbDescricao;
    private javax.swing.JLabel lbValor;
    private javax.swing.JTextField txtDescricao;
    private javax.swing.JTextField txtValor;
    // End of variables declaration//GEN-END:variables
}
