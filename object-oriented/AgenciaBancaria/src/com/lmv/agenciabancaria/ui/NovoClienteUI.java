package com.lmv.agenciabancaria.ui;

import com.lmv.agenciabancaria.database.helper.DBHelper;
import com.lmv.agenciabancaria.model.Cliente;
import com.lmv.agenciabancaria.model.Funcionario;
import java.awt.Cursor;
import java.sql.Date;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class NovoClienteUI extends javax.swing.JDialog {
    
    private final java.awt.Frame parent;
    private Funcionario gerente;
    private SimpleDateFormat dateFormat;
    
    public NovoClienteUI(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        this.parent = parent;
        beforeInitComponents();
        
        dateFormat = new SimpleDateFormat("dd/MM/yyyy");
    }
    
    public void setGerente(Funcionario g) {
        this.gerente = g;
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblNome = new javax.swing.JLabel();
        txtNome = new javax.swing.JTextField();
        lblEndereco = new javax.swing.JLabel();
        txtEndereco = new javax.swing.JTextField();
        lblEstado = new javax.swing.JLabel();
        txtEstado = new javax.swing.JTextField();
        lblCPF = new javax.swing.JLabel();
        txtCPF = new javax.swing.JTextField();
        lblCidade = new javax.swing.JLabel();
        txtCidade = new javax.swing.JTextField();
        lblData = new javax.swing.JLabel();
        txtData = new javax.swing.JTextField();
        btnOK = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Novo Cliente");
        setModal(true);
        setModalExclusionType(null);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosed(java.awt.event.WindowEvent evt) {
                formWindowClosed(evt);
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

        lblEndereco.setFont(new java.awt.Font("Roboto", 0, 18)); // NOI18N
        lblEndereco.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblEndereco.setText("Endereço");
        lblEndereco.setMaximumSize(new java.awt.Dimension(200, 40));
        lblEndereco.setMinimumSize(new java.awt.Dimension(200, 40));
        lblEndereco.setPreferredSize(new java.awt.Dimension(200, 40));
        lblEndereco.setRequestFocusEnabled(false);

        txtEndereco.setFont(new java.awt.Font("Roboto", 0, 18)); // NOI18N
        txtEndereco.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtEndereco.setMaximumSize(new java.awt.Dimension(200, 40));
        txtEndereco.setMinimumSize(new java.awt.Dimension(200, 40));
        txtEndereco.setPreferredSize(new java.awt.Dimension(200, 40));

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

        lblCPF.setFont(new java.awt.Font("Roboto", 0, 18)); // NOI18N
        lblCPF.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblCPF.setText("CPF");
        lblCPF.setMaximumSize(new java.awt.Dimension(200, 40));
        lblCPF.setMinimumSize(new java.awt.Dimension(200, 40));
        lblCPF.setPreferredSize(new java.awt.Dimension(200, 40));
        lblCPF.setRequestFocusEnabled(false);

        txtCPF.setFont(new java.awt.Font("Roboto", 0, 18)); // NOI18N
        txtCPF.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtCPF.setMaximumSize(new java.awt.Dimension(200, 40));
        txtCPF.setMinimumSize(new java.awt.Dimension(200, 40));
        txtCPF.setPreferredSize(new java.awt.Dimension(200, 40));

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

        lblData.setFont(new java.awt.Font("Roboto", 0, 18)); // NOI18N
        lblData.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblData.setText("Data de Nascimento");
        lblData.setMaximumSize(new java.awt.Dimension(200, 40));
        lblData.setMinimumSize(new java.awt.Dimension(200, 40));
        lblData.setPreferredSize(new java.awt.Dimension(200, 40));
        lblData.setRequestFocusEnabled(false);

        txtData.setFont(new java.awt.Font("Roboto", 0, 18)); // NOI18N
        txtData.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtData.setMaximumSize(new java.awt.Dimension(200, 40));
        txtData.setMinimumSize(new java.awt.Dimension(200, 40));
        txtData.setPreferredSize(new java.awt.Dimension(200, 40));

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
                        .addComponent(txtEstado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(lblEndereco, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txtNome, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txtEndereco, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lblNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 130, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(lblData, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txtData, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(lblCidade, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txtCPF, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txtCidade, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lblCPF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(65, 65, 65))
            .addGroup(layout.createSequentialGroup()
                .addGap(230, 230, 230)
                .addComponent(btnOK, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblNome, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(lblEndereco, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtEndereco, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(lblEstado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtEstado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblCPF, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtCPF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(lblCidade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtCidade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(lblData, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtData, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(25, 25, 25)
                .addComponent(btnOK, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents
    private void beforeInitComponents() {
        initComponents();
    }
    
    private void btnOKActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnOKActionPerformed

        if (!isDadosOK())
            return;
        
        new Thread() {
            
            @Override
            public void run() {
                try {
                    if (gerente == null) {
                        throw new IllegalArgumentException("Gerente is null");
                    }                   
                    setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
                    btnOK.setEnabled(false);
                    String nome, endereco, cidade, cpf, estado, dataNascimento;
                    nome = txtNome.getText().trim();
                    endereco = txtEndereco.getText().trim();
                    cpf = txtCPF.getText().trim();
                    cidade = txtCidade.getText().trim();
                    dataNascimento = txtData.getText().trim();
                    estado = txtEstado.getText().trim();
                    
                    Date dataNiver = new Date(dateFormat.parse(dataNascimento).getTime());
                    
                    
                    Cliente c = new Cliente(cpf, cidade, endereco, estado, nome, 
                            dataNiver, gerente.getNum());
                    DBHelper.getInstance().addCliente(c); 
                    Mensagem.informacao(parent, "Cliente cadastrado com sucesso!");
                    dispose();
                } catch (SQLException | ParseException ex) {
                    Mensagem.erro(parent, ex.getMessage());
                } finally {
                    setCursor(Cursor.getDefaultCursor());
                    btnOK.setEnabled(true);
                }
            }
        }.start();
    }//GEN-LAST:event_btnOKActionPerformed

    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed
        // TODO add your handling code here:
        if (!btnOK.isEnabled())
            setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
    }//GEN-LAST:event_formWindowClosed
    
    private boolean isDadosOK() {
        String nome = txtNome.getText().trim(),
                estado = txtEstado.getText().trim(),
                cidade = txtCidade.getText().trim(),
                cpf = txtCPF.getText().trim(),
                data = txtData.getText().trim(),
                endereco = txtEndereco.getText().trim();

        if (nome.isEmpty()) {
            Mensagem.atencao(parent, "Por favor, insira um nome!");
            return false;
        }

        if (cpf.isEmpty()) {
            Mensagem.atencao(parent, "Insira o seu CPF!");
            txtCPF.requestFocus();
            txtCPF.selectAll();
            return false;
        }
        cpf = cpf.replaceAll("[.-]", "");

        if (endereco.isEmpty()) {
            Mensagem.atencao(parent, "Por favor, insira um endereço!");
            txtEndereco.requestFocus();
            return false;
        }

        if (cidade.isEmpty()) {
            Mensagem.atencao(parent, "Por favor, insira uma cidade!");
            txtCidade.requestFocus();
            return false;
        }

        if (estado.isEmpty()) {
            Mensagem.atencao(parent, "Por favor, insira um estado!");
            txtEstado.requestFocus();
            return false;
        }

        if (data.isEmpty()) {
            Mensagem.atencao(parent, "Por favor, insira uma data de nascimento!");
            txtData.requestFocus();
            return false;
        }

        if (nome.length() > 50) {
            Mensagem.atencao(parent, "Por favor, insira um nome de até 50 caracteres!");
            txtNome.requestFocus();
            txtNome.selectAll();
            return false;
        }

        if (cpf.length() != 11) {
            Mensagem.atencao(parent, "CPF inválido. \nInsira um CPF válido.");
            txtCPF.requestFocus();
            txtCPF.selectAll();
            return false;
        }

        if (endereco.length() > 50) {
            Mensagem.atencao(parent, "Por favor, insira um endereço de até 50 caracteres!");
            txtEndereco.requestFocus();
            txtEndereco.selectAll();
            return false;
        }

        if (cidade.length() > 50) {
            Mensagem.atencao(parent, "Por favor, insira uma cidade de até 50 caracteres!");
            txtCidade.requestFocus();
            txtCidade.selectAll();
            return false;
        }

        if (estado.length() != 2) {
            Mensagem.atencao(parent, "Por favor, insira somente a sigla do estado, ex: SP!");
            txtEstado.requestFocus();
            txtEstado.selectAll();
            return false;
        }

        try {
            new Date(dateFormat.parse(data).getTime());
        } catch  (ParseException ex) {
            Mensagem.atencao(parent, "Data de nascimento inválida!");
            return false;
        }
        
        return true;
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnOK;
    private javax.swing.JLabel lblCPF;
    private javax.swing.JLabel lblCidade;
    private javax.swing.JLabel lblData;
    private javax.swing.JLabel lblEndereco;
    private javax.swing.JLabel lblEstado;
    private javax.swing.JLabel lblNome;
    private javax.swing.JTextField txtCPF;
    private javax.swing.JTextField txtCidade;
    private javax.swing.JTextField txtData;
    private javax.swing.JTextField txtEndereco;
    private javax.swing.JTextField txtEstado;
    private javax.swing.JTextField txtNome;
    // End of variables declaration//GEN-END:variables
}
