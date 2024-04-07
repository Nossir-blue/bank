/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistemabancario;

import DTO.ContaDTO;
import java.util.Vector;
import javax.swing.JOptionPane;
import java.util.Random;
import DTO.CadastroDTO;

public class Contas extends javax.swing.JFrame {
    
    public Contas() {
        initComponents();
        GerarIban();
    }
    
    Vector<Integer> id_Cliente = new Vector<Integer>();
    Vector<String> NIF = new Vector<String>();

 CadastroDTO cx = new CadastroDTO();
    public void mostrarnif() {
        jtxtNIF.setText(NIF.get(cmbTitular.getSelectedIndex() - 1));
    }

    public void GerarIban() {
        String Iban, x;
        int y;
        Random aleatoria = new Random();
        y = aleatoria.nextInt((999 - 100) + 1) + 100;
        x = "AO06000600009225592218";
        Iban = x + y;
        txtiban.setText(Iban);
        txtiban.setEditable(false);
        
    }

    public void cadastrarContas() {
        try {
            String Titular, Iban;
            int cliente = 0;
            double saldo = 0;
            cliente = id_Cliente.get(cmbTitular.getSelectedIndex() - 1);
            saldo = Double.parseDouble(txtSaldo.getText());
            Titular = (String) cmbTitular.getSelectedItem();
            Iban = txtiban.getText();
            if (saldo < 5000) {
                JOptionPane.showMessageDialog(null, "Erro, Valor a depositar insuficiente");
                txtSaldo.setText("");
            } else {
                ContaDTO cndto = new ContaDTO();
                cndto.criarConta(, Iban, ICONIFIED, Iban);
                JOptionPane.showMessageDialog(null, "Conta criada com sucesso!!");
                txtSaldo.setText("");
                txtiban.setText("");
                jtxtNIF.setText("");
                cmbTitular.setSelectedIndex(0);
            }

        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Erro no formulario de contas, cadastrar Contas" + e);
            txtSaldo.setText("");
            txtiban.setText("");
            jtxtNIF.setText("");
            cmbTitular.setSelectedIndex(0);
        }

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jDialog1 = new javax.swing.JDialog();
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
        jTabbedPane1 = new javax.swing.JTabbedPane();
        txtiban = new javax.swing.JTextField();

        javax.swing.GroupLayout jDialog1Layout = new javax.swing.GroupLayout(jDialog1.getContentPane());
        jDialog1.getContentPane().setLayout(jDialog1Layout);
        jDialog1Layout.setHorizontalGroup(
            jDialog1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        jDialog1Layout.setVerticalGroup(
            jDialog1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

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
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 270, -1, -1));

        jLabel3.setFont(new java.awt.Font("Garamond", 1, 24)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(204, 204, 0));
        jLabel3.setText("NIF:");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 220, -1, -1));

        txtSaldo.setFont(new java.awt.Font("Garamond", 0, 18)); // NOI18N
        getContentPane().add(txtSaldo, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 270, 593, -1));

        jButton2.setFont(new java.awt.Font("Garamond", 1, 24)); // NOI18N
        jButton2.setForeground(new java.awt.Color(102, 102, 0));
        jButton2.setText("Continuar");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 490, -1, -1));

        jButton1.setFont(new java.awt.Font("Garamond", 1, 24)); // NOI18N
        jButton1.setForeground(new java.awt.Color(102, 102, 0));
        jButton1.setText("Voltar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 490, -1, -1));

        jLabel2.setFont(new java.awt.Font("Garamond", 1, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(204, 204, 0));
        jLabel2.setText("Nome do titular:");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 180, -1, -1));

        jLabel1.setFont(new java.awt.Font("Garamond", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(204, 204, 0));
        jLabel1.setText("Introduza os dados da Conta");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 80, -1, -1));

        jtxtNIF.setEditable(false);
        jtxtNIF.setFont(new java.awt.Font("Garamond", 0, 18)); // NOI18N
        getContentPane().add(jtxtNIF, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 220, 593, -1));

        jLabel5.setFont(new java.awt.Font("Garamond", 1, 24)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(204, 204, 0));
        jLabel5.setText("Iban:");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 320, -1, -1));

        cmbTitular.setFont(new java.awt.Font("Garamond", 1, 18)); // NOI18N
        cmbTitular.setForeground(new java.awt.Color(102, 102, 0));
        cmbTitular.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Selecione" }));
        getContentPane().add(cmbTitular, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 180, 593, -1));
        getContentPane().add(jTabbedPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, -30, -1, -1));

        txtiban.setFont(new java.awt.Font("Garamond", 0, 18)); // NOI18N
        getContentPane().add(txtiban, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 320, 600, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        new TelaPrincipal().setVisible(true);
        this.dispose();// TODO add your handling code here:

    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        cadastrarContas();

    }//GEN-LAST:event_jButton2ActionPerformed

    private void formMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseMoved
        // TODO add your handling code here:
        mostrarnif();

    }//GEN-LAST:event_formMouseMoved

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
            java.util.logging.Logger.getLogger(Contas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Contas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Contas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Contas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Contas().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox cmbTitular;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JDialog jDialog1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTextField jtxtNIF;
    private javax.swing.JTextField txtSaldo;
    private javax.swing.JTextField txtiban;
    // End of variables declaration//GEN-END:variables
}
