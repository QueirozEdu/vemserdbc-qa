package br.com.automacaobatista.pages;

import org.openqa.selenium.By;

public class ValidarUsuarioPage extends BasePage{

    private static final By testeValidadeNome =
            By.cssSelector("body > div.row > div.col.s9 > div:nth-child(3) > div > p:nth-child(1) > strong");
    private static final By testeValidaUltimoNome =
            By.cssSelector("body > div.row > div.col.s9 > div:nth-child(3) > div > p:nth-child(2) > strong");
    private static final By testeValidaEmail =
            By.cssSelector("body > div.row > div.col.s9 > div:nth-child(3) > div > p:nth-child(3) > strong");
    private static final By testeValidaUniversidade =
            By.cssSelector("body > div.row > div.col.s9 > div:nth-child(3) > div > p:nth-child(4) > strong");
    private static final By testeValidaGenero =
            By.cssSelector("body > div.row > div.col.s9 > div:nth-child(3) > div > p:nth-child(5) > strong");
    private static final By testeValidaProfissao =
            By.cssSelector("body > div.row > div.col.s9 > div:nth-child(3) > div > p:nth-child(6) > strong");
    private static final By testeValidaIdade =
            By.cssSelector("body > div.row > div.col.s9 > div:nth-child(3) > div > p:nth-child(7) > strong");
    private static final By testeValidaEndereco =
            By.cssSelector("body > div.row > div.col.s9 > div:nth-child(3) > div > p:nth-child(8) > strong");
}
