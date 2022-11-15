package br.com.automacaobatista.pages;

import org.openqa.selenium.By;

public class CriarUserPage extends BasePage{


    //MAPEAMENTO

    private static final By botaoFormulario =
            By.cssSelector("body > div.row > div.col.s3 > ul > li:nth-child(1) > a");

    private static final By botaoCriarUsuario =
            By.cssSelector("body > div.row > div.col.s3 > ul > li.bold.active > div > ul > li:nth-child(1) > a");

    private static final By campoNome =
            By.cssSelector("#user_name");

    private static final By campoUltimoNome =
            By.cssSelector("#user_lastname");

    private static final By campoEmail =
            By.cssSelector("#user_email");

    private static final By campoEndereco =
            By.cssSelector("#user_address");

    private static final By campoUniversidade =
            By.cssSelector("#user_university");

    private static final By campoProfissao =
            By.cssSelector("#user_profile");

    private static final By campoGenero =
            By.cssSelector("#user_gender");

    private static final By campoIdade =
            By.cssSelector("#user_age");

    private static final By btnCriar =
            By.cssSelector("#new_user > div:nth-child(7) > div > div > input[type=submit]");




    public void clicarCampoFormulario() {
        click(botaoFormulario);
    }
    public void clicarBotaoCriarUsuario() {
        click(botaoCriarUsuario);
    }

    public void escreverCampoNome(String nome) {
        sendKeys(campoNome, nome);
    }
    public void escreverCampoUltimoNome(String ultimoNome) {
        sendKeys(campoUltimoNome, ultimoNome);
    }
    public void escreverCampoEmail(String email) {
        sendKeys(campoEmail, email);
    }
    public void escreverCampoEndereco(String endereco) {
        sendKeys(campoEndereco, endereco);
    }
    public void escreverCampoUniversidade(String universidade){
        sendKeys(campoUniversidade, universidade);
    }
    public void escreverCampoProfissao(String profissao) {
        sendKeys(campoProfissao, profissao);
    }
    public void escreverCampoGenero(String genero){
        sendKeys(campoGenero, genero);
    }
    public void escreverCampoIdade(String idade) {
        sendKeys(campoIdade, idade);
    }

    public void clicarBotaoCriar() {
        click(btnCriar);
    }
}
