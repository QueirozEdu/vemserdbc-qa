public class ContaCorrente {
    Cliente cliente;
    String numeroConta;
    int agencia;
    double saldo;
    double chequeEspecial;

    public void imprimirContaCorrente() {
        System.out.println(cliente.nome);
        System.out.println("Conta: " +numeroConta);
        System.out.println("Agencia: " +agencia);
        System.out.println("Saldo: " +saldo);
        System.out.println("Cheque especial:" +chequeEspecial);
    }

    public boolean sacar(double valor) {
        if (valor >= saldo || (valor + this.retornarSaldoComChequeEspecial()) >= saldo) {
            this.saldo -= valor;
            System.out.println("Saque realidado");
            return true;
        } else {
            System.out.println("Saque não realizado");
            return false;
        }
    }

    public boolean depositar(double valor) {
        if (valor > 0){
            this.saldo += valor;
            System.out.println("Depósito realizado");
            return true;
        }else {
            System.out.println("Valor incompatível");
            return false;
        }

    }

    public double retornarSaldoComChequeEspecial() {
        double saldoComCheque;
        saldoComCheque = saldo + chequeEspecial;
        return saldoComCheque;
    }

    public boolean transferir(ContaCorrente conta, double valor) {
        if (retornarSaldoComChequeEspecial() >= valor && valor > 0){
            saldo -= valor;
            conta.saldo += valor;
            return true;
        }
        else {
            System.out.println("Transferência não realizada");
            return false;
        }


    }
}
