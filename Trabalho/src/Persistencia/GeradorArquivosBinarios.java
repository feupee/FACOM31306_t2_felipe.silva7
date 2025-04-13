package Persistencia;

import Classes.*;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class GeradorArquivosBinarios {

    public static void salvarArquivo(String nomeArquivo, Object objeto) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(nomeArquivo))) {
            oos.writeObject(objeto);
            System.out.println("Arquivo salvo com sucesso: " + nomeArquivo);
        } catch (IOException e) {
            System.err.println("Erro ao salvar o arquivo: " + nomeArquivo);
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

            // Gerentes
            List<Gerente> gerentes = new ArrayList<>();
            Gerente gerente1 = new Gerente("18219822821", "Carlos Silva", "Rua A, 123",
                    "Casado", "Superior Completo", sdf.parse("15/05/1975"), "123456", "SP-1.111.111",
                    "Gerente Geral", "15000.00", "2005", "Masculino", sdf.parse("10/01/2015"),
                    null, true);
            Gerente gerente2 = new Gerente("31081862807", "Ana Oliveira", "Av. B, 456",
                    "Solteira", "Mestrado", sdf.parse("20/10/1980"), "654321", "SP-2.222.222",
                    "Gerente Regional", "12000.00", "2010", "Feminino", sdf.parse("15/03/2018"),
                    null, true);
            gerentes.add(gerente1);
            gerentes.add(gerente2);

            // Agências
            List<Agencia> agencias = new ArrayList<>();
            Agencia agencia1 = new Agencia("001", "Agência Central", "Av. Principal, 100",
                    "São Paulo", "SP", "Centro", gerente1, new Funcionario[0]);
            gerente1.setAgencia_gerenciada(agencia1);
            agencias.add(agencia1);

            Agencia agencia2 = new Agencia("002", "Agência Norte", "Rua Norte, 200",
                    "São Paulo", "SP", "Santana", gerente2, new Funcionario[0]);
            gerente2.setAgencia_gerenciada(agencia2);
            agencias.add(agencia2);

            // Funcionários
            List<Funcionario> funcionarios = new ArrayList<>();
            Funcionario f1 = new Funcionario("33441877837", "João Santos", "Rua C, 789",
                    "Solteiro", "Superior Completo", sdf.parse("10/03/1985"), "112233",
                    "SP-3.333.333", "Caixa", "4500.00", "2018", "Masculino");
            Funcionario f2 = new Funcionario("11142760812", "Maria Souza", "Av. D, 101",
                    "Casada", "Técnico", sdf.parse("25/07/1990"), "445566",
                    "SP-4.444.444", "Atendente", "3800.00", "2019", "Feminino");

            funcionarios.add(f1);
            funcionarios.add(f2);

            agencia1.setFuncionarios(new Funcionario[]{f1});
            agencia2.setFuncionarios(new Funcionario[]{f2});

            // Clientes
            List<Cliente> clientes = new ArrayList<>();
            Cliente c1 = new Cliente("33065979888", "Pedro Costa", "Rua E, 202",
                    "Casado", "Superior", sdf.parse("12/11/1978"), agencia1);
            Cliente c2 = new Cliente("15681075877", "Juliana Almeida", "Av. F, 303",
                    "Divorciada", "Mestrado", sdf.parse("30/01/1982"), agencia2);
            clientes.add(c1);
            clientes.add(c2);

            // Contas
            List<ContaBancaria> contas = new ArrayList<>();
            contas.add(new ContaCorrente("1001-1", 2500.0, new Date(), 5000.0, 20.0,
                    "1001", "senha123", true, agencia1, c1));
            contas.add(new ContaPoupanca("2001-2", 5000.0, new Date(), 0.5,
                    "senha456", true, agencia2, c2));

            // Salvar nos arquivos
            salvarArquivo("src/dados/clientes.dat", clientes);
            salvarArquivo("src/dados/contas.dat", contas);
            salvarArquivo("src/dados/agencias.dat", agencias);
            salvarArquivo("src/dados/funcionarios.dat", funcionarios);
            salvarArquivo("src/dados/gerentes.dat", gerentes);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
