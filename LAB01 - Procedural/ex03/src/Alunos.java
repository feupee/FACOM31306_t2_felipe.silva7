package ex03.src;

class Aluno {
    int matricula;
    char classeSocial;
    double CRA;

    // Construtor da classe Aluno
    public Aluno(int matricula, char classeSocial, double CRA) {
        this.matricula = matricula;
        this.classeSocial = classeSocial;
        this.CRA = CRA;
    }

    // Método para exibir os dados do aluno
    public void exibirDados() {
        System.out.println("Matrícula: " + matricula + ", Classe Social: " + classeSocial + ", CRA: " + CRA);
    }
}