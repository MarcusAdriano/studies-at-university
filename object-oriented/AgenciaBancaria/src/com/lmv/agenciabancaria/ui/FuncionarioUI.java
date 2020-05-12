package com.lmv.agenciabancaria.ui;

import com.lmv.agenciabancaria.database.helper.DBHelper;
import com.lmv.agenciabancaria.model.Dependente;
import com.lmv.agenciabancaria.model.Funcionario;
import java.awt.Cursor;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import javax.swing.table.DefaultTableModel;

public class FuncionarioUI extends javax.swing.JDialog {
    
    private final java.awt.Frame parent;
    private final Funcionario funcionario;
    private final SimpleDateFormat dateFormat;
    private DefaultTableModel tabDependentes;
    private boolean control = false;
    
    public FuncionarioUI(java.awt.Frame parent, boolean modal, Funcionario f) {
        super(parent, modal);
        this.parent = parent;
        this.funcionario = f;
        this.dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        beforeInitComponents();        
        
        this.tabDependentes = (DefaultTableModel) tblDependentes.getModel();
        refreshTable();
    }
    
    private void addOnTable(Dependente a) {
        Object[] rowData = {
                a.getNome()
            };
        tabDependentes.addRow(rowData);
    }
    
    private void refreshTable() {
        Thread t1 = new Thread() {
            @Override
            public void run() {
                try {
                    control = true;                    
                    while (tabDependentes.getRowCount() > 0)
                        tabDependentes.removeRow(0);
                    
                    setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
                    for (Dependente a: DBHelper.getInstance().getAllDependenteFuncionario(funcionario)) {
                        addOnTable(a);
                    }
                } catch (SQLException ex) {
                    Mensagem.erro(parent, "Erro ao carregar dados! Detalhes:\n" + ex.getMessage());
                } finally {
                    setCursor(Cursor.getDefaultCursor());
                    control = false;
                }
            }            
        };
        
        t1.start();
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        informacao = new javax.swing.JTabbedPane();
        aba_inf = new javax.swing.JPanel();
        lblNome = new javax.swing.JLabel();
        lblNum_func = new javax.swing.JLabel();
        lblTelefone = new javax.swing.JLabel();
        lblData_admissao = new javax.swing.JLabel();
        lblTempo = new javax.swing.JLabel();
        lblSupervisor = new javax.swing.JLabel();
        txtNome = new javax.swing.JTextField();
        txtNumFuncionario = new javax.swing.JTextField();
        txtTelefone = new javax.swing.JTextField();
        txtDataAdmissao = new javax.swing.JTextField();
        txtSupervisor = new javax.swing.JTextField();
        txtTempoServico = new javax.swing.JTextField();
        btnSair = new javax.swing.JButton();
        aba_dep = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblDependentes = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Funcionário");
        setMinimumSize(new java.awt.Dimension(500, 350));
        setModal(true);
        setModalExclusionType(null);
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        informacao.setMaximumSize(new java.awt.Dimension(500, 350));
        informacao.setMinimumSize(new java.awt.Dimension(500, 350));
        informacao.setPreferredSize(new java.awt.Dimension(500, 350));

        aba_inf.setMaximumSize(new java.awt.Dimension(500, 350));
        aba_inf.setMinimumSize(new java.awt.Dimension(500, 350));

        lblNome.setFont(new java.awt.Font("Roboto", 0, 18)); // NOI18N
        lblNome.setText("Nome");
        lblNome.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        lblNome.setMaximumSize(new java.awt.Dimension(175, 36));
        lblNome.setMinimumSize(new java.awt.Dimension(175, 36));
        lblNome.setPreferredSize(new java.awt.Dimension(175, 36));

        lblNum_func.setFont(new java.awt.Font("Roboto", 0, 18)); // NOI18N
        lblNum_func.setText("Número Funcional");
        lblNum_func.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        lblNum_func.setMaximumSize(new java.awt.Dimension(175, 36));
        lblNum_func.setMinimumSize(new java.awt.Dimension(175, 36));
        lblNum_func.setPreferredSize(new java.awt.Dimension(175, 36));

        lblTelefone.setFont(new java.awt.Font("Roboto", 0, 18)); // NOI18N
        lblTelefone.setText("Telefone");
        lblTelefone.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        lblTelefone.setMaximumSize(new java.awt.Dimension(175, 36));
        lblTelefone.setMinimumSize(new java.awt.Dimension(175, 36));
        lblTelefone.setPreferredSize(new java.awt.Dimension(175, 36));

        lblData_admissao.setFont(new java.awt.Font("Roboto", 0, 18)); // NOI18N
        lblData_admissao.setText("Data de Admissão");
        lblData_admissao.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        lblData_admissao.setMaximumSize(new java.awt.Dimension(175, 36));
        lblData_admissao.setMinimumSize(new java.awt.Dimension(175, 36));
        lblData_admissao.setPreferredSize(new java.awt.Dimension(175, 36));

        lblTempo.setFont(new java.awt.Font("Roboto", 0, 18)); // NOI18N
        lblTempo.setText("Tempo de Serviço");
        lblTempo.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        lblTempo.setMaximumSize(new java.awt.Dimension(175, 36));
        lblTempo.setMinimumSize(new java.awt.Dimension(175, 36));
        lblTempo.setPreferredSize(new java.awt.Dimension(175, 36));

        lblSupervisor.setFont(new java.awt.Font("Roboto", 0, 18)); // NOI18N
        lblSupervisor.setText("Supervisor");
        lblSupervisor.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        lblSupervisor.setMaximumSize(new java.awt.Dimension(175, 36));
        lblSupervisor.setMinimumSize(new java.awt.Dimension(175, 36));
        lblSupervisor.setPreferredSize(new java.awt.Dimension(175, 36));

        txtNome.setEditable(false);
        txtNome.setFont(new java.awt.Font("Roboto", 0, 18)); // NOI18N
        txtNome.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtNome.setAutoscrolls(false);
        txtNome.setMaximumSize(new java.awt.Dimension(150, 36));
        txtNome.setMinimumSize(new java.awt.Dimension(150, 36));
        txtNome.setPreferredSize(new java.awt.Dimension(150, 36));

        txtNumFuncionario.setEditable(false);
        txtNumFuncionario.setFont(new java.awt.Font("Roboto", 0, 18)); // NOI18N
        txtNumFuncionario.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtNumFuncionario.setAutoscrolls(false);
        txtNumFuncionario.setMaximumSize(new java.awt.Dimension(150, 36));
        txtNumFuncionario.setMinimumSize(new java.awt.Dimension(150, 36));
        txtNumFuncionario.setPreferredSize(new java.awt.Dimension(150, 36));

        txtTelefone.setEditable(false);
        txtTelefone.setFont(new java.awt.Font("Roboto", 0, 18)); // NOI18N
        txtTelefone.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtTelefone.setAutoscrolls(false);
        txtTelefone.setMaximumSize(new java.awt.Dimension(150, 36));
        txtTelefone.setMinimumSize(new java.awt.Dimension(150, 36));
        txtTelefone.setPreferredSize(new java.awt.Dimension(150, 36));

        txtDataAdmissao.setEditable(false);
        txtDataAdmissao.setFont(new java.awt.Font("Roboto", 0, 18)); // NOI18N
        txtDataAdmissao.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtDataAdmissao.setAutoscrolls(false);
        txtDataAdmissao.setMaximumSize(new java.awt.Dimension(150, 36));
        txtDataAdmissao.setMinimumSize(new java.awt.Dimension(150, 36));
        txtDataAdmissao.setPreferredSize(new java.awt.Dimension(150, 36));

        txtSupervisor.setEditable(false);
        txtSupervisor.setFont(new java.awt.Font("Roboto", 0, 18)); // NOI18N
        txtSupervisor.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtSupervisor.setAutoscrolls(false);
        txtSupervisor.setMaximumSize(new java.awt.Dimension(150, 36));
        txtSupervisor.setMinimumSize(new java.awt.Dimension(150, 36));
        txtSupervisor.setPreferredSize(new java.awt.Dimension(150, 36));

        txtTempoServico.setEditable(false);
        txtTempoServico.setFont(new java.awt.Font("Roboto", 0, 18)); // NOI18N
        txtTempoServico.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtTempoServico.setAutoscrolls(false);
        txtTempoServico.setMaximumSize(new java.awt.Dimension(150, 36));
        txtTempoServico.setMinimumSize(new java.awt.Dimension(150, 36));
        txtTempoServico.setPreferredSize(new java.awt.Dimension(150, 36));

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

        javax.swing.GroupLayout aba_infLayout = new javax.swing.GroupLayout(aba_inf);
        aba_inf.setLayout(aba_infLayout);
        aba_infLayout.setHorizontalGroup(
            aba_infLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(aba_infLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(aba_infLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblData_admissao, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblNum_func, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblNome, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblTelefone, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblTempo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblSupervisor, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(aba_infLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtNome, javax.swing.GroupLayout.DEFAULT_SIZE, 291, Short.MAX_VALUE)
                    .addComponent(txtNumFuncionario, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtTelefone, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtDataAdmissao, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtSupervisor, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtTempoServico, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, aba_infLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnSair, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        aba_infLayout.setVerticalGroup(
            aba_infLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(aba_infLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(aba_infLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(aba_infLayout.createSequentialGroup()
                        .addComponent(txtNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtNumFuncionario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtTelefone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtDataAdmissao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(aba_infLayout.createSequentialGroup()
                        .addComponent(lblNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblNum_func, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblTelefone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblData_admissao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(aba_infLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblTempo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtTempoServico, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(aba_infLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblSupervisor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtSupervisor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnSair, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(44, Short.MAX_VALUE))
        );

        informacao.addTab("Informações", aba_inf);

        aba_dep.setMaximumSize(new java.awt.Dimension(500, 350));
        aba_dep.setMinimumSize(new java.awt.Dimension(500, 350));
        aba_dep.setPreferredSize(new java.awt.Dimension(500, 350));

        tblDependentes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nome"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblDependentes.setRowSelectionAllowed(false);
        jScrollPane1.setViewportView(tblDependentes);
        if (tblDependentes.getColumnModel().getColumnCount() > 0) {
            tblDependentes.getColumnModel().getColumn(0).setResizable(false);
        }

        javax.swing.GroupLayout aba_depLayout = new javax.swing.GroupLayout(aba_dep);
        aba_dep.setLayout(aba_depLayout);
        aba_depLayout.setHorizontalGroup(
            aba_depLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, aba_depLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 472, Short.MAX_VALUE)
                .addContainerGap())
        );
        aba_depLayout.setVerticalGroup(
            aba_depLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(aba_depLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(65, 65, 65))
        );

        informacao.addTab("Dependentes", aba_dep);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(informacao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(informacao, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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
        if (!btnSair.isEnabled() || control)
            setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
    }//GEN-LAST:event_formWindowClosing
    private void beforeInitComponents() {
        initComponents();     
        
        // carregar informações do cliente
        txtNome.setText(funcionario.getNome());
        txtNumFuncionario.setText(funcionario.getNum() + "");
        txtTelefone.setText(funcionario.getTelefone());
        txtDataAdmissao.setText(dateFormat.format(funcionario.getDataAdmissao()));
        txtTempoServico.setText("" + (int) (funcionario.getTempoServico() / (1000*60*60*24)));
        txtSupervisor.setText("" + funcionario.getIdSupervisor()); 
        
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel aba_dep;
    private javax.swing.JPanel aba_inf;
    private javax.swing.JButton btnSair;
    private javax.swing.JTabbedPane informacao;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblData_admissao;
    private javax.swing.JLabel lblNome;
    private javax.swing.JLabel lblNum_func;
    private javax.swing.JLabel lblSupervisor;
    private javax.swing.JLabel lblTelefone;
    private javax.swing.JLabel lblTempo;
    private javax.swing.JTable tblDependentes;
    private javax.swing.JTextField txtDataAdmissao;
    private javax.swing.JTextField txtNome;
    private javax.swing.JTextField txtNumFuncionario;
    private javax.swing.JTextField txtSupervisor;
    private javax.swing.JTextField txtTelefone;
    private javax.swing.JTextField txtTempoServico;
    // End of variables declaration//GEN-END:variables
}
