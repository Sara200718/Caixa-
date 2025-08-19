package sara;

import javax.swing.JOptionPane;

public class NewJFrame extends javax.swing.JFrame {

    private double saldo = 1000;

    public NewJFrame() {
        initComponents();
        lblSaldo.setText("Saldo atual: R$ " + saldo); // mostra o saldo inicial
    }

    // Botão Consultar Saldo
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {                                         
        lblSaldo.setText("Saldo atual: R$ " + saldo);
    }                                        

    // Botão Depositar
    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {                                         
        String valor = JOptionPane.showInputDialog("Digite o valor do depósito:");
        if (valor != null) {
            try {
                double deposito = Double.parseDouble(valor);
                if (deposito > 0) {
                    saldo += deposito;
                    lblSaldo.setText("Depósito realizado! Saldo: R$ " + saldo);
                } else {
                    JOptionPane.showMessageDialog(this, "Digite um valor positivo!");
                }
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "Valor inválido!");
            }
        }
    }                                        

    // Botão Saque
    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {                                         
        String valor = JOptionPane.showInputDialog("Digite o valor do saque:");
        if (valor != null) {
            try {
                double saque = Double.parseDouble(valor);
                if (saque > 0) {
                    if (saque <= saldo) {
                        saldo -= saque;
                        lblSaldo.setText("Saque realizado! Saldo: R$ " + saldo);
                    } else {
                        JOptionPane.showMessageDialog(this, "Saldo insuficiente!");
                    }
                } else {
                    JOptionPane.showMessageDialog(this, "Digite um valor positivo!");
                }
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "Valor inválido!");
            }
        }
    }                                        

    // Botão Sair
    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {                                         
        System.exit(0);
    }                                        

    // Variables declaration (adicione no Design do NetBeans)
    private javax.swing.JLabel lblSaldo;
    private javax.swing.JButton jButton1; // Consultar saldo
    private javax.swing.JButton jButton2; // Depositar
    private javax.swing.JButton jButton3; // Sacar
    private javax.swing.JButton jButton4; // Sair
    // End of variables declaration                   
}