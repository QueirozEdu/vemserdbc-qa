import java.util.Scanner;

public class Exercicio6 {
    public static void main(String[] args) {
        Scanner userInput = new Scanner(System.in);

        int medias[][] = new int[5][4];

        int media1 = 0;
        int media2 = 0;
        int media3 = 0;
        int media4 = 0;
        int media5 = 0;
        int mediaGeral = 0;


        for (int i = 0; i < medias.length; i++) {
            System.out.println("Digite a nota 1 para a matéria "+(i+1));
            medias[i][0] = userInput.nextInt();

            System.out.println("Digite a nota 2 para a matéria "+(i+1));
            medias[i][1] = userInput.nextInt();

            System.out.println("Digite a nota 3 para a matéria "+(i+1));
            medias[i][2] = userInput.nextInt();

            System.out.println("Digite a nota 4 para a matéria "+(i+1));
            medias[i][3] = userInput.nextInt();

        }
        media1 = (medias[0][0] + medias[0][1] + medias[0][2] + medias[0][3])/medias[0].length;
        System.out.println("Media 1: "+media1);
        media2 = (medias[1][0] + medias[1][1] + medias[1][2] + medias[1][3])/medias[0].length;
        System.out.println("Media 2: "+media2);
        media3 = (medias[2][0] + medias[2][1] + medias[2][2] + medias[2][3])/medias[0].length;
        System.out.println("Media 3: "+media3);
        media4 = (medias[3][0] + medias[3][1] + medias[3][2] + medias[3][3])/medias[0].length;
        System.out.println("Media 4: "+media4);
        media5 = (medias[4][0] + medias[4][1] + medias[4][2] + medias[4][3])/medias[0].length;
        System.out.println("Media 5: "+media5);

        mediaGeral = (media1 + media2 + media3 + media4 + media5)/5;
        System.out.println(mediaGeral);
    }
}
