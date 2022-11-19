import Contato from "../../service/contatoService";
const contato = new Contato;
const contatoPayload = require('../../../fixtures/contato.payload.json')
const token = 'eyJhbGciOiJIUzI1NiJ9.eyJpc3MiOiJ2ZW1zZXItYXBpIiwianRpIjoiMiIsImNhcmdvcyI6WyJST0xFX0FETUlOIiwiUk9MRV9VU1VBUklPIiwiUk9MRV9NQVJLRVRJTkciXSwiaWF0IjoxNjY4NzA0NTA2LCJleHAiOjE2Njg3OTA5MDZ9.tif5n9lSs5B13vW5cokhlwv7yOJKugF0bemELENQrp8';

const allure = Cypress.Allure.reporter.getInterface();

context('Contato', () => {
    context('Listar contatos', () => {
        it('GET - Listar contatos', () => {
            cy.allure()
                .epic('Contato')
                .feature('Testa listar contatos')
                .story('Todos os dados corretos')
            contato.contatoRequest(token)
                .then((response) => {
                    expect(response.status).to.eq(200)
                    expect(response.body).length.to.be.greaterThan(5)
                })
        });
    })
    context('Cadastrar um contato', () => {

        it('POST - Cadastrar novo contato', () => {
            cy.allure()
                .epic('Contato')
                .feature('Cadastrar um novo contato')
                .story('Todos os dados corretos')
            contato.contatoCadastro(token, contatoPayload[0].idPessoa, contatoPayload[0])
                .then((response) => {
                    expect(response.status).to.eq(200)
                    expect(response.body.idPessoa).to.eq(contatoPayload[0].idPessoa)
                })
        });

        it('POST - Tentar cadastrar novo contato com id inexistente', () => {
            cy.allure()
                .epic('Contato')
                .feature('Tenta cadastrar contato com id inexistente')
                .story('Id inexistente')
            contato.contatoCadastro(token, 10, contatoPayload[0])
                .then((response) => {
                    expect(response.status).to.eq(404);
                })
        });
    })
    context('Listar contato', () => {

        it('GET - Listar contato por id', () => {
            cy.allure()
                .epic('Contato')
                .feature('Listar contato por ID')
                .story('ID correto')
            contato.contatoBuscarId(token, contatoPayload[0].idPessoa)
                .then((response) => {
                    expect(response.status).to.eq(200);
                    expect(response.body[0].idPessoa).to.eq(contatoPayload[0].idPessoa);
                    expect(response.body[0].tipoContato).to.eq("RESIDENCIAL")
                    expect(response.body[0]).to.have.any.keys("idContato")
                })
        });


        it('GET - Tentar listar contato por id inexistente', () => {
            cy.allure()
                .epic('Contato')
                .feature('Tenta listar um contato com ID inexistente')
                .story('ID incorreto')
            contato.contatoBuscarId(token, 10)
                .then((response) => {
                    expect(response.status).to.eq(404);
                })
        });

    })
    context('Atualizar contato', () => {

        it('PUT - Atualizar contato', () => {
            cy.allure()
                .epic('Contato')
                .feature('Atualizar contato')
                .story('Atualiza contato com dados corretos')
            contato.contatoAtualizar(token, contatoPayload[1].idContato, contatoPayload[0])
                .then((response) => {
                    expect(response.status).to.eq(200)
                })
        });


        it('PUT - Tentar atualizar contato com id inválido', () => {
            cy.allure()
                .epic('Contato')
                .feature('Tentar atualizar contato com ID inválido')
                .story('ID inválido')
            contato.contatoAtualizar(token, '01', contatoPayload[0])
                .then((response) => {
                    expect(response.status).to.eq(404)
                })
        });
    })

    context('Deletar contato', () => {

        it('DELETE - Deletar contato', () => {
            cy.allure()
                .epic('Contato')
                .feature('Deletar contato')
                .story('Deletar um contato passando ID')
            contato.contatoDeletar(token, "204")
                .then((response) => {
                    expect(response.status).to.eq(200);
                })
        });


        it('DELETE - Tentar deletar contato com id inválido', () => {
            cy.allure()
                .epic('Contato')
                .feature('Tenta deletar contato com ID inválido')
                .story('ID inválido')
            contato.contatoDeletar(token, "01")
                .then((response) => {
                    expect(response.status).to.eq(404);
                })
        });
    })
})