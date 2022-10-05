public class ContaPagamento extends Conta implements Impressao{
    static final double TAXA_SAQUE = 4.25;
    public ContaPagamento(Cliente cliente, String numeroConta, String agencia, double saldo) {
        super(cliente, numeroConta, agencia, saldo);
    }

    @Override
    public boolean sacar(double valor){
            if (getSaldo() > (valor + TAXA_SAQUE) && valor > 0) {
                super.sacar((valor + 4.25));
                return true;
            } else {
                System.out.println("Saque não realizado");
                return false;
            }
        }
        @Override
        public boolean transferir(Conta conta, double valor) {
            if (super.sacar(valor)){
                conta.depositar(valor);
                return true;
            }
            else {
                System.out.println("Transferência não realizada");
                return false;
            }
        }


    @Override
    public void imprimir() {
        System.out.println("Agência: " +this.getAgencia());
        System.out.println("Conta: " +this.getNumeroConta());
        System.out.println("Saldo: " +this.getSaldo());
    }
}
