import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class JanelaPrincipal extends JFrame {
    public JanelaPrincipal() {
        setTitle("Sistema Bancário");
        setSize(400, 300);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(null);

        JButton btnCliente = new JButton("Cadastrar Cliente");
        btnCliente.setBounds(100, 30, 200, 30);
        btnCliente.addActionListener(e -> new JanelaCadastroCliente());

        JButton btnConta = new JButton("Cadastrar Conta");
        btnConta.setBounds(100, 70, 200, 30);

        JButton btnOperacoes = new JButton("Operações Bancárias");
        btnOperacoes.setBounds(100, 110, 200, 30);

        JButton btnSair = new JButton("Sair");
        btnSair.setBounds(100, 150, 200, 30);
        btnSair.addActionListener(e -> System.exit(0));

        add(btnCliente);
        add(btnConta);
        add(btnOperacoes);
        add(btnSair);

        setVisible(true);
    }

    public static void main(String[] args) {
        new JanelaPrincipal();
    }
}