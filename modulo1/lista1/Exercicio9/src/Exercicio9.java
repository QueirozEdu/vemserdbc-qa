import java.util.Scanner;

public class Exercicio9 {
    public static void main(String[] args) {
        Scanner userInput = new Scanner(System.in);
        System.out.println("Digite a hora de início do jogo");
        int horaInicio = userInput.nextInt();
        System.out.println("Digite os minutos de início do jogo");
        int minutoInicio = userInput.nextInt();
        System.out.println("Digite a hora de término do jogo");
        int horaTermino = userInput.nextInt();
        System.out.println("Digite os minutos de término do jogo");
        int minutoTermino = userInput.nextInt();

        int inicioX = horaInicio * 60 + minutoInicio;
        int finalX = horaTermino * 60 + minutoTermino;

        int duracao = inicioX - finalX;
        if (duracao < 0) {
            duracao = duracao + 1440;
        }
        int durHoras = (duracao / 60);
        int durMinutos = duracao % 60;
        System.out.println(durHoras);
        System.out.println(durMinutos);

    }
}
