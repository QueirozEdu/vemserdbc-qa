import Endereco from "../../service/enderecoService";
const endereco = new Endereco;
const enderecoPayload = require('../../../fixtures/endereco.payload.json')
let token = 'eyJhbGciOiJIUzI1NiJ9.eyJpc3MiOiJ2ZW1zZXItYXBpIiwianRpIjoiMiIsImNhcmdvcyI6WyJST0xFX1VTVUFSSU8iLCJST0xFX01BUktFVElORyIsIlJPTEVfQURNSU4iXSwiaWF0IjoxNjY4NjU3ODgwLCJleHAiOjE2Njg3NDQyODB9.beqOeZRPmSjO3J8vDLggfQ5nJYirltWtsMVdEHkUJkM';


context('Endereço', () => {

    context('Criar novo endereço', () => {
        //Erro - Api deveria retornar código 200
        cy.allure()
            .epic('Endereço')
            .feature('Criar um novo endereço')
            .story('Dados corretos')
        it('POST - Criar novo endereço', () => {
            endereco.criarEndereco(enderecoPayload[0], 2258, token)
                .then((response) => {
                    expect(response.status).to.eq(200);
                })
        });
    })

    context('Buscar endereço', () => {
        cy.allure()
            .epic('Endereço')
            .feature('Buscar endereço')
            .story('Todos os dados corretos')
        it('GET - Buscar endereço inválido', () => {
            endereco.buscarEndereco(20, token)
                .then((response) => {
                    expect(response.status).to.eq(404);
                })
        });
    })

    context('Atualizar endereço', () => {
        cy.allure()
            .epic('Endereço')
            .feature('Atualizar um endereço existente')
            .story('Todos os dados corretos')
        it('PUT - Atualizar endereço', () => {
            endereco.atualizarEndereco(enderecoPayload[1], 2258, token)
                .then((response) => {
                    expect(response.status).to.eq(200);
                    expect(response.body.idPessoa).to.eq(2258);
                    expect(response.body.tipo).to.eq("Residencial");
                    expect(response.body.cidade).to.eq("Salvador");
                })
        });
    })

    context('Deletar endereço', () => {
        cy.allure()
            .epic('Endereço')
            .feature('Deletar um endereço existente')
            .story('Id correto')
        it('DELETE - Deletar endereço', () => {
            endereco.deletarEndereco(225, token)
                .then((response) => {
                    expect(response.status).to.eq(200)
                })
        })

        it('DELETE - Tentar deletar endereço com id inválido', () => {
            cy.allure()
                .epic('Endereço')
                .feature('Tenta deletar um endereço com id inválido')
                .story('ID incorreto')
            endereco.deletarEndereco(1, token)
                .then((response) => {
                    expect(response.status).to.eq(404)
                })
        })
    })

    context('Listar endereço', () => {

        it('GET - Listar endereços', () => {
            cy.allure()
                .epic('Endereço')
                .feature('Listar todos os endereços')
                .story('Todos os dados corretos')
            endereco.listarEnderecos(token)
                .then((response) => {
                    expect(response.status).to.eq(200);
                })

        });

        it('GET - Retorna por país', () => {
            cy.allure()
                .epic('Endereço')
                .feature('Listar endereços por país')
                .story('Todos os dados corretos')
            endereco.listarPorPais("Brasil", token)
                .then((response) => {
                    expect(response.status).to.eq(200);
                    console.log(response.body[0]);
                    expect(response.body[0]).to.have.any.keys('cep')
                })
        });

        it('GET - Retorna por id pessoa', () => {
            cy.allure()
                .epic('Endereço')
                .feature('Listar endereço por ID')
                .story('ID incorreto')
            endereco.listarPorId("Brasil", token)
                .then((response) => {
                    expect(response.status).to.eq(400);
                    expect(response.body).to.be.empty;
                })
        });
    })
})