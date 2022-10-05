
public class Cliente{

    private String nome;
    private String cpf;
    private Contato[] contatos = new Contato[2];
    private Endereco[] enderecos = new Endereco[2];


    public Cliente(String nome, String cpf){
        this.nome = nome;
        this.cpf = cpf;
    }

    public String getNome() {
        return this.nome;
    }

    public void setNome(String nome) { this.nome = nome; }

    public String getCpf() {
        return this.cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public Contato[] getContatos() {
        return contatos;
    }

    public Endereco[] getEnderecos() {
        return enderecos;
    }

    public void setEnderecos(Endereco endereco, int i) {
        if ((i <= enderecos.length-1) && i >= 0) {
            this.enderecos[i] = endereco;
        }
    }
    public void setContatos(Contato contato, int i){
        if (i <= (contatos.length-1) && i >= 0 ) {
            this.contatos[i] = contato;
        }
    }

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
