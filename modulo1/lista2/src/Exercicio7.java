import java.util.Scanner;

public class Exercicio7 {
    public static void main(String[] args) {
        Scanner userInput = new Scanner(System.in);

        int mercados[][] = new int[10][3];

        int mercado1 = 0;
        int mercado2 = 0;
        int mercado3 = 0;

        for (int a = 0; a < 10; a++) {
            for (int b = 0; b < 3; b++) {
                System.out.println("Insira o valor do item " +(a+1)+ " no " +(b+1)+ "o mercado");
                mercados[a][b] = userInput.nextInt();
            }
        }
        for (int a = 0; a < 10; a++){
            mercado1 += mercados[a][0];
            mercado2 += mercados[a][1];
            mercado3 += mercados[a][2];
        }
        if (mercado1 <= mercado2 && mercado1 <= mercado3) {
            System.out.println("O mercado mais barato é o 1");
        } else if (mercado2 <= mercado3 && mercado2 <= mercado1) {
            System.out.println("O mercado mais barato é o 2");
        } else {
            System.out.println("O mercado mais barato é o 3");
        }
    }
}
