import java.util.ArrayList;
import java.util.List;

public class Arrays {
    public static void main(String[] args) {
        List<String> listaDeNomes = new ArrayList<>();

        listaDeNomes.add("Donatello");
        listaDeNomes.add("Michelangelo");
        listaDeNomes.add("Rafael");
        listaDeNomes.add("Leonardo");
        listaDeNomes.add("Sandro");
        listaDeNomes.add("Filippo");

        System.out.println("Penúltimo nome: "+listaDeNomes.get(listaDeNomes.size()-2));
        System.out.println("Primeiro nome: "+listaDeNomes.get(0));
        listaDeNomes.remove(listaDeNomes.size()-1);
        System.out.println(listaDeNomes);
        System.out.println("Tamanho: "+listaDeNomes.size());

    }
}
