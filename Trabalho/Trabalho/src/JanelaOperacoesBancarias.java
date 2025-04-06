import javax.swing.*;
public class JanelaOperacoesBancarias extends JFrame {
    public JanelaOperacoesBancarias() {
        setTitle("Operações Bancárias");
        setSize(400, 250);
        setLocationRelativeTo(null);
        setLayout(null);

        JLabel lblConta = new JLabel("Conta:");
        lblConta.setBounds(20, 20, 100, 25);
        JTextField txtConta = new JTextField();
        txtConta.setBounds(120, 20, 200, 25);

        JLabel lblValor = new JLabel("Saldo:");
        lblValor.setBounds(20, 60, 100, 25);
        JTextField txtValor = new JTextField();
        txtValor.setBounds(120, 60, 200, 25);

        JButton btnDepositar = new JButton("Depositar");
        btnDepositar.setBounds(20, 110, 120, 30);
        btnDepositar.addActionListener(e -> {
            String numero = txtConta.getText();
            Conta conta = Conta.buscarPorNumero(numero); // supondo que esse metodo exista
            if (conta != null) {
                try {
                    double valor = Double.parseDouble(txtValor.getText());
                    conta.depositar(valor);
                    JOptionPane.showMessageDialog(null, "Depósito realizado! Novo saldo: " + conta.getSaldo());
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "Valor inválido.");
                }
            } else {
                JOptionPane.showMessageDialog(null, "Conta não encontrada.");
            }
        });


        JButton btnSacar = new JButton("Sacar");
        btnSacar.setBounds(150, 110, 120, 30);
        btnSacar.addActionListener(e -> {
            String numero = txtConta.getText();
            Conta conta = Conta.buscarPorNumero(numero); // metodo que busca a conta pelo número

            if (conta != null) {
                try {
                    double valor = Double.parseDouble(txtValor.getText());
                    boolean sucesso = conta.sacar(valor);
                    if (sucesso) {
                        JOptionPane.showMessageDialog(null, "Saque realizado! Novo saldo: " + conta.getSaldo());
                    } else {
                        JOptionPane.showMessageDialog(null, "Saldo insuficiente.");
                    }
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "Valor inválido.");
                }
            } else {
                JOptionPane.showMessageDialog(null, "Conta não encontrada.");
            }
        });


        JButton btnTransferir = new JButton("Efetuar pagamento");
        btnTransferir.setBounds(280, 110, 100, 30);
        btnTransferir.addActionListener(e -> {
            if (sacar(valor)) {
                destino.depositar(valor);
                return true;
            }
            return false;
        });

        add(lblConta);
        add(txtConta);
        add(lblValor);
        add(txtValor);
        add(btnDepositar);
        add(btnSacar);
        add(btnTransferir);

        setVisible(true);
    }
}