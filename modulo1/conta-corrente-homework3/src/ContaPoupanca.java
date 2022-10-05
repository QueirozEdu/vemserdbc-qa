public class ContaPoupanca extends Conta implements Movimentacao {
    static final double JUROS_MENSAL = 1.01;


    public ContaPoupanca(Cliente cliente, String numeroConta, String agencia, double saldo){
        super(cliente, numeroConta, agencia, saldo);
    }
    public void creditarTaxa() {
        this.setSaldo(this.getSaldo()* JUROS_MENSAL);
    }

    @Override
    public void imprimir() {
        System.out.println("Agência: " +this.getAgencia());
        System.out.println("Conta: " +this.getNumeroConta());
        System.out.println("Saldo: " +this.getSaldo());
    }
}
