package br.com.automacaobatista.pages;

import org.openqa.selenium.By;

import static br.com.automacaobatista.util.Elements.element;
import static br.com.automacaobatista.util.Elements.waitElement;

public class BasePage {
    public static void click(By by) {
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
