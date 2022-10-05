import java.util.ArrayList;
import java.util.List;

public class Cliente extends Contato{

    private String nome;
    private String cpf;
    private List<Contato> contatos = new ArrayList<>();
    private List<Endereco> enderecos = new ArrayList<>();


    public Cliente(String nome, String cpf, List<Contato> contatos, List<Endereco> enderecos){
        this.nome = nome;
        this.cpf = cpf;
        this.contatos = contatos;
        this.enderecos = enderecos;
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

    public List<Contato> getContatos() {
        return contatos;
    }

    public List<Endereco> getEnderecos() {
        return enderecos;
    }

    public void setEnderecos(ArrayList<Endereco> enderecos) {
        this.enderecos = enderecos;
    }

    public void setContatos(ArrayList<Contato> contatos) {
        this.contatos = contatos;
    }

    public void imprimirContatos(){
        if (contatos != null){
            for (int i = 0; i < contatos.size(); i++) {
                if (contatos.get(i) != null){
                    contatos.get(i).imprimirContato();
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
