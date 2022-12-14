public class ContaCorrente extends Conta implements Impressao {
    private double chequeEspecial;

    public double retornarSaldoComChequeEspecial() {
        return this.getSaldo() + this.chequeEspecial;
    }

    public double setChequeEspecial(double valor) {
        return this.chequeEspecial = valor;
    }

    public ContaCorrente(Cliente cliente, String numeroConta, String agencia, double saldo, double chequeEspecial) {
        super(cliente, numeroConta, agencia, saldo);
        this.chequeEspecial = chequeEspecial;
    }

    public void imprimir() {
        System.out.println("Conta: " + this.getNumeroConta());
        System.out.println("Nome: " + this.getCliente().getNome());
        System.out.println("Agência número: " + this.getAgencia());
        System.out.println("Saldo: " + this.getSaldo());
        System.out.println("Cheque especial: " + (this.retornarSaldoComChequeEspecial() - this.getSaldo()));
        this.getCliente().getContatos();
        this.getCliente().getEnderecos();
    }




    @Override
    public boolean sacar(double valor) {
        if (valor <= retornarSaldoComChequeEspecial() && valor > 0) {
            setSaldo(getSaldo() - valor);
            return true;
        } else {
            System.out.println("Saque não realizado");
            return false;
        }
    }



}





