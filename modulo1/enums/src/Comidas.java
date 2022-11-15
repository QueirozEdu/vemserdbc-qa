public enum Comidas {
    JAPONESA("Japonesa", 50),
    FAST_FOOD("Fast food", 30),
    TRADICIONAL("Tradicional", 20);

    private String nome;
    private int valor;

    Comidas(String nome, int valor){
        this.nome = nome;
        this.valor = valor;
    }

    public String getNome() {
        return nome;
    }

    public int getValor() {
        return valor;
    }
}
