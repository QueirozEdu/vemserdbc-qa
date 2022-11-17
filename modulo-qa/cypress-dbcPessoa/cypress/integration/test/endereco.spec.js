import end from "fortune/lib/request/end";
import Endereco from "../service/enderecoService";
const endereco = new Endereco;
const enderecoPayload = require('../../fixtures/endereco.payload.json')
let token = 'eyJhbGciOiJIUzI1NiJ9.eyJpc3MiOiJ2ZW1zZXItYXBpIiwianRpIjoiMiIsImNhcmdvcyI6WyJST0xFX1VTVUFSSU8iLCJST0xFX01BUktFVElORyIsIlJPTEVfQURNSU4iXSwiaWF0IjoxNjY4NjU3ODgwLCJleHAiOjE2Njg3NDQyODB9.beqOeZRPmSjO3J8vDLggfQ5nJYirltWtsMVdEHkUJkM';


context('Endereço', () => {

    //Erro - Api deveria retornar código 200
    it('POST - Criar novo endereço', () => {
        endereco.criarEndereco(enderecoPayload[0], 2258, token)
            .then((response) => {
                expect(response.status).to.eq(200);
            })
    });

    it('GET - Buscar endereço inválido', () => {
        endereco.buscarEndereco(20, token)
            .then((response) => {
                expect(response.status).to.eq(404);
            })
    });

    it('PUT - Atualizar endereço', () => {
        endereco.atualizarEndereco(enderecoPayload[1], 2258, token)
            .then((response) => {
                expect(response.status).to.eq(200);
                expect(response.body.idPessoa).to.eq(2258);
                expect(response.body.tipo).to.eq("Residencial");
                expect(response.body.cidade).to.eq("Salvador");
            })

    });

    it('DELETE - Deletar endereço', () => {
        endereco.deletarEndereco(225, token)
            .then((response) => {
                expect(response.status).to.eq(200)
            })
    })

    it('DELETE - Tentar deletar endereço com id inválido', () => {
        endereco.deletarEndereco(1, token)
            .then((response) => {
                expect(response.status).to.eq(404)
            })
    })

    it('GET - Listar endereços', () => {
        endereco.listarEnderecos(token)
            .then((response) => {
                expect(response.status).to.eq(200);
            })

    });

    it('GET - Retorna por país', () => {
        endereco.listarPorPais("Brasil", token)
            .then((response) => {
                expect(response.status).to.eq(200);
                console.log(response.body[0]);
                expect(response.body[0]).to.have.any.keys('cep')
            })
    });

    it('GET - Retorna por id pessoa', () => {
        endereco.listarPorId("Brasil", token)
            .then((response) => {
                expect(response.status).to.eq(400);
                expect(response.body).to.be.empty;
            })
    });
})