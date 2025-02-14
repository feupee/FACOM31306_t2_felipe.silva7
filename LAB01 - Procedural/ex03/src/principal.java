package ex03.src;

import java.util.Scanner;

public class principal {

    public static void ex01(){
        Scanner sc = new Scanner(System.in);
        int val1,val2,val3,val4,val5,val6;

        System.out.println("<< Listando um vetor >>");
        System.out.println("Entre com o número 1: ");
        val1 = sc.nextInt();

        System.out.println("Entre com o número 2: ");
        val2 = sc.nextInt();

        System.out.println("Entre com o número 3: ");
        val3 = sc.nextInt();

        System.out.println("Entre com o número 4: ");
        val4 = sc.nextInt();

        System.out.println("Entre com o número 5: ");
        val5 = sc.nextInt();

        System.out.println("Entre com o número 6: ");
        val6 = sc.nextInt();

        System.out.println("Os valores lidos são:");
        System.out.printf("%d %d %d %d %d %d ", val1, val2, val3, val4, val5, val6);
    }

    public static void ex02(){
        Scanner sc = new Scanner(System.in);
        int[] vet = new int[6];
        System.out.println("<< Listando um vetor >>");

        for (int i = 0; i < 6; i++){
            System.out.printf("\n Entre com o número %d: ",i+1);
            vet[i] = sc.nextInt();
        }

        System.out.println("Os valores lidos são:");
        for (int i = 0; i < 6; i++){
            System.out.printf("%d ",vet[i]);
        }
    }

    public static void ex03() {
        Scanner sc = new Scanner(System.in);
        int [] vet = new int[6];
        System.out.println("<< Listando um vetor >>");

        for (int i = 0; i < 6; i++){
            System.out.printf("\n Entre com o número %d: ", i+1);
            vet[i] = sc.nextInt();
        }
        System.out.println("A ordem inversa dos valores é: ");
        for(int i = 5; i >= 0; i--){//inverte os valores do vetor
            System.out.printf("%d ", vet[i]);
        }
    }

    public static void ex04() {
        Scanner sc = new Scanner(System.in);
        int [] vet = new int[6];
        System.out.println("<< Listando um vetor >>");
        int i = 0;
        while (i < 6) {//While usado p/ verificar se tem um ímpar e pedir que digite novamente
            System.out.printf("\n Entre com o número %d: ", i+1);
            int num = sc.nextInt();
            if (num % 2 == 0) {
                vet[i] = num;
                i++;
            } else {
                System.out.println("Erro! Valor inválido.");
            }
        }
        System.out.println("Os números pares digitados foram:");
        i = 0;
        while (i < 6) {
            System.out.printf("%d ", vet[i]);
            i++;
        }
    }

    public static void ex05() {
        Scanner sc = new Scanner(System.in);
        int [] vet = new int[5];
        System.out.println("<< 5 valores >>");
        for (int i = 0; i < 5; i++){
            System.out.printf("Entre com o número %d: ", i+1);
            vet[i] = sc.nextInt();
        }

        System.out.printf("Os números digitados são: ");
        for (int i = 0; i<5; i++) {
            System.out.printf("%d ", vet[i]);
        }

        int maior = vet[0];
        for (int i = 1; i < 5; i++){//verifica qual é o maior dentro do vetor[5]
            if(vet[i] > maior){
                maior = vet[i];
            }
        }
        System.out.printf("\nO maior valor é: %d\n", maior);

        int menor = vet[0];
        for(int i = 1; i < 5; i++){//verifica qual é o menor dentro do vetor[5]
            if(vet[i]< menor){
                menor = vet[i];
            }
        }
        System.out.printf("O menor valor é: %d\n", menor);

        float media = 0;
        for(int i = 0; i < 5; i++){
            media = media + vet[i];
        }
        media = media/5;
        System.out.printf("A média é: %.1f", media);
    }

    public static void ex06(){
        Scanner sc = new Scanner(System.in);
        int [] vet = new int[5];
        System.out.println("<< 5 valores >>");
        for(int i = 0; i < 5; i++){
            System.out.printf("Entre com o número %d: ", i+1);
            vet[i] = sc.nextInt();
        }

        System.out.printf("Os números digitados são: ");
        for (int i = 0; i<5; i++) {
            System.out.printf("%d ", vet[i]);
        }

        int maior = vet[0];
        int posicao1 = 0;
        for (int i = 1; i < 5; i++){//verifica qual é o maior dentro do vetor[5]
            if(vet[i] > maior){
                maior = vet[i];
                posicao1 = i;
            }
        }
        System.out.printf("\nO maior valor é: %d, na posição %d do vetor\n", maior,posicao1);

        int menor = vet[0];
        int posicao2 = 0;
        for(int i = 1; i < 5; i++) {//verifica qual é o menor dentro do vetor[5]
            if (vet[i] < menor) {
                menor = vet[i];
                posicao2 = i;
            }
        }
        System.out.printf("O menor valor é: %d, na posição %d do vetor\n", menor, posicao2);

        float media = 0;
        for(int i = 0; i < 5; i++){
            media = media + vet[i];
        }
        media = media/5;
        System.out.printf("A média é: %.1f", media);
    }

    public static void ex07(){
        Scanner sc = new Scanner(System.in);
        int [] vet = new int [5];
        System.out.println("<<Normalizando as notas>>");
        for(int i = 0; i < 5; i++){
            System.out.printf("Entre com a nota do aluno %d: ", i+1);
            vet[i] = sc.nextInt();
        }

        System.out.println("\nNotas normalizadas\n");
        int maior = vet[0];
        for (int i = 0; i < 5; i++) {//verifica qual é o maior dentro do vetor
            if(vet[i] > maior){
                maior = vet[i];
            }
        }
        int fatornorma = 100/maior;//calcula o fator de normalização
        for(int i = 0; i < 5; i++){
            int normal = vet[i]*fatornorma;
            System.out.printf("A nota do aluno %d é %d\n", i+1, normal);
        }
    }

    public static void ex08(){
        Scanner sc = new Scanner(System.in);
        float[] valores = new float[5];
        float soma = 0;

        System.out.println("<< Média e desvio-padrão >>");
        for (int i = 0; i < 5; i++) {
            System.out.print("Digite o valor " + (i + 1) + ": ");
            valores[i] = sc.nextFloat();
            soma += valores[i];
        }

        float media = soma / 5;
        float somaDiferencas = 0;
        for (int i = 0; i < 5; i++) {
            somaDiferencas += (valores[i] - media) * (valores[i] - media);
        }
        float desvioPadrao = (float) Math.sqrt(somaDiferencas / 4); // Desvio-padrão amostral

        System.out.printf("A média é %.0f e o desvio-padrão é %f\n", media, desvioPadrao);
    }

    public static void ex09() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Digite a quantidade de alunos: ");
        int qnt_alunos = sc.nextInt();
        if (qnt_alunos > 100) {
            System.out.println("Erro: Numero maior que 100");
            return;
        }
        double[] notas = new double[qnt_alunos];
        for (int i = 0; i < qnt_alunos; i++) {
            System.out.println("Digite nota aluno" + (i + 1));
            notas[i] = sc.nextInt();
        }
        double nota_final = 0;
        for (int i = 0; i < qnt_alunos; i++) {
            nota_final = nota_final + notas[i];
        }
        System.out.printf("A média das notas eh: " + nota_final / 2);
    }

    public static void ex10() {
        Scanner sc = new Scanner(System.in);
        int[] A = new int[3];
        int[] B = new int[3];
        int[] C = new int[3];

        for (int i = 0; i < 3; i++) {
            System.out.println("Digite o valor " + (i + 1) + " do Array A: ");
            A[i] = sc.nextInt();
        }
        for (int i = 0; i < 3; i++) {
            System.out.println("Digite o valor " + (i + 1) + " do Array B: ");
            B[i] = sc.nextInt();
        }
        for (int i = 0; i < 3; i++) {
            C[i] = A[i] - B[i];
            System.out.println("Valor " + (i + 1) + " do Array C: " + C[i]);
        }
    }

    public static void ex11() {
        Scanner sc = new Scanner(System.in);
        int[] V = new int[5];
        // Lê os valores do vetor V
        for (int i = 0; i < 5; i++) {
            System.out.println("Digite valor " + (i + 1) + ":");
            V[i] = sc.nextInt();
        }

        int j = 0, k = 0; // Contadores para pares e ímpares
        int[] V1 = new int[5]; // Vetor para ímpares
        int[] V2 = new int[5]; // Vetor para pares

        // Separa os valores em pares e ímpares
        for (int i = 0; i < 5; i++) {
            if (V[i] % 2 == 0) {
                V2[j] = V[i];
                j++;
            } else {
                V1[k] = V[i];
                k++;
            }
        }
        // Exibe os números ímpares
        System.out.print("Ímpares: ");
        for (int i = 0; i < k; i++) { // Usa 'k' como limite
            System.out.print(V1[i]);
            if (i < k - 1) {
                System.out.print(", ");
            }
        }
        System.out.println(); // Pula linha
        // Exibe os números pares
        System.out.print("Pares: ");
        for (int i = 0; i < j; i++) { // Usa 'j' como limite
            System.out.print(V2[i]);
            if (i < j - 1) {
                System.out.print(", ");
            }
        }
        System.out.println(); // Pula linha
    }

    public static void ex12(){
        Scanner sc = new Scanner(System.in);
        int B_V, B_A, B_AM, B_VE;
        System.out.println("Digite quantidade bolinhas Verde: ");
        B_V = sc.nextInt();
        System.out.println("Digite quantidade bolinhas Azul: ");
        B_A = sc.nextInt();
        System.out.println("Digite quantidade bolinhas Amarela: ");
        B_AM = sc.nextInt();
        System.out.println("Digite quantidade bolinhas Vermelha: ");
        B_VE = sc.nextInt();

        int total_B = B_V + B_A + B_AM + B_VE;

        System.out.println("Probabilidades");
        System.out.printf("Verde: %.2f%%\n", (B_V / (float) total_B) * 100);
        System.out.printf("Azul: %.2f%%\n", (B_A / (float) total_B) * 100);
        System.out.printf("Amarela: %.2f%%\n", (B_AM / (float) total_B) * 100);
        System.out.printf("Vermelha: %.2f%%\n", (B_VE / (float) total_B) * 100);
    }

    public static void ex13(){
        Scanner sc = new Scanner(System.in);
        int V[] = new int[5];
        for(int i = 0; i < 5; i++){
            System.out.println("Digite valor " + (i + 1) + ": ");
            V[i] = sc.nextInt();
        }
        System.out.println("Zerando os negativos, obtém-se: ");
        for(int i = 0; i < 5; i++){
            if(V[i] < 0){
                V[i] = 0;
            }
            System.out.print(V[i]+", ");
        }
    }

    public static void ex14() {
        Scanner sc = new Scanner(System.in);
        int qnt_alunos;
        System.out.println("Digite a quantidade de alunos: ");
        qnt_alunos = sc.nextInt();
        if (qnt_alunos > 10000) {
            System.out.println("Erro: tamanho excedeu o limite");
            return;
        }
        Aluno[] alunos = new Aluno[qnt_alunos];
        for (int i = 0; i < qnt_alunos; i++) {
            System.out.println("Cadastro do aluno " + (i + 1) + ":");
            System.out.print("Número de matrícula: ");
            int matricula = sc.nextInt();
            System.out.print("Classe social (A, B, C, D ou E): ");
            char classeSocial = sc.next().charAt(0);
            System.out.print("CRA: ");
            double CRA = sc.nextDouble();
            alunos[i] = new Aluno(matricula, classeSocial, CRA);
        }
        System.out.println("\nDados dos alunos cadastrados:");
        for (int i = 0; i < qnt_alunos; i++) {
            alunos[i].exibirDados();
        }
    }

    public static void ex15(){
        Scanner sc = new Scanner(System.in);
        int[] vetor = new int[8];
        System.out.println("Digite 8 números para o vetor:");
        for (int i = 0; i < 8; i++) {
            System.out.print("Número " + (i + 1) + ": ");
            vetor[i] = sc.nextInt();
        }
        boolean repetido;
        System.out.println("Números repetidos:");
        for (int i = 0; i < 8; i++) {
            repetido = false;
            for (int j = 0; j < i; j++) {
                if (vetor[i] == vetor[j]) {
                    repetido = true;
                    break;
                }
            }
            if (!repetido) {
                for (int k = i + 1; k < 8; k++) {
                    if (vetor[i] == vetor[k]) {
                        System.out.println(vetor[i]);
                        break;
                    }
                }
            }
        }
        sc.close();
    }

    public static void ex16(){
        Scanner sc = new Scanner(System.in);
        int[] vetor = new int[8];
        System.out.println("Digite 8 números para o vetor:");
        for (int i = 0; i < 8; i++) {
            System.out.print("Número " + (i + 1) + ": ");
            vetor[i] = sc.nextInt();
        }
        boolean[] jaVisto = new boolean[8];
        System.out.println("Números repetidos e a quantidade de vezes que aparecem:");
        for (int i = 0; i < 8; i++) {
            if (!jaVisto[i]) {
                int count = 1;
                for (int j = i + 1; j < 8; j++) {
                    if (vetor[i] == vetor[j]) {
                        count++;
                        jaVisto[j] = true;
                    }
                }
                if (count > 1) {
                    System.out.println(vetor[i] + " aparece " + count + " vezes.");
                }
            }
        }
        sc.close();
    }


    public static void main(String[] args) {
        //ex01();
        //ex02();
        //ex03();
        //ex04();
        //ex05();
        //ex06();
        //ex07();
        //ex08();
        //ex09();
        //ex10();
        //ex11();
        //ex12();
        //ex13();
        //ex14();
        //ex15();
        //ex16();
    }
}
