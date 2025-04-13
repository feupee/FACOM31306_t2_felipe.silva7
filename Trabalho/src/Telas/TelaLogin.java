package Telas;

import Persistencia.BancoDados;

import javax.swing.*;
import java.awt.*;

// Tela 4: Tela de Login com nome da conta e senha
class TelaLogin extends JFrame {
    public TelaLogin() {
        setTitle("Login da Conta");
        setSize(300, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new GridLayout(3, 2, 5, 5));

        add(new JLabel("Nome da Conta:"));
        JTextField txtNomeConta = new JTextField();
        add(txtNomeConta);

        add(new JLabel("Senha:"));
        JPasswordField txtSenha = new JPasswordField();
        add(txtSenha);

        JButton btnEntrar = new JButton("Entrar");
        btnEntrar.addActionListener(e -> {
            String nomeConta = txtNomeConta.getText();
            String senha = new String(txtSenha.getPassword());

            /*if (verificarLogin(nomeConta, senha)) {
                JOptionPane.showMessageDialog(null, "Login realizado com sucesso!");
                new Telas.TelaOperacoes();
                dispose();
            } else {
                JOptionPane.showMessageDialog(null, "Nome da conta ou senha incorretos.");
            }*/
        });
        add(btnEntrar);

        JButton btnVoltar = new JButton("Voltar");
        btnVoltar.addActionListener(e -> {
            new TelaInicial();
            dispose();
        });
        add(btnVoltar);

        setVisible(true);

    }

    /*private boolean verificarLogin(String nomeConta, String senha) {
        for (String[] conta : (BancoDados.getTodasContas())) {
            if (conta[0].equals(numeroConta) && conta[1].equals(senha)) {
                return true;
            }
        }
        return false;
    }*/
}