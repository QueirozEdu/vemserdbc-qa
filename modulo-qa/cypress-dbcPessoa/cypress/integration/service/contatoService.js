const baseUrl = Cypress.env('API_BASE');

export default class Contato {

    contatoRequest(token) {
        return cy.request({
            method: 'GET',
            url: `${baseUrl}/contato`,
            headers: {
                'Content-Type': 'application/json',
                Authorization: `Bearer ${token}`
            },
            failOnStatusCode: false
        })
    }

    contatoCadastro(token, id, payload) {
        return cy.request({
            method: 'POST',
            url: `${baseUrl}/contato/${id}`,
            headers: {
                'Content-Type': 'application/json',
                Authorization: `Bearer ${token}`
            },
            body: payload,
            failOnStatusCode: false
        });
    }

    contatoBuscarId(token, id) {
        return cy.request({
            method: 'GET',
            url: `${baseUrl}/contato/${id}`,
            headers: {
                'Content-Type': 'application/json',
                Authorization: `Bearer ${token}`
            },
            failOnStatusCode: false
        });
    }

    contatoAtualizar(token, id, payload) {
        return cy.request({
            method: 'PUT',
            url: `${baseUrl}/contato/${id}`,
            headers: {
                'Content-Type': 'application/json',
                Authorization: `Bearer ${token}`
            },
            body: payload,
            failOnStatusCode: false
        });
    }

    contatoDeletar(token, id) {
        return cy.request({
            method: 'DELETE',
            url: `${baseUrl}/contato/${id}`,
            headers: {
                'Content-Type': 'application/json',
                Authorization: `Bearer ${token}`
            },
            failOnStatusCode: false
        });
    }
}