import java.util.Date;

public class Main {
    public static void main(String[] args) {
        Date dataAbertura = new Date();

        // Instanciando uma ContaCorrente
        ContaCorrente contaCorrente = new ContaCorrente(
                "12345-6",         // número da conta
                1000.0,            // saldo inicial
                dataAbertura,      // data de abertura
                500.0,             // limite do cheque especial
                30.0,              // taxa administrativa
                "CC12345"          // número da conta
        );

        // Instanciando uma ContaPoupança
        ContaPoupanca contaPoupanca = new ContaPoupanca(
                "98765-4",         // número da conta
                1500.0,            // saldo inicial
                dataAbertura,      // data de abertura
                0.05               // rendimento mensal
        );

        // Instanciando uma ContaSalario
        ContaSalario contaSalario = new ContaSalario(
                "54321-0",         // número da conta
                2000.0,            // saldo inicial
                dataAbertura,      // data de abertura
                1000.0,            // limite de saque
                2000.0             // limite de transferência
        );

        try {
            contaPoupanca.depositar( 500);
            contaCorrente.sacar(200);
            contaSalario.consultarSaldo();
            contaCorrente.efetuarPagamento(150, contaCorrente);

            // Exibir histórico de transações
            contaSalario.exibirTransacoes();

        } catch (ValorInvalidoException e) {
            System.out.println("Erro: " + e.getMessage());
        }
    }
}