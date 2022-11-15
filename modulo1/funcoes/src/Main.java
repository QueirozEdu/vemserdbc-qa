import java.util.function.Function;

public class Main {
    public static void main(String[] args) {
        Calculo soma = ((valor1, valor2) -> valor1+valor2);
        Calculo multiplicacao = ((valor1, valor2) -> valor1 * valor2);

        System.out.println(soma.calcular(1, 5));
        System.out.println(multiplicacao.calcular(5,4));
    }
    FunctionalInterface<Integer> =* 10;

}

