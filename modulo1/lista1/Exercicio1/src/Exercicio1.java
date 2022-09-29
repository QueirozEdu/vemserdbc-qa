import java.util.Scanner;

public class Exercicio1 {
    public static void main(String[] args) {
        Scanner userInput = new Scanner(System.in).useDelimiter("\n");

        System.out.println("Digite o seu nome");
        String nome = userInput.nextLine();
        System.out.println("Digite a sua idade");
        int idade = userInput.nextInt();
        System.out.println("Digite o seu estado");
        String estado = userInput.next();
        System.out.println("Digite a sua cidade");
        String cidade = userInput.next();

        System.out.println("Olá seu nome é " +nome+ " você tem "+idade+
                " anos, é da cidade de "+cidade+", situada no estado de "+estado);

    }
}
