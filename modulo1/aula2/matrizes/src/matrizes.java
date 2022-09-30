public class matrizes {
    public static void main(String[] args){
        int[][] matriz =
                {
                        {5, 4},
                        {3, 7}
                };
        int somaValores = matriz[0][0] + matriz[0][1] + matriz[1][0]+ matriz[1][1];
        System.out.println(somaValores);

        int somaLinhaUm = matriz[0][0] + matriz[0][1];
        System.out.println(somaLinhaUm);

        int somaLinhaDois = matriz[1][0] + matriz[1][1];
        System.out.println(somaLinhaDois);

        int diferenca = (somaLinhaUm - somaLinhaDois);
        System.out.println(diferenca);
    }
}
