import java.util.Calendar;
import java.util.Date;

public class Main {
    /*public static void main(String[] args) throws ValorInvalidoException {

        //As agências bancárias devem ser previamente cadastradas, sendo que cada agência possui um
        //número, um nome fictício e um endereço, sendo que os campos cidade, estado e bairro são
        //campos frequentemente usados para se realizar buscas por agências.

        // Datas necessárias
        Calendar dataNascGerente = Calendar.getInstance();
        dataNascGerente.set(1980, Calendar.MARCH, 15);

        Calendar dataIngressoGerencia = Calendar.getInstance();
        dataIngressoGerencia.set(2020, Calendar.JANUARY, 1);

        // Funcionários da agência (vazio por enquanto)
        Funcionario[] funcionarios = new Funcionario[0];

        Agencia agencia = new Agencia(
                "001",
                "Agência Central",
                "Av. Brasil, 500",
                "São Paulo",
                "SP",
                "Centro",
                null,
                funcionarios
        );

        // Instancia o gerente
        Gerente gerente = new Gerente(
                "999.999.999-99",
                "Ana Paula",
                "Rua do Gerente, 123",
                "Casada",
                "Superior Completo",
                dataNascGerente.getTime(),
                "123456",
                "MG-12.345.678",
                "Gerente Geral",
                "12000.00",
                "2010",
                "Feminino",
                dataIngressoGerencia.getTime(),
                agencia, // agencia_gerenciada (antes de vincular à agência)
                true
        );

        agencia.setGerente(gerente);

        // Criando a agência e associando ao gerente

        // Datas de nascimento dos clientes
        Calendar cal1 = Calendar.getInstance();
        cal1.set(1990, Calendar.JANUARY, 10);

        Calendar cal2 = Calendar.getInstance();
        cal2.set(1985, Calendar.JUNE, 25);

        Calendar cal3 = Calendar.getInstance();
        cal3.set(2000, Calendar.DECEMBER, 5);

        // Criando os clientes vinculados à agência
        Cliente cliente1 = new Cliente("111.111.111-11", "João Silva", "Rua A, 123", "Solteiro", "Ensino Médio", cal1.getTime(), agencia);
        Cliente cliente2 = new Cliente("222.222.222-22", "Maria Souza", "Av. B, 456", "Casada", "Superior", cal2.getTime(), agencia);
        Cliente cliente3 = new Cliente("333.333.333-33", "Carlos Lima", "Trav. C, 789", "Divorciado", "Pós-graduação", cal3.getTime(), agencia);

        System.out.println("3 clientes criados e associados à agência com sucesso!");

        Date dataHoje = new Date();

        ContaCorrente contaCorrente = new ContaCorrente(
                "CC123", 1000.00, dataHoje,
                500.00, 15.00, "CC123", "1234", true,
                agencia, cliente1
        );

        // Conta Poupança para cliente2
        ContaPoupanca contaPoupanca = new ContaPoupanca(
                "CP456", 2000.00, dataHoje,
                0.5, "5678", true,
                agencia, cliente2
        );

        // Conta Salário para cliente3
        ContaSalario contaSalario = new ContaSalario(
                "CS789", 1500.00, dataHoje,
                1000.00, 500.00, "91011", true,
                agencia, cliente3
        );

        try {
            contaPoupanca.depositar( 500, "internet Banking");
            contaCorrente.sacar(200, "Caixa Eletrônico");
            contaSalario.consultarSaldo("Caixa Eletrônico");
            contaCorrente.efetuarPagamento(150, contaCorrente, "internet Banking");

            // Exibir histórico de transações
            contaSalario.exibirTransacoes();

        } catch (ValorInvalidoException e) {
            System.out.println("Erro: " + e.getMessage());


        }
    }*/
}