import Contato from "../../service/contatoService";
const contato = new Contato;
const contatoPayload = require('../../../fixtures/contato.payload.json')
const token = 'eyJhbGciOiJIUzI1NiJ9.eyJpc3MiOiJ2ZW1zZXItYXBpIiwianRpIjoiMiIsImNhcmdvcyI6WyJST0xFX0FETUlOIiwiUk9MRV9VU1VBUklPIiwiUk9MRV9NQVJLRVRJTkciXSwiaWF0IjoxNjY4NzA0NTA2LCJleHAiOjE2Njg3OTA5MDZ9.tif5n9lSs5B13vW5cokhlwv7yOJKugF0bemELENQrp8';

context('Contato', () => {

    it('GET - Listar contatos', () => {
        contato.contatoRequest(token)
            .then((response) => {
                expect(response.status).to.eq(200)
                expect(response.body).length.to.be.greaterThan(5)
            })
    });

    it('POST - Cadastrar novo contato', () => {
        contato.contatoCadastro(token, contatoPayload[0].idPessoa, contatoPayload[0])
            .then((response) => {
                expect(response.status).to.eq(200)
                expect(response.body.idPessoa).to.eq(contatoPayload[0].idPessoa)
            })
    });

    it('POST - Tentar cadastrar novo contato com id inexistente', () => {
        contato.contatoCadastro(token, 10, contatoPayload[0])
            .then((response) => {
                expect(response.status).to.eq(404);
            })
    });

    it('GET - Listar contato por id', () => {
        contato.contatoBuscarId(token, contatoPayload[0].idPessoa)
            .then((response) => {
                expect(response.status).to.eq(200);
                expect(response.body[0].idPessoa).to.eq(contatoPayload[0].idPessoa);
                expect(response.body[0].tipoContato).to.eq("RESIDENCIAL")
                expect(response.body[0]).to.have.any.keys("idContato")
            })
    });

    it('GET - Tentar listar contato por id inexistente', () => {
        contato.contatoBuscarId(token, 10)
            .then((response) => {
                expect(response.status).to.eq(404);
            })
    });

    it('PUT - Atualizar contato', () => {
        contato.contatoAtualizar(token, contatoPayload[1].idContato, contatoPayload[0])
            .then((response) => {
                expect(response.status).to.eq(200)
            })
    });

    it('PUT - Tentar atualizar contato com id inválido', () => {
        contato.contatoAtualizar(token, '01', contatoPayload[0])
            .then((response) => {
                expect(response.status).to.eq(404)
            })
    });

    it('DELETE - Deletar contato', () => {
        contato.contatoDeletar(token, "204")
            .then((response) => {
                expect(response.status).to.eq(200);
            })
    });

    it('DELETE - Tentar deletar contato com id inválido', () => {
        contato.contatoDeletar(token, "01")
            .then((response) => {
                expect(response.status).to.eq(404);
            })
    });
})