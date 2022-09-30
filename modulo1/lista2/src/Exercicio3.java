import java.util.Scanner;

public class exercicio3 {
    public static void main(String[] args) {
        Scanner userInput = new Scanner(System.in);
        int contagem = 0;

        String nome = "";
        String maisVelho = "";
        String maisPesado = "";

        float altura = 0;
        float maiorAltura = 0;

        int idade = 0;
        int maiorIdade = 0;

        float peso = 0;
        float maiorPeso = 0;

        float mediaAlturas = 0;

        System.out.println("Digite o nome do jogador");
        nome = userInput.next();

        while (!(nome.equals("sair"))) {

            System.out.println("Digite a altura do jogador");
            altura = userInput.nextFloat();

            System.out.println("Digite a idade do jogador");
            idade = userInput.nextInt();

            System.out.println("Digite o peso do jogador");
            peso = userInput.nextFloat();
            contagem++;
            
            if (altura> maiorAltura){
                maiorAltura = altura;
            }
            if (idade > maiorIdade) {
                maisVelho = nome;
            }
            if (peso > maiorPeso) {
                maisPesado = nome;
            }
            
            mediaAlturas = (mediaAlturas + altura)/contagem;

            System.out.println("Digite o nome do jogador");
            nome = userInput.next();

        }
        System.out.println("Quantidade de jogadores:" + contagem);
        System.out.println("Altura do maior jogador: " +maiorAltura);
        System.out.println("Jogador mais velho: " + maisVelho);
        System.out.println("Jogador mais pesado: " + maisPesado);
        System.out.println("Média das alturas dos jogadores: " + mediaAlturas);



    }
}
