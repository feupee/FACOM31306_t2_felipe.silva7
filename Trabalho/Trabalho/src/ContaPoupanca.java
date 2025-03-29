import java.util.Date;

public class ContaPoupanca extends ContaBancaria {
    private double rendimento_mesAtual;

    public ContaPoupanca(String numeroConta, double saldoInicial, Date dataAbertura, double rendimento_mesAtual) {
        super(numeroConta, saldoInicial, dataAbertura);
        this.rendimento_mesAtual = rendimento_mesAtual;
    }

    public double getRendimento_mesAtual() {
        return rendimento_mesAtual;
    }

    public void setRendimento_mesAtual(double rendimento_mesAtual) {
        this.rendimento_mesAtual = rendimento_mesAtual;
    }
}
