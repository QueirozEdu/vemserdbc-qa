
public class Cliente extends Contato{

    private String nome;
    private String cpf;
    private Contato[] contatos = new Contato[2];
    private Endereco[] enderecos = new Endereco[2];

    public Cliente(){}
    public Cliente(String nome, String cpf, Contato contato1, Contato contato2, Endereco endereco1, Endereco endereco2){
        this.nome = nome;
        this.cpf = cpf;
        this.contatos[0] = contato1;
        this.contatos[1] = contato2;
        this.enderecos[0] = endereco1;
        this.enderecos[1] = endereco2;
    }

    public String getNome() {
        return this.nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

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

    public void setEnderecos(int tipo, String logradouro, int numero, String complemento, String cep, String cidade, String estado, String pais) {
        if (tipo == 1){
            this.enderecos[0].setTipo(tipo);
            this.enderecos[0].setLogradouro(logradouro);
            this.enderecos[0].setNumero(numero);
            this.enderecos[0].setComplemento(complemento);
            this.enderecos[0].setCidade(cidade);
            this.enderecos[0].setEstado(estado);
            this.enderecos[0].setPais(pais);
        } else if (tipo == 2) {
            this.enderecos[1].setTipo(tipo);
            this.enderecos[1].setLogradouro(logradouro);
            this.enderecos[1].setNumero(numero);
            this.enderecos[1].setComplemento(complemento);
            this.enderecos[1].setCidade(cidade);
            this.enderecos[1].setEstado(estado);
            this.enderecos[1].setPais(pais);
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
