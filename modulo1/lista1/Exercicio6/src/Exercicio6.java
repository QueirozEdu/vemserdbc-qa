import java.util.Scanner;

public class Exercicio6 {
    public static void main(String[] args) {
        Scanner userInput = new Scanner(System.in);

        System.out.println("Digite o número de eleitores");
        int eleitores = userInput.nextInt();
        System.out.println("Digite o total de votos brancos");
        int votosBrancos = userInput.nextInt();
        System.out.println("Digite o total de votos nulos");
        int votosNulos = userInput.nextInt();
        System.out.println("Digite o total de votos válidos");
        int votosValidos = userInput.nextInt();

        System.out.println("O percentual que votos brancos representa é: "+ (votosBrancos * eleitores)/10000 + "%");
        System.out.println("O percentual que votos nulos representa é: "+ (votosNulos * eleitores)/10000 + "%");
        System.out.println("O percentual que votos válidos representa é: "+ (votosValidos * eleitores)/10000 + "%");

    }
}
