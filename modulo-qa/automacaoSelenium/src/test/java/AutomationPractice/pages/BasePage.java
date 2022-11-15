package AutomationPractice.pages;

import br.com.AutomationPractice.step.BaseStep;
import br.com.AutomationPractice.util.Elements;
import org.openqa.selenium.By;

public class BasePage extends Elements {

    public static void click(By by){
        waitElement(by);
        element(by).click();
    }

    public static void sendKeys(By by, String texto) {
        waitElement(by);
        element(by).sendKeys(texto);
    }

    public static String getTexto(By by){
        waitElement(by);
        return element(by).getText();
    }

}
