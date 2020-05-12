package com.lmv.agenciabancaria.ui;
import com.lmv.agenciabancaria.database.helper.DBHelper;
import com.lmv.agenciabancaria.exception.AgenciaBancariaException;
import com.lmv.agenciabancaria.model.Funcionario;
import java.awt.Cursor;
import java.awt.event.KeyEvent;
import java.sql.SQLException;

public class AcessoFuncionarioUI extends javax.swing.JDialog {
    
    private final java.awt.Frame parent;
    private final int op;
    
    public AcessoFuncionarioUI(java.awt.Frame parent, boolean modal, int op) {
        super(parent, modal);
        this.parent = parent;
        this.op = op;
        beforeInitComponents();
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        texto = new javax.swing.JLabel();
        txtNumFunc = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Acesso::Funcionário");
        setMaximumSize(new java.awt.Dimension(348, 200));
        setMinimumSize(new java.awt.Dimension(348, 200));
        setModal(true);
        setModalExclusionType(null);
        setResizable(false);
        setSize(new java.awt.Dimension(348, 200));
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        texto.setFont(new java.awt.Font("Roboto", 0, 18)); // NOI18N
        texto.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        texto.setText("Insira seu número funcional:");
        texto.setMaximumSize(new java.awt.Dimension(300, 40));
        texto.setMinimumSize(new java.awt.Dimension(300, 40));
        texto.setPreferredSize(new java.awt.Dimension(300, 40));

        txtNumFunc.setFont(new java.awt.Font("Roboto", 0, 18)); // NOI18N
        txtNumFunc.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtNumFunc.setAutoscrolls(false);
        txtNumFunc.setMaximumSize(new java.awt.Dimension(300, 40));
        txtNumFunc.setMinimumSize(new java.awt.Dimension(300, 40));
        txtNumFunc.setPreferredSize(new java.awt.Dimension(300, 40));
        txtNumFunc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNumFuncActionPerformed(evt);
            }
        });
        txtNumFunc.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtNumFuncKeyPressed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(texto, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtNumFunc, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(24, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(texto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(txtNumFunc, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(77, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents
    
    private void beforeInitComponents() {
        initComponents();
    }
    
    private void carregarFuncionario() {        
        new Thread() {            
            @Override
            public void run() {
                try {
                    txtNumFunc.setEnabled(false);
                    setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
                    int cod = Integer.parseInt(txtNumFunc.getText().trim());
                    Funcionario f = DBHelper.getInstance().getFuncionario(cod);
                    switch (op) { // Qual tela carregar
                        case 0: // FUNCIONARIO
                            dispose();
                            new FuncionarioUI(parent, true, f).setVisible(true);
                            break;
                        case 1: // GERENTE
                            DBHelper.getInstance().gerenteExists(cod);
                            dispose();
                            new GerenteUI(parent, true, f).setVisible(true);
                            break;
                        default:
                            break;             
                    }
                } catch (AgenciaBancariaException ex) {
                    Mensagem.atencao(parent, ex.getMessage());
                } catch (SQLException ex) {
                    Mensagem.erro(parent, ex.getMessage());
                } finally {
                    setCursor(Cursor.getDefaultCursor());
                    txtNumFunc.setEnabled(true);
                }
            }
        }.start();
    }
    
    private void txtNumFuncKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNumFuncKeyPressed
        int key = evt.getKeyCode();
        if (key == KeyEvent.VK_ENTER) {
            this.carregarFuncionario();
        }
    }//GEN-LAST:event_txtNumFuncKeyPressed

    private void txtNumFuncActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNumFuncActionPerformed
    }//GEN-LAST:event_txtNumFuncActionPerformed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        // TODO add your handling code here:
        if (!txtNumFunc.isEnabled())
            setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
    }//GEN-LAST:event_formWindowClosing

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel texto;
    private javax.swing.JTextField txtNumFunc;
    // End of variables declaration//GEN-END:variables
}
