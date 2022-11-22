/// <reference types = "cypress"/>

import LoginPage from "../pages/LoginPage";
const loginPage = new LoginPage


import BasePage from "../pages/BasePage";
const basePage = new BasePage;

import UserPage from "../pages/UserPage";
const userPage = new UserPage;

let createNewBtn = "body > div > div > p:nth-child(4) > a"
context('Usuario', () => {

    it('Criar novo usuario', () => {
        loginPage.loginNoSistema();

        basePage.click(createNewBtn);

        userPage.criarUsuarioComCamposCorretos();
    });

    it('Tentar criar usuário vazio', () => {
        loginPage.loginNoSistema;
        basePage.click;
        userPage.validarCriarUsuarioVazio
    });

    it('Editar usuario', () => {
        loginPage.loginNoSistema();

        basePage.click(createNewBtn);
        userPage.editarUsuarioComCamposCorretos();
    });

    it('Tentar editar usuário sem preencher campos', () => {
        loginPage.loginNoSistema;
        basePage.click(createNewBtn);
        userPage.tentaEditarUsuarioSemPreencherCampos;
    });

    it('Buscar detalhes do usuário', () => {
        loginPage.loginNoSistema()
        basePage.click(createNewBtn);
        userPage.verificarUsuario
    });

    it('Tentar buscar usuário vazio', () => {
        loginPage.loginNoSistema;
        basePage.click(createNewBtn);
        userPage.buscarUsuarioVazio;
    });

    it('Deletar usuário', () => {
        loginPage.loginNoSistema();
        basePage.click(createNewBtn);
        userPage.deletarUsuario;
    });
})