import java.util.List;
public class Main {
    public static void main(String[] args) {


        Contato contato1Pedro = new Contato("Número pessoal", "(84) 458-365-154", 1);
        Contato contato2Pedro = new Contato("Número comercial", "(84) 258-147-369", 2);
        Endereco endereco1Pedro = new Endereco("Avenida Europa", 155, "Casa da esquina", "55487-988", "Petrolina", "Pernambuco", "Brasil");
        Endereco endereco2Pedro = new Endereco("Rua dos Ladrilhos", 22, "Próximo ao farol", "45878-010", "Petrolina", "Pernambuco", "Brasil");
        Cliente pedro = new Cliente("Pedro", "524.365.152-78", List.of(contato1Pedro, contato2Pedro), List.of(endereco1Pedro, endereco2Pedro));



        Contato contato1Maria = new Contato("Número pessoal", "(44) 785-542-365", 1);
        Contato contato2Maria = new Contato("Número comercial", "(44) 452-745-777", 2);
        Endereco endereco1Maria = new Endereco("Loteamento América", 253, "Próximo ao posto", "44740-854", "Jaboatão", "Pernambuco", "Brasil");
        Endereco endereco2Maria = new Endereco("Avenida Laranjeiras", 84, "Condomínio das flores", "55421-748", "Jaboatão", "Pernambuco", "Brasil");

        Cliente maria = new Cliente("Maria", "052.698.547-98", List.of(contato1Maria, contato2Maria), List.of(endereco1Maria, endereco2Maria));




        ContaCorrente contac1 = new ContaCorrente(pedro, "7458-4", "2546-9", 2000, 500);
        ContaCorrente contac2 = new ContaCorrente(maria, "4458-7", "8745-0", 5000, 2000);
        ContaPoupanca contap1 = new ContaPoupanca(pedro, "7458-98", "2546-1", 50000);
        ContaPoupanca contap2 = new ContaPoupanca(maria, "4622-77", "8745-1", 25000);
        ContaPagamento contapg1 = new ContaPagamento(pedro, "6533-8", "7845-2", 100.0);
        ContaPagamento contapg2 = new ContaPagamento(maria, "4587-8", "1254-6", 50.0);



//
//        contac1.imprimir();
//        contac2.imprimir();
//        contap1.imprimir();
//        contap2.imprimir();
//
//        //Teste transferência
//        contac1.transferir(contac2, 1000);
//        contac2.transferir(contac1, 2000);
//        contap1.imprimir();
//        contac2.imprimir();
//        //Fim teste transferência
//
//        //Teste depósito
//        contap1.depositar(500);
//        System.out.println(contap1.getSaldo());
//        //Fim teste depósito
//
//        //Teste saque
//        contac2.sacar(230);
//        System.out.println(contac2.getSaldo());
//        //Fim teste saque
//
//        //Teste creditar taxa
//        System.out.println(contap2.getSaldo());
//        contap2.creditarTaxa();
//        System.out.println(contap2.getSaldo());
//

        //Testes conta pagamento

        //Saque
        contapg1.sacar(10.0);
        System.out.println(contapg1.getSaldo());
        contapg2.sacar(10.0);
        System.out.println(contapg2.getSaldo());


        //Depósito
        contapg1.depositar(500);
        System.out.println(contapg1.getSaldo());
        contapg2.depositar(200);
        System.out.println(contapg2.getSaldo());

        //Transferência
        contapg1.transferir(contapg2, 100);
        System.out.println(contapg1.getSaldo());
        System.out.println(contapg2.getSaldo());
        contapg2.transferir(contapg1, 100);
        System.out.println(contapg1.getSaldo());
        System.out.println(contapg2.getSaldo());


    }

}