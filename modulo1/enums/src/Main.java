import java.util.Scanner;

public class Main{
    public static void main(String[] args) {

        Scanner userInput = new Scanner(System.in);
        System.out.println("Digite o tipo de comida");
        String escolha = userInput.nextLine();
        Comidas comidaDesejada = Comidas.valueOf(escolha);
        System.out.println(comidaDesejada);
        switch (comidaDesejada){
            case JAPONESA -> System.out.println(comidaDesejada.getValor());
            case FAST_FOOD -> System.out.println(comidaDesejada.getValor());
            case TRADICIONAL -> System.out.println(comidaDesejada.getValor());
        }
    }

}