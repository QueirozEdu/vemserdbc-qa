import java.util.Scanner;

public class Exercicio3 {
    public static void main(String[] args) {
        Scanner userInput = new Scanner(System.in);

        System.out.println("Digite uma palavra");
        String palavra = userInput.next();

        switch (palavra){
            case "Cachorro":
                System.out.println("Dog");
                break;
            case "Tempo":
                System.out.println("Time");
                break;
            case "Amor":
                System.out.println("Love");
                break;
            case "Cidade":
                System.out.println("City");
                break;
            case "Feliz":
                System.out.println("Happy");
                break;
            case "Triste":
                System.out.println("Sad");
                break;
            case "Deveria":
                System.out.println("Should");
                break;
            case "Poderia":
                System.out.println("Could");
                break;
            case "Dog":
                System.out.println("Cachorro");
                break;
            case "Time":
                System.out.println("Tempo");
                break;
            case "Love":
                System.out.println("Amor");
                break;
            case "City":
                System.out.println("Cidade");
                break;
            case "Happy":
                System.out.println("Feliz");
                break;
            case "Sad":
                System.out.println("Triste");
                break;
            case "Should":
                System.out.println("Deveria");
                break;
            case "Could":
                System.out.println("Poderia");
                break;
            default:
                System.out.println("Essa palavra não é válida");
        }
    }
}
