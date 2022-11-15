package AutomationPractice.step;


import AutomationPractice.pages.LoginPage;
import AutomationPractice.util.BrowserSetUp;
import com.github.javafaker.Faker;

import org.hamcrest.MatcherAssert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.testng.AssertJUnit;

import java.util.concurrent.TimeUnit;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.MatcherAssert.assertThat;

public class LoginStep extends BaseStep {

    LoginPage loginPage = new LoginPage();

    @Test
    public void validarCampoLoginComUserSenhaValidos(){
        loginPage.escreverNoCampoLogin();
        loginPage.escreverNoCampoSenha();
        loginPage.clicarBotaoLogin();

    }















//    Faker fake = new Faker();
//
//    @Test
//    public void logarComUsuarioCadastrado() {
//        BrowserSetUp.driver.findElement(By.cssSelector("#menu-item-50 > a")).click();
//        BrowserSetUp.driver.manage().timeouts().implicitlyWait(200, TimeUnit.MILLISECONDS);
//        String url = BrowserSetUp.driver.getCurrentUrl();
//        String urlAnuncio = "https://practice.automationtesting.in/#google_vignette";
//
//        //Verifica se foi redirecionado para a pagina do anuncio
//        if (url.equals(urlAnuncio)) {
//            BrowserSetUp.driver.get("https://practice.automationtesting.in/my-account/");
//        }
//
//        String emailLogin = "usuariodeteste@exemplo.com";
//        BrowserSetUp.driver.findElement(By.id("username")).sendKeys(emailLogin);
//        String senhaLogin = "senhaDificil**888///";
//        BrowserSetUp.driver.findElement(By.id("password")).sendKeys(senhaLogin);
//        BrowserSetUp.driver.findElement(By.cssSelector("#customer_login > div.u-column1.col-1 > form > p:nth-child(3) > input.woocommerce-Button.button")).click();
//
//        MatcherAssert.assertThat(BrowserSetUp.driver.findElement(By.cssSelector("#page-36 > div > div.woocommerce > div > p:nth-child(1)")).getText(), containsString("Hello") );
//    }
//
//    @Test
//    public void tentarLogarComUsuarioNaoCadastrado() {
//        BrowserSetUp.driver.findElement(By.cssSelector("#menu-item-50 > a")).click();
//        BrowserSetUp.driver.manage().timeouts().implicitlyWait(200, TimeUnit.MILLISECONDS);
//        String url = BrowserSetUp.driver.getCurrentUrl();
//        String urlAnuncio = "https://practice.automationtesting.in/#google_vignette";
//
//        //Verifica se foi redirecionado para a pagina do anuncio
//        if (url.equals(urlAnuncio)) {
//            BrowserSetUp.driver.get("https://practice.automationtesting.in/my-account/");
//        }
//
//        String emailLogin = "usernaocadastrado@email.com";
//        BrowserSetUp.driver.findElement(By.id("username")).sendKeys(emailLogin);
//        String senhaLogin = "senhaDificil**888///";
//        BrowserSetUp.driver.findElement(By.id("password")).sendKeys(senhaLogin);
//        BrowserSetUp.driver.findElement(By.cssSelector("#customer_login > div.u-column1.col-1 > form > p:nth-child(3) > input.woocommerce-Button.button")).click();
//
//        AssertJUnit.assertEquals(BrowserSetUp.driver.getCurrentUrl(), "https://practice.automationtesting.in/my-account/");
//        MatcherAssert.assertThat(BrowserSetUp.driver.findElement(By.cssSelector("#page-36 > div > div.woocommerce > ul > li")).getText(), containsString("Error: A user could not be found with this email address."));
//    }
//
//    @Test
//    public void tentarLogarSemDigitarCampos() {
//        BrowserSetUp.driver.findElement(By.cssSelector("#menu-item-50 > a")).click();
//        BrowserSetUp.driver.manage().timeouts().implicitlyWait(200, TimeUnit.MILLISECONDS);
//        String url = BrowserSetUp.driver.getCurrentUrl();
//        String urlAnuncio = "https://practice.automationtesting.in/#google_vignette";
//
//        //Verifica se foi redirecionado para a pagina do anuncio
//        if (url.equals(urlAnuncio)) {
//            BrowserSetUp.driver.get("https://practice.automationtesting.in/my-account/");
//        }
//
//        String emailLogin = "";
//        BrowserSetUp.driver.findElement(By.id("username")).sendKeys(emailLogin);
//        String senhaLogin = "";
//        BrowserSetUp.driver.findElement(By.id("password")).sendKeys(senhaLogin);
//        BrowserSetUp.driver.findElement(By.cssSelector("#customer_login > div.u-column1.col-1 > form > p:nth-child(3) > input.woocommerce-Button.button")).click();
//
//        AssertJUnit.assertEquals(BrowserSetUp.driver.getCurrentUrl(), "https://practice.automationtesting.in/my-account/");
//        MatcherAssert.assertThat(BrowserSetUp.driver.findElement(By.cssSelector("#page-36 > div > div.woocommerce > ul > li")).getText(), containsString("Error: Username is required."));
//    }

}
