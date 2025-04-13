package Telas;

import Classes.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

public class TelaCadastroConta extends JFrame {
    private JComboBox<String> comboBoxTipoConta;
    private JTextField txtNumeroConta;
    private JPasswordField txtSenha;
    private JPasswordField txtConfirmarSenha;
    private JTextField txtLimiteChequeEspecial; // Para conta-corrente
    private JTextField txtTaxaAdministrativa;   // Para conta-corrente
    private JTextField txtRendimentoMensal;     // Para poupança
    private JTextField txtLimiteSaque;          // Para conta salário
    private JTextField txtLimiteTransferencia;  // Para conta salário
    private JPanel panelCamposEspecificos;

    public TelaCadastroConta() {
        setTitle("Cadastro de Nova Conta Bancária");
        setSize(500, 600);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout(10, 10));

        // Painel principal com rolagem
        JPanel panelPrincipal = new JPanel();
        panelPrincipal.setLayout(new BoxLayout(panelPrincipal, BoxLayout.Y_AXIS));
        JScrollPane scrollPane = new JScrollPane(panelPrincipal);
        add(scrollPane, BorderLayout.CENTER);

        // Seção de dados básicos da conta
        JPanel panelDadosBasicos = new JPanel(new GridLayout(0, 2, 5, 5));
        panelDadosBasicos.setBorder(BorderFactory.createTitledBorder("Dados Básicos da Conta"));

        panelDadosBasicos.add(new JLabel("Tipo de Conta:"));
        comboBoxTipoConta = new JComboBox<>(new String[]{"Corrente", "Poupança", "Salário"});
        comboBoxTipoConta.addActionListener(new TipoContaListener());
        panelDadosBasicos.add(comboBoxTipoConta);

        panelDadosBasicos.add(new JLabel("Número da Conta:"));
        txtNumeroConta = new JTextField();
        panelDadosBasicos.add(txtNumeroConta);

        panelDadosBasicos.add(new JLabel("Senha:"));
        txtSenha = new JPasswordField();
        panelDadosBasicos.add(txtSenha);

        panelDadosBasicos.add(new JLabel("Confirmar Senha:"));
        txtConfirmarSenha = new JPasswordField();
        panelDadosBasicos.add(txtConfirmarSenha);

        panelPrincipal.add(panelDadosBasicos);

        // Painel dinâmico para campos específicos
        panelCamposEspecificos = new JPanel(new GridLayout(0, 2, 5, 5));
        panelCamposEspecificos.setBorder(BorderFactory.createTitledBorder("Detalhes Específicos"));
        atualizarCamposEspecificos("Corrente"); // Inicia com campos para conta-corrente
        panelPrincipal.add(panelCamposEspecificos);

        // Botões de ação
        JPanel panelBotoes = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 10));
        JButton btnConfirmar = new JButton("Confirmar Cadastro");
        btnConfirmar.addActionListener(new ConfirmarCadastroListener());
        panelBotoes.add(btnConfirmar);

        JButton btnCancelar = new JButton("Cancelar");
        btnCancelar.addActionListener(e -> dispose());
        panelBotoes.add(btnCancelar);

        add(panelBotoes, BorderLayout.SOUTH);
    }

    private class TipoContaListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String tipoConta = (String) comboBoxTipoConta.getSelectedItem();
            atualizarCamposEspecificos(tipoConta);
        }
    }

    private void atualizarCamposEspecificos(String tipoConta) {
        panelCamposEspecificos.removeAll();

        switch (tipoConta) {
            case "Corrente":
                panelCamposEspecificos.add(new JLabel("Limite Cheque Especial:"));
                txtLimiteChequeEspecial = new JTextField();
                panelCamposEspecificos.add(txtLimiteChequeEspecial);

                panelCamposEspecificos.add(new JLabel("Taxa Administrativa:"));
                txtTaxaAdministrativa = new JTextField();
                panelCamposEspecificos.add(txtTaxaAdministrativa);
                break;

            case "Poupança":
                panelCamposEspecificos.add(new JLabel("Rendimento Mensal (%):"));
                txtRendimentoMensal = new JTextField();
                panelCamposEspecificos.add(txtRendimentoMensal);
                break;

            case "Salário":
                panelCamposEspecificos.add(new JLabel("Limite para Saque:"));
                txtLimiteSaque = new JTextField();
                panelCamposEspecificos.add(txtLimiteSaque);

                panelCamposEspecificos.add(new JLabel("Limite para Transferência:"));
                txtLimiteTransferencia = new JTextField();
                panelCamposEspecificos.add(txtLimiteTransferencia);
                break;
        }

        panelCamposEspecificos.revalidate();
        panelCamposEspecificos.repaint();
    }

    private class ConfirmarCadastroListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                // Validações básicas
                if (!new String(txtSenha.getPassword()).equals(new String(txtConfirmarSenha.getPassword()))) {
                    JOptionPane.showMessageDialog(null, "As senhas não coincidem!", "Erro", JOptionPane.ERROR_MESSAGE);
                    return;
                }

                String tipoConta = (String) comboBoxTipoConta.getSelectedItem();
                ContaBancaria novaConta;

                // Cria a conta específica conforme o tipo selecionado
                /*switch (tipoConta) {
                    case "Corrente":
                        novaConta = new ContaCorrente(
                                txtNumeroConta.getText(),                // numeroConta
                                0.0,                                    // saldoInicial (inicia com zero)
                                new Date(),                             // dataAbertura (data atual)
                                Double.parseDouble(txtLimiteChequeEspecial.getText()),  // limite_chequeEspecial
                                Double.parseDouble(txtTaxaAdministrativa.getText()),    // valor_taxaAdministrativa
                                txtNumeroConta.getText(),                // NrmConta
                                new String(txtSenha.getPassword()),      // Senha
                                true,                                    // status (ativa)
                                obterAgenciaSelecionada(),              // agencia (você precisa implementar isso)
                                obterClienteSelecionado()               // cliente (você precisa implementar isso)
                        );
                        break;

                    case "Poupança":
                        novaConta = new ContaPoupanca(
                                txtNumeroConta.getText(),                // numeroConta
                                0.0,                                     // saldoInicial
                                new Date(),                              // dataAbertura
                                Double.parseDouble(txtRendimentoMensal.getText()),  // rendimento_mesAtual
                                new String(txtSenha.getPassword()),      // Senha
                                true,                                    // status
                                obterAgenciaSelecionada(),              // agencia
                                obterClienteSelecionado()                // cliente
                        );
                        break;

                    case "Salário":
                        novaConta = new ContaSalario(
                                txtNumeroConta.getText(),                // numeroConta
                                0.0,                                     // saldoInicial
                                new Date(),                              // dataAbertura
                                Double.parseDouble(txtLimiteSaque.getText()),        // limite_saque
                                Double.parseDouble(txtLimiteTransferencia.getText()), // limite_transferencia
                                new String(txtSenha.getPassword()),      // Senha
                                true,                                    // status
                                obterAgenciaSelecionada(),              // agencia
                                obterClienteSelecionado()                // cliente
                        );
                        break;

                    default:
                        throw new IllegalArgumentException("Tipo de conta inválido");
                }*/

                // Aqui você adicionaria a conta ao sistema (BancoDados.adicionarConta(novaConta))
                /*JOptionPane.showMessageDialog(null, "Conta criada com sucesso!\nNúmero: " + novaConta.getNumeroConta(),
                        "Sucesso", JOptionPane.INFORMATION_MESSAGE);*/
                dispose();

            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(null, "Valores numéricos inválidos!", "Erro", JOptionPane.ERROR_MESSAGE);
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, "Erro ao criar conta: " + ex.getMessage(),
                        "Erro", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    /*private Agencia obterAgenciaSelecionada() {
        // Você precisará adicionar um JComboBox ou outra forma de selecionar a agência na tela
        // Exemplo simplificado:
        return BancoDados.getAgenciaPorNumero(numeroAgenciaSelecionada);
    }

    private Cliente obterClienteSelecionado() {
        // Você precisará adicionar um JComboBox ou outra forma de selecionar o cliente na tela
        // Exemplo simplificado:
        return BancoDados.getClientePorCPF(cpfClienteSelecionado);
    }*/

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new TelaCadastroConta().setVisible(true));
    }
}