public class Endereco {
    private int tipo;
    private String logradouro;
    private int numero;
    private String complemento;
    private String cep;
    private String cidade;
    private String estado;

    public Endereco(){}
    public Endereco(String logradouro, int numero, String complemento, String cep, String cidade, String estado, String pais){
        this.tipo = tipo;
        this.logradouro = logradouro;
        this.numero = numero;
        this.complemento = complemento;
        this.cep = cep;
        this.estado = estado;
        this.pais = pais;
    }

    public int getTipo() {
        return tipo;
    }

    public void setTipo(int tipo) {
        this.tipo = tipo;
    }

    public String getLogradouro() {
        return logradouro;
    }

    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    private String pais;

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
