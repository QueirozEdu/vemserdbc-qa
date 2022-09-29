import java.util.Scanner;

public class Exercicio2 {
    public static void main(String[] args) {

        Scanner userInput = new Scanner(System.in);

        System.out.println("Escolha o Estado:");
        System.out.println("1 - Bahia");
        System.out.println("2 - Pernambuco");
        System.out.println("3 - Minas Gerais");
        String escolhaEstado = userInput.next();

        String escolhaCidade = "";
        switch (escolhaEstado) {
            case "1":
                System.out.println("Escolha a cidade:");
                System.out.println("1 - Vitória da Conquista");
                System.out.println("2 - Salvador");
                escolhaCidade = userInput.next();
                break;
            case "2":
                System.out.println("Escolha a cidade:");
                System.out.println("1 - Petrolina");
                System.out.println("2 - Garanhuns");
                escolhaCidade = userInput.next();
                break;
            case "3":
                System.out.println("Escolha a cidade:");
                System.out.println("1 - Belo Horizonte");
                System.out.println("2 - Ouro Preto");
                escolhaCidade = userInput.next();
                break;
        }
        String escolhaFinal = escolhaEstado+escolhaCidade;
        switch (escolhaFinal) {
            case "11":
                System.out.println("População: 341.128");
                System.out.println("IDH: 0.688");
                System.out.println("Atração: Cristo de Mário Cravo. O maior Cristo crucificado do mundo");
                break;
            case "12":
                System.out.println("População: 2.900.319");
                System.out.println("IDH: 0.759");
                System.out.println("Atração: Elevador Lacerda. Primeiro elevador urbano do mundo");
                break;
            case "21":
                System.out.println("População: 354.317");
                System.out.println("IDH: 0.697");
                System.out.println("Ilha do Rodeadouro. Ilha que Medeia Petrolina e Juazeiro");
                break;
            case "22":
                System.out.println("População: 140.577");
                System.out.println("IDH: 0.664");
                System.out.println("Atração: Mosteiro de São Bento. Antigo mosteiro transformado em hotel");
                break;
            case "31":
                System.out.println("População: 2.530.701");
                System.out.println("IDH: 0.810");
                System.out.println("Atração: Lagoa da Pampulha. Principal área de lazer dos moradores");
                break;
            case "32":
                System.out.println("População: 74.558");
                System.out.println("IDH: 0.741");
                System.out.println("Atração: Museu Aleijadinho. Abrange três igrejas históricas da cidade");
                break;
        }
    }
}
