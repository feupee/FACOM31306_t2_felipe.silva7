package Persistencia;

import Classes.*;
import Persistencia.Agencia.AgenciaBinarioIO;
import Persistencia.Cliente.ClienteBinarioIO;
import Persistencia.Conta.ContaBancariaBinarioIO;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class BancoDados {
    private static List<Agencia> agencias = new ArrayList<>();
    private static List<Cliente> clientes = new ArrayList<>();
    private static List<ContaBancaria> contas = new ArrayList<>();

    public static void carregarTudo() {
        carregarAgencias();
        carregarClientes();
        carregarContas();
    }

    // Métodos para Agência (já existentes)
    public static void carregarAgencias() {
        agencias.clear();
        int i = 1;

        while (true) {
            String nomeArquivo = String.format("dados/agencia_%04d.bin", i);
            File arquivo = new File(nomeArquivo);

            if (!arquivo.exists()) {
                break;
            }

            try {
                Agencia agencia = AgenciaBinarioIO.carregarAgencia(nomeArquivo);
                agencias.add(agencia);
            } catch (Exception e) {
                System.err.println("Erro ao carregar agência: " + nomeArquivo);
                e.printStackTrace();
            }

            i++;
        }
    }

    public static void salvarAgencia(Agencia agencia, int numeroSequencial) {
        String nomeArquivo = String.format("dados/agencia_%04d.bin", numeroSequencial);
        try {
            AgenciaBinarioIO.salvarAgencia(agencia, nomeArquivo);
        } catch (IOException e) {
            System.err.println("Erro ao salvar agência: " + nomeArquivo);
            e.printStackTrace();
        }
    }

    // Métodos para Cliente
    public static void carregarClientes() {
        clientes.clear();
        int i = 1;

        while (true) {
            String nomeArquivo = String.format("dados/cliente_%04d.bin", i);
            File arquivo = new File(nomeArquivo);

            if (!arquivo.exists()) {
                break;
            }

            try {
                Cliente cliente = ClienteBinarioIO.carregarCliente(nomeArquivo, agencias);
                clientes.add(cliente);
            } catch (Exception e) {
                System.err.println("Erro ao carregar cliente: " + nomeArquivo);
                e.printStackTrace();
            }

            i++;
        }
    }

    public static void salvarCliente(Cliente cliente, int numeroSequencial) {
        String nomeArquivo = String.format("dados/cliente_%04d.bin", numeroSequencial);
        try {
            ClienteBinarioIO.salvarCliente(cliente, nomeArquivo);
        } catch (IOException e) {
            System.err.println("Erro ao salvar cliente: " + nomeArquivo);
            e.printStackTrace();
        }
    }

    // Métodos para Conta
    public static void carregarContas() {
        contas.clear();
        String[] tipos = {"corrente", "poupanca", "salario"};

        for (String tipo : tipos) {
            int i = 1;

            while (true) {
                String nomeArquivo = String.format("dados/conta_%s_%04d.bin", tipo, i);
                File arquivo = new File(nomeArquivo);

                if (!arquivo.exists()) {
                    break;
                }

                try {
                    ContaBancaria conta = ContaBancariaBinarioIO.carregarConta(
                            nomeArquivo, clientes, agencias);
                    contas.add(conta);
                } catch (Exception e) {
                    System.err.println("Erro ao carregar conta: " + nomeArquivo);
                    e.printStackTrace();
                }

                i++;
            }
        }
    }

    public static void salvarConta(ContaBancaria conta, String tipo, int numeroSequencial) {
        String nomeArquivo = String.format("dados/conta_%s_%04d.bin", tipo, numeroSequencial);
        try {
            ContaBancariaBinarioIO.salvarConta(conta, nomeArquivo);
        } catch (IOException e) {
            System.err.println("Erro ao salvar conta: " + nomeArquivo);
            e.printStackTrace();
        }
    }

    // Métodos auxiliares para gerenciamento de IDs
    public static int getProximoIdCliente() {
        return clientes.size() + 1;
    }

    public static int getProximoIdConta(String tipo) {
        int maxId = 0;
        String prefixo = "conta_" + tipo + "_";

        for (ContaBancaria conta : contas) {
            if (conta instanceof ContaCorrente && tipo.equals("corrente")) {
                maxId++;
            } else if (conta instanceof ContaPoupanca && tipo.equals("poupanca")) {
                maxId++;
            } else if (conta instanceof ContaSalario && tipo.equals("salario")) {
                maxId++;
            }
        }

        return maxId + 1;
    }

    // Métodos de consulta (getters)
    public static List<Agencia> getTodasAgencias() {
        return agencias;
    }

    public static List<Cliente> getTodosClientes() {
        return clientes;
    }

    public static List<ContaBancaria> getTodasContas() {
        return contas;
    }

    // Métodos para adicionar novos itens
    public static void adicionarAgencia(Agencia agencia) {
        agencias.add(agencia);
        salvarAgencia(agencia, agencias.size());
    }

    public static void adicionarCliente(Cliente cliente) {
        clientes.add(cliente);
        salvarCliente(cliente, clientes.size());
    }

    public static void adicionarConta(ContaBancaria conta) {
        contas.add(conta);
        String tipo = "";

        if (conta instanceof ContaCorrente) {
            tipo = "corrente";
        } else if (conta instanceof ContaPoupanca) {
            tipo = "poupanca";
        } else if (conta instanceof ContaSalario) {
            tipo = "salario";
        }

        salvarConta(conta, tipo, getProximoIdConta(tipo));
    }
}