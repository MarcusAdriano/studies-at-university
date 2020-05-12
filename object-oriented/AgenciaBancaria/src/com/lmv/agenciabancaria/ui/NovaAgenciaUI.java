package com.lmv.agenciabancaria.ui;

import com.lmv.agenciabancaria.database.helper.DBHelper;
import com.lmv.agenciabancaria.model.Agencia;
import java.awt.Cursor;
import java.sql.SQLException;

public class NovaAgenciaUI extends javax.swing.JDialog {
    private java.awt.Frame parent;
    
    public NovaAgenciaUI(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        this.parent = parent;
        beforeInitComponents();
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblNome = new javax.swing.JLabel();
        txtNome = new javax.swing.JTextField();
        lblCidade = new javax.swing.JLabel();
        txtCidade = new javax.swing.JTextField();
        lblEstado = new javax.swing.JLabel();
        txtEstado = new javax.swing.JTextField();
        btnOK = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Nova Agência");
        setModal(true);
        setModalExclusionType(null);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        lblNome.setFont(new java.awt.Font("Roboto", 0, 18)); // NOI18N
        lblNome.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblNome.setText("Nome");
        lblNome.setMaximumSize(new java.awt.Dimension(200, 40));
        lblNome.setMinimumSize(new java.awt.Dimension(200, 40));
        lblNome.setPreferredSize(new java.awt.Dimension(200, 40));
        lblNome.setRequestFocusEnabled(false);

        txtNome.setFont(new java.awt.Font("Roboto", 0, 18)); // NOI18N
        txtNome.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtNome.setMaximumSize(new java.awt.Dimension(200, 40));
        txtNome.setMinimumSize(new java.awt.Dimension(200, 40));
        txtNome.setPreferredSize(new java.awt.Dimension(200, 40));

        lblCidade.setFont(new java.awt.Font("Roboto", 0, 18)); // NOI18N
        lblCidade.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblCidade.setText("Cidade");
        lblCidade.setMaximumSize(new java.awt.Dimension(200, 40));
        lblCidade.setMinimumSize(new java.awt.Dimension(200, 40));
        lblCidade.setPreferredSize(new java.awt.Dimension(200, 40));
        lblCidade.setRequestFocusEnabled(false);

        txtCidade.setFont(new java.awt.Font("Roboto", 0, 18)); // NOI18N
        txtCidade.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtCidade.setMaximumSize(new java.awt.Dimension(200, 40));
        txtCidade.setMinimumSize(new java.awt.Dimension(200, 40));
        txtCidade.setPreferredSize(new java.awt.Dimension(200, 40));

        lblEstado.setFont(new java.awt.Font("Roboto", 0, 18)); // NOI18N
        lblEstado.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblEstado.setText("Estado");
        lblEstado.setMaximumSize(new java.awt.Dimension(200, 40));
        lblEstado.setMinimumSize(new java.awt.Dimension(200, 40));
        lblEstado.setPreferredSize(new java.awt.Dimension(200, 40));
        lblEstado.setRequestFocusEnabled(false);

        txtEstado.setFont(new java.awt.Font("Roboto", 0, 18)); // NOI18N
        txtEstado.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtEstado.setMaximumSize(new java.awt.Dimension(200, 40));
        txtEstado.setMinimumSize(new java.awt.Dimension(200, 40));
        txtEstado.setPreferredSize(new java.awt.Dimension(200, 40));

        btnOK.setFont(new java.awt.Font("Roboto", 0, 18)); // NOI18N
        btnOK.setText("OK");
        btnOK.setMaximumSize(new java.awt.Dimension(200, 40));
        btnOK.setMinimumSize(new java.awt.Dimension(200, 40));
        btnOK.setPreferredSize(new java.awt.Dimension(200, 40));
        btnOK.setRequestFocusEnabled(false);
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
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(lblEstado, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txtEstado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnOK, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(lblCidade, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txtNome, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txtCidade, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lblNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(65, 65, 65))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(lblNome, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblCidade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtCidade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblEstado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtEstado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnOK, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents
    private void beforeInitComponents() {
        initComponents();
        this.getRootPane().setDefaultButton(btnOK);
        setLocationRelativeTo(null);
    }
    private void btnOKActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnOKActionPerformed
        String nome = txtNome.getText().trim(), 
               estado = txtEstado.getText().trim(), 
               cidade = txtCidade.getText().trim();
        
        if (nome.isEmpty()) {
            Mensagem.atencao(parent, "Por favor, insira um nome!");
            return;
        }
        
        if (cidade.isEmpty()) {
            Mensagem.atencao(parent, "Por favor, insira uma cidade!");
            txtCidade.requestFocus();
            return;
        }
        
        if (estado.isEmpty()) {
            Mensagem.atencao(parent, "Por favor, insira um estado!");
            txtEstado.requestFocus();
            return;
        }
        
        if (nome.length() > 50) {
            Mensagem.atencao(parent, "Por favor, insira um nome de até 50 caracteres!");
            txtNome.requestFocus();
            txtNome.selectAll();
            return;
        }
        
        if (estado.length() != 2) {
            Mensagem.atencao(parent, "Por favor, insira somente a sigla do estado, ex: SP!");
            txtEstado.requestFocus();
            txtEstado.selectAll();
            return;
        }
        
        if (cidade.length() > 50) {
            Mensagem.atencao(parent, "Por favor, insira uma cidade de até 50 caracteres!");
            txtCidade.requestFocus();
            txtCidade.selectAll();
            return;
        }
        // CADASTRAR AGENCIA COM BD
        Thread t1 = new Thread() {
            
            @Override
            public void run() {
                try {    
                    setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
                    DBHelper instance = DBHelper.getInstance();
                    Agencia a = new Agencia();
                    a.setNome(nome);
                    a.setCidade(cidade);
                    a.setEstado(estado);
                    instance.addAgencia(a);
                    Mensagem.informacao(parent, "Agência cadastrada com sucesso!");
                    dispose();
                    // ENCERRAR JANELA
                } catch (SQLException ex) {
                    Mensagem.erro(parent, ex.getMessage());
                } finally {
                    btnOK.setEnabled(true);
                    setCursor(Cursor.getDefaultCursor());
                }
            }
        };
        
        t1.start();
    }//GEN-LAST:event_btnOKActionPerformed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        // TODO add your handling code here:
        if (!btnOK.isEnabled()) {
            setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
            Mensagem.atencao(parent, "Aguarde, estamos cadastrando uma nova agência!");
        }
    }//GEN-LAST:event_formWindowClosing
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnOK;
    private javax.swing.JLabel lblCidade;
    private javax.swing.JLabel lblEstado;
    private javax.swing.JLabel lblNome;
    private javax.swing.JTextField txtCidade;
    private javax.swing.JTextField txtEstado;
    private javax.swing.JTextField txtNome;
    // End of variables declaration//GEN-END:variables
}
