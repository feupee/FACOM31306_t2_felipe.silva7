import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public abstract class ContaBancaria {
    protected String numeroConta;
    protected double saldo;
    protected Date dataAbertura;
    protected Date dataUltimaMovimentacao;
    protected List<Transacao> transacoes;

    public ContaBancaria(String numeroConta, double saldoInicial, Date dataAbertura) {
        this.numeroConta = numeroConta;
        this.saldo = saldoInicial;
        this.dataAbertura = dataAbertura;
        this.dataUltimaMovimentacao = dataAbertura;
        this.transacoes = new ArrayList<>();
    }

    // Método para sacar
    public void sacar(double valor) throws ValorInvalidoException {
        if (valor > saldo) {
            throw new ValorInvalidoException("Saldo insuficiente para saque!");
        }
        Transacao transacao = new Transacao(this, valor, "saque");
        saldo -= valor;
        atualizarDataUltimaMovimentacao();
        transacoes.add(transacao);
        enviarNotificacao(transacao);  // Envia a notificação após o saque
    }

    // Método para depositar
    public void depositar(double valor) {
        Transacao transacao = new Transacao(this, valor, "depósito");
        saldo += valor;
        atualizarDataUltimaMovimentacao();
        transacoes.add(transacao);
        enviarNotificacao(transacao);
    }

    // Método para consultar saldo
    public void consultarSaldo() {
        Transacao transacao = new Transacao(this,0, "consultar saldo");
        transacoes.add(transacao);
        System.out.printf("Saldo atual: R$ %.2f\n", getSaldo());
    }

    // Método para efetuar pagamento
    public void efetuarPagamento(double valor, ContaBancaria contaBancariadestino) throws ValorInvalidoException {
        if (valor > saldo) {
            throw new ValorInvalidoException("Saldo insuficiente para transferencia!");
        }
        Transacao transacao = new Transacao(this, valor, "efetuar pagamento");
        saldo -= valor;
        atualizarDataUltimaMovimentacao();
        transacoes.add(transacao);
        contaBancariadestino.depositar(valor);
        enviarNotificacao(transacao);
    }

    private void atualizarDataUltimaMovimentacao() {
        this.dataUltimaMovimentacao = new Date();
    }

    // Exibir histórico de transações
    public void exibirTransacoes() {
        System.out.println("\n=== HISTÓRICO DE TRANSAÇÕES - CONTA " + numeroConta + " ===");
        for (Transacao t : transacoes) {
            System.out.println(t);
        }
    }

    public String getNumeroConta() {
        return numeroConta;
    }

    public void setNumeroConta(String numeroConta) {
        this.numeroConta = numeroConta;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public Date getDataAbertura() {
        return dataAbertura;
    }

    public void setDataAbertura(Date dataAbertura) {
        this.dataAbertura = dataAbertura;
    }

    public Date getDataUltimaMovimentacao() {
        return dataUltimaMovimentacao;
    }

    public void setDataUltimaMovimentacao(Date dataUltimaMovimentacao) {
        this.dataUltimaMovimentacao = dataUltimaMovimentacao;
    }

    public List<Transacao> getTransacoes() {
        return transacoes;
    }

    public void setTransacoes(List<Transacao> transacoes) {
        this.transacoes = transacoes;
    }

    // Método para enviar notificações após a transação
    private void enviarNotificacao(Transacao transacao) {
        Notificacao notificacao = switch (transacao.getTipo()) {
            case "saque" -> new NotificacaoSaque(this, transacao);
            case "depósito" -> new NotificacaoDeposito(this, transacao);
            case "efetuar pagamento" -> new NotificacaoPagamento(this, transacao);
            default -> throw new IllegalArgumentException("Tipo de transação desconhecido");
        };
        notificacao.enviarNotificacao();
    }
}