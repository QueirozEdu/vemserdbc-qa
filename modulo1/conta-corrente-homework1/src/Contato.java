public class Contato {
    String descricao;
    String telefone;
    int tipo;

    public void imprimirContato() {
        String saidaTipo = "";
        switch (tipo) {
            case 1:
                saidaTipo = "Residencial";
            case 2:
                saidaTipo = "Comercial";
        }
        System.out.println("Contato: " +descricao+ "\nTelefone " +saidaTipo+ ":" +telefone);
    }
}
