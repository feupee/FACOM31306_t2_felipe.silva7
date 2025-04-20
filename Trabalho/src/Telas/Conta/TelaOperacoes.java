package Telas.Conta;

import javax.swing.*;
import java.awt.*;

class TelaOperacoes extends JFrame {
    public TelaOperacoes() {
        setTitle("Operações Bancárias");
        setSize(300, 250);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new GridLayout(4, 1, 10, 10));

        JButton btnSaque = new JButton("Saque");
        JButton btnDeposito = new JButton("Depósito");
        JButton btnPagamento = new JButton("Pagamento");
        JButton btnTransferencia = new JButton("Transferência");

        btnSaque.addActionListener(e -> JOptionPane.showMessageDialog(null, "Função de saque chamada."));
        btnDeposito.addActionListener(e -> JOptionPane.showMessageDialog(null, "Função de depósito chamada."));
        btnPagamento.addActionListener(e -> JOptionPane.showMessageDialog(null, "Função de pagamento chamada."));
        btnTransferencia.addActionListener(e -> JOptionPane.showMessageDialog(null, "Função de transferência chamada."));

        add(btnSaque);
        add(btnDeposito);
        add(btnPagamento);
        add(btnTransferencia);

        setVisible(true);
    }
}