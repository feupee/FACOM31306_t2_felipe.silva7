public class Candidato {
    private String nome_completo, data_de_Nascimento, genero, cargo_pretendido;
    private float total_de_bens;
    private boolean reeleicao;
    private int número_do_partido;


    public void setData_de_Nascimento(String data_de_Nascimento) {
        this.data_de_Nascimento = data_de_Nascimento;
    }


    public void setGenero(String genero) {
        this.genero = genero;
    }


    public void setCargo_pretendido(String cargo_pretendido) {
        this.cargo_pretendido = cargo_pretendido;
    }

    public void setTotal_de_bens(float total_de_bens) {
        this.total_de_bens = total_de_bens;
    }

    public void setReeleicao(boolean reeleicao) {
        this.reeleicao = reeleicao;
    }

    public void Reeleicao(Candidato candidato){
        System.out.println(candidato.total_de_bens);
    }

    public void setNúmero_do_partido(int número_do_partido) {
        this.número_do_partido = número_do_partido;
    }

    public void mostrarInformacoes() {
        System.out.println("Nome Completo: " + nome_completo);
        System.out.println("Data de Nascimento: " + data_de_Nascimento);
        System.out.println("Gênero: " + genero);
        System.out.println("Cargo Pretendido: " + cargo_pretendido);
        System.out.println("Total de Bens: R$ " + total_de_bens);
        System.out.println("Reeleição: " + reeleicao);
        System.out.println("Número do Partido: " + número_do_partido);
    }

}