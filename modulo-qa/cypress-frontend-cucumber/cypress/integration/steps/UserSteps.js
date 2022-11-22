/// <reference types = "cypress"/>

import LoginPage from "../pages/LoginPage";
const loginPage = new LoginPage

import BasePage from "../pages/BasePage";
const basePage = new BasePage;
import {
    faker
} from '@faker-js/faker';
import UserPage, {
    campoName,
    createBtn,
    nomeCriado,
    campoBusca,
    botaoBusca,
    editBtn,
    campoCompany,
    campoAddress,
    campoCity,
    campoPhone,
    campoEmail,
    saveButton,
    nomeAnterior,
    confirmDelete,
    noMatchText
} from "../pages/UserPage";

const userPage = new UserPage;
let createNewBtn = "body > div > form > div > div:nth-child(9) > div > input";
let nome;
let novoNome;

Given("que estou logado", () => {
    loginPage.loginNoSistema();
})

And("que clico em create user", () => {
    basePage.click(createBtn)
})

And("que preencho todos os campos validos", () => {
    nome = userPage.criarUsuarioComCamposCorretos();
})

When("clico em create", () => {
    basePage.click(createNewBtn)
})

Then("devo ver usuario criado", () => {
    basePage.limparInput(campoBusca);
    basePage.preencherInput(campoBusca, nome);
    basePage.click(botaoBusca);
})

And("que nao preencho os campos obrigatorios", () => {
    userPage.validarCriarUsuarioVazio();
})

Then("nao devo criar usuario", () => {
    userPage.buscarUsuarioVazio();
})


And("que crio um usuario corretamente", () => {
    basePage.click(createBtn)
    nome = userPage.criarUsuarioComCamposCorretos();
    basePage.click(createNewBtn)
})

And("que clico em editar", () => {
    userPage.buscarNome(nome);
    basePage.click(editBtn)
})

And("preencho todos os campos corretamente", () => {
    basePage.limparInput(campoName)
    basePage.limparInput(campoCompany)
    basePage.limparInput(campoAddress)
    basePage.limparInput(campoCity)
    basePage.limparInput(campoPhone)
    basePage.limparInput(campoEmail)

    novoNome = faker.name.firstName()
    basePage.preencherInput(campoName, novoNome);
    basePage.preencherInput(campoCompany, faker.company.name());
    basePage.preencherInput(campoAddress, faker.address.street());
    basePage.preencherInput(campoCity, faker.address.cityName());
    basePage.preencherInput(campoPhone, faker.phone.number());
    basePage.preencherInput(campoEmail, faker.internet.email());
})

When("clico em salvar", () => {
    basePage.click(saveButton)
})

Then("devo ter editado um usuario", () => {
    userPage.buscarNome(novoNome);
    basePage.validarText(nomeCriado, novoNome)
})

Then("nao devo ter editado o usuario", () => {
    userPage.buscarNome(nome);
    basePage.validarText(nomeCriado, nome)
})

And("clico em Deletar", () => {
    userPage.deletarUsuario(nome);
})

And("clico em confirmar Deletar", () => {
    basePage.click(confirmDelete);
})

Then("devo ter deletado o usuario", () => {
    userPage.buscarNome(nome);
    basePage.validarText(noMatchText, "No Match")
})