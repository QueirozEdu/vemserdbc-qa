import java.util.Scanner;
import java.text.DecimalFormat;


public class exercicio1 {
    public static void main(String[] args) {
        Scanner userInput = new Scanner(System.in);

        System.out.println("Digite o nome do produto");
        String nomeProduto = userInput.nextLine();

        System.out.println("Digite o valor do produto");
        float valor = userInput.nextFloat();

        float desconto;

        DecimalFormat df = new DecimalFormat("0.00");

        System.out.println("Produto: " +nomeProduto+ "\nPreço: R$ " +valor+ "\nPromoção: "+nomeProduto );
        for (int i = 1; i<=10; i++) {
            desconto = (float) ((float) valor * i * 0.05);
            System.out.println(i + "x R$ " + (valor - desconto) + " = R$ " + df.format((valor - desconto)*i));
        }

    }
}
