import java.util.Scanner;

public class exercicio4 {
    public static void main(String[] args) {
        Scanner userInput = new Scanner(System.in);

        int valores[] = new int[20];

        for (int i =0; i<20; i++){
            System.out.println("Digite um número inteiro");
            valores[i] = userInput.nextInt();
        }
        for (int i = (valores.length -1); i >= 0; i--) {
            System.out.println(valores[i]);
        }
    }
}
