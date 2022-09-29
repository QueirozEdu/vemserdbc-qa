import java.util.Scanner;

public class Exercicio7 {
    public static void main(String[] args) {
        Scanner userInput = new Scanner(System.in);
        System.out.println("Digite o código do produto");
        String codigo = userInput.next();
        System.out.println("Digite a quantidade comprada");
        int quantidade = userInput.nextInt();

        float valorFinal = 0f;
        switch (codigo) {
            case "ABCD":
                valorFinal = (float) (5.30 * quantidade);
                System.out.println("Valor devido: R$ " + valorFinal);
                break;
            case "XYPL":
                valorFinal = (float) (6.00 * quantidade);
                System.out.println("Valor devido: R$ " + valorFinal);
                break;
            case "KLMP":
            valorFinal = (float) (3.20 * quantidade);
            System.out.println("Valor devido: R$ " + valorFinal);
                break;
            case "QRST":
                valorFinal = (float) (2.50 * quantidade);
                System.out.println("Valor devido: R$ " + valorFinal);
                break;
            default:
                System.out.println("Código não encontrado");
        }
    }
}
