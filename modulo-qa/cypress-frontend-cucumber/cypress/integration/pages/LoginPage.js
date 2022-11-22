import BasePage from "../pages/BasePage";
const basePage = new BasePage;

export let username = '#Username';
export let password = '#Password'
export let loginBtn = "body > div > div:nth-child(4) > form > table > tbody > tr:nth-child(7) > td:nth-child(2) > input.btn.btn-primary"
export let msgmLogin = ".alert-danger"
export let botaoPaginaLogin = '#navbarColor01 > form > ul > li:nth-child(2) > a';
export let msgmBoasBindas = "body > div > div > h3";
export default class LoginPage {


    loginNoSistema() {
        //Navegar para login
        basePage.click(botaoPaginaLogin);

        //Limpando campos
        basePage.limparInput(username);
        basePage.limparInput(password);

        basePage.preencherInput(username, 'teste123');
        basePage.preencherInput(password, '12345');
        basePage.click(loginBtn);
    }

    loginNoSistemaComSenhaErrada() {
        //Navegar para login
        basePage.click(botaoPaginaLogin);

        //Limpando campos
        basePage.limparInput(username);
        basePage.limparInput(password);

        basePage.preencherInput(username, 'teste123');
        basePage.preencherInput(password, '00000');
        basePage.click(loginBtn);
        basePage.validarText(msgmLogin, "Wrong username or password")
    }

    loginComUsuarioErrado() {
        //Navegar para login
        basePage.click(botaoPaginaLogin);

        //Limpando campos
        basePage.limparInput(username);
        basePage.limparInput(password);

        basePage.preencherInput(username, 'usuarioNaoExistente');
        basePage.preencherInput(password, '00000');
        basePage.click(loginBtn);
        basePage.validarText(msgmLogin, "Wrong username or password")
    }
}