import java.util.Date;

public class ContaSalario extends ContaBancaria {
    private double limite_saque;
    private double limite_transferencia;

    public ContaSalario(String numeroConta, double saldoInicial, Date dataAbertura, double limite_saque, double limite_transferencia) {
        super(numeroConta, saldoInicial, dataAbertura);
        this.limite_saque = limite_saque;
        this.limite_transferencia = limite_transferencia;
    }

    public double getLimite_saque() {
        return limite_saque;
    }

    public void setLimite_saque(double limite_saque) {
        this.limite_saque = limite_saque;
    }

    public double getLimite_transferencia() {
        return limite_transferencia;
    }

    public void setLimite_transferencia(double limite_transferencia) {
        this.limite_transferencia = limite_transferencia;
    }
}
