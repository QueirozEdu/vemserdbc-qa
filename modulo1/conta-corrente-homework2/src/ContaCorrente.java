public class ContaCorrente extends Conta implements Impressao {
    private double chequeEspecial;

    public double retornarSaldoComChequeEspecial() {
        return this.getSaldo() + this.chequeEspecial;
    }

    public double setChequeEspecial(double valor) {
        return this.chequeEspecial = valor;
    }

    public ContaCorrente() {}
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
    public boolean depositar(double deposito) {
        if (deposito >= 0) {
            this.setSaldo(this.getSaldo() + deposito);
            return true;
        } else {
            System.out.println("Depósito não realizado");
            return false;
        }
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

    @Override
    public boolean transferir(Conta conta, double valor) {
        if (this.retornarSaldoComChequeEspecial() >= valor && this.retornarSaldoComChequeEspecial() >= 0) {
            conta.setSaldo(conta.getSaldo() + valor);
            this.setSaldo(this.getSaldo() - valor);
            return true;
        }
        else {
            System.out.println("Transferência não realizada pois o valor é maior que: " +this.retornarSaldoComChequeEspecial());
            return false;
        }
    }

    @Override
    public Cliente getCliente(){
        return super.getCliente();
    }
    @Override
    public void setCliente(Cliente cliente) {
        super.setCliente(cliente);
    }

    @Override
    public String getNumeroConta(){
        return super.getNumeroConta();
    }
    @Override
    public void setNumeroConta(String numeroConta){
        super.setNumeroConta(numeroConta);
    }
    @Override
    public String getAgencia(){
        return super.getAgencia();
    }
    @Override
    public void setAgencia(String agencia) {
        super.setAgencia(agencia);
    }
    @Override
    public double getSaldo() {
        return super.getSaldo();
    }
    @Override
    public void setSaldo(double saldo){
        super.setSaldo(saldo);
    }

}





