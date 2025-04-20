package Telas.Cliente;

import Classes.Cliente;
import Classes.ContaBancaria;
import Persistencia.BancoDados;
import Telas.Conta.TelaInicialContaBancaria;

import javax.swing.*;
import java.awt.*;
import java.util.List;

// Tela 4: Tela de Login com nome da conta e senha
public class TelaClienteLogin extends JFrame {
    public TelaClienteLogin() {
        setTitle("Login da Conta");
        setSize(300, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new GridLayout(3, 2, 5, 5));

        add(new JLabel("Nome da Conta:"));
        JTextField txtNomeConta = new JTextField();
        add(txtNomeConta);

        add(new JLabel("Senha:"));
        JTextField txtSenha = new JTextField();
        add(txtSenha);

        JButton btnEntrar = new JButton("Entrar");
        btnEntrar.addActionListener(e -> {
            String nomeConta = txtNomeConta.getText();
            String CPF = new String(txtSenha.getText());

            if (verificarLogin(nomeConta, CPF)) {
                JOptionPane.showMessageDialog(null, "Login realizado com sucesso!");
                new TelaInicialContaBancaria();
                dispose();
            } else {
                JOptionPane.showMessageDialog(null, "Nome da conta ou senha incorretos.");
            }
        });
        add(btnEntrar);

        JButton btnVoltar = new JButton("Voltar");
        btnVoltar.addActionListener(e -> {
            new TelaInicialCliente();
            dispose();
        });
        add(btnVoltar);

        setVisible(true);

    }

    private boolean verificarLogin(String nomeCliente, String CPF) {
        List<Cliente> clientes = BancoDados.getTodosClientes();

        for (Cliente c : clientes) {
            // Verifica se o nome e CPF correspondem (ignorando maiúsculas/minúsculas e espaços)
            if (c.getNome().equalsIgnoreCase(nomeCliente.trim()) &&
                    c.getCPF().replaceAll("[^0-9]", "").equals(CPF.replaceAll("[^0-9]", ""))) {
                return true; // Login válido
            }
        }

        return false; // Nenhum cliente encontrado com esses dados
    }
}