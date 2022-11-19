import Pessoa from "../../service/pessoaService";
const pessoa = new Pessoa;
const pessoaPayload = require('../../../fixtures/pessoa.payload.json')
let token = 'eyJhbGciOiJIUzI1NiJ9.eyJpc3MiOiJ2ZW1zZXItYXBpIiwianRpIjoiMiIsImNhcmdvcyI6WyJST0xFX1VTVUFSSU8iLCJST0xFX0FETUlOIiwiUk9MRV9NQVJLRVRJTkciXSwiaWF0IjoxNjY4NzkzNzA4LCJleHAiOjE2Njg4ODAxMDh9.Olj_48TPpjW52lLj2FzRAqToFNIZnHTviOT2_WQbgDU'
// let token = pessoa.fazerLogin();


context('Pessoa', () => {
    context('Atualizar pessoa', () => {
        it('PUT - Atualizar pessoa', () => {
            cy.allure()
                .epic('Pessoa')
                .feature('Atualiza uma pessoa existente')
                .story('Dados corretos')
            pessoa.pessoaRequest(pessoaPayload[0], 107, token)
                .then((response) => {
                    expect(response.status).to.eq(200)
                    expect(response.body.nome).to.eq("Gabriel O Pescador");
                    expect(response.body.dataNascimento).to.eq("1994-12-08");
                    expect(response.body.cpf).to.eq("555444");
                    expect(response.body.email).to.eq("gabriel.pescador@dbccompany.com.br");
                })
        });

        it('PUT - Tentar atualizar pessoa com id inválido', () => {
            cy.allure()
                .epic('Pessoa')
                .feature('Atualiza uma pessoa com id inválido')
                .story('Id inválido')
            pessoa.pessoaRequest(pessoaPayload[0], 555, token)
                .then((response) => {
                    expect(response.status).to.eq(404)

                })
        });
    })
    context('Adicionar pessoa', () => {

        it('POST - Adicionar pessoa', () => {
            cy.allure()
                .epic('Pessoa')
                .feature('Adiciona uma pessoa')
                .story('Dados corretos')
            pessoa.pessoaCriar(pessoaPayload[1], token)
                .then((response) => {
                    expect(response.status).to.eq(200);
                    expect(response.body.nome).to.eq("Igor Dinho")
                    expect(response.body.cpf).to.eq("741258");
                    expect(response.body.email).to.eq("igor.dinho@dbccompany.com.br")
                })
        });

        it('POST - Tentar adicionar pessoa vazio', () => {
            cy.allure()
                .epic('Pessoa')
                .feature('Adiciona uma pessoa com dados vazios')
                .story('Dados vazios')
            pessoa.pessoaCriar('{}', token)
                .then((response) => {
                    expect(response.status).to.eq(400);
                    expect(response.body.status).to.eq(400)
                })
        });
    })

    context('Deletar pessoa', () => {

        it('DELETE - Deletar pessoa', () => {
            cy.allure()
                .epic('Pessoa')
                .feature('Deleta uma pessoa existente')
                .story('Dados corretos')
            //Criando nova pessoa
            let id = 0;
            pessoa.pessoaCriar(pessoaPayload[1], token)
                .then((response) => {
                    id = response.body.idPessoa;
                    //Deletando pessoa
                    pessoa.pessoaDeletar(id, token)
                        .then((response) => {
                            expect(response.status).to.eq(200);
                        })
                });
        })

        it('DELETE - Tentar deletar pessoa inexistente', () => {
            cy.allure()
                .epic('Pessoa')
                .feature('Tenta deletar uma pessoa inexistente')
                .story('Dados corretos')
            pessoa.pessoaDeletar(555555, token)
                .then((response) => {
                    expect(response.status).to.eq(404);
                })
        });
    })
    context('Listar pessoas', () => {

        it('GET - Listar pessoas', () => {
            cy.allure()
                .epic('Pessoa')
                .feature('Lista os dados de todas as pessoas')
                .story('Dados corretos')
            pessoa.pessoaListar(token)
                .then((response) => {
                    expect(response.status).to.eq(200);
                    expect(response.body.totalElements).to.be.greaterThan(10)
                })
        });

        //Erro - API não está retornando o body da requisição
        it('GET - Buscar pessoa por cpf', () => {
            cy.allure()
                .epic('Pessoa')
                .feature('Lista pessoas por CPF')
                .story('Dados corretos')
            let cpf = pessoaPayload[0].cpf;
            pessoa.pessoaBuscarCpf(cpf, token)
                .then((response) => {
                    expect(response.status).to.eq(200);
                    expect(response.body.nome).to.eq("Gabriel o Pescador")
                })

        });

        //Erro - API retorna OK para cpf inexistente
        it('GET - Tentar buscar pessoa por cpf inválido', () => {
            cy.allure()
                .epic('Pessoa')
                .feature('Tentar listar pessoa com CPF inválido')
                .story('CPF inválido')
            let cpf = NaN;
            pessoa.pessoaBuscarCpf(cpf, token)
                .then((response) => {
                    expect(response.status).to.eq(404);

                })

        });

        it('GET - Buscar relatório', () => {
            cy.allure()
                .epic('Pessoa')
                .feature('Busca o relatório completo de uma pessoa')
                .story('Dados corretos')
            let id = 119;
            pessoa.pessoaRelatorio(id, token)
                .then((response) => {
                    expect(response.status).to.eq(200)
                    expect(response.body[0].idPessoa).to.eq(119)
                    expect(response.body[0].nomePessoa).to.eq("Werner")
                    expect(response.body[0].email).to.eq("adrianne.dibbert@yahoo.com")
                })

        });

        it('GET - Tentar buscar relatório com id inválido', () => {
            cy.allure()
                .epic('Pessoa')
                .feature('Tenta buscar o relatório completo de uma pessoa passando Id inválido')
                .story('Id inválido')
            let id = 1;
            pessoa.pessoaRelatorio(id, token)
                .then((response) => {
                    expect(response.status).to.eq(200)
                    expect(response.body).to.have.length(0)
                })

        });

        it('GET - Buscar lista completa', () => {
            cy.allure()
                .epic('Pessoa')
                .feature('Busca a lista completa de uma pessoa')
                .story('Dados corretos')
            let id = 119;
            pessoa.pessoaListaCompleta(id, token)
                .then((response) => {
                    expect(response.status).to.eq(200)
                    expect(response.body[0].idPessoa).to.eq(119)
                    expect(response.body[0].nome).to.eq("Werner")
                    expect(response.body[0].email).to.eq("adrianne.dibbert@yahoo.com")
                })

        });

        it('GET - Tentar buscar lista completa com id inválido', () => {
            cy.allure()
                .epic('Pessoa')
                .feature('Tenta buscar a lista de uma pessoa passando Id inválido')
                .story('Id inválido')
            let id = 1;
            pessoa.pessoaListaCompleta(id, token)
                .then((response) => {
                    expect(response.status).to.eq(200)
                    expect(response.body).to.have.length(0)
                })
        });

        it('GET - Buscar pessoa com endereços', () => {
            cy.allure()
                .epic('Pessoa')
                .feature('Busca uma pessoa com endereço')
                .story('Dados corretos')
            let id = 119;
            pessoa.pessoaListaComEndereco(id, token)
                .then((response) => {
                    expect(response.status).to.eq(200);
                    expect(response.body[0]).to.have.any.keys('enderecos')
                })

        });

        it('GET - Tentar buscar pessoa com endereços passando id inválido', () => {
            cy.allure()
                .epic('Pessoa')
                .feature('Tenta buscar uma pessoa com endereço passando ID inválido')
                .story('Id inválido')
            let id = 0;
            pessoa.pessoaListaComEndereco(id, token)
                .then((response) => {
                    expect(response.status).to.eq(404);
                })
        });

        it('GET - Buscar pessoa com contato', () => {
            cy.allure()
                .epic('Pessoa')
                .feature('Busca pessoa com contatos')
                .story('Dados corretos')
            let id = 119;
            pessoa.pessoaListarComContato(id, token)
                .then((response) => {
                    expect(response.status).to.eq(200);
                    expect(response.body[0]).to.have.any.keys('contatos')
                })

        });

        it('GET - Tentar buscar pessoa com contatos passando id inválido', () => {
            cy.allure()
                .epic('Pessoa')
                .feature('Tenta buscar uma pessoa com contatos passando Id inválido')
                .story('Id inválido')
            let id = 0;
            pessoa.pessoaListarComContato(id, token)
                .then((response) => {
                    expect(response.status).to.eq(404);
                })
        });

        it('GET - Listar pessoas por nome', () => {
            cy.allure()
                .epic('Pessoa')
                .feature('Lista pessoas por nome')
                .story('Dados corretos')
            let nome = 'Gabriel'
            pessoa.pessoaListarPorNome(nome, token)
                .then((response) => {
                    expect(response.status).to.eq(200)
                    expect(response.body).length.to.be.greaterThan(1)
                })
        });

        it('GET - Tentar buscar pessoa por nome inválido', () => {
            cy.allure()
                .epic('Pessoa')
                .feature('Tenta listar pessoas com nome inválido')
                .story('Nome inválido')
            let nome = 'SemNome'
            pessoa.pessoaListarPorNome(nome, token)
                .then((response) => {
                    expect(response.status).to.eq(200)
                    console.log(response.body);
                    expect(response.body).to.be.empty
                })
        });

    })
})