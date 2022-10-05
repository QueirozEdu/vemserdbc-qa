public interface Movimentacao {
    public boolean sacar(double saque);

    public boolean depositar(double deposito);

    public boolean transferir(Conta conta, double valor);

    void imprimir();
}
