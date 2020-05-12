package com.lmv.agenciabancaria.ui;

import com.lmv.agenciabancaria.database.helper.DBHelper;
import com.lmv.agenciabancaria.exception.AgenciaBancariaException;
import com.lmv.agenciabancaria.model.ContaCorrente;
import com.lmv.agenciabancaria.model.ContaPoupanca;
import java.awt.Cursor;
import java.awt.event.KeyEvent;
import java.sql.SQLException;

public class AcessoClienteUI extends javax.swing.JDialog {
    private java.awt.Frame parent;
    
    public AcessoClienteUI(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        this.parent = parent;
        beforeInitComponents();
    }
    
    private void beforeInitComponents() {
        initComponents();
    }
    
    private void verificarInput(int key) {
        if (key == KeyEvent.VK_ENTER) {
            int conta;
            String agencia = txtAgencia.getText().trim();

            if (agencia.isEmpty()) {
                Mensagem.atencao(parent, "Insira o seu CPF!");
                txtAgencia.requestFocus();
                txtAgencia.selectAll();
                return;
            }

            try {
                conta = Integer.parseInt(txtConta.getText().trim());// Pega o cpf do cliente          
            } catch (NumberFormatException ex) {
                Mensagem.atencao(parent, 
                  "Insira apenas número para tentarmos identificar sua conta!");
                txtConta.requestFocus();
                txtConta.selectAll();
                return;
            }
            
            // VERIFICAR o CLIENTE e buscar suas contas
            try {
                setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
                txtAgencia.setEnabled(false);
                txtConta.setEnabled(false);
                ContaCorrente cc;
                ContaPoupanca cp;
                int i = 0;
                try {
                    cc = DBHelper.getInstance().getContaCorrente(agencia, conta);
                    new ClienteUI(parent, true, 
                            DBHelper.getInstance().getCliente(conta),
                            cc).setVisible(true);
                    return;
                } catch (AgenciaBancariaException ex) {
                    i++;
                }
                try {                
                    cp = DBHelper.getInstance().getContaPoupanca(agencia, conta);
                    new ClienteInfUI(parent, true, 
                            DBHelper.getInstance().getCliente(conta),
                            cp).setVisible(true);
                    return;
                } catch (AgenciaBancariaException ex) {
                    i++;
                }
                
                if (i == 2) {
                    Mensagem.atencao(parent, "Nenhuma conta encontrada!");
                }
            } catch (SQLException ex) {
                Mensagem.erro(parent, ex.getMessage());
            } finally {
                setCursor(Cursor.getDefaultCursor());
                txtAgencia.setEnabled(true);
                txtConta.setEnabled(true);
            }
        }
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblCPF = new javax.swing.JLabel();
        txtAgencia = new javax.swing.JTextField();
        lblConta = new javax.swing.JLabel();
        txtConta = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Acesso::Cliente");
        setModal(true);
        setModalExclusionType(null);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        lblCPF.setFont(new java.awt.Font("Roboto", 0, 18)); // NOI18N
        lblCPF.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblCPF.setText("Agência:");
        lblCPF.setMaximumSize(new java.awt.Dimension(300, 40));
        lblCPF.setMinimumSize(new java.awt.Dimension(300, 40));
        lblCPF.setPreferredSize(new java.awt.Dimension(300, 40));

        txtAgencia.setFont(new java.awt.Font("Roboto", 0, 18)); // NOI18N
        txtAgencia.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtAgencia.setAutoscrolls(false);
        txtAgencia.setMaximumSize(new java.awt.Dimension(300, 40));
        txtAgencia.setMinimumSize(new java.awt.Dimension(300, 40));
        txtAgencia.setPreferredSize(new java.awt.Dimension(300, 40));
        txtAgencia.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtAgenciaKeyPressed(evt);
            }
        });

        lblConta.setFont(new java.awt.Font("Roboto", 0, 18)); // NOI18N
        lblConta.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblConta.setText("Conta:");
        lblConta.setMaximumSize(new java.awt.Dimension(300, 40));
        lblConta.setMinimumSize(new java.awt.Dimension(300, 40));
        lblConta.setPreferredSize(new java.awt.Dimension(300, 40));

        txtConta.setFont(new java.awt.Font("Roboto", 0, 18)); // NOI18N
        txtConta.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtConta.setAutoscrolls(false);
        txtConta.setMaximumSize(new java.awt.Dimension(300, 40));
        txtConta.setMinimumSize(new java.awt.Dimension(300, 40));
        txtConta.setPreferredSize(new java.awt.Dimension(300, 40));
        txtConta.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtContaKeyPressed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(65, 65, 65)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblCPF, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                        .addComponent(lblConta, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtConta, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtAgencia, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(65, 65, 65))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(lblCPF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtAgencia, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblConta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtConta, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(25, 25, 25))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void txtAgenciaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtAgenciaKeyPressed
        verificarInput(evt.getKeyCode());
    }//GEN-LAST:event_txtAgenciaKeyPressed

    private void txtContaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtContaKeyPressed
        verificarInput(evt.getKeyCode());
    }//GEN-LAST:event_txtContaKeyPressed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        // TODO add your handling code here:
        if (!txtAgencia.isEnabled())
            setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
    }//GEN-LAST:event_formWindowClosing

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel lblCPF;
    private javax.swing.JLabel lblConta;
    private javax.swing.JTextField txtAgencia;
    private javax.swing.JTextField txtConta;
    // End of variables declaration//GEN-END:variables
}
