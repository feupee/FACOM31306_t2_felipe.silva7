import java.util.Date;

public class Gerente extends Funcionario {
    private Date ingresso_gerencia;
    private Agencia agencia_gerenciada;
    private Boolean formacaoBasica_gerencia;
    private static double comissao;

    public Gerente(String CPF, String nome, String endereco_completo, String estado_civil, String escolaridade, Date data_nascimento, String nro_carteiradeTrabalho, String RG, String cargo_empresa, String salario, String ano_ingresso, String sexo, Date ingresso_gerencia, Agencia agencia_gerenciada, Boolean formacaoBasica_gerencia) throws ValorInvalidoException {
        super(CPF, nome, endereco_completo, estado_civil, escolaridade, data_nascimento, nro_carteiradeTrabalho, RG, cargo_empresa, salario, ano_ingresso, sexo);
        this.ingresso_gerencia = ingresso_gerencia;
        this.agencia_gerenciada = agencia_gerenciada;
        this.formacaoBasica_gerencia = formacaoBasica_gerencia;
    }

    public static double getComissao() {
        return comissao;
    }

    public static void setComissao(double comissao) {
        Gerente.comissao = comissao;
    }

    public Date getIngresso_gerencia() {
        return ingresso_gerencia;
    }

    public void setIngresso_gerencia(Date ingresso_gerencia) {
        this.ingresso_gerencia = ingresso_gerencia;
    }

    public Agencia getAgencia_gerenciada() {
        return agencia_gerenciada;
    }

    public void setAgencia_gerenciada(Agencia agencia_gerenciada) {
        this.agencia_gerenciada = agencia_gerenciada;
    }

    public Boolean getFormacaoBasica_gerencia() {
        return formacaoBasica_gerencia;
    }

    public void setFormacaoBasica_gerencia(Boolean formacaoBasica_gerencia) {
        this.formacaoBasica_gerencia = formacaoBasica_gerencia;
    }

    @Override
    public double calcularSalario() {
        // Primeiro, calcula o salário base do funcionário
        double salarioBase = super.calcularSalario();
        // Agora adiciona a comissão ao salário do gerente
        double salarioGerente = salarioBase + comissao;
        return salarioGerente;  // Retorna o salário do gerente com comissão
    }
}
