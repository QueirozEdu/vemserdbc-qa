import BasePage from "./BasePage";
const basePage = new BasePage;

import {
    faker
} from '@faker-js/faker';


let campoName = "#Name";
let campoCompany = "#Company";
let campoAddress = "#Address";
let campoCity = "#City";
let campoPhone = "#Phone";
let campoEmail = "#Email";

let createBtn = "body > div > form > div > div:nth-child(9) > div > input"
let campoBusca = "#searching"
let botaoBusca = "body > div > div > form > input.btn.btn-secondary.my-2.my-sm-0";

let nomeCriado = "body > div > div > table > tbody > tr:nth-child(2) > td:nth-child(1)";
let editBtn = "body > div > div > table > tbody > tr:nth-child(2) > td:nth-child(7) > a.btn.btn-outline-primary";
let saveButton = "body > div > form > div > div:nth-child(10) > div > input";
let detailsBtn = "body > div > div > table > tbody > tr:nth-child(2) > td:nth-child(7) > a.btn.btn-outline-primary"
let nomeDetalhes = "body > div > div > dl > dt:nth-child(1)";
let deleteBtn = "body > div > div > table > tbody > tr:nth-child(2) > td:nth-child(7) > a.btn.btn-outline-danger";
let confirmDelete = "body > div > div > form > div > input";
let noMatchText = "body > div > div > table > tbody > tr:nth-child(2) > td";

export default class UserPage {

    criarUsuarioComCamposCorretos() {

        //Gera dados
        let nome = faker.name.firstName();
        let empresa = faker.company.name();
        let endereco = faker.address.street();
        let cidade = faker.address.cityName();
        let phone = faker.phone.number();
        let email = faker.internet.email();

        //Preenchendo campos
        basePage.preencherInput(campoName, nome)
        basePage.preencherInput(campoCompany, empresa)
        basePage.preencherInput(campoAddress, endereco)
        basePage.preencherInput(campoCity, cidade)
        basePage.preencherInput(campoPhone, phone)
        basePage.preencherInput(campoEmail, email)

        //Clicando botao CREATE
        basePage.click(createBtn);

        //Validando por busca
        this.buscarNome(nome)

        basePage.validarText(nomeCriado, nome)

        //Deletar usuário
        this.deletarUsuario(nome)

        return nome;
    }

    validarCriarUsuarioVazio() {

        let nome = "";
        let empresa = "";
        let endereco = "";
        let cidade = "";
        let phone = "";
        let email = "";

        basePage.preencherInput(campoName, nome)
        basePage.preencherInput(campoCompany, empresa)
        basePage.preencherInput(campoAddress, endereco)
        basePage.preencherInput(campoCity, cidade)
        basePage.preencherInput(campoPhone, phone)
        basePage.preencherInput(campoEmail, email)

        //Clicando botao CREATE
        basePage.click(createBtn);

        //Validando por busca
        this.buscarNome(nome)

        basePage.validarText(noMatchText, "No match")
    }

    editarUsuarioComCamposCorretos() {
        //Cria novo usuário
        this.criarUsuarioComCamposCorretos();

        //Clica botao editar
        basePage.click(editBtn);

        //Limpa os campos
        basePage.limparInput(campoName)
        basePage.limparInput(campoCompany)
        basePage.limparInput(campoAddress)
        basePage.limparInput(campoCity)
        basePage.limparInput(campoPhone)
        basePage.limparInput(campoEmail)

        //Gera novos dados
        let nome = faker.name.firstName();
        let empresa = faker.company.name();
        let endereco = faker.address.street();
        let cidade = faker.address.cityName();
        let phone = faker.phone.number();
        let email = faker.internet.email();

        //Preenche os campos com os novos dados gerados
        basePage.preencherInput(campoName, nome)
        basePage.preencherInput(campoCompany, empresa)
        basePage.preencherInput(campoAddress, endereco)
        basePage.preencherInput(campoCity, cidade)
        basePage.preencherInput(campoPhone, phone)
        basePage.preencherInput(campoEmail, email)

        basePage.click(saveButton);

        this.buscarNome(nome);
        basePage.validarText(nomeCriado, nome)

        //Deletar usuário
        this.deletarUsuario(nome)
    }

    tentaEditarUsuarioSemPreencherCampos() {
        this.criarUsuarioComCamposCorretos();

        //Clica botao editar
        basePage.click(editBtn);

        //Limpa os campos
        basePage.limparInput(campoName)
        basePage.limparInput(campoCompany)
        basePage.limparInput(campoAddress)
        basePage.limparInput(campoCity)
        basePage.limparInput(campoPhone)
        basePage.limparInput(campoEmail)

        //Gera novos dados
        let nome = "";
        let empresa = "";
        let endereco = "";
        let cidade = "";
        let phone = "";
        let email = "";

        //Preenche os campos com os novos dados gerados
        basePage.preencherInput(campoName, nome)
        basePage.preencherInput(campoCompany, empresa)
        basePage.preencherInput(campoAddress, endereco)
        basePage.preencherInput(campoCity, cidade)
        basePage.preencherInput(campoPhone, phone)
        basePage.preencherInput(campoEmail, email)

        basePage.click(saveButton);

        this.buscarNome(nome);
        basePage.validarText(noMatchText, "No match")
    }

    deletarUsuario(nome) {
        this.buscarNome(nome)
        basePage.click(deleteBtn);
        basePage.click(confirmDelete);

        this.buscarNome(nome);
        basePage.validarText(noMatchText, "No match")
    }

    buscarUsuarioVazio() {
        basePage.limparInput(campoBusca);
        basePage.preencherInput(campoBusca, " ");
        basePage.click(botaoBusca);
        basePage.validarText(noMatchText, "No match")
    }

    verificarUsuario() {
        let nome = this.criarUsuarioComCamposCorretos();
        basePage.click(detailsBtn);
        basePage.validarText(nomeDetalhes, nome)
    }



    buscarNome(nome) {

        basePage.limparInput(campoBusca);
        basePage.preencherInput(campoBusca, nome);
        basePage.click(botaoBusca);

    }

}