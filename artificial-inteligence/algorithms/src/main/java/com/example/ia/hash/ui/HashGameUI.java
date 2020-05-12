package com.example.ia.hash.ui;

import br.ufu.ml.ia.AlfaBeta;
import br.ufu.ml.ia.Minimax;
import br.ufu.ml.ia.Node;
import br.ufu.ml.ia.NodeData;
import com.example.ia.hash.HashAgent;
import com.example.ia.hash.HashPosition;
import com.example.ia.hash.HashState;

import javax.swing.*;
import java.util.LinkedList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 *
 * @author Marcus
 */
public class HashGameUI extends javax.swing.JFrame {

    /**
     * Creates new form NewJFrame
     */
    private HashGameUI() {
        initComponents();
        this.newGame();
        this.mListener = (button, position) -> {
            if (!mMinimax.isUserTurn()) {
                JOptionPane.showMessageDialog(
                        HashGameUI.this,
                        "You can't play now!",
                        "Oops", JOptionPane.WARNING_MESSAGE);
                return;
            }

            if (!mLocalGame.canMark(position)) {
                JOptionPane.showMessageDialog(
                        HashGameUI.this,
                        "You can't play in this position!",
                        "Oops", JOptionPane.WARNING_MESSAGE);
                return;
            }

            mLocalGame = mMinimax.minimaxForMin(new Node<>(NodeData.newRoot(mLocalGame)));

            //mLocalGame.mark('O', position.x, position.y);
            updateView();
            computerMovement();
        };
    }

    private void computerMovement() {
        mService.execute(() -> {
            btnNewGame.setEnabled(false);
            try {
                Thread.sleep(500);
                mLocalGame = mMinimax.minimax(new Node<>(NodeData.newRoot(mLocalGame)));
                updateView();

            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                btnNewGame.setEnabled(true);
            }
        });
    }

    private void updateView() {
        mMinimax.nextPlayer();

        // Current player
        if (mMinimax.isUserTurn()) {
            lblCurrentPlayer.setText("COMPUTADOR O");
        } else {
            lblCurrentPlayer.setText("COMPUTADOR X...");
        }
        int n = 0;
        for (int i = 0; i < 3; i++) {
            for (int  j = 0; j < 3; j++) {
                char value = mLocalGame.getValue(i, j);
                if (value != HashState.nullChar) {
                    mButtonList.get(n).setText(mLocalGame.getValue(i, j) + "");
                } else {
                    mButtonList.get(n).setText("");
                }
                n++;
            }
        }

        if (mLocalGame.isTerminal()) {
            if (mLocalGame.getUtility() > 0) {
                JOptionPane
                        .showMessageDialog(this,
                                "YOU LOSE!");
                newGame();
            } else if (mLocalGame.getUtility() == 0) {
                JOptionPane
                        .showMessageDialog(this,
                                "DRAW!");
                newGame();
            } else {
                JOptionPane
                        .showMessageDialog(this,
                                "IMPOSSIBLEEE!");
                newGame();
            }
        }
    }

    private void newGame() {
        mAgent = new HashAgent((mLocalGame = new HashState()));
        for (javax.swing.JButton btn : mButtonList) {
            btn.setText("");
        }

        mMinimax = new AlfaBeta();
        mAgent.setAlgorithm(mMinimax);
        updateView();

        if (!mMinimax.isUserTurn()) {
            mService.shutdownNow();
            mService = Executors.newSingleThreadExecutor();
            computerMovement();
        }
    }

    private void buttonClick(java.awt.event.ActionEvent event) {
        javax.swing.JButton button =
                (javax.swing.JButton) event.getSource();

        switch (button.getName()) {
            case "btn00":
                mListener.onClick(button, new HashPosition(0,0));
                break;
            case "btn01":
                mListener.onClick(button, new HashPosition(0,1));
                break;
            case "btn02":
                mListener.onClick(button, new HashPosition(0,2));
                break;
            case "btn10":
                mListener.onClick(button, new HashPosition(1,0));
                break;
            case "btn11":
                mListener.onClick(button, new HashPosition(1,1));
                break;
            case "btn12":
                mListener.onClick(button, new HashPosition(1,2));
                break;
            case "btn20":
                mListener.onClick(button, new HashPosition(2,0));
                break;
            case "btn21":
                mListener.onClick(button, new HashPosition(2,1));
                break;
            case "btn22":
                mListener.onClick(button, new HashPosition(2,2));
                break;
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">
    private void initComponents() {
        btnNewGame = new javax.swing.JButton();
        panelGameView = new javax.swing.JPanel();
        btn00 = new javax.swing.JButton(); mButtonList.add(btn00); btn00.setName("btn00");
        btn01 = new javax.swing.JButton(); mButtonList.add(btn01); btn01.setName("btn01");
        btn02 = new javax.swing.JButton(); mButtonList.add(btn02); btn02.setName("btn02");
        btn10 = new javax.swing.JButton(); mButtonList.add(btn10); btn10.setName("btn10");
        btn11 = new javax.swing.JButton(); mButtonList.add(btn11); btn11.setName("btn11");
        btn12 = new javax.swing.JButton(); mButtonList.add(btn12); btn12.setName("btn12");
        btn20 = new javax.swing.JButton(); mButtonList.add(btn20); btn20.setName("btn20");
        btn21 = new javax.swing.JButton(); mButtonList.add(btn21); btn21.setName("btn21");
        btn22 = new javax.swing.JButton(); mButtonList.add(btn22); btn22.setName("btn22");
        CurrentPlayer = new javax.swing.JLabel();
        lblCurrentPlayer = new javax.swing.JLabel();

        for (javax.swing.JButton bt : mButtonList) {
            bt.addActionListener(this::buttonClick);
        }

        btnNewGame.addActionListener((e) -> newGame());

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Jogo da Velha");
        setMaximumSize(new java.awt.Dimension(501, 501));
        setMinimumSize(new java.awt.Dimension(499, 499));
        setPreferredSize(new java.awt.Dimension(500, 575));
        setResizable(false);
        setSize(new java.awt.Dimension(500, 575));

        btnNewGame.setText("New Game");

        panelGameView.setBorder(javax.swing.BorderFactory.createTitledBorder("Game View"));

        btn00.setFont(new java.awt.Font("Arial", 1, 96)); // NOI18N
        btn00.setText("X");
        btn00.setFocusPainted(false);
        btn00.setFocusable(false);
        btn00.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        btn02.setFont(new java.awt.Font("Arial", 1, 96)); // NOI18N
        btn02.setFocusPainted(false);
        btn02.setFocusable(false);
        btn02.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        btn01.setFont(new java.awt.Font("Arial", 1, 96)); // NOI18N
        btn01.setText("O");
        btn01.setFocusPainted(false);
        btn01.setFocusable(false);
        btn01.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        btn12.setFont(new java.awt.Font("Arial", 1, 96)); // NOI18N
        btn12.setFocusPainted(false);
        btn12.setFocusable(false);
        btn12.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        btn11.setFont(new java.awt.Font("Arial", 1, 96)); // NOI18N
        btn11.setFocusPainted(false);
        btn11.setFocusable(false);
        btn11.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        btn10.setFont(new java.awt.Font("Arial", 1, 96)); // NOI18N
        btn10.setFocusPainted(false);
        btn10.setFocusable(false);
        btn10.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        btn22.setFont(new java.awt.Font("Arial", 1, 96)); // NOI18N
        btn22.setFocusPainted(false);
        btn22.setFocusable(false);
        btn22.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        btn21.setFont(new java.awt.Font("Arial", 1, 96)); // NOI18N
        btn21.setFocusPainted(false);
        btn21.setFocusable(false);
        btn21.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        btn20.setFont(new java.awt.Font("Arial", 1, 96)); // NOI18N
        btn20.setFocusPainted(false);
        btn20.setFocusable(false);
        btn20.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout panelGameViewLayout = new javax.swing.GroupLayout(panelGameView);
        panelGameView.setLayout(panelGameViewLayout);
        panelGameViewLayout.setHorizontalGroup(
                panelGameViewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(panelGameViewLayout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(panelGameViewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(panelGameViewLayout.createSequentialGroup()
                                                .addComponent(btn00, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 17, Short.MAX_VALUE)
                                                .addComponent(btn01, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(btn02, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(panelGameViewLayout.createSequentialGroup()
                                                .addComponent(btn10, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(btn11, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(btn12, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(panelGameViewLayout.createSequentialGroup()
                                                .addComponent(btn20, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(btn21, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(btn22, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addContainerGap())
        );
        panelGameViewLayout.setVerticalGroup(
                panelGameViewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(panelGameViewLayout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(panelGameViewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(btn01, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(btn02, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(btn00, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(panelGameViewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(btn11, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(btn12, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(btn10, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(panelGameViewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(btn21, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(btn22, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(btn20, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        CurrentPlayer.setText("Current Player:");

        lblCurrentPlayer.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        lblCurrentPlayer.setText("X");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(panelGameView, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addGroup(layout.createSequentialGroup()
                                                .addComponent(btnNewGame, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(CurrentPlayer)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(lblCurrentPlayer, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                                .addContainerGap())
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(btnNewGame)
                                        .addComponent(CurrentPlayer)
                                        .addComponent(lblCurrentPlayer))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(panelGameView, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>

    public static void launchUi() {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(HashGameUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() ->
                new HashGameUI().setVisible(true));
    }

    // Variables declaration - do not modify
    private javax.swing.JLabel CurrentPlayer;
    public javax.swing.JButton btn00;
    public javax.swing.JButton btn01;
    public javax.swing.JButton btn02;
    public javax.swing.JButton btn10;
    public javax.swing.JButton btn11;
    public javax.swing.JButton btn12;
    public javax.swing.JButton btn20;
    public javax.swing.JButton btn21;
    public javax.swing.JButton btn22;
    private javax.swing.JButton btnNewGame;
    private javax.swing.JLabel lblCurrentPlayer;
    private javax.swing.JPanel panelGameView;
    private ButtonClickListener mListener;
    private LinkedList<javax.swing.JButton> mButtonList = new LinkedList<>();
    // End of variables declaration

    // problem variable declaration
    private HashAgent mAgent;
    private HashState mLocalGame;
    private AlfaBeta mMinimax;
    //private Minimax mMinimax;
    private ExecutorService mService = Executors.newSingleThreadExecutor();
    // end declar

    public interface ButtonClickListener {
        void onClick(javax.swing.JButton btn, HashPosition position);
    }
}