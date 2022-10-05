public class Main {
    public static void main(String[] args) {

        //Contato residencial e comercial da primeira conta
        Contato pauloTelefoneResidencial = new Contato();
        pauloTelefoneResidencial.tipo = 1;
        pauloTelefoneResidencial.descricao = "Número pessoal";
        pauloTelefoneResidencial.telefone = "59411-8992";
        Contato pauloTelefoneComercial = new Contato();
        pauloTelefoneComercial.tipo = 2;
        pauloTelefoneComercial.descricao = "Número comercial";
        pauloTelefoneComercial.telefone = "555 856 251";

        //Endereço da primeira conta
        Endereco pauloEndereco = new Endereco();
        pauloEndereco.cidade = "São José das Couves";
        pauloEndereco.numero = 222;
        pauloEndereco.tipo = 1;
        pauloEndereco.complemento = "Perto do posto Shell";
        pauloEndereco.logradouro = "Paulo de Tarço";
        pauloEndereco.cep = "42024-658";
        pauloEndereco.estado = "Minas Gerais";
        pauloEndereco.pais = "Brasil";

        //Primeiro cliente
        Cliente paulo = new Cliente();
        paulo.nome = "Paulo de Sá";
        paulo.enderecos[0] = pauloEndereco;
        paulo.contatos[0] = pauloTelefoneResidencial;
        paulo.contatos[1] = pauloTelefoneComercial;
        paulo.cpf = "980.975.430-28";

        //Primeira conta
        ContaCorrente pauloConta = new ContaCorrente();
        pauloConta.cliente = paulo;
        pauloConta.numeroConta = "45224";
        pauloConta.saldo =   709471989;
        pauloConta.chequeEspecial = 444444;
        pauloConta.agencia = 578;





        //Contato residencial e comercial da segunda conta
        Contato saraTelefoneResidencial = new Contato();
        saraTelefoneResidencial.tipo = 1;
        saraTelefoneResidencial.descricao = "Número pessoal";
        saraTelefoneResidencial.telefone = "23511-8552";
        Contato saraTelefoneComercial = new Contato();
        saraTelefoneComercial.tipo = 2;
        pauloTelefoneResidencial.descricao = "Número comercial";
        pauloTelefoneComercial.telefone = "555 425 783";

        //Endereço da segunda conta
        Endereco saraEndereco = new Endereco();
        saraEndereco.cidade = "São João de Meriti";
        saraEndereco.numero = 4815;
        saraEndereco.tipo = 1;
        saraEndereco.complemento = "Na esquina com a Dutra";
        saraEndereco.logradouro = "Brotas";
        saraEndereco.cep = "77063-526";
        saraEndereco.estado = "Bahia";
        saraEndereco.pais = "Brasil";

        //Segundo cliente
        Cliente sara = new Cliente();
        sara.nome = "Sara Dadengue";
        sara.enderecos[0] = saraEndereco;
        sara.contatos[0] = saraTelefoneComercial;
        sara.contatos[1] = saraTelefoneResidencial;
        sara.cpf = "410.698.670-12";

        //Segunda conta
        ContaCorrente saraConta = new ContaCorrente();
        saraConta.numeroConta = "35266";
        saraConta.cliente = sara;
        saraConta.saldo =   75209;
        saraConta.chequeEspecial = 8999;
        saraConta.agencia = 125;




        //Operações
        pauloConta.transferir(saraConta, 400);
        saraConta.sacar(150);
        saraConta.depositar(4545);


        saraConta.transferir(pauloConta, 1000);
        pauloConta.depositar(1500);
        saraConta.sacar(2000);

        pauloConta.imprimirContaCorrente();
        saraConta.imprimirContaCorrente();
    }

}
