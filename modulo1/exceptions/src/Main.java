import java.util.InputMismatchException;
import java.util.Scanner;

public class Main{
    public static void main(String[] args) {
        loop();
        System.out.println("Operacão finalizada");

    }
    public static void loop(){
        Scanner userInput = new Scanner(System.in);
        try {
            System.out.println("Digite o primeiro número");
            int n1 = userInput.nextInt();
            System.out.println("Digite o segundo número");
            int n2 = userInput.nextInt();
            System.out.println("Resultado: " + (n1/n2));

        }catch (InputMismatchException e){
            System.out.println("Os valores informados não são numéricos. Tente novamente.");
            loop();
        }catch (ArithmeticException e){
            System.out.println("Não é possível dividir nenhum número por zero. Tente novamente");
            loop();
        }
        finally {
            userInput.close();

        }

    }
}

