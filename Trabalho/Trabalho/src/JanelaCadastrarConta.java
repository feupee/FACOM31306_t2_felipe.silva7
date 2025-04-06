import javax.swing.*;

public class JanelaCadastroConta extends JFrame {
    public JanelaCadastroConta() {
        setTitle("Cadastrar Conta");
        setSize(350, 200);
        setLocationRelativeTo(null);
        setLayout(null);

        JLabel lblCPF = new JLabel("CPF Cliente:");
        lblCPF.setBounds(20, 20, 100, 25);
        JTextField txtCPF = new JTextField();
        txtCPF.setBounds(120, 20, 200, 25);

        JLabel lblNumero = new JLabel("Número Conta:");
        lblNumero.setBounds(20, 60, 100, 25);
        JTextField txtNumero = new JTextField();
        txtNumero.setBounds(120, 60, 200, 25);

        JButton btnCriar = new JButton("Criar");
        btnCriar.setBounds(120, 100, 100, 30);

        btnCriar.addActionListener(e -> {
            Cliente cliente = Cliente.buscarPorCPF(txtCPF.getText());
            if (cliente != null) {
                Conta conta = new Conta(txtNumero.getText());
                // você pode adaptar com associação à classe Cliente se necessário
                JOptionPane.showMessageDialog(null, "Conta criada!");
            } else {
                JOptionPane.showMessageDialog(null, "Cliente não encontrado!");
            }
        });

        add(lblCPF); add(txtCPF);
        add(lblNumero); add(txtNumero);
        add(btnCriar);

        setVisible(true);
    }
}
