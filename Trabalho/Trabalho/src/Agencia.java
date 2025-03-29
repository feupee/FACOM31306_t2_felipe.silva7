public class Agencia {
    private String NmrAgencia;
    private String NmAgencia;
    private String endereco;
    private String cidade;
    private String estado;
    private String bairro;
    private Gerente gerente;

    public Agencia(String nmrAgencia, String nmAgencia, String endereco, String cidade, String estado, String bairro, Gerente gerente, Funcionario[] funcionarios) {
        NmrAgencia = nmrAgencia;
        NmAgencia = nmAgencia;
        this.endereco = endereco;
        this.cidade = cidade;
        this.estado = estado;
        this.bairro = bairro;
        this.gerente = gerente;
        this.funcionarios = funcionarios;
    }

    public String getNmrAgencia() {
        return NmrAgencia;
    }

    public void setNmrAgencia(String nmrAgencia) {
        NmrAgencia = nmrAgencia;
    }

    public String getNmAgencia() {
        return NmAgencia;
    }

    public void setNmAgencia(String nmAgencia) {
        NmAgencia = nmAgencia;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public Funcionario[] getFuncionarios() {
        return funcionarios;
    }

    public void setFuncionarios(Funcionario[] funcionarios) {
        this.funcionarios = funcionarios;
    }

    public Gerente getGerente() {
        return gerente;
    }

    public void setGerente(Gerente gerente) {
        this.gerente = gerente;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    private Funcionario[] funcionarios;
}
