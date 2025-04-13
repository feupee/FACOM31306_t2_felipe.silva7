package Telas;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import Classes.Agencia;
import Classes.Cliente;
import ExceptionsAndInterfaces.ValorInvalidoException;
import Persistencia.PersistenciaDados;

import static Classes.ValidadorCPF.validarCPF;

public class TelaCadastroCliente extends JFrame {
    private JTextField txtCpf;
    private JTextField txtNome;
    private JTextField txtEndereco;
    private JComboBox<String> comboEstadoCivil;
    private JTextField txtEscolaridade;
    private JFormattedTextField txtDataNascimento;
    private JComboBox<Agencia> comboAgencias;

    public TelaCadastroCliente() {
        setTitle("Cadastro de Cliente");
        setSize(500, 400); // Aumentei o tamanho para melhor visualização
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout(10, 10));

        // Painel principal
        JPanel panelPrincipal = new JPanel();
        panelPrincipal.setLayout(new BoxLayout(panelPrincipal, BoxLayout.Y_AXIS));
        panelPrincipal.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        // Painel de dados do cliente
        JPanel panelDados = new JPanel(new GridLayout(0, 2, 5, 5));
        panelDados.setBorder(BorderFactory.createTitledBorder("Dados Pessoais"));

        // Adicionando componentes
        adicionarComponentes(panelDados);
        panelPrincipal.add(panelDados);

        // Carregar agências (deve ser feito após a criação dos componentes)
        carregarAgencias();

        // Botões
        JPanel panelBotoes = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 10));
        JButton btnConfirmar = new JButton("Confirmar Cadastro");
        btnConfirmar.addActionListener(new ConfirmarCadastroListener());

        JButton btnCancelar = new JButton("Cancelar");
        btnCancelar.addActionListener(e -> {
            new TelaInicial().setVisible(true);
            dispose();
        });

        panelBotoes.add(btnConfirmar);
        panelBotoes.add(btnCancelar);

        add(panelPrincipal, BorderLayout.CENTER);
        add(panelBotoes, BorderLayout.SOUTH);

        setVisible(true); // Garante que a tela será exibida
    }

    private void adicionarComponentes(JPanel panel) {
        // CPF
        panel.add(new JLabel("CPF:"));
        txtCpf = new JTextField();
        panel.add(txtCpf);

        // Nome
        panel.add(new JLabel("Nome Completo:"));
        txtNome = new JTextField();
        panel.add(txtNome);

        // Endereço
        panel.add(new JLabel("Endereço Completo:"));
        txtEndereco = new JTextField();
        panel.add(txtEndereco);

        // Estado Civil
        panel.add(new JLabel("Estado Civil:"));
        comboEstadoCivil = new JComboBox<>(new String[]{
                "Solteiro(a)", "Casado(a)", "Divorciado(a)", "Viúvo(a)", "Separado(a)"
        });
        panel.add(comboEstadoCivil);

        // Escolaridade
        panel.add(new JLabel("Escolaridade:"));
        txtEscolaridade = new JTextField();
        panel.add(txtEscolaridade);

        // Data de Nascimento
        panel.add(new JLabel("Data de Nascimento (dd/MM/yyyy):"));
        txtDataNascimento = new JFormattedTextField(new SimpleDateFormat("dd/MM/yyyy"));
        panel.add(txtDataNascimento);

        // Agência
        panel.add(new JLabel("Agência:"));
        comboAgencias = new JComboBox<>();
        comboAgencias.setRenderer(new DefaultListCellRenderer() {
            @Override
            public Component getListCellRendererComponent(JList<?> list, Object value, int index,
                                                          boolean isSelected, boolean cellHasFocus) {
                super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
                if (value instanceof Agencia) {
                    Agencia agencia = (Agencia) value;
                    setText(agencia.getNmAgencia() + " - " + agencia.getEndereco());
                }
                return this;
            }
        });
        panel.add(comboAgencias);
    }

    private void carregarAgencias() {
        try {
            comboAgencias.removeAllItems();
            for (Agencia agencia : PersistenciaDados.carregarAgencias()) {
                comboAgencias.addItem(agencia);
            }

            if (comboAgencias.getItemCount() == 0) {
                JOptionPane.showMessageDialog(this,
                        "Nenhuma agência cadastrada. Cadastre uma agência primeiro.",
                        "Aviso", JOptionPane.WARNING_MESSAGE);
                dispose();
                new TelaInicial().setVisible(true);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this,
                    "Erro ao carregar agências: " + e.getMessage(),
                    "Erro", JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
        }
    }

    private class ConfirmarCadastroListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                validarCampos();
                Cliente novoCliente = criarCliente();
                PersistenciaDados.adicionarCliente(novoCliente);

                JOptionPane.showMessageDialog(null, "Cliente cadastrado com sucesso!",
                        "Sucesso", JOptionPane.INFORMATION_MESSAGE);

                new TelaInicial().setVisible(true);
                dispose();
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, ex.getMessage(),
                        "Erro", JOptionPane.ERROR_MESSAGE);
            }
        }

        private void validarCampos() throws Exception {
            if (txtCpf.getText().isEmpty() || txtNome.getText().isEmpty() ||
                    txtEndereco.getText().isEmpty() || txtEscolaridade.getText().isEmpty() ||
                    txtDataNascimento.getText().isEmpty()) {
                throw new Exception("Todos os campos são obrigatórios!");
            }

            if (!validarCPF(txtCpf.getText())) {
                throw new Exception("CPF inválido!");
            }

            if (comboAgencias.getSelectedItem() == null) {
                throw new Exception("Selecione uma agência válida!");
            }
        }

        private Cliente criarCliente() throws ParseException, ValorInvalidoException {
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
            Date dataNascimento = sdf.parse(txtDataNascimento.getText());
            Agencia agencia = (Agencia) comboAgencias.getSelectedItem();

            return new Cliente(
                    txtCpf.getText(),
                    txtNome.getText(),
                    txtEndereco.getText(),
                    (String) comboEstadoCivil.getSelectedItem(),
                    txtEscolaridade.getText(),
                    dataNascimento,
                    agencia
            );
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            TelaCadastroCliente tela = new TelaCadastroCliente();
            tela.setVisible(true);
        });
    }
}