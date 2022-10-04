public class ContaPoupanca extends Conta implements Movimentacao {
    static final double JUROS_MENSAL = 1.01;

    public ContaPoupanca(){}
    public ContaPoupanca(Cliente cliente, String numeroConta, String agencia, double saldo){
        super(cliente, numeroConta, agencia, saldo);
    }
    public void creditarTaxa() {
        this.setSaldo(this.getSaldo()* JUROS_MENSAL);
    }

    @Override
    public Cliente getCliente() {
        return super.getCliente();
    }
    @Override
    public boolean sacar(double saque){
        if (saque >= getSaldo()){
            return super.sacar(saque);
        }
        else {
            return false;
        }
    }
    @Override
    public boolean depositar(double deposito) {
        if (deposito >= 0) {
            this.setSaldo(this.getSaldo() + deposito);
            return true;
        }
        else {
            System.out.println("Valor incompatível para depósito");
            return false;
        }
    }
    @Override
    public boolean transferir(Conta conta, double valor){
        if (getSaldo() >= valor && getSaldo() >0){
            this.setSaldo(getSaldo() - valor);
            conta.setSaldo(conta.getSaldo() + valor);
            return true;
        }
        else {
            System.out.println("Transferência não realizada");
            return false;
        }
    }


    public void imprimir() {
        System.out.println("Agência: " +this.getAgencia());
        System.out.println("Conta: " +this.getNumeroConta());
        System.out.println("Saldo: " +this.getSaldo());
    }
}
