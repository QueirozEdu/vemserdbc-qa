
public class Cliente{
    String nome;
    String cpf;
    Contato[] contatos = new Contato[2];
    Endereco[] enderecos = new Endereco[2];


    public void imprimirContatos(){
        if (contatos != null){
            for (Contato i: contatos) {
                if(i != null){
                    i.imprimirContato();
                }
            }
        }
    }
    public void imprimirEnderecos(){
        if(enderecos != null){
            for (Endereco i:
                    enderecos) {
                if (i != null){
                    i.imprimirEndereco();
                }
            }
        }
    }
    public void imprimirCliente(){
        System.out.println("Nome: " +nome);
        System.out.println("CPF: " +cpf);
        System.out.println("Contatos: ");
        this.imprimirContatos();
        System.out.println("Enderecos");
        this.imprimirEnderecos();
    }

}
