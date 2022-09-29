import java.util.Scanner;

public class Exercicio10 {
    public static void main(String[] args) {
        Scanner userInput = new Scanner(System.in);

        System.out.println("Digite o número de identificação do aluno");
        int identificacao = userInput.nextInt();
        System.out.println("Digite a nota 1");
        float nota1 = userInput.nextFloat();
        System.out.println("Digite a nota 2");
        float nota2 = userInput.nextFloat();
        System.out.println("Digite a nota 3");
        float nota3 = userInput.nextFloat();
        System.out.println("Digite a média dos exercícios");
        float mediaExercicios = userInput.nextFloat();

        boolean aprovado;

        float ma = (nota1 + (nota2*2) + (nota3 * 3) + mediaExercicios)/7;

        String conceito;
        if (ma>= 9) {
            conceito = "A";
        } else if (ma > 7.5 && ma <9) {
            conceito = "B";
        } else if (ma >6 && ma < 7.5) {
            conceito = "C";
        } else if (ma > 4 && ma < 6) {
            conceito = "D";
        }else {
            conceito = "E";
        }
        aprovado = conceito == "A" || conceito == "B" || conceito == "C";

        System.out.println("Número de Identificação: " + identificacao);
        System.out.println("Nota 1: " + nota1);
        System.out.println("Nota 2: " + nota2);
        System.out.println("Nota 3: " + nota3);
        System.out.println("Média dos Exercícios: " + mediaExercicios);
        System.out.println("Conceito: " + conceito);
        if (aprovado) {
            System.out.println("Aprovado");
        }else {
            System.out.println("Reprovado");
        }
    }
}
