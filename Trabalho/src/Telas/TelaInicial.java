package Telas;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class TelaInicial extends JFrame {
    public TelaInicial() {
        setTitle("Bem-vindo ao Banco");
        setSize(350, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new FlowLayout());

        // Painel para clientes existentes
        JPanel panelClientes = new JPanel();
        panelClientes.setLayout(new FlowLayout());
        panelClientes.add(new JLabel("Se já for cliente: "));

        JButton btnCadastrar = new JButton("Cadastrar Conta");
        JButton btnLogin = new JButton("Login");

        // Painel para novos clientes
        JPanel panelNovosClientes = new JPanel();
        panelNovosClientes.setLayout(new FlowLayout());
        panelNovosClientes.add(new JLabel("Se não for cliente: "));

        JButton btnClienteCadastro = new JButton("Cadastrar Cliente");

        // Adicionando componentes
        panelClientes.add(btnCadastrar);
        panelClientes.add(btnLogin);
        panelNovosClientes.add(btnClienteCadastro);

        add(panelClientes);
        add(panelNovosClientes);

        // Configurando os listeners corretamente
        btnCadastrar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                abrirTelaCadastroConta();
            }
        });

        btnLogin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                abrirTelaLogin();
            }
        });

        btnClienteCadastro.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                abrirTelaCadastroCliente();
            }
        });

        setVisible(true);
    }

    private void abrirTelaCadastroConta() {
        new TelaCadastroConta();
        this.setVisible(false); // Esconde a tela atual sem fechar
    }

    private void abrirTelaLogin() {
        new TelaLogin();
        this.setVisible(false); // Esconde a tela atual sem fechar
    }

    private void abrirTelaCadastroCliente() {
        new TelaCadastroCliente();
        this.setVisible(false); // Esconde a tela atual sem fechar
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new TelaInicial();
            }
        });
    }
}