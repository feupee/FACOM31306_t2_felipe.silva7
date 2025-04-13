package Persistencia;

import Classes.*;
import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;

public class GeradorDadosAgencias {
    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");

    public static void main(String[] args) {
        new File("dados").mkdirs();

        try (DataOutputStream escritor = new DataOutputStream(new FileOutputStream("dados/agencias.dat"))) {
            // Criar primeiro os gerentes sem agência
            Gerente gerente1 = getGerenteExemplo1();
            Gerente gerente2 = getGerenteExemplo2();

            // Criar as agências com os gerentes
            Agencia agencia1 = new Agencia("001", "Agência Centro", "Rua Principal, 100",
                    "São Paulo", "SP", "Centro", gerente1, getFuncionariosExemplo1());

            Agencia agencia2 = new Agencia("002", "Agência Zona Norte", "Av. Secundária, 200",
                    "São Paulo", "SP", "Zona Norte", gerente2, getFuncionariosExemplo2());

            // Agora associar as agências aos gerentes
            gerente1.setAgencia_gerenciada(agencia1);
            gerente2.setAgencia_gerenciada(agencia2);

            // Escrever as agências no arquivo
            escreverAgencia(escritor, agencia1);
            escreverAgencia(escritor, agencia2);

            System.out.println("Arquivo agencias.dat criado com sucesso!");
        } catch (Exception e) {
            System.err.println("Erro ao gerar arquivo: " + e.getMessage());
            e.printStackTrace();
        }
    }

    private static void escreverAgencia(DataOutputStream escritor, Agencia agencia) throws Exception {
        // Escrever dados básicos da agência
        escritor.writeUTF(agencia.getNmrAgencia());
        escritor.writeUTF(agencia.getNmAgencia());
        escritor.writeUTF(agencia.getEndereco());
        escritor.writeUTF(agencia.getCidade());
        escritor.writeUTF(agencia.getEstado());
        escritor.writeUTF(agencia.getBairro());

        // Escrever dados do gerente
        Gerente gerente = agencia.getGerente();
        escreverPessoa(escritor, gerente);
        escritor.writeUTF(gerente.getNro_carteiradeTrabalho());
        escritor.writeUTF(gerente.getRG());
        escritor.writeUTF(gerente.getCargo_empresa());
        escritor.writeUTF(gerente.getSalario());
        escritor.writeUTF(gerente.getAno_ingresso());
        escritor.writeUTF(gerente.getSexo());
        escritor.writeUTF(dateFormat.format(gerente.getIngresso_gerencia()));
        escritor.writeBoolean(gerente.getFormacaoBasica_gerencia());

        // Escrever funcionários
        Funcionario[] funcionarios = agencia.getFuncionarios();
        escritor.writeInt(funcionarios.length);
        for (Funcionario func : funcionarios) {
            escreverPessoa(escritor, func);
            escritor.writeUTF(func.getNro_carteiradeTrabalho());
            escritor.writeUTF(func.getRG());
            escritor.writeUTF(func.getCargo_empresa());
            escritor.writeUTF(func.getSalario());
            escritor.writeUTF(func.getAno_ingresso());
            escritor.writeUTF(func.getSexo());
        }
    }

    private static void escreverPessoa(DataOutputStream escritor, Pessoa pessoa) throws IOException {
        escritor.writeUTF(pessoa.getCPF());
        escritor.writeUTF(pessoa.getNome());
        escritor.writeUTF(pessoa.getEndereco_completo());
        escritor.writeUTF(pessoa.getEstado_civil());
        escritor.writeUTF(pessoa.getEscolaridade());
        escritor.writeUTF(dateFormat.format(pessoa.getData_nascimento()));
    }

    // Métodos para criar dados de exemplo
    private static Gerente getGerenteExemplo1() throws Exception {
        Date dataNasc = dateFormat.parse("15/05/1975");
        Date ingressoGerencia = dateFormat.parse("10/01/2015");
        return new Gerente("15285426650", "Carlos Silva", "Av. Principal, 100", "Casado",
                "Superior Completo", dataNasc, "12345", "MG-10.111.111",
                "Gerente Geral", "15000", "2005", "Masculino", ingressoGerencia,
                null, true);
    }

    private static Funcionario[] getFuncionariosExemplo1() throws Exception {
        Date dataNasc1 = dateFormat.parse("20/10/1985");
        Date dataNasc2 = dateFormat.parse("05/03/1990");

        Funcionario func1 = new Funcionario("18219822821", "Ana Oliveira", "Rua A, 200",
                "Solteira", "Superior Completo", dataNasc1,
                "54321", "SP-20.222.222", "Caixa", "3500",
                "2018", "Feminino");

        Funcionario func2 = new Funcionario("31081862807", "Pedro Santos", "Rua B, 300",
                "Casado", "Ensino Médio", dataNasc2,
                "98765", "SP-30.333.333", "Atendente", "2800",
                "2020", "Masculino");

        return new Funcionario[]{func1, func2};
    }

    private static Gerente getGerenteExemplo2() throws Exception {
        Date dataNasc = dateFormat.parse("22/08/1980");
        Date ingressoGerencia = dateFormat.parse("05/06/2018");
        return new Gerente("33441877837", "Mariana Costa", "Av. Secundária, 500", "Divorciada",
                "Pós-Graduação", dataNasc, "67890", "RJ-40.444.444",
                "Gerente Regional", "18000", "2010", "Feminino", ingressoGerencia,
                null, true);
    }

    private static Funcionario[] getFuncionariosExemplo2() throws Exception {
        Date dataNasc1 = dateFormat.parse("12/04/1992");
        Date dataNasc2 = dateFormat.parse("30/11/1988");
        Date dataNasc3 = dateFormat.parse("15/07/1995");

        Funcionario func1 = new Funcionario("11142760812", "Lucas Pereira", "Rua C, 400",
                "Solteiro", "Superior Completo", dataNasc1,
                "13579", "SP-50.555.555", "Gerente Assistente", "4500",
                "2017", "Masculino");

        Funcionario func2 = new Funcionario("33065979888", "Juliana Almeida", "Rua D, 500",
                "Casada", "Superior Completo", dataNasc2,
                "24680", "SP-60.666.666", "Caixa Sênior", "4200",
                "2015", "Feminino");

        Funcionario func3 = new Funcionario("15681075877", "Roberto Nunes", "Rua E, 600",
                "Solteiro", "Ensino Médio", dataNasc3,
                "11223", "SP-70.777.777", "Atendente", "2600",
                "2021", "Masculino");

        return new Funcionario[]{func1, func2, func3};
    }
}