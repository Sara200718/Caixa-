package introducao;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BancoGUI extends JFrame {
    private double saldo = 1000; // saldo inicial
    private JLabel lblSaldo;

    public BancoGUI() {
        // Configuração da janela
        setTitle("Banco - Menu");
        setSize(300, 200);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new GridLayout(5, 1, 10, 10));

        // Label para mostrar saldo
        lblSaldo = new JLabel("Saldo atual: R$ " + saldo);
        lblSaldo.setHorizontalAlignment(SwingConstants.CENTER);

        // Botões
        JButton btnSaldo = new JButton("Consultar Saldo");
        JButton btnDeposito = new JButton("Depositar (%)");
        JButton btnSaque = new JButton("Sacar (%)");
        JButton btnSair = new JButton("Sair");

        // Ações dos botões
        btnSaldo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                lblSaldo.setText("Saldo atual: R$ " + saldo);
            }
        });

        btnDeposito.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String valor = JOptionPane.showInputDialog("Digite o percentual de depósito:");
                if (valor != null) {
                    try {
                        double perc = Double.parseDouble(valor);
                        double deposito = saldo * (perc / 100);
                        saldo += deposito;
                        lblSaldo.setText("Depósito realizado! Saldo: R$ " + saldo);
                    } catch (NumberFormatException ex) {
                        JOptionPane.showMessageDialog(null, "Valor inválido!");
                    }
                }
            }
        });

        btnSaque.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String valor = JOptionPane.showInputDialog("Digite o percentual de saque:");
                if (valor != null) {
                    try {
                        double perc = Double.parseDouble(valor);
                        double saque = saldo * (perc / 100);
                        if (saque > saldo) {
                            JOptionPane.showMessageDialog(null, "Saldo insuficiente!");
                        } else {
                            saldo -= saque;
                            lblSaldo.setText("Saque realizado! Saldo: R$ " + saldo);
                        }
                    } catch (NumberFormatException ex) {
                        JOptionPane.showMessageDialog(null, "Valor inválido!");
                    }
                }
            }
        });

        btnSair.addActionListener(e -> System.exit(0));

        // Adicionando componentes na tela
        add(lblSaldo);
        add(btnSaldo);
        add(btnDeposito);
        add(btnSaque);
        add(btnSair);

        setVisible(true);
    }

    public static void main(String[] args) {
        new BancoGUI();
    }
}