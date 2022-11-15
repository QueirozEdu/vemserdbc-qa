package br.com.Itera.pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
//
//import static br.com.AutomationPractice.pages.BasePage.click;
//import static br.com.AutomationPractice.pages.BasePage.sendKeys;

public class LoginPage extends BasePage {
    String emailLogin = "usuariodeteste@exemplo.com";
    String senhaLogin = "senhaDificil**888///";


    //MAPEAMENTO
    private static final By campoUsername =
            By.cssSelector("#username");

    private static final By campoSenha =
            By.cssSelector("#password");

    private static final By btnLogin =
            By.cssSelector("#customer_login > div.u-column1.col-1 > form > p:nth-child(3) > input.woocommerce-Button.button");

    @Step("escrever no campo login")
    public void escreverNoCampoLogin() {
        sendKeys(campoUsername, emailLogin);

    }
    public void escreverNoCampoSenha(){
        sendKeys(campoSenha, senhaLogin);
    }
    public void clicarBotaoLogin(){
        click(btnLogin);
    }



}
