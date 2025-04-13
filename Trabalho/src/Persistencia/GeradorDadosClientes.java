package Persistencia;

import Classes.*;
import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class GeradorDadosClientes {
    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");

    public static void main(String[] args) {
        // Carregar agências existentes
        List<Agencia> agencias;
        try {
            agencias = PersistenciaDados.carregarAgencias();
            if (agencias.isEmpty()) {
                System.err.println("Nenhuma agência encontrada. Execute primeiro o GeradorDadosAgencias.");
                return;
            }
        } catch (Exception e) {
            System.err.println("Erro ao carregar agências: " + e.getMessage());
            return;
        }

        // Usar pasta temporária do sistema
        String caminhoArquivo = System.getProperty("java.io.tmpdir") + "clientes.dat";
        System.out.println("Criando arquivo em: " + caminhoArquivo);

        try (DataOutputStream escritor = new DataOutputStream(new FileOutputStream(caminhoArquivo))) {
            // Gerar clientes para a primeira agência
            Agencia agencia1 = agencias.get(0);
            escreverCliente(escritor, GeradorCPF.gerarCPFValido(), "João Silva", "Rua A, 100",
                    "Casado", "Superior Completo", "15/05/1980", agencia1);

            escreverCliente(escritor, GeradorCPF.gerarCPFValido(), "Maria Oliveira", "Av. B, 200",
                    "Solteira", "Ensino Médio", "20/10/1990", agencia1);

            // Gerar clientes para a segunda agência (se existir)
            if (agencias.size() > 1) {
                Agencia agencia2 = agencias.get(1);
                escreverCliente(escritor, GeradorCPF.gerarCPFValido(), "Carlos Santos", "Rua C, 300",
                        "Divorciado", "Pós-Graduação", "10/03/1975", agencia2);

                escreverCliente(escritor, GeradorCPF.gerarCPFValido(), "Ana Pereira", "Av. D, 400",
                        "Casada", "Superior Completo", "22/07/1985", agencia2);
            }

            System.out.println("Arquivo clientes.dat criado com sucesso!");
        } catch (Exception e) {
            System.err.println("Erro ao gerar arquivo: " + e.getMessage());
            e.printStackTrace();
        }
    }

    private static void escreverCliente(DataOutputStream escritor, String CPF, String nome,
                                        String endereco, String estadoCivil, String escolaridade,
                                        String dataNascimentoStr, Agencia agencia) throws Exception {
        // Validar CPF antes de escrever
        if (!ValidadorCPF.validarCPF(CPF)) {
            throw new IllegalArgumentException("CPF inválido: " + CPF);
        }

        Date dataNascimento = dateFormat.parse(dataNascimentoStr);

        // Escrever dados da superclasse Pessoa
        escritor.writeUTF(CPF);
        escritor.writeUTF(nome);
        escritor.writeUTF(endereco);
        escritor.writeUTF(estadoCivil);
        escritor.writeUTF(escolaridade);
        escritor.writeUTF(dateFormat.format(dataNascimento));

        // Escrever referência à agência
        escritor.writeUTF(agencia.getNmrAgencia());
    }
}