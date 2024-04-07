/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistemabancario;

import DTO.Aglomerado;
import java.awt.HeadlessException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Random;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 */
public class criarContaPoupanca extends javax.swing.JFrame {


    public void CadastroClientes() {
        initComponents();
        GerarIban();
        
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
    public void variacao()
    {
        double saldo = Integer.parseInt(txtSaldo.getText());
        
        if(saldo<100000)
        {
            textVariacao.setText("Valor insuficiente");
        }
        else if(saldo>=100000&&saldo<=600000)
        {
            textVariacao.setText("5%");
        }
        else if(saldo>600000&&saldo<=1200000)
        {
            textVariacao.setText("10%");
        }
        else if(saldo>1300000&saldo<=1800000)
        {
            textVariacao.setText("15%");
        }
        else if(saldo>1900000&&saldo<=2400000)
        {
            textVariacao.setText("20%");
        }
        else if(saldo>2500000&&saldo<=3000000)
        {
            textVariacao.setText("25%");
        }
        else if(saldo>3100000&&saldo<=3600000)
        {
            textVariacao.setText("30%");
        }
        else if(saldo>3700000&&saldo<=4200000)
        {
            textVariacao.setText("35%");
        }
        else if(saldo>4300000&&saldo<=4800000)
        {
            textVariacao.setText("40%");
        }
        else if(saldo>4900000&&saldo<=5400000)
        {
            textVariacao.setText("45%");
        }
        else if(saldo>5500000&&saldo<=6000000)
        {
            textVariacao.setText("50%");
        }
        else if(saldo>6100000&&saldo<=6500000)
        {
            textVariacao.setText("55%");
        }
        else if(saldo>6600000&&saldo<=7100000)
        {
            textVariacao.setText("60%");
        }
        else if(saldo>7200000&&saldo<=7700000)
        {
            textVariacao.setText("65%");
        }
        else if(saldo>7800000&&saldo<=8300000)
        {
            textVariacao.setText("70%");
        }
        else if(saldo>8400000&&saldo<=8900000)
        {
            textVariacao.setText("75%");
        }
        else if(saldo>9000000&&saldo<=9500000)
        {
            textVariacao.setText("80%");
        }
        else if(saldo>9500000)
        {
            textVariacao.setText("85%");
        }
        else
            textVariacao.setText("");
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jDialog1 = new javax.swing.JDialog();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel2 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
        jLabel6 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel1 = new javax.swing.JLabel();
        textTelefone = new java.awt.TextField();
        textEndereco = new java.awt.TextField();
        textNome = new java.awt.TextField();
        textNif = new java.awt.TextField();
        jcmbMes = new javax.swing.JComboBox();
        jcmbAno = new javax.swing.JComboBox();
        jcmbdia = new javax.swing.JComboBox();
        jButton1 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        txt_email = new java.awt.TextField();
        jLabel9 = new javax.swing.JLabel();
        jcmbSexo = new javax.swing.JComboBox();
        txtSaldo = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        txtiban = new javax.swing.JTextField();
        textVariacao = new java.awt.TextField();
        jLabel11 = new javax.swing.JLabel();

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

        jTabbedPane1.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jTabbedPane1.setFont(new java.awt.Font("Garamond", 1, 18)); // NOI18N
        jTabbedPane1.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                jTabbedPane1MouseMoved(evt);
            }
        });

        jPanel2.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                jPanel2MouseMoved(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1267, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 600, Short.MAX_VALUE)
        );

        jTabbedPane1.addTab("", jPanel2);

        jPanel1.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                jPanel1MouseMoved(evt);
            }
        });
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel3.setFont(new java.awt.Font("Garamond", 1, 24)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(204, 204, 0));
        jLabel3.setText("Data de Nascimento:");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 440, -1, -1));

        jLabel7.setFont(new java.awt.Font("Garamond", 1, 24)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(204, 204, 0));
        jLabel7.setText("Endereço:");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 110, -1, 20));

        jLabel5.setFont(new java.awt.Font("Garamond", 1, 24)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(204, 204, 0));
        jLabel5.setText("CADASTRAMENTO");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 20, -1, -1));

        jLabel8.setFont(new java.awt.Font("Garamond", 1, 24)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(204, 204, 0));
        jLabel8.setText("Telefone:");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 150, -1, 20));

        jSeparator2.setOrientation(javax.swing.SwingConstants.VERTICAL);
        jPanel1.add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 251, -1, -1));

        jLabel6.setFont(new java.awt.Font("Garamond", 1, 24)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(204, 204, 0));
        jLabel6.setText("NIF:");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 230, -1, 20));

        jButton2.setFont(new java.awt.Font("Garamond", 1, 24)); // NOI18N
        jButton2.setForeground(new java.awt.Color(102, 102, 0));
        jButton2.setText("Voltar");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 550, -1, -1));

        jSeparator1.setOrientation(javax.swing.SwingConstants.VERTICAL);
        jPanel1.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 251, -1, -1));

        jLabel1.setFont(new java.awt.Font("Garamond", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(204, 204, 0));
        jLabel1.setText("Nome Completo:");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 70, -1, 20));

        textTelefone.setFont(new java.awt.Font("Garamond", 1, 18)); // NOI18N
        textTelefone.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textTelefoneActionPerformed(evt);
            }
        });
        jPanel1.add(textTelefone, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 150, 500, 20));

        textEndereco.setFont(new java.awt.Font("Garamond", 1, 18)); // NOI18N
        jPanel1.add(textEndereco, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 110, 500, 20));

        textNome.setFont(new java.awt.Font("Garamond", 1, 18)); // NOI18N
        jPanel1.add(textNome, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 70, 500, 20));

        textNif.setFont(new java.awt.Font("Garamond", 1, 18)); // NOI18N
        textNif.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textNifActionPerformed(evt);
            }
        });
        jPanel1.add(textNif, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 220, 500, 20));

        jcmbMes.setFont(new java.awt.Font("Garamond", 1, 24)); // NOI18N
        jcmbMes.setForeground(new java.awt.Color(102, 102, 0));
        jcmbMes.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Mês", "Janeiro", "Fevereiro", "Março", "Abril", "Maio", "Junho", "Julho", "Agosto", "Setembro", "Outubro", "Novembro", "Dezembro", " ", " " }));
        jPanel1.add(jcmbMes, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 440, 200, -1));

        jcmbAno.setFont(new java.awt.Font("Garamond", 1, 24)); // NOI18N
        jcmbAno.setForeground(new java.awt.Color(102, 102, 0));
        jcmbAno.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Ano", "2002", "2001", "2000", "1999", "1998", "1997", "1996", "1995", "1994", "1993", "1992", "1991", "1990", "1989", "1988", "1987", "1986", "1985", "1984", "1983", "1982", "1981", "1980", "1979", "1978", "1977", "1976", "1975", "1974", "1973", "1972", "1971", "1970", "1969", "1968", "1967", "1966", "1965", "1964", "1963", "1962", "1961", "1960", "1959", "1958", "1957", "1956", "1955", "1954", "1953", "1952", "1951", "1950", "1949", "1948", "1947", "1946", "1945", "1944", "1943", "1942", "1941", "1940", "1939", "1938", "1937", "1936", "1935", "1934", "1933", "1932", "1931", "1930", "1929", "1928", "1927", "1926" }));
        jPanel1.add(jcmbAno, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 440, 110, -1));

        jcmbdia.setFont(new java.awt.Font("Garamond", 1, 24)); // NOI18N
        jcmbdia.setForeground(new java.awt.Color(102, 102, 0));
        jcmbdia.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Dia", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31" }));
        jPanel1.add(jcmbdia, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 440, 110, -1));

        jButton1.setFont(new java.awt.Font("Garamond", 1, 24)); // NOI18N
        jButton1.setForeground(new java.awt.Color(102, 102, 0));
        jButton1.setText("Continuar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(940, 550, -1, -1));

        jLabel2.setFont(new java.awt.Font("Garamond", 1, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(204, 204, 0));
        jLabel2.setText("E-mail:");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 190, -1, 20));

        txt_email.setFont(new java.awt.Font("Garamond", 1, 18)); // NOI18N
        jPanel1.add(txt_email, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 190, 500, 20));

        jLabel9.setFont(new java.awt.Font("Garamond", 1, 24)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(204, 204, 0));
        jLabel9.setText("Sexo");
        jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 390, -1, -1));

        jcmbSexo.setFont(new java.awt.Font("Garamond", 0, 24)); // NOI18N
        jcmbSexo.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Femenino", "Masculino" }));
        jPanel1.add(jcmbSexo, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 390, 500, -1));

        txtSaldo.setFont(new java.awt.Font("Garamond", 0, 18)); // NOI18N
        jPanel1.add(txtSaldo, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 260, 500, -1));

        jLabel4.setFont(new java.awt.Font("Garamond", 1, 24)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(204, 204, 0));
        jLabel4.setText("Valor Inicial:");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 260, -1, -1));

        jLabel10.setFont(new java.awt.Font("Garamond", 1, 24)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(204, 204, 0));
        jLabel10.setText("Iban:");
        jPanel1.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 300, -1, -1));

        txtiban.setFont(new java.awt.Font("Garamond", 0, 18)); // NOI18N
        jPanel1.add(txtiban, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 300, 500, -1));

        textVariacao.setFont(new java.awt.Font("Garamond", 1, 18)); // NOI18N
        jPanel1.add(textVariacao, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 350, 500, 20));

        jLabel11.setFont(new java.awt.Font("Garamond", 1, 24)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(204, 204, 0));
        jLabel11.setText("Variação:");
        jPanel1.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 350, 130, 20));

        jTabbedPane1.addTab("Cadastramento de Clientes", jPanel1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTabbedPane1MouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTabbedPane1MouseMoved
        // TODO add your handling code here:
    }//GEN-LAST:event_jTabbedPane1MouseMoved

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        cadastrarClientes();

    }//GEN-LAST:event_jButton1ActionPerformed

    private void textNifActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textNifActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textNifActionPerformed

    private void textTelefoneActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textTelefoneActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textTelefoneActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        new TelaPrincipal().setVisible(true);
        this.dispose();            // TODO add your handling code here:
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jPanel2MouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel2MouseMoved
        // TODO add your handling code here:
    }//GEN-LAST:event_jPanel2MouseMoved

    private void jPanel1MouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel1MouseMoved
        // TODO add your handling code here:   variacao();
    }//GEN-LAST:event_jPanel1MouseMoved

    public void cadastrarClientes() {

        try {
            String email, sexo;
            int telefone;
            email = txt_email.getText();
            sexo = (String) jcmbSexo.getSelectedItem();
            telefone = Integer.parseInt(textTelefone.getText());
            if (textTelefone.getText().length() != 9) {
                JOptionPane.showMessageDialog(null, "Numero de Telefone Inválido, Digite Novamente");
                textTelefone.setText("");
            } else {
                if (telefone < 0) {
                    JOptionPane.showMessageDialog(null, "Numero de Telefone Inválido, Digite Novamente");
                    textTelefone.setText("");
                } else {
                    if (textNif.getText().length() != 14) {
                        JOptionPane.showMessageDialog(null, "NIF inválido, Digite Novamente");
                        textNif.setText("");
                    } else {
                        String dia, mes, ano;
                        dia = jcmbdia.getSelectedItem().toString();
                        mes = jcmbMes.getSelectedItem().toString();
                        ano = jcmbAno.getSelectedItem().toString();
                        int anoverif = Integer.parseInt(ano);
                        int idade;
                        idade = 2022 - anoverif;
                        if (idade < 18) {
                            JOptionPane.showMessageDialog(null, "Idade Inválida para criar Conta");
                        } else {
                            String data = dia + "/" + mes + "/" + ano;
                            Aglomerado d = new Aglomerado();
                            d.criarConta(textNome.getText(), textEndereco.getText(), textNif.getText(), data, txt_email.getText(), jcmbSexo.getName(), Integer.parseInt(txtSaldo.getText()), txtiban.getText(), 1, Integer.parseInt(textTelefone.getText()));
                            JOptionPane.showMessageDialog(null, "Conta criada com sucesso!!");
                            textEndereco.setText("");
                            textNif.setText("");
                            textNome.setText("");
                            textTelefone.setText("");
                            txt_email.setText("");

                        }
                    }
                }
            }
        } catch (NumberFormatException | HeadlessException e) {
            JOptionPane.showMessageDialog(null, "Cadastro formulario, cadastrar Cliente" + e);
            textEndereco.setText("");
            textNif.setText("");
            textNome.setText("");
            textTelefone.setText("");
            txt_email.setText("");
            jcmbSexo.setSelectedIndex(0);
        }

    }

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
            java.util.logging.Logger.getLogger(CadastroClientes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(criarContaPoupanca.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(criarContaPoupanca.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(criarContaPoupanca.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new criarContaPoupanca().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JDialog jDialog1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JComboBox jcmbAno;
    private javax.swing.JComboBox jcmbMes;
    private javax.swing.JComboBox jcmbSexo;
    private javax.swing.JComboBox jcmbdia;
    private java.awt.TextField textEndereco;
    private java.awt.TextField textNif;
    private java.awt.TextField textNome;
    private java.awt.TextField textTelefone;
    private java.awt.TextField textVariacao;
    private javax.swing.JTextField txtSaldo;
    private java.awt.TextField txt_email;
    private javax.swing.JTextField txtiban;
    // End of variables declaration//GEN-END:variables
}
