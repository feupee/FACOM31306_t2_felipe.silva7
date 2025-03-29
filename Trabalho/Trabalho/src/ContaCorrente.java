import java.util.Date;

public class ContaCorrente extends ContaBancaria {
    private double limite_chequeEspecial;
    private double valor_taxaAdministrativa;
    private String NrmConta;

    public ContaCorrente(String numeroConta, double saldoInicial, Date dataAbertura, double limite_chequeEspecial, double valor_taxaAdministrativa, String NrmConta) {
        super(numeroConta, saldoInicial, dataAbertura);
        this.limite_chequeEspecial = limite_chequeEspecial;
        this.valor_taxaAdministrativa = valor_taxaAdministrativa;
        this.NrmConta = NrmConta;
    }

    public double getLimite_chequeEspecial() {
        return limite_chequeEspecial;
    }

    public void setLimite_chequeEspecial(double limite_chequeEspecial) {
        this.limite_chequeEspecial = limite_chequeEspecial;
    }

    public double getValor_taxaAdministrativa() {
        return valor_taxaAdministrativa;
    }

    public void setValor_taxaAdministrativa(double valor_taxaAdministrativa) {
        this.valor_taxaAdministrativa = valor_taxaAdministrativa;
    }

    public String getNrmConta() {
        return NrmConta;
    }

    public void setNrmConta(String nrmConta) {
        NrmConta = nrmConta;
    }
}
