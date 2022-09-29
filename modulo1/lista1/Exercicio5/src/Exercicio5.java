import java.util.Scanner;

public class Exercicio5 {
    public static void main(String[] args) {
        Scanner userInput = new Scanner(System.in);

        System.out.println("Digite a altura do retângulo");
        int altura = userInput.nextInt();
        System.out.println("Digite a base do retângulo");
        int base = userInput.nextInt();

        int area = base * altura;
        System.out.println("A área é: " +area);
    }
}
