import java.util.Scanner;

public class Exercicio8 {
    public static void main(String[] args) {
        Scanner userInput = new Scanner(System.in);

        int vetor[] = {11, 22, 56, 48, 52, 38, 10, 54, 87, 55};
        int contador = 0;
        int menores = 0;
        int maiores = 0;

        System.out.println("Digite um número");
        int numero = userInput.nextInt();

        for (int i = 0; i < vetor.length; i++) {
            if (numero == vetor[i]) {
                contador++;
            }
            if (vetor[i] > numero) {
                maiores++;
            } else if (vetor[i] < numero) {
                menores++;
            }
        }
        System.out.println("O seu número aparece "+contador+" vez no vetor");
        System.out.println("No vetor existem " +maiores+ " numeros maiores");
        System.out.println("No vetor existem " +menores+ " numeros menores");
    }
}
