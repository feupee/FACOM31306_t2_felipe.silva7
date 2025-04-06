import javax.swing.*;

public class JanelaCadastroCliente extends JFrame {
    public JanelaCadastroCliente() {
        setTitle("Cadastrar Cliente");
        setSize(350, 250);
        setLocationRelativeTo(null);
        setLayout(null);

        JLabel lblNome = new JLabel("Nome:");
        lblNome.setBounds(20, 20, 100, 25);
        JTextField txtNome = new JTextField();
        txtNome.setBounds(100, 20, 200, 25);

        JLabel lblCPF = new JLabel("CPF:");
        lblCPF.setBounds(20, 60, 100, 25);
        JTextField txtCPF = new JTextField();
        txtCPF.setBounds(100, 60, 200, 25);

        JButton btnSalvar = new JButton("Salvar");
        btnSalvar.setBounds(100, 120, 100, 30);

        btnSalvar.addActionListener(e -> {
            String nome = txtNome.getText();
            String cpf = txtCPF.getText();

            JOptionPane.showMessageDialog(null, "Cliente " + nome + " cadastrado!");
            dispose();
        });

        add(lblNome);
        add(txtNome);
        add(lblCPF);
        add(txtCPF);
        add(btnSalvar);

        setVisible(true);
    }
}