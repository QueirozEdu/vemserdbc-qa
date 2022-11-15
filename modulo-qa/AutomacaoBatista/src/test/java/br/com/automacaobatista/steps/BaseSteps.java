package br.com.automacaobatista.steps;

import br.com.automacaobatista.util.Browser;
import org.junit.After;
import org.junit.Before;

import java.util.concurrent.TimeUnit;

public class BaseSteps extends Browser {
    @Before
    public void abrirNavegador() {
        browserUp("https://automacaocombatista.herokuapp.com/treinamento/home");
        driver.manage().timeouts().implicitlyWait(200, TimeUnit.MILLISECONDS);
    }

    @After
    public void fecharNavegador() {
        browserDown();
    }
}
