package Persistencia;

import Classes.*;

import java.io.IOException;
import java.util.*;

public class BancoDados {
    /*private static List<Agencia> agencias = new ArrayList<>();
    private static List<Cliente> clientes = new ArrayList<>();
    private static List<ContaBancaria> contas = new ArrayList<>();
    private static List<Funcionario> funcionarios = new ArrayList<>();
    private static List<Gerente> gerentes = new ArrayList<>();

    static {
        carregarDados();
    }

    // Métodos para Cliente
    public static void adicionarCliente(Cliente cliente) throws IOException {
        if (clientes.stream().anyMatch(c -> c.getCPF().equals(cliente.getCPF()))) {
            throw new IllegalArgumentException("CPF já cadastrado");
        }
        clientes.add(cliente);
        PersistenciaDados.salvarClientes(clientes);
    }

    // Métodos para Agência
    public static void adicionarAgencia(Agencia agencia) throws IOException {
        if (agencias.stream().anyMatch(a -> a.getNmAgencia().equals(agencia.getNmAgencia()))) {
            throw new IllegalArgumentException("Agência já existe");
        }
        agencias.add(agencia);
        PersistenciaDados.salvarAgencias(agencias);
    }

    // Métodos para Conta Bancária
    public static void adicionarConta(ContaBancaria conta) throws IOException {
        if (contas.stream().anyMatch(c -> c.getNumeroConta().equals(conta.getNumeroConta()))) {
            throw new IllegalArgumentException("Conta já existe");
        }
        contas.add(conta);
        PersistenciaDados.salvarContas(contas);
    }

    // Métodos para Funcionário
    public static void adicionarFuncionario(Funcionario funcionario) throws IOException {
        if (funcionarios.stream().anyMatch(f -> f.getCPF().equals(funcionario.getCPF()))) {
            throw new IllegalArgumentException("Funcionário já cadastrado");
        }
        funcionarios.add(funcionario);
        PersistenciaDados.salvarFuncionarios(funcionarios);
    }

    // Métodos para Gerente
    public static void adicionarGerente(Gerente gerente) throws IOException {
        if (gerentes.stream().anyMatch(g -> g.getCPF().equals(gerente.getCPF()))) {
            throw new IllegalArgumentException("Gerente já cadastrado");
        }
        gerentes.add(gerente);
        PersistenciaDados.salvarGerentes(gerentes);
    }

    // Carregamento inicial dos dados
    public static void carregarDados() {
        try {
            agencias = PersistenciaDados.carregarAgencias();
            clientes = PersistenciaDados.carregarClientes();
            contas = PersistenciaDados.carregarContas();
            funcionarios = PersistenciaDados.carregarFuncionarios();
            gerentes = PersistenciaDados.carregarGerentes();

            // Vincular gerentes às agências
            for (Gerente gerente : gerentes) {
                if (gerente.getAgencia_gerenciada() != null) {
                    agencias.stream()
                            .filter(a -> a.getNmAgencia().equals(gerente.getAgencia_gerenciada().getNmAgencia()))
                            .findFirst()
                            .ifPresent(a -> a.setGerente(gerente));
                }
            }

        } catch (IOException | ClassNotFoundException e) {
            System.err.println("Erro ao carregar dados: " + e.getMessage());
            // Inicializa listas vazias se ocorrer erro
            agencias = new ArrayList<>();
            clientes = new ArrayList<>();
            contas = new ArrayList<>();
            funcionarios = new ArrayList<>();
            gerentes = new ArrayList<>();
        }
    }

    // Métodos de consulta (getters)
    public static List<Agencia> getTodasAgencias() {
        return Collections.unmodifiableList(agencias);
    }

    public static List<Cliente> getTodosClientes() {
        return Collections.unmodifiableList(clientes);
    }

    public static List<ContaBancaria> getTodasContas() {
        return Collections.unmodifiableList(contas);
    }

    public static List<Funcionario> getTodosFuncionarios() {
        return Collections.unmodifiableList(funcionarios);
    }

    public static List<Gerente> getTodosGerentes() {
        return Collections.unmodifiableList(gerentes);
    }*/
}