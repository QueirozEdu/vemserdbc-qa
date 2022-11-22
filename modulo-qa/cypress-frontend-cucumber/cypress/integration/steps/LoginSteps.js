/// <reference types = "cypress"/>

import LoginPage, {
    botaoPaginaLogin,
    loginBtn,
    msgmBoasBindas,
    msgmLogin,
    password,
    username
} from "../pages/LoginPage";

import BasePage from "../pages/BasePage"
const basePage = new BasePage;


Given("que estou na pagina de login", () => {
    basePage.click(botaoPaginaLogin)
})

And("que preencho o username valido", () => {
    basePage.limparInput(username);
    basePage.preencherInput(username, 'teste123');

});

And("que preencho a senha valida", () => {
    basePage.limparInput(password);
    basePage.preencherInput(password, '12345');
});

When("clico em login", () => {
    basePage.click(loginBtn);
});

And("que preencho um username invalido", () => {
    basePage.limparInput(username);
    basePage.preencherInput(username, "notUser")
})

And("que preencho a senha invalida", () => {
    basePage.limparInput(password);
    basePage.preencherInput(password, 'notPassword');
})

Then("devo visualizar uma mensagem de boas vindas", () => {
    basePage.validarText(msgmBoasBindas, "Welcome")
})

Then("devo visualizar uma mensagem de login invalido", () => {
    basePage.validarText(msgmLogin, "Wrong username or password")
})