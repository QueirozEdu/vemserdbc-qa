public class Endereco {
    int tipo;
    String logradouro;
    int numero;
    String complemento;
    String cep;
    String cidade;
    String estado;
    String pais;

    public void imprimirEndereco() {
        String saida = "";
        switch (tipo){
            case 1:
                saida = "Residencial";
            case 2:
                saida = "Comercial";
        }
        System.out.println("Endereço " +saida+":");
        System.out.println(logradouro);
        System.out.println(numero);
        System.out.println(complemento);
        System.out.println(cep);
        System.out.println(cidade);
        System.out.println(estado);
        System.out.println(pais);
    }
}
