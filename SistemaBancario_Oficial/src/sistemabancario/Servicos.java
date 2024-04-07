/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistemabancario;

import DAO.PagamentoDAO;
import DTO.ContaDTO;
import DTO.PagamentoDTO;
import java.awt.HeadlessException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;
import javax.swing.JOptionPane;

/**
 *
 * @author Manuel Genásys
 */
public class Servicos extends javax.swing.JFrame {

    /**
     * Creates new form Servicos
     */
    public Servicos() {
        initComponents();
        listarTipoServico();
        listarContas();
    }
    Vector<Integer> id_servico = new Vector<Integer>();
    Vector<String> Nome = new Vector<String>();
    Vector<Integer> NumeroCliente = new Vector<Integer>();
    public Vector<Double> SaldoActual = new Vector<Double>();

    public void listarTipoServico() {
        try {
            PagamentoDAO objpagaDao = new PagamentoDAO();
            ResultSet rs = objpagaDao.listaTipo();
            while (rs.next()) {
                id_servico.addElement(rs.getInt(1));
                jcmbServico.addItem(rs.getString(2));
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro no formularioServiços listar servicos" + e);
        }

    }

    public void mostrarTitular() {
        jtxtCliente.setText(String.valueOf(NumeroCliente.get(jcmbConta.getSelectedIndex() - 1)));
        jtxtTitular.setText(String.valueOf(Nome.get(jcmbConta.getSelectedIndex() - 1)));

    }

    public void listarContas() {
        try {
            PagamentoDAO objlevaDao = new PagamentoDAO();
            ResultSet rs = objlevaDao.listaContas();
            while (rs.next()) {
                jcmbConta.addItem(rs.getInt(1));
                NumeroCliente.addElement(rs.getInt(2));
                Nome.addElement(rs.getString(3));
                SaldoActual.addElement(rs.getDouble(4));
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro no formulario do Serviços Listar Contas" + e);
        }
    }

    public void pagar() {
        try {
            String dia, mes, ano;
            dia = jcmbdia.getSelectedItem().toString();
            mes = jcmbMes.getSelectedItem().toString();
            ano = jcmbAno.getSelectedItem().toString();
            String data = dia + "/" + mes + "/" + ano;
            int Numero_conta, Serviço;
            double Rupe, Valor, valorantigo, novovalor;
            Serviço = id_servico.get(jcmbServico.getSelectedIndex() - 1);
            Numero_conta = (int) jcmbConta.getSelectedItem();
            Valor = Double.parseDouble(jtxtValor.getText());
            valorantigo = SaldoActual.get(jcmbConta.getSelectedIndex() - 1);
            if (Valor <= 0) {
                JOptionPane.showMessageDialog(null, "Impossivel realizar a operação");
                jtxtValor.setText("");

            } else {
                if (Valor > valorantigo) {
                    JOptionPane.showMessageDialog(null, "Impossivel realizar a operação");
                    jtxtValor.setText("");
                } else {
                    novovalor = valorantigo - Valor;
                    String titular = jtxtTitular.getText();
                    Rupe = Double.parseDouble(jtxtRupe.getText());
                    PagamentoDTO pagadto = new PagamentoDTO();
                    ContaDTO contadto = new ContaDTO();
                    pagadto.setNumero_conta(Numero_conta);
                    pagadto.setTitular(titular);
                    pagadto.setValor(Valor);
                    pagadto.setData_Pagamento(data);
                    pagadto.setRupe(Rupe);
                    pagadto.setServiço(Serviço);
                    PagamentoDAO pagadao = new PagamentoDAO();
                    contadto.setSaldo(novovalor);
                    contadto.setCliente(Integer.parseInt(jtxtCliente.getText()));
                    pagadao.novoSaldo(contadto);
                    pagadao.pagar(pagadto);
                    JOptionPane.showMessageDialog(null, "Pagamento concluido");
                    jtxtCliente.setText("");
                    jcmbConta.setSelectedIndex(0);
                    jcmbServico.setSelectedIndex(0);
                    jcmbConta.setSelectedIndex(0);
                    jtxtRupe.setText("");
                    jtxtTitular.setText("");
                    jtxtValor.setText("");
                }
            }

        } catch (HeadlessException | NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Erro no formulario" + e);
            jtxtCliente.setText("");
            jcmbConta.setSelectedIndex(0);
            jcmbServico.setSelectedIndex(0);
            jcmbConta.setSelectedIndex(0);
            jtxtRupe.setText("");
            jtxtTitular.setText("");
            jtxtValor.setText("");
        }

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jButton3 = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jtxtValor = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jButton5 = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        jtxtRupe = new javax.swing.JTextField();
        jcmbServico = new javax.swing.JComboBox();
        jcmbConta = new javax.swing.JComboBox();
        jcmbdia = new javax.swing.JComboBox();
        jcmbMes = new javax.swing.JComboBox();
        jcmbAno = new javax.swing.JComboBox();
        Titular = new javax.swing.JLabel();
        jtxtTitular = new javax.swing.JTextField();
        Titular1 = new javax.swing.JLabel();
        jtxtCliente = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                formMouseMoved(evt);
            }
        });
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Garamond", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(204, 204, 0));
        jLabel1.setText("Introduza os dados do Pagamento");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 60, -1, -1));

        jLabel2.setFont(new java.awt.Font("Garamond", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(204, 204, 0));
        jLabel2.setText("Tipo de Serviço");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 250, -1, -1));

        jButton3.setFont(new java.awt.Font("Garamond", 1, 18)); // NOI18N
        jButton3.setForeground(new java.awt.Color(102, 102, 0));
        jButton3.setText("Continuar");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 400, -1, -1));

        jLabel4.setFont(new java.awt.Font("Garamond", 1, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(204, 204, 0));
        jLabel4.setText("Valor:");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 280, -1, -1));

        jLabel3.setFont(new java.awt.Font("Garamond", 1, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(204, 204, 0));
        jLabel3.setText("Número de Conta:");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 200, -1, -1));

        jtxtValor.setFont(new java.awt.Font("Garamond", 1, 18)); // NOI18N
        jtxtValor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtxtValorActionPerformed(evt);
            }
        });
        getContentPane().add(jtxtValor, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 280, 430, -1));

        jLabel5.setFont(new java.awt.Font("Garamond", 1, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(204, 204, 0));
        jLabel5.setText("Data de Levantamento:");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 360, -1, -1));

        jButton5.setFont(new java.awt.Font("Garamond", 1, 18)); // NOI18N
        jButton5.setForeground(new java.awt.Color(102, 102, 0));
        jButton5.setText("Voltar");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton5, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 400, -1, -1));

        jLabel6.setFont(new java.awt.Font("Garamond", 1, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(204, 204, 0));
        jLabel6.setText("RUPE");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 320, -1, -1));

        jtxtRupe.setFont(new java.awt.Font("Garamond", 1, 18)); // NOI18N
        getContentPane().add(jtxtRupe, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 320, 430, -1));

        jcmbServico.setFont(new java.awt.Font("Garamond", 1, 18)); // NOI18N
        jcmbServico.setForeground(new java.awt.Color(102, 102, 0));
        jcmbServico.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Selecione" }));
        getContentPane().add(jcmbServico, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 240, 430, -1));

        jcmbConta.setFont(new java.awt.Font("Garamond", 1, 18)); // NOI18N
        jcmbConta.setForeground(new java.awt.Color(102, 102, 0));
        jcmbConta.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Selecione" }));
        getContentPane().add(jcmbConta, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 190, 430, -1));

        jcmbdia.setFont(new java.awt.Font("Garamond", 1, 18)); // NOI18N
        jcmbdia.setForeground(new java.awt.Color(102, 102, 0));
        jcmbdia.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Dia", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31", " " }));
        getContentPane().add(jcmbdia, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 360, 89, -1));

        jcmbMes.setFont(new java.awt.Font("Garamond", 1, 18)); // NOI18N
        jcmbMes.setForeground(new java.awt.Color(102, 102, 0));
        jcmbMes.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Mês", "Janeiro ", "Fevereiro", "Março", "Abril", "Maio", "Junho", "Julho", "Agosto", "Setembro", "Outubro", "Novembro", "Dezembro" }));
        getContentPane().add(jcmbMes, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 360, 120, -1));

        jcmbAno.setFont(new java.awt.Font("Garamond", 1, 18)); // NOI18N
        jcmbAno.setForeground(new java.awt.Color(102, 102, 0));
        jcmbAno.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Ano", "2022", " " }));
        getContentPane().add(jcmbAno, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 360, 106, -1));

        Titular.setFont(new java.awt.Font("Garamond", 1, 18)); // NOI18N
        Titular.setForeground(new java.awt.Color(204, 204, 0));
        Titular.setText("Titular:");
        getContentPane().add(Titular, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 150, -1, -1));

        jtxtTitular.setEditable(false);
        jtxtTitular.setFont(new java.awt.Font("Garamond", 1, 18)); // NOI18N
        jtxtTitular.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtxtTitularActionPerformed(evt);
            }
        });
        getContentPane().add(jtxtTitular, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 150, 430, -1));

        Titular1.setFont(new java.awt.Font("Garamond", 1, 18)); // NOI18N
        Titular1.setForeground(new java.awt.Color(204, 204, 0));
        Titular1.setText("Numero de Cliente:");
        getContentPane().add(Titular1, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 110, -1, 20));

        jtxtCliente.setEditable(false);
        jtxtCliente.setFont(new java.awt.Font("Garamond", 1, 18)); // NOI18N
        jtxtCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtxtClienteActionPerformed(evt);
            }
        });
        getContentPane().add(jtxtCliente, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 110, 430, 30));

        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/View/Fundo Projecto 1 .jpg.png"))); // NOI18N
        getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1090, 500));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        new TelaPrincipal().setVisible(true);
        this.dispose();        // TODO add your handling code here:

    }//GEN-LAST:event_jButton5ActionPerformed

    private void formMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseMoved
        mostrarTitular();
        // TODO add your handling code here:
    }//GEN-LAST:event_formMouseMoved

    private void jtxtValorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtxtValorActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtxtValorActionPerformed

    private void jtxtTitularActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtxtTitularActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtxtTitularActionPerformed

    private void jtxtClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtxtClienteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtxtClienteActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        pagar();        // TODO add your handling code here:
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
            java.util.logging.Logger.getLogger(Servicos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Servicos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Servicos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Servicos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Servicos().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Titular;
    private javax.swing.JLabel Titular1;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton5;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JComboBox jcmbAno;
    private javax.swing.JComboBox jcmbConta;
    private javax.swing.JComboBox jcmbMes;
    private javax.swing.JComboBox jcmbServico;
    private javax.swing.JComboBox jcmbdia;
    private javax.swing.JTextField jtxtCliente;
    private javax.swing.JTextField jtxtRupe;
    private javax.swing.JTextField jtxtTitular;
    private javax.swing.JTextField jtxtValor;
    // End of variables declaration//GEN-END:variables
}
