package br.com.Itera.step;

import br.com.Itera.pages.LoginPage;

import br.com.Itera.step.BaseSteps;
import io.qameta.allure.Description;
import io.qameta.allure.Step;
import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;

public class LoginSteps extends BaseSteps {

    LoginPage loginPage = new LoginPage();

    @Test
    @Description("Testando fazer login")
    public void validarCampoLoginComUserSenhaValidos(){
        loginPage.escreverNoCampoLogin();
        loginPage.escreverNoCampoSenha();
        loginPage.clicarBotaoLogin();

    }
















}
