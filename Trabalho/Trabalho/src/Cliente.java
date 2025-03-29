import java.util.Date;

public class Cliente extends Pessoa {
    private String CPF;
    private String nome;
    private String endereco_completo;
    private String estado_civil;
    private String escolaridade;
    private Date data_nascimento;

    public Cliente(String CPF, String nome, String endereco_completo, String estado_civil, String escolaridade, Date data_nascimento, Agencia agencia) throws ValorInvalidoException {
        super(CPF, nome, endereco_completo, estado_civil, escolaridade, data_nascimento);
        this.agencia = agencia;
    }

    public Cliente(String CPF, String nome) throws ValorInvalidoException {
        super(CPF, nome);
    }

    public Cliente(){
        super();

    }

    public Agencia getAgencia() {
        return agencia;
    }

    public void setAgencia(Agencia agencia) {
        this.agencia = agencia;
    }

    public Date getData_nascimento() {
        return data_nascimento;
    }

    public void setData_nascimento(Date data_nascimento) {
        this.data_nascimento = data_nascimento;
    }

    public String getEscolaridade() {
        return escolaridade;
    }

    public void setEscolaridade(String escolaridade) {
        this.escolaridade = escolaridade;
    }

    public String getEstado_civil() {
        return estado_civil;
    }

    public void setEstado_civil(String estado_civil) {
        this.estado_civil = estado_civil;
    }

    public String getEndereco_completo() {
        return endereco_completo;
    }

    public void setEndereco_completo(String endereco_completo) {
        this.endereco_completo = endereco_completo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCPF() {
        return CPF;
    }

    public void setCPF(String CPF) {
        this.CPF = CPF;
    }

    private Agencia agencia; // Associação com a agência
}
