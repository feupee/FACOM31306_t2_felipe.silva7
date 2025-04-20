package Telas.Cliente;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TelaInicialCliente extends JFrame {
    public TelaInicialCliente() {
        setTitle("Bem-vindo ao Banco");
        setSize(350, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Painel principal com layout vertical
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));

        // Painel para clientes existentes
        JPanel panelClientes = new JPanel();
        panelClientes.setLayout(new FlowLayout(FlowLayout.CENTER));
        panelClientes.add(new JLabel("Se for cliente: "));
        JButton btnClienteLogin = new JButton("Login");
        panelClientes.add(btnClienteLogin);

        // Painel para novos clientes
        JPanel panelNovosClientes = new JPanel();
        panelNovosClientes.setLayout(new FlowLayout(FlowLayout.CENTER));
        panelNovosClientes.add(new JLabel("Se não for cliente: "));
        JButton btnClienteCadastro = new JButton("Cadastrar");
        panelNovosClientes.add(btnClienteCadastro);

        // Adicionar os painéis ao painel principal
        mainPanel.add(Box.createVerticalStrut(25));
        mainPanel.add(panelClientes);
        mainPanel.add(panelNovosClientes);

        // Adicionar o painel principal à janela
        add(mainPanel);

        btnClienteCadastro.addActionListener(btnClienteCadastro());
        btnClienteLogin.addActionListener(btnClienteLogin());

        setVisible(true);
    }

    private ActionListener btnClienteCadastro() {
        return new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new TelaCadastroCliente();
            }
        };
    }

    private ActionListener btnClienteLogin() {
        return new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new TelaClienteLogin();
            }
        };
    }

}