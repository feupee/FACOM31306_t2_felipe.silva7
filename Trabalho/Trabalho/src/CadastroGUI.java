import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

public class CadastroGUI extends JFrame {

    private JTextField tfNumeroConta;
    private JTextField tfSaldoInicial;
    private JTextField tfLimiteChequeEspecial;
    private JTextField tfTaxaAdministrativa;
    private JTextField tfRendimentoMensal;
    private JTextField tfLimiteSaque;
    private JTextField tfLimiteTransferencia;
    private JComboBox<String> cbTipoConta;

    public CadastroGUI() {
        // Configurações do JFrame
        setTitle("Cadastro de Conta Bancária");
        setSize(400, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Layout do JFrame
        setLayout(new GridLayout(9, 2));

        // Adicionando os componentes
        JLabel lblTipoConta = new JLabel("Tipo de Conta:");
        cbTipoConta = new JComboBox<>(new String[]{"Conta Corrente", "Conta Poupança", "Conta Salário"});

        JLabel lblNumeroConta = new JLabel("Número da Conta:");
        tfNumeroConta = new JTextField();

        JLabel lblSaldoInicial = new JLabel("Saldo Inicial:");
        tfSaldoInicial = new JTextField();

        JLabel lblLimiteChequeEspecial = new JLabel("Limite Cheque Especial:");
        tfLimiteChequeEspecial = new JTextField();

        JLabel lblTaxaAdministrativa = new JLabel("Taxa Administrativa:");
        tfTaxaAdministrativa = new JTextField();

        JLabel lblRendimentoMensal = new JLabel("Rendimento Mensal:");
        tfRendimentoMensal = new JTextField();

        JLabel lblLimiteSaque = new JLabel("Limite de Saque:");
        tfLimiteSaque = new JTextField();

        JLabel lblLimiteTransferencia = new JLabel("Limite de Transferência:");
        tfLimiteTransferencia = new JTextField();

        JButton btnCadastrar = new JButton("Cadastrar");

        // Adicionando os componentes ao layout
        add(lblTipoConta);
        add(cbTipoConta);
        add(lblNumeroConta);
        add(tfNumeroConta);
        add(lblSaldoInicial);
        add(tfSaldoInicial);
        add(lblLimiteChequeEspecial);
        add(tfLimiteChequeEspecial);
        add(lblTaxaAdministrativa);
        add(tfTaxaAdministrativa);
        add(lblRendimentoMensal);
        add(tfRendimentoMensal);
        add(lblLimiteSaque);
        add(tfLimiteSaque);
        add(lblLimiteTransferencia);
        add(tfLimiteTransferencia);
        add(new JLabel());
        add(btnCadastrar);

        // Ação do botão "Cadastrar"
        btnCadastrar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cadastrarConta();
            }
        });
    }

    private void cadastrarConta() {
        try {
            String numeroConta = tfNumeroConta.getText();
            double saldoInicial = Double.parseDouble(tfSaldoInicial.getText());
            Date dataAbertura = new Date();  // Usando a data atual

            // Obter o tipo da conta selecionada
            String tipoConta = (String) cbTipoConta.getSelectedItem();

            // Criar a conta conforme o tipo selecionado
            ContaBancaria contaBancaria = null;
            if (tipoConta.equals("Conta Corrente")) {
                double limiteChequeEspecial = Double.parseDouble(tfLimiteChequeEspecial.getText());
                double taxaAdministrativa = Double.parseDouble(tfTaxaAdministrativa.getText());
                contaBancaria = new ContaCorrente(numeroConta, saldoInicial, dataAbertura, limiteChequeEspecial, taxaAdministrativa, "CC" + numeroConta);
            } else if (tipoConta.equals("Conta Poupança")) {
                double rendimentoMensal = Double.parseDouble(tfRendimentoMensal.getText());
                contaBancaria = new ContaPoupanca(numeroConta, saldoInicial, dataAbertura, rendimentoMensal);
            } else if (tipoConta.equals("Conta Salário")) {
                double limiteSaque = Double.parseDouble(tfLimiteSaque.getText());
                double limiteTransferencia = Double.parseDouble(tfLimiteTransferencia.getText());
                contaBancaria = new ContaSalario(numeroConta, saldoInicial, dataAbertura, limiteSaque, limiteTransferencia);
            }

            // Exibir a conta cadastrada
            if (contaBancaria != null) {
                JOptionPane.showMessageDialog(this,
                        "Conta " + tipoConta + " cadastrada com sucesso!\n" +
                                "Número da conta: " + contaBancaria.getNumeroConta() + "\n" +
                                "Saldo Inicial: R$ " + contaBancaria.getSaldo());
            } else {
                JOptionPane.showMessageDialog(this, "Erro ao cadastrar a conta.");
            }

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Erro: " + ex.getMessage());
        }
    }

    public static void main(String[] args) {
        // Exibir a interface gráfica
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new CadastroGUI().setVisible(true);
            }
        });
    }
}
