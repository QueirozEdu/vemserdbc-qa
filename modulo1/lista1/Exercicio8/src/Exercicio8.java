import javax.annotation.processing.SupportedSourceVersion;
import java.util.Scanner;

public class Exercicio8 {
    public static void main(String[] args) {
        Scanner userInput = new Scanner(System.in);

        System.out.println("Digite o salário atual");
        int salario = userInput.nextInt();
        System.out.println("Digite o código do cargo");
        int codigo = userInput.nextInt();
        int novoSalario = 0;
        int diferenca = 0;
        switch (codigo){
            case 101:
                System.out.println("Salário antigo: R$: " + salario);
                novoSalario = salario+(salario*10)/100;
                System.out.println("Novo salário: R$: " + novoSalario);
                diferenca = novoSalario-salario;
                System.out.println("Diferença: R$ "+ diferenca);
                break;
            case 102:
                System.out.println("Salário antigo: R$: " + salario);
                novoSalario = salario+(salario*20)/100;
                System.out.println("Novo salário: R$: " + novoSalario);
                diferenca = novoSalario-salario;
                System.out.println("Diferença: R$ "+ diferenca);
                break;
            case 103:
                System.out.println("Salário antigo: R$: " + salario);
                novoSalario = salario+(salario*30)/100;
                System.out.println("Novo salário: R$: " + novoSalario);
                diferenca = novoSalario-salario;
                System.out.println("Diferença: R$ "+ diferenca);
                break;
            default:
                System.out.println("Código Inválido");
        }
    }
}
