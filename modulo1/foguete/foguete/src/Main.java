public class Main {

    public static void main(String[] args) {
        Foguete foguete1 = new Foguete();
        foguete1.setCor("prata");
        foguete1.setNivelCombustivel(510);
        foguete1.setFabricante("NASA");

        System.out.println(foguete1.getCor());
        System.out.println(foguete1.getNivelCombustivel());
        System.out.println(foguete1.getFabricante());

    }
}
