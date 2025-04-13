package Persistencia;

import Classes.*;
import ExceptionsAndInterfaces.ValorInvalidoException;

import java.io.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class PersistenciaDados {
    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");

    public static List<Agencia> carregarAgencias() throws Exception {
        List<Agencia> agencias = new ArrayList<>();

        try (DataInputStream leitor = new DataInputStream(new FileInputStream("dados/agencias.dat"))) {
            while (leitor.available() > 0) {
                // Ler dados básicos da agência
                String nmrAgencia = leitor.readUTF();
                String nmAgencia = leitor.readUTF();
                String endereco = leitor.readUTF();
                String cidade = leitor.readUTF();
                String estado = leitor.readUTF();
                String bairro = leitor.readUTF();

                // Ler dados do gerente
                Gerente gerente = lerGerente(leitor);

                // Ler funcionários
                int numFuncionarios = leitor.readInt();
                Funcionario[] funcionarios = new Funcionario[numFuncionarios];
                for (int i = 0; i < numFuncionarios; i++) {
                    funcionarios[i] = lerFuncionario(leitor);
                }

                // Criar agência e associar o gerente
                Agencia agencia = new Agencia(nmrAgencia, nmAgencia, endereco, cidade,
                        estado, bairro, gerente, funcionarios);

                // Garantir que o gerente está associado à agência
                if (gerente != null) {
                    gerente.setAgencia_gerenciada(agencia);
                }

                agencias.add(agencia);
            }
        }

        return agencias;
    }

    private static Gerente lerGerente(DataInputStream leitor) throws IOException, ParseException, ValorInvalidoException {
        // Dados pessoais
        String CPF = leitor.readUTF();
        String nome = leitor.readUTF();
        String endereco_completo = leitor.readUTF();
        String estado_civil = leitor.readUTF();
        String escolaridade = leitor.readUTF();
        Date data_nascimento = dateFormat.parse(leitor.readUTF());

        // Dados funcionais
        String nro_carteiradeTrabalho = leitor.readUTF();
        String RG = leitor.readUTF();
        String cargo_empresa = leitor.readUTF();
        String salario = leitor.readUTF();
        String ano_ingresso = leitor.readUTF();
        String sexo = leitor.readUTF();

        // Dados específicos de gerente
        Date ingresso_gerencia = dateFormat.parse(leitor.readUTF());
        boolean formacaoBasica_gerencia = leitor.readBoolean();

        // Criar gerente (agencia_gerenciada será definida depois)
        try {
            return new Gerente(CPF, nome, endereco_completo, estado_civil, escolaridade,
                    data_nascimento, nro_carteiradeTrabalho, RG, cargo_empresa,
                    salario, ano_ingresso, sexo, ingresso_gerencia, null, formacaoBasica_gerencia);
        } catch (ValorInvalidoException e) {
            throw new RuntimeException(e);
        }
    }

    private static Funcionario lerFuncionario(DataInputStream leitor) throws IOException, ParseException, ValorInvalidoException {
        // Dados pessoais
        String CPF = leitor.readUTF();
        String nome = leitor.readUTF();
        String endereco_completo = leitor.readUTF();
        String estado_civil = leitor.readUTF();
        String escolaridade = leitor.readUTF();
        Date data_nascimento = dateFormat.parse(leitor.readUTF());

        // Dados funcionais
        String nro_carteiradeTrabalho = leitor.readUTF();
        String RG = leitor.readUTF();
        String cargo_empresa = leitor.readUTF();
        String salario = leitor.readUTF();
        String ano_ingresso = leitor.readUTF();
        String sexo = leitor.readUTF();

        return new Funcionario(CPF, nome, endereco_completo, estado_civil, escolaridade,
                data_nascimento, nro_carteiradeTrabalho, RG, cargo_empresa,
                salario, ano_ingresso, sexo);
    }

    public static List<Cliente> carregarClientes() {
        List<Cliente> clientes = new ArrayList<>();

        try (DataInputStream leitor = new DataInputStream(new FileInputStream("dados/clientes.dat"))) {
            while (leitor.available() > 0) {
                // Ler dados básicos do cliente (herdados de Pessoa)
                String CPF = leitor.readUTF();
                String nome = leitor.readUTF();
                String endereco_completo = leitor.readUTF();
                String estado_civil = leitor.readUTF();
                String escolaridade = leitor.readUTF();
                Date data_nascimento = dateFormat.parse(leitor.readUTF());

                // Ler dados da agência associada
                Agencia agencia = lerAgenciaCliente(leitor);

                // Validar CPF antes de criar o cliente
                if (!ValidadorCPF.validarCPF(CPF)) {
                    System.err.println("CPF inválido encontrado: " + CPF);
                    continue; // Pula para o próximo cliente
                }

                // Criar cliente e adicionar à lista
                Cliente cliente = new Cliente(CPF, nome, endereco_completo, estado_civil,
                        escolaridade, data_nascimento, agencia);
                clientes.add(cliente);
            }
        } catch (FileNotFoundException e) {
            System.err.println("Arquivo de clientes não encontrado: " + e.getMessage());
        } catch (IOException e) {
            System.err.println("Erro de leitura do arquivo de clientes: " + e.getMessage());
        } catch (ParseException e) {
            System.err.println("Erro ao converter data no arquivo de clientes: " + e.getMessage());
        } catch (ValorInvalidoException e) {
            System.err.println("Dados inválidos no arquivo de clientes: " + e.getMessage());
        }

        return clientes;
    }

    private static Agencia lerAgenciaCliente(DataInputStream leitor) throws IOException {
        // Ler os dados básicos da agência do cliente
        String nmrAgencia = leitor.readUTF();
        String nmAgencia = leitor.readUTF();
        String endereco = leitor.readUTF();
        String cidade = leitor.readUTF();
        String estado = leitor.readUTF();
        String bairro = leitor.readUTF();

        // Como o cliente não precisa dos detalhes completos da agência (gerente e funcionários),
        // podemos criar uma agência simplificada
        return new Agencia(nmrAgencia, nmAgencia, endereco, cidade, estado, bairro, null, null);
    }

    // Método para adicionar novo cliente (como solicitado)
    public static void adicionarCliente(Cliente novoCliente) {
        // Primeiro carrega todos os clientes existentes
        List<Cliente> clientes = carregarClientes();

        // Verifica se o CPF já existe
        for (Cliente c : clientes) {
            if (c.getCPF().equals(novoCliente.getCPF())) {
                throw new IllegalArgumentException("CPF já cadastrado: " + novoCliente.getCPF());
            }
        }

        // Adiciona o novo cliente
        clientes.add(novoCliente);

        // Salva todos os clientes no arquivo
        salvarClientes(clientes);
    }

    private static void salvarClientes(List<Cliente> clientes) {
        try (DataOutputStream escritor = new DataOutputStream(new FileOutputStream("dados/clientes.dat"))) {
            for (Cliente cliente : clientes) {
                // Escrever dados básicos do cliente
                escritor.writeUTF(cliente.getCPF());
                escritor.writeUTF(cliente.getNome());
                escritor.writeUTF(cliente.getEndereco_completo());
                escritor.writeUTF(cliente.getEstado_civil());
                escritor.writeUTF(cliente.getEscolaridade());
                escritor.writeUTF(dateFormat.format(cliente.getData_nascimento()));

                // Escrever dados da agência (apenas informações básicas)
                Agencia agencia = cliente.getAgencia();
                escritor.writeUTF(agencia.getNmrAgencia());
                escritor.writeUTF(agencia.getNmAgencia());
                escritor.writeUTF(agencia.getEndereco());
                escritor.writeUTF(agencia.getCidade());
                escritor.writeUTF(agencia.getEstado());
                escritor.writeUTF(agencia.getBairro());
            }
        } catch (IOException e) {
            System.err.println("Erro ao salvar clientes: " + e.getMessage());
        }
    }

    private static Agencia encontrarAgencia(List<Agencia> agencias, String nmrAgencia) {
        return agencias.stream()
                .filter(a -> a.getNmrAgencia().equals(nmrAgencia))
                .findFirst()
                .orElse(null);
    }
}