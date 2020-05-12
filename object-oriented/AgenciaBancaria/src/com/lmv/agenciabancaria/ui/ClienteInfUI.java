package com.lmv.agenciabancaria.ui;

import com.lmv.agenciabancaria.model.Cliente;
import com.lmv.agenciabancaria.model.Conta;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;

public class ClienteInfUI extends javax.swing.JDialog {
    
    private final java.awt.Frame parent;
    private final Cliente cliente;
    private final Conta conta;
    
    public ClienteInfUI(java.awt.Frame parent, boolean modal, 
            Cliente c, Conta p) {
        super(parent, modal);
        this.parent = parent;
        beforeInitComponents();
        this.conta = p;
        this.cliente = c;
        
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        DecimalFormat decimalFormat = new DecimalFormat("#,##0.00");
        
        txtCPF.setText(cliente.getCpf());
        txtCidade.setText(cliente.getCidade());
        txtData.setText(dateFormat.format(cliente.getDataNiver()));
        txtEndeco.setText(cliente.getEndereco());
        txtEstado.setText(cliente.getEstado());
        txtNome.setText(cliente.getNome());
        txtSaldo.setText("R$ " + decimalFormat.format(conta.getSaldo()));
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblNome = new javax.swing.JLabel();
        lblCPF = new javax.swing.JLabel();
        lblData = new javax.swing.JLabel();
        lblEndereco = new javax.swing.JLabel();
        lblCidade = new javax.swing.JLabel();
        lblEstado = new javax.swing.JLabel();
        txtNome = new javax.swing.JTextField();
        txtCPF = new javax.swing.JTextField();
        txtData = new javax.swing.JTextField();
        txtEndeco = new javax.swing.JTextField();
        txtCidade = new javax.swing.JTextField();
        txtEstado = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        lblSaldo = new javax.swing.JLabel();
        txtSaldo = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Informações de Cliente");
        setModal(true);
        setModalExclusionType(null);
        setResizable(false);

        lblNome.setFont(new java.awt.Font("Roboto", 0, 18)); // NOI18N
        lblNome.setText("Nome");
        lblNome.setMaximumSize(new java.awt.Dimension(100, 36));
        lblNome.setMinimumSize(new java.awt.Dimension(100, 36));
        lblNome.setPreferredSize(new java.awt.Dimension(100, 36));

        lblCPF.setFont(new java.awt.Font("Roboto", 0, 18)); // NOI18N
        lblCPF.setText("CPF");
        lblCPF.setMaximumSize(new java.awt.Dimension(100, 36));
        lblCPF.setMinimumSize(new java.awt.Dimension(100, 36));
        lblCPF.setPreferredSize(new java.awt.Dimension(100, 36));

        lblData.setFont(new java.awt.Font("Roboto", 0, 18)); // NOI18N
        lblData.setText("Nascimento");
        lblData.setMaximumSize(new java.awt.Dimension(100, 36));
        lblData.setMinimumSize(new java.awt.Dimension(100, 36));
        lblData.setPreferredSize(new java.awt.Dimension(100, 36));

        lblEndereco.setFont(new java.awt.Font("Roboto", 0, 18)); // NOI18N
        lblEndereco.setText("Endereço");
        lblEndereco.setMaximumSize(new java.awt.Dimension(100, 36));
        lblEndereco.setMinimumSize(new java.awt.Dimension(100, 36));
        lblEndereco.setPreferredSize(new java.awt.Dimension(100, 36));

        lblCidade.setFont(new java.awt.Font("Roboto", 0, 18)); // NOI18N
        lblCidade.setText("Cidade");
        lblCidade.setMaximumSize(new java.awt.Dimension(100, 36));
        lblCidade.setMinimumSize(new java.awt.Dimension(100, 36));
        lblCidade.setPreferredSize(new java.awt.Dimension(100, 36));

        lblEstado.setFont(new java.awt.Font("Roboto", 0, 18)); // NOI18N
        lblEstado.setText("Estado");
        lblEstado.setMaximumSize(new java.awt.Dimension(100, 36));
        lblEstado.setMinimumSize(new java.awt.Dimension(100, 36));
        lblEstado.setPreferredSize(new java.awt.Dimension(100, 36));

        txtNome.setEditable(false);
        txtNome.setAutoscrolls(false);
        txtNome.setEnabled(false);
        txtNome.setMaximumSize(new java.awt.Dimension(150, 36));
        txtNome.setMinimumSize(new java.awt.Dimension(150, 36));
        txtNome.setPreferredSize(new java.awt.Dimension(150, 36));

        txtCPF.setEditable(false);
        txtCPF.setAutoscrolls(false);
        txtCPF.setEnabled(false);
        txtCPF.setMaximumSize(new java.awt.Dimension(150, 36));
        txtCPF.setMinimumSize(new java.awt.Dimension(150, 36));
        txtCPF.setPreferredSize(new java.awt.Dimension(150, 36));

        txtData.setEditable(false);
        txtData.setAutoscrolls(false);
        txtData.setEnabled(false);
        txtData.setMaximumSize(new java.awt.Dimension(150, 36));
        txtData.setMinimumSize(new java.awt.Dimension(150, 36));
        txtData.setPreferredSize(new java.awt.Dimension(150, 36));

        txtEndeco.setEditable(false);
        txtEndeco.setAutoscrolls(false);
        txtEndeco.setEnabled(false);
        txtEndeco.setMaximumSize(new java.awt.Dimension(150, 36));
        txtEndeco.setMinimumSize(new java.awt.Dimension(150, 36));
        txtEndeco.setPreferredSize(new java.awt.Dimension(150, 36));

        txtCidade.setEditable(false);
        txtCidade.setAutoscrolls(false);
        txtCidade.setEnabled(false);
        txtCidade.setMaximumSize(new java.awt.Dimension(150, 36));
        txtCidade.setMinimumSize(new java.awt.Dimension(150, 36));
        txtCidade.setPreferredSize(new java.awt.Dimension(150, 36));

        txtEstado.setEditable(false);
        txtEstado.setAutoscrolls(false);
        txtEstado.setEnabled(false);
        txtEstado.setMaximumSize(new java.awt.Dimension(150, 36));
        txtEstado.setMinimumSize(new java.awt.Dimension(150, 36));
        txtEstado.setPreferredSize(new java.awt.Dimension(150, 36));

        jButton1.setFont(new java.awt.Font("Roboto", 0, 18)); // NOI18N
        jButton1.setText("Sair");
        jButton1.setMaximumSize(new java.awt.Dimension(75, 36));
        jButton1.setMinimumSize(new java.awt.Dimension(75, 36));
        jButton1.setPreferredSize(new java.awt.Dimension(75, 36));
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        lblSaldo.setFont(new java.awt.Font("Roboto", 0, 18)); // NOI18N
        lblSaldo.setText("Saldo");
        lblSaldo.setMaximumSize(new java.awt.Dimension(100, 36));
        lblSaldo.setMinimumSize(new java.awt.Dimension(100, 36));
        lblSaldo.setPreferredSize(new java.awt.Dimension(100, 36));

        txtSaldo.setEditable(false);
        txtSaldo.setAutoscrolls(false);
        txtSaldo.setEnabled(false);
        txtSaldo.setMaximumSize(new java.awt.Dimension(150, 36));
        txtSaldo.setMinimumSize(new java.awt.Dimension(150, 36));
        txtSaldo.setPreferredSize(new java.awt.Dimension(150, 36));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(65, 65, 65)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lblEstado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lblCPF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lblEndereco, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lblCidade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lblData, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtCPF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtData, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtEndeco, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtCidade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtEstado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(lblSaldo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(txtSaldo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(160, 160, 160)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(65, 65, 65))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblCPF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtCPF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblData, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtData, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblEndereco, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtEndeco, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblCidade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtCidade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblEstado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtEstado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblSaldo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtSaldo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 30, Short.MAX_VALUE)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents
    private void beforeInitComponents() {
        initComponents();
    }
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        this.dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel lblCPF;
    private javax.swing.JLabel lblCidade;
    private javax.swing.JLabel lblData;
    private javax.swing.JLabel lblEndereco;
    private javax.swing.JLabel lblEstado;
    private javax.swing.JLabel lblNome;
    private javax.swing.JLabel lblSaldo;
    private javax.swing.JTextField txtCPF;
    private javax.swing.JTextField txtCidade;
    private javax.swing.JTextField txtData;
    private javax.swing.JTextField txtEndeco;
    private javax.swing.JTextField txtEstado;
    private javax.swing.JTextField txtNome;
    private javax.swing.JTextField txtSaldo;
    // End of variables declaration//GEN-END:variables
}
