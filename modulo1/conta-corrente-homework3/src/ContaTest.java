import org.testng.annotations.Test;

import org.testng.AssertJUnit.*;

import static org.testng.AssertJUnit.*;

public class ContaTest extends ContaCorrente{
     ContaCorrente conta1 = new ContaCorrente(null, "25", "54", 51.0, 25.0);
    @Test
    public void deveTestarSaqueContaCorrenteSemSaldo() {
        //Variaveis
        final double SALDO = 50;
        conta1.setSaldo(SALDO);
        double saque = 1000;

        //Ação

        boolean retorno = conta1.sacar(saque);


        //Verificação
        assertFalse(retorno);
        assertEquals(SALDO, conta1.getSaldo());
    }
}
