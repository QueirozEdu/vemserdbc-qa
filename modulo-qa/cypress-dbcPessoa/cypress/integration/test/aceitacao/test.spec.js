import Pessoa from "../../service/pessoaService";
const pessoa = new Pessoa;
const pessoaPayload = require('../../../fixtures/pessoa.payload.json')
let token = 'eyJhbGciOiJIUzI1NiJ9.eyJpc3MiOiJ2ZW1zZXItYXBpIiwianRpIjoiMiIsImNhcmdvcyI6WyJST0xFX1VTVUFSSU8iLCJST0xFX01BUktFVElORyIsIlJPTEVfQURNSU4iXSwiaWF0IjoxNjY4NjU3ODgwLCJleHAiOjE2Njg3NDQyODB9.beqOeZRPmSjO3J8vDLggfQ5nJYirltWtsMVdEHkUJkM'
// let token = pessoa.fazerLogin();


context('Pessoa', () => {
    it('PUT - Atualizar pessoa', () => {
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
        pessoa.pessoaRequest(pessoaPayload[0], 555, token)
            .then((response) => {
                expect(response.status).to.eq(404)

            })
    });

    it('POST - Adicionar pessoa', () => {
        pessoa.pessoaCriar(pessoaPayload[1], token)
            .then((response) => {
                expect(response.status).to.eq(200);
                expect(response.body.nome).to.eq("Igor Dinho")
                expect(response.body.cpf).to.eq("741258");
                expect(response.body.email).to.eq("igor.dinho@dbccompany.com.br")
            })
    });

    it('POST - Tentar adicionar pessoa vazio', () => {
        pessoa.pessoaCriar('{}', token)
            .then((response) => {
                expect(response.status).to.eq(400);
                expect(response.body.status).to.eq(400)
            })
    });

    it('DELETE - Deletar pessoa', () => {
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
        pessoa.pessoaDeletar(555555, token)
            .then((response) => {
                expect(response.status).to.eq(404);
            })
    });

    it('GET - Listar pessoas', () => {
        pessoa.pessoaListar(token)
            .then((response) => {
                expect(response.status).to.eq(200);
                expect(response.body.totalElements).to.be.greaterThan(10)
            })
    });

    //Erro - API não está retornando o body da requisição
    it('GET - Buscar pessoa por cpf', () => {
        let cpf = pessoaPayload[0].cpf;
        pessoa.pessoaBuscarCpf(cpf, token)
            .then((response) => {
                expect(response.status).to.eq(200);
                expect(response.body.nome).to.eq("Gabriel o Pescador")
            })

    });

    //Erro - API retorna OK para cpf inexistente
    it('GET - Tentar buscar pessoa por cpf inválido', () => {
        let cpf = NaN;
        pessoa.pessoaBuscarCpf(cpf, token)
            .then((response) => {
                expect(response.status).to.eq(404);

            })

    });

    it('GET - Buscar relatório', () => {
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
        let id = 1;
        pessoa.pessoaRelatorio(id, token)
            .then((response) => {
                expect(response.status).to.eq(200)
                expect(response.body).to.have.length(0)
            })

    });

    it('GET - Buscar lista completa', () => {
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
        let id = 1;
        pessoa.pessoaListaCompleta(id, token)
            .then((response) => {
                expect(response.status).to.eq(200)
                expect(response.body).to.have.length(0)
            })
    });

    it('GET - Buscar pessoa com endereços', () => {
        let id = 119;
        pessoa.pessoaListaComEndereco(id, token)
            .then((response) => {
                expect(response.status).to.eq(200);
                expect(response.body[0]).to.have.any.keys('enderecos')
            })

    });

    it('GET - Tentar buscar pessoa com endereços passando id inválido', () => {
        let id = 0;
        pessoa.pessoaListaComEndereco(id, token)
            .then((response) => {
                expect(response.status).to.eq(404);
            })
    });

    it('GET - Buscar pessoa com endereços', () => {
        let id = 119;
        pessoa.pessoaListarComContato(id, token)
            .then((response) => {
                expect(response.status).to.eq(200);
                expect(response.body[0]).to.have.any.keys('contatos')
            })

    });

    it('GET - Tentar buscar pessoa com contatos passando id inválido', () => {
        let id = 0;
        pessoa.pessoaListarComContato(id, token)
            .then((response) => {
                expect(response.status).to.eq(404);
            })
    });

    it('GET - Listar pessoas por nome', () => {
        let nome = 'Gabriel'
        pessoa.pessoaListarPorNome(nome, token)
            .then((response) => {
                expect(response.status).to.eq(200)
                expect(response.body).length.to.be.greaterThan(1)
            })
    });

    it('GET - Tentar buscar pessoa por nome inválido', () => {
        let nome = 'SemNome'
        pessoa.pessoaListarPorNome(nome, token)
            .then((response) => {
                expect(response.status).to.eq(200)
                console.log(response.body);
                expect(response.body).to.be.empty
            })
    });

})