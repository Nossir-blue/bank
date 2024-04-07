/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistemabancario;



import DTO.Aglomerado;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;
import javax.swing.JOptionPane;

/**
 *
 * @author Manuel Genásys
 */
public class ContaPoupança extends javax.swing.JFrame {

    /**
     * Creates new form ContaPoupança
     */
    public ContaPoupança() {
        initComponents();
        listarContas();
        jtxtNIF.setEditable(false);
        txtLimite.setEditable(false);
    }

    Vector<String> Titular = new Vector<String>();
    Vector<Double> Saldo = new Vector<Double>();

    public void listarContas() {
        try {
            ContaPoupançaDAO objcontaDao = new ContaPoupançaDAO();
            ResultSet rs = objcontaDao.listaContas();
            while (rs.next()) {
                cmbTitular.addItem(rs.getInt(1));
                Titular.addElement(rs.getString(2));
                Saldo.addElement(rs.getDouble(3));
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro no formulario  de contas poupança, listar Cliente" + e);
        }
    }

    public void mostrarTitular() {
        jtxtNIF.setText(Titular.get(cmbTitular.getSelectedIndex() - 1));
    }

    public void Verificar() {
        double saldo = 0,novosaldo = 0;
        saldo = Double.parseDouble(txtSaldo.getText());
        if (saldo > 100000 && saldo < 600000) {
            txtVariação.setText("5%");
            novosaldo = saldo + (saldo * 0.05);
            txtLimite.setText(String.valueOf(novosaldo));

        }

    }

    public void cadastrarContasPoupança() {
        try {

            String Titular;
            int cliente = 0;
            double saldo = 0, novosaldo = 0, variação, limite;
            cliente = (int) cmbTitular.getSelectedItem();
            saldo = Double.parseDouble(txtSaldo.getText());
            Titular = jtxtNIF.getText();
            if (saldo < 100000) {
                JOptionPane.showMessageDialog(null, "Erro, Valor a depositar insuficiente");
                txtSaldo.setText("");
            } else {

                if (saldo > 100000 && saldo < 600000) {

                }
                variação = Double.parseDouble(txtVariação.getText());
                limite = Double.parseDouble(txtLimite.getText());
                ContaPoupançaDTO cndto = new ContaPoupançaDTO();
                cndto.setCliente(cliente);
                cndto.setTitular(Titular);
                cndto.setSaldo(novosaldo);
                cndto.setLimite(limite);
                cndto.setVariação(variação);
                ContaPoupançaDAO cndoa = new ContaPoupançaDAO();
                cndoa.criarConta(cndto);
                JOptionPane.showMessageDialog(null, "Conta criada com sucesso!!");
                txtSaldo.setText("");
                jtxtNIF.setText("");
                txtLimite.setText("");
                txtSaldo.setText("");
                txtVariação.setText("");
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Erro no formulario de contas poupança, cadastrar Contas" + e);
            txtSaldo.setText("");
            jtxtNIF.setText("");
            txtLimite.setText("");
            txtSaldo.setText("");
            txtVariação.setText("");
            cmbTitular.setSelectedIndex(0);
        }

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel4 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtSaldo = new javax.swing.JTextField();
        jButton2 = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jtxtNIF = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        cmbTitular = new javax.swing.JComboBox();
        jLabel6 = new javax.swing.JLabel();
        txtVariação = new javax.swing.JTextField();
        txtLimite = new javax.swing.JTextField();
        jButton3 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                formMouseMoved(evt);
            }
        });
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel4.setFont(new java.awt.Font("Garamond", 1, 24)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(204, 204, 0));
        jLabel4.setText("Valor Inicial:");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 240, -1, -1));

        jLabel3.setFont(new java.awt.Font("Garamond", 1, 24)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(204, 204, 0));
        jLabel3.setText("Numero de Cliente:");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 140, -1, -1));

        txtSaldo.setFont(new java.awt.Font("Garamond", 1, 24)); // NOI18N
        getContentPane().add(txtSaldo, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 240, 593, -1));

        jButton2.setBackground(new java.awt.Color(255, 255, 255));
        jButton2.setFont(new java.awt.Font("Garamond", 1, 24)); // NOI18N
        jButton2.setForeground(new java.awt.Color(102, 102, 0));
        jButton2.setText("Continuar");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(940, 490, -1, -1));

        jButton1.setBackground(new java.awt.Color(255, 255, 255));
        jButton1.setFont(new java.awt.Font("Garamond", 1, 24)); // NOI18N
        jButton1.setForeground(new java.awt.Color(102, 102, 0));
        jButton1.setText("Voltar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 480, -1, -1));

        jLabel2.setFont(new java.awt.Font("Garamond", 1, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(204, 204, 0));
        jLabel2.setText("Nome do titular:");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 190, -1, -1));

        jLabel1.setFont(new java.awt.Font("Garamond", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(204, 204, 0));
        jLabel1.setText("Introduza os dados da Conta");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(375, 52, -1, -1));

        jtxtNIF.setEditable(false);
        jtxtNIF.setFont(new java.awt.Font("Garamond", 1, 24)); // NOI18N
        getContentPane().add(jtxtNIF, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 190, 593, -1));

        jLabel5.setFont(new java.awt.Font("Garamond", 1, 24)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(204, 204, 0));
        jLabel5.setText("Variação:");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 290, -1, -1));

        cmbTitular.setFont(new java.awt.Font("Garamond", 1, 24)); // NOI18N
        cmbTitular.setForeground(new java.awt.Color(102, 102, 0));
        cmbTitular.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Selecione" }));
        getContentPane().add(cmbTitular, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 140, 593, -1));

        jLabel6.setFont(new java.awt.Font("Garamond", 1, 24)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(204, 204, 0));
        jLabel6.setText("Limite:");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 350, -1, -1));

        txtVariação.setFont(new java.awt.Font("Garamond", 1, 24)); // NOI18N
        getContentPane().add(txtVariação, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 290, 590, -1));

        txtLimite.setFont(new java.awt.Font("Garamond", 1, 24)); // NOI18N
        getContentPane().add(txtLimite, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 340, 590, -1));

        jButton3.setBackground(new java.awt.Color(255, 255, 255));
        jButton3.setFont(new java.awt.Font("Garamond", 1, 24)); // NOI18N
        jButton3.setForeground(new java.awt.Color(102, 102, 0));
        jButton3.setText("Verificar ");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 470, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        cadastrarContasPoupança();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        new TelaPrincipal().setVisible(true);
        this.dispose();// TODO add your handling code here:
    }//GEN-LAST:event_jButton1ActionPerformed

    private void formMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseMoved
        mostrarTitular();
        // TODO add your handling code here:
    }//GEN-LAST:event_formMouseMoved

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
Verificar();        // TODO add your handling code here:
    }//GEN-LAST:event_jButton3ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
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
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(ContaPoupança.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ContaPoupança.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ContaPoupança.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ContaPoupança.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ContaPoupança().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox cmbTitular;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JTextField jtxtNIF;
    private javax.swing.JTextField txtLimite;
    private javax.swing.JTextField txtSaldo;
    private javax.swing.JTextField txtVariação;
    // End of variables declaration//GEN-END:variables
}
