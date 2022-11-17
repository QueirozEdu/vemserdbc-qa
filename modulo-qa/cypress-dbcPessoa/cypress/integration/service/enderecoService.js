const baseUrl = Cypress.env('API_BASE');

export default class Endereco {

    criarEndereco(payload, id, token) {
        return cy.request({
            method: 'POST',
            url: `${baseUrl}/endereco/${id}`,
            qs: {
                "idPessoa": id
            },
            headers: {
                'Content-Type': 'application/json',
                Authorization: `Bearer ${token}`
            },
            body: payload,
            failOnStatusCode: false
        })
    }

    buscarEndereco(id, token) {
        return cy.request({
            method: 'GET',
            url: `${baseUrl}/endereco/${id}`,
            headers: {
                'Content-Type': 'application/json',
                Authorization: `Bearer ${token}`
            },
            failOnStatusCode: false
        })
    }

    atualizarEndereco(payload, id, token) {
        return cy.request({
            method: 'PUT',
            url: `${baseUrl}/endereco/${id}`,
            headers: {
                'Content-Type': 'application/json',
                Authorization: `Bearer ${token}`
            },
            body: payload,
            failOnStatusCode: false
        })
    }

    deletarEndereco(id, token) {
        return cy.request({
            method: 'DELETE',
            url: `${baseUrl}/endereco/${id}`,
            headers: {
                'Content-Type': 'application/json',
                Authorization: `Bearer ${token}`
            },
            failOnStatusCode: false
        })
    }

    listarEnderecos(token) {
        return cy.request({
            method: 'GET',
            url: `${baseUrl}/endereco`,
            qs: {
                "pagina": "0",
                "tamanhoDasPaginas": "20"
            },
            headers: {
                Authorization: `Bearer ${token}`
            },
            failOnStatusCode: false
        })
    }

    listarPorPais(pais, token) {
        return cy.request({
            method: 'GET',
            url: `${baseUrl}/endereco/retorna-por-pais`,
            qs: {
                "País": pais,
            },
            headers: {
                Authorization: `Bearer ${token}`
            },
            failOnStatusCode: false
        })
    }

    listarPorId(id, token) {
        return cy.request({
            method: 'GET',
            url: `${baseUrl}/endereco/retorna-por-id-pessoa`,
            qs: {
                "idPessoa": id,
            },
            headers: {
                Authorization: `Bearer ${token}`
            },
            failOnStatusCode: false
        })
    }
}