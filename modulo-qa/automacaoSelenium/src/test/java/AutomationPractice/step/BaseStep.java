package AutomationPractice.step;

import AutomationPractice.util.BrowserSetUp;
import org.junit.After;
import org.junit.Before;


public class BaseStep extends BrowserSetUp {

    @Before
    public void abrirNavegador() {

        browserUp("https://practice.automationtesting.in/");
    }

    @After
    public void fecharNavegador() {
        browserDown();
    }
}
