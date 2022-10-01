import javax.annotation.processing.SupportedSourceVersion;
import java.util.Scanner;

public class Exercicio5 {
    public static void main(String[] args) {
        Scanner userInput = new Scanner(System.in);

        int[][] informacoes = new int[5][4];
        int maiorNota = 0;
        int matriculaMaiorNota = 0;
        int mediaBuffer = 0;
        int media = 0;

        for (int a = 0; a < 5; a++){

                System.out.println("Digite o número da matrícula para o aluno " + (a+1));
                informacoes[a][0] = userInput.nextInt();

                System.out.println("Digite a média das provas");
                informacoes[a][1] = userInput.nextInt();

                System.out.println("Digite a média dos trabalhos");
                informacoes[a][2] = userInput.nextInt();

                informacoes[a][3] = (int) (informacoes[a][1]*0.6 + (informacoes[a][2]*0.4));

                if(informacoes[a][3] > maiorNota) {
                    matriculaMaiorNota = informacoes[a][0];
                    maiorNota = informacoes[a][3];
                }
                mediaBuffer += informacoes[a][3];

        };
        media = mediaBuffer/5;
        System.out.println("Matrícula com maior nota final: " +matriculaMaiorNota);
        System.out.println("Média das notas finais: " +media);

    }
}
