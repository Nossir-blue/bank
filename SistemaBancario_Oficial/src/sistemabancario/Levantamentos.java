/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistemabancario;

import DAO.ContaDao;
import DAO.DepositoDAO;
import DAO.LevantamentoDAO;
import DTO.ContaDTO;
import DTO.DepositoDTO;
import DTO.LevantamentoDTO;
import java.awt.HeadlessException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;
import javax.swing.JOptionPane;

/**
 *
 * @author Manuel Genásys
 */
public class Levantamentos extends javax.swing.JFrame {

    /**
     * Creates new form Levantamentos
     */
    public Levantamentos() {
        initComponents();
        listarContas();
    }
    Vector<String> Nome = new Vector<String>();
    Vector<Integer> NumeroCliente = new Vector<Integer>();
    public Vector<Double> SaldoActual = new Vector<Double>();

    public void mostrarTitular() {
        jtxtCliente.setText(String.valueOf(NumeroCliente.get(jcmbNumeroConta.getSelectedIndex() - 1)));
        jtxtTitular.setText(String.valueOf(Nome.get(jcmbNumeroConta.getSelectedIndex() - 1)));

    }

    public void listarContas() {
        try {
            LevantamentoDAO objlevaDao = new LevantamentoDAO();
            ResultSet rs = objlevaDao.listaCliente();
            while (rs.next()) {
                jcmbNumeroConta.addItem(rs.getInt(1));
                NumeroCliente.addElement(rs.getInt(2));
                Nome.addElement(rs.getString(3));
                SaldoActual.addElement(rs.getDouble(4));
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro no formulario do Levantamento Listar Contas" + e);
        }
    }

    public void levantar() {
        try {
            String dia, mes, ano;
            dia = jcmbdia.getSelectedItem().toString();
            mes = jcmbMes.getSelectedItem().toString();
            ano = jcmbAno.getSelectedItem().toString();
            String data = dia + "/" + mes + "/" + ano;
            String Nome;
            double Valor, valorantigo, novovalor;;
            int Numero_Conta;
            Nome = jtxtCliente.getText();
            Valor = Double.parseDouble(jtxtValor.getText());
            valorantigo = SaldoActual.get(jcmbNumeroConta.getSelectedIndex() - 1);
            if (Valor <= 0) {
                JOptionPane.showMessageDialog(null, "Impossivel realizar a operação");
                jtxtValor.setText("");
            } else {
                if (Valor > valorantigo) {
                    JOptionPane.showMessageDialog(null, "Impossivel realizar a operação");
                    jtxtValor.setText("");
                } else {
                    novovalor = valorantigo - Valor;
                    Numero_Conta = (int) jcmbNumeroConta.getSelectedItem();
                    LevantamentoDTO depdto = new LevantamentoDTO();
                    ContaDTO contadto = new ContaDTO();
                    depdto.setNumero_Conta(Numero_Conta);
                    depdto.setTitular(Nome);
                    depdto.setValor(Valor);
                    depdto.setData_Deposito(data);
                    LevantamentoDAO dpdao = new LevantamentoDAO();
                    contadto.setSaldo(novovalor);
                    contadto.setCliente(Integer.parseInt(jtxtCliente.getText()));
                    dpdao.novoSaldo(contadto);
                    dpdao.levantar(depdto);
                    JOptionPane.showMessageDialog(null, "Levantamento concluido");
                    jtxtCliente.setText("");
                    jtxtTitular.setText("");
                    jtxtValor.setText("");
                    jcmbNumeroConta.setSelectedIndex(0);

                }
            }
        } catch (HeadlessException | NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Erro no formulario Levantar " + e);
            jtxtCliente.setText("");
            jtxtTitular.setText("");
            jtxtValor.setText("");
            jcmbNumeroConta.setSelectedIndex(0);
        }
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
        jButton1 = new javax.swing.JButton();
        jtxtCliente = new javax.swing.JTextField();
        jcmbMes = new javax.swing.JComboBox();
        jLabel5 = new javax.swing.JLabel();
        jcmbNumeroConta = new javax.swing.JComboBox();
        jcmbdia = new javax.swing.JComboBox();
        jcmbAno = new javax.swing.JComboBox();
        jLabel7 = new javax.swing.JLabel();
        jtxtTitular = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                formMouseMoved(evt);
            }
        });
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Garamond", 1, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(204, 204, 0));
        jLabel1.setText("Introduza os dados do Levantamento");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 40, -1, -1));

        jLabel2.setFont(new java.awt.Font("Garamond", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(204, 204, 0));
        jLabel2.setText("Nome do titular:");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 170, -1, -1));

        jButton2.setFont(new java.awt.Font("Garamond", 1, 18)); // NOI18N
        jButton2.setForeground(new java.awt.Color(102, 102, 0));
        jButton2.setText("Continuar");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 390, -1, -1));

        jLabel4.setFont(new java.awt.Font("Garamond", 1, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(204, 204, 0));
        jLabel4.setText("Valor:");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 280, -1, -1));

        jLabel3.setFont(new java.awt.Font("Garamond", 1, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(204, 204, 0));
        jLabel3.setText("Número de Conta:");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 230, -1, -1));

        jtxtValor.setFont(new java.awt.Font("Garamond", 1, 18)); // NOI18N
        getContentPane().add(jtxtValor, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 280, 435, -1));

        jButton1.setFont(new java.awt.Font("Garamond", 1, 18)); // NOI18N
        jButton1.setForeground(new java.awt.Color(102, 102, 0));
        jButton1.setText("Voltar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 400, -1, -1));

        jtxtCliente.setEditable(false);
        jtxtCliente.setFont(new java.awt.Font("Garamond", 1, 18)); // NOI18N
        getContentPane().add(jtxtCliente, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 110, 435, -1));

        jcmbMes.setFont(new java.awt.Font("Garamond", 1, 18)); // NOI18N
        jcmbMes.setForeground(new java.awt.Color(102, 102, 0));
        jcmbMes.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Mês", "Janeiro ", "Fevereiro", "Março", "Abril", "Maio", "Junho", "Julho", "Agosto", "Setembro", "Outubro", "Novembro", "Dezembro" }));
        getContentPane().add(jcmbMes, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 340, 130, 30));

        jLabel5.setFont(new java.awt.Font("Garamond", 1, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(204, 204, 0));
        jLabel5.setText("Data de Levantamento:");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 340, -1, -1));

        jcmbNumeroConta.setFont(new java.awt.Font("Garamond", 1, 18)); // NOI18N
        jcmbNumeroConta.setForeground(new java.awt.Color(102, 102, 0));
        jcmbNumeroConta.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Selecione" }));
        getContentPane().add(jcmbNumeroConta, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 220, 435, -1));

        jcmbdia.setFont(new java.awt.Font("Garamond", 1, 18)); // NOI18N
        jcmbdia.setForeground(new java.awt.Color(102, 102, 0));
        jcmbdia.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Dia", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31", " " }));
        getContentPane().add(jcmbdia, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 340, 90, 30));

        jcmbAno.setFont(new java.awt.Font("Garamond", 1, 18)); // NOI18N
        jcmbAno.setForeground(new java.awt.Color(102, 102, 0));
        jcmbAno.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Ano", "2022" }));
        getContentPane().add(jcmbAno, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 340, 130, 30));

        jLabel7.setFont(new java.awt.Font("Garamond", 1, 18)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(204, 204, 0));
        jLabel7.setText("Número de Cliente:");
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 120, -1, -1));

        jtxtTitular.setEditable(false);
        jtxtTitular.setFont(new java.awt.Font("Garamond", 1, 18)); // NOI18N
        getContentPane().add(jtxtTitular, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 160, 435, -1));

        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/View/Fundo Projecto 1 .jpg.png"))); // NOI18N
        getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1100, 490));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        new TelaPrincipal().setVisible(true);
        this.dispose();        // TODO add your handling code here:

    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        levantar();
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton2ActionPerformed

    private void formMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseMoved
        mostrarTitular();
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
            java.util.logging.Logger.getLogger(Levantamentos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Levantamentos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Levantamentos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Levantamentos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Levantamentos().setVisible(true);
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
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JComboBox jcmbAno;
    private javax.swing.JComboBox jcmbMes;
    private javax.swing.JComboBox jcmbNumeroConta;
    private javax.swing.JComboBox jcmbdia;
    private javax.swing.JTextField jtxtCliente;
    private javax.swing.JTextField jtxtTitular;
    private javax.swing.JTextField jtxtValor;
    // End of variables declaration//GEN-END:variables
}
