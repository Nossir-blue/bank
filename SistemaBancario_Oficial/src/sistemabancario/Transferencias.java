/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistemabancario;

import DAO.ContaDao;
import DAO.DepositoDAO;
import DAO.TransferenciaDAO;
import DTO.ContaDTO;
import DTO.TransferenciaDTO;
import java.awt.HeadlessException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;
import javax.swing.JOptionPane;

/**
 *
 * @author Manuel Genásys
 */
public class Transferencias extends javax.swing.JFrame {

    /**
     * Creates new form Transferencias
     */
    public Transferencias() {
        initComponents();
        listarContas();
    }
    Vector<String> Nome = new Vector<String>();
    Vector<Integer> NumeroCliente = new Vector<Integer>();
    public Vector<Double> SaldoActual = new Vector<Double>();
    public Vector<String> VIban = new Vector<String>();

    public void mostrarTitular() {
        jtxtCliente.setText(String.valueOf(NumeroCliente.get(jcmbConta.getSelectedIndex() - 1)));
        jtxtTitular.setText(String.valueOf(Nome.get(jcmbConta.getSelectedIndex() - 1)));

    }

    public void listarContas() {
        try {
            TransferenciaDAO objlevaDao = new TransferenciaDAO();
            ResultSet rs = objlevaDao.listaCliente();
            while (rs.next()) {
                jcmbConta.addItem(rs.getInt(1));
                NumeroCliente.addElement(rs.getInt(2));
                Nome.addElement(rs.getString(3));
                SaldoActual.addElement(rs.getDouble(4));
                VIban.addElement(rs.getString(5));
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro no formulario do Deposito Listar Contas" + e);
        }
    }

    public void transferir() {
        try {
            String dia, mes, ano;
            dia = jcmbdia.getSelectedItem().toString();
            mes = jcmbMes.getSelectedItem().toString();
            ano = jcmbAno.getSelectedItem().toString();
            String data = dia + "/" + mes + "/" + ano;
            String Nomes, Iban;
            double Valor = 0, valorantigo, novovalor;
            int Numero_Conta;
            TransferenciaDTO depdto = new TransferenciaDTO();
            ContaDTO contadto = new ContaDTO();
            TransferenciaDAO dpdao = new TransferenciaDAO();
            Iban = (jtxtIban.getText());
            Nomes = jtxtTitular.getText();
            Valor = Double.parseDouble(jtxtValor.getText());
            /*for (int i = 0; i < VIban.capacity(); i++) {
             if (VIban.equals(i)) {
             int x = VIban.indexOf(jtxtIban);
             double valorant, valornovo;
             valorant = SaldoActual.get(x);
             valornovo = Valor + valorant;
             contadto.setIban(Iban);
             contadto.setSaldo(valornovo);
             dpdao.AumSaldo(contadto);
             }
             }*/
            valorantigo = SaldoActual.get(jcmbConta.getSelectedIndex() - 1);
            if (Valor <= 0) {
                JOptionPane.showMessageDialog(null, "Impossivel realizar a operação, Valor Introduzido Inválido");
            } else {
                if (Valor > valorantigo) {
                    JOptionPane.showMessageDialog(null, "Impossivel realizar a operação, Valor Introduzido Inválido");
                    jtxtValor.setText("");
                } else {
                    Numero_Conta = (int) jcmbConta.getSelectedItem();
                    novovalor = valorantigo - Valor;
                    depdto.setNumero_Conta(Numero_Conta);
                    depdto.setIban(Iban);
                    depdto.setTitular(Nomes);
                    depdto.setValor(Valor);
                    depdto.setData_Transferencia(data);
                    contadto.setSaldo(novovalor);
                    contadto.setCliente(Integer.parseInt(jtxtCliente.getText()));
                    dpdao.novoSaldo(contadto);
                    dpdao.transferir(depdto);
                    JOptionPane.showMessageDialog(null, "Transferencia concluida");
                    jtxtCliente.setText("");
                    jtxtIban.setText("");
                    jtxtTitular.setText("");
                    jtxtValor.setText("");
                    jcmbConta.setSelectedIndex(0);
                }
            }
        } catch (HeadlessException | NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Erro no formulario Levantar " + e);
            jtxtCliente.setText("");
            jtxtIban.setText("");
            jtxtTitular.setText("");
            jtxtValor.setText("");
            jcmbConta.setSelectedIndex(0);
        }
    }

    public void verIban() {
        String iban;
        iban = jtxtIban.getText();
        ContaDTO h = new ContaDTO();
        h.setIban(iban);
        ContaDao g = new ContaDao();

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jtxtValor = new javax.swing.JTextField();
        jtxtTitular = new javax.swing.JTextField();
        jcmbMes = new javax.swing.JComboBox();
        jLabel5 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        jcmbdia = new javax.swing.JComboBox();
        jcmbAno = new javax.swing.JComboBox();
        jcmbConta = new javax.swing.JComboBox();
        jLabel7 = new javax.swing.JLabel();
        jtxtCliente = new javax.swing.JTextField();
        jtxtIban = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                formMouseMoved(evt);
            }
        });
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Garamond", 1, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(153, 153, 0));
        jLabel1.setText("Introduza os dados da Transferência ");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 40, -1, -1));

        jLabel2.setFont(new java.awt.Font("Garamond", 1, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(153, 153, 0));
        jLabel2.setText("Nome do titular:");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 160, -1, -1));

        jButton2.setFont(new java.awt.Font("Garamond", 1, 24)); // NOI18N
        jButton2.setForeground(new java.awt.Color(153, 153, 0));
        jButton2.setText("Transferir");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 430, -1, -1));

        jLabel4.setFont(new java.awt.Font("Garamond", 1, 24)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(153, 153, 0));
        jLabel4.setText("Valor:");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 300, -1, -1));

        jLabel3.setFont(new java.awt.Font("Garamond", 1, 24)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(153, 153, 0));
        jLabel3.setText("Número de Conta:");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 210, -1, -1));

        jtxtValor.setFont(new java.awt.Font("Garamond", 1, 18)); // NOI18N
        getContentPane().add(jtxtValor, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 310, 440, -1));

        jtxtTitular.setEditable(false);
        jtxtTitular.setFont(new java.awt.Font("Garamond", 1, 18)); // NOI18N
        getContentPane().add(jtxtTitular, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 160, 440, -1));

        jcmbMes.setFont(new java.awt.Font("Garamond", 1, 18)); // NOI18N
        jcmbMes.setForeground(new java.awt.Color(102, 102, 0));
        jcmbMes.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Mês", "Janeiro ", "Fevereiro", "Março", "Abril", "Maio", "Junho", "Julho", "Agosto", "Setembro", "Outubro", "Novembro", "Dezembro" }));
        getContentPane().add(jcmbMes, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 360, 130, -1));

        jLabel5.setFont(new java.awt.Font("Garamond", 1, 24)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(153, 153, 0));
        jLabel5.setText("Data de Levantamento:");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 360, -1, -1));

        jButton1.setFont(new java.awt.Font("Garamond", 1, 24)); // NOI18N
        jButton1.setForeground(new java.awt.Color(153, 153, 0));
        jButton1.setText("Voltar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 440, -1, -1));

        jLabel6.setFont(new java.awt.Font("Garamond", 1, 24)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(153, 153, 0));
        jLabel6.setText("Iban do destinatário:");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 260, -1, -1));

        jcmbdia.setFont(new java.awt.Font("Garamond", 1, 18)); // NOI18N
        jcmbdia.setForeground(new java.awt.Color(102, 102, 0));
        jcmbdia.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Dia ", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31" }));
        getContentPane().add(jcmbdia, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 360, 120, -1));

        jcmbAno.setFont(new java.awt.Font("Garamond", 1, 18)); // NOI18N
        jcmbAno.setForeground(new java.awt.Color(102, 102, 0));
        jcmbAno.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Ano", "2022" }));
        getContentPane().add(jcmbAno, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 360, 120, -1));

        jcmbConta.setFont(new java.awt.Font("Garamond", 1, 18)); // NOI18N
        jcmbConta.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Selecione" }));
        getContentPane().add(jcmbConta, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 210, 440, -1));

        jLabel7.setFont(new java.awt.Font("Garamond", 1, 24)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(153, 153, 0));
        jLabel7.setText("Numero do Cliente:");
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 120, -1, -1));

        jtxtCliente.setEditable(false);
        jtxtCliente.setFont(new java.awt.Font("Garamond", 1, 18)); // NOI18N
        getContentPane().add(jtxtCliente, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 120, 440, -1));

        jtxtIban.setFont(new java.awt.Font("Garamond", 1, 18)); // NOI18N
        getContentPane().add(jtxtIban, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 260, 440, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        new TelaPrincipal().setVisible(true);
        this.dispose();        // TODO add your handling code here:

    }//GEN-LAST:event_jButton1ActionPerformed

    private void formMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseMoved
        mostrarTitular();
        // TODO add your handling code here:
    }//GEN-LAST:event_formMouseMoved

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        transferir();        // TODO add your handling code here:
    }//GEN-LAST:event_jButton2ActionPerformed

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
            java.util.logging.Logger.getLogger(Transferencias.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Transferencias.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Transferencias.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Transferencias.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Transferencias().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JComboBox jcmbAno;
    private javax.swing.JComboBox jcmbConta;
    private javax.swing.JComboBox jcmbMes;
    private javax.swing.JComboBox jcmbdia;
    private javax.swing.JTextField jtxtCliente;
    private javax.swing.JTextField jtxtIban;
    private javax.swing.JTextField jtxtTitular;
    private javax.swing.JTextField jtxtValor;
    // End of variables declaration//GEN-END:variables
}
