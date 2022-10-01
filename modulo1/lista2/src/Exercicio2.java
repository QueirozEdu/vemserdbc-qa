import java.util.Scanner;

public class Exercicio2 {
    public static void main(String[] args) {
        Scanner userInput = new Scanner(System.in);


        System.out.println("Digite o número a ser adivinhado");
        int resposta = userInput.nextInt();

        System.out.println("Por favor, digite um número");
        int numero = userInput.nextInt();


        while (numero != resposta) {
            if (numero > resposta) {
                System.out.println("O número a ser encontrado é menor do que você digitou");
            }else {
                System.out.println("O número a ser encontrado é maior do que você digitou");
            }
            numero = userInput.nextInt();
        }
        System.out.println("Parabéns! você acertou");
    }
}
