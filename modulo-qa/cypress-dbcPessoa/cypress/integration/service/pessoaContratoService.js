import Ajv from "ajv";
const ajv = new Ajv;

const API_BASE = Cypress.env('API_BASE');
const TOKEN = 'eyJhbGciOiJIUzI1NiJ9.eyJpc3MiOiJ2ZW1zZXItYXBpIiwianRpIjoiMiIsImNhcmdvcyI6WyJST0xFX0FETUlOIiwiUk9MRV9NQVJLRVRJTkciLCJST0xFX1VTVUFSSU8iXSwiaWF0IjoxNjY4NzI5MDQ1LCJleHAiOjE2Njg4MTU0NDV9.YdFSk9QuFziiSRpXyHrwqr09phaJUAmHS0_ZC4D9wBo'

export default class ContratoPessoa {
    contratoRequest(contrato) {
        cy.request({
            method: 'GET',
            url: `${API_BASE}/pessoa`,
            headers: {
                Authorization: `Bearer ${TOKEN}`
            },
            failOnStatusCode: false
        }).then((response) => {
            //pegar o arquivo schema pasta fixtures e passar como parametro 
            cy.fixture(contrato).then((contrato) => {
                //compilar o arquivo, (jsonSchema)
                const validate = ajv.compile(contrato)

                //response da api (validacoes)
                const valid = validate(response.body)

                //validar erro
                if (!valid) cy.log(validate.errors).then(() => {
                    throw new Error('Falha do contrato')
                })
            })
        })
    }

    contratoCpfRequest(contrato, cpf) {
        cy.request({
            method: 'GET',
            url: `${API_BASE}/pessoa/${cpf}/cpf`,
            headers: {
                Authorization: `Bearer ${TOKEN}`
            },
            failOnStatusCode: false
        }).then((response) => {
            //pegar o arquivo schema pasta fixtures e passar como parametro 
            cy.fixture(contrato).then((contrato) => {
                //compilar o arquivo, (jsonSchema)
                const validate = ajv.compile(contrato)

                //response da api (validacoes)
                const valid = validate(response.body)
                //validar erro
                if (!valid) cy.log(validate.errors).then(() => {
                    console.log(response.body);
                    throw new Error('Falha do contrato')
                })
            })
        })
    }

    contratoPessoaRelatorio(contrato, id) {
        cy.request({
            method: 'GET',
            url: `${API_BASE}/pessoa/relatorio`,
            qs: {
                "idPessoa": id
            },
            headers: {
                Authorization: `Bearer ${TOKEN}`
            },
            failOnStatusCode: false
        }).then((response) => {
            //pegar o arquivo schema pasta fixtures e passar como parametro 
            cy.fixture(contrato).then((contrato) => {
                //compilar o arquivo, (jsonSchema)
                const validate = ajv.compile(contrato)

                //response da api (validacoes)
                const valid = validate(response.body)
                //validar erro
                if (!valid) cy.log(validate.errors).then(() => {
                    console.log(response.body);
                    throw new Error('Falha do contrato')
                })
            })
        })
    }
    contratoPessoaListaCompleta(contrato, id) {
        cy.request({
            method: 'GET',
            url: `${API_BASE}/pessoa/lista-completa`,
            qs: {
                "idPessoa": id
            },
            headers: {
                Authorization: `Bearer ${TOKEN}`
            },
            failOnStatusCode: false
        }).then((response) => {
            //pegar o arquivo schema pasta fixtures e passar como parametro 
            cy.fixture(contrato).then((contrato) => {
                //compilar o arquivo, (jsonSchema)
                const validate = ajv.compile(contrato)

                //response da api (validacoes)
                const valid = validate(response.body)
                //validar erro
                if (!valid) cy.log(validate.errors).then(() => {
                    console.log(response.body);
                    throw new Error('Falha do contrato')
                })
            })
        })
    }

    contratoPessoaListaEndereco(contrato, id) {
        cy.request({
            method: 'GET',
            url: `${API_BASE}/pessoa/lista-com-enderecos`,
            qs: {
                "idPessoa": id
            },
            headers: {
                Authorization: `Bearer ${TOKEN}`
            },
            failOnStatusCode: false
        }).then((response) => {
            //pegar o arquivo schema pasta fixtures e passar como parametro 
            cy.fixture(contrato).then((contrato) => {
                //compilar o arquivo, (jsonSchema)
                const validate = ajv.compile(contrato)

                //response da api (validacoes)
                const valid = validate(response.body)
                //validar erro
                if (!valid) cy.log(validate.errors).then(() => {
                    console.log(response.body);
                    throw new Error('Falha do contrato')
                })
            })
        })
    }

    contratoListaComContato(contrato, id) {
        cy.request({
            method: 'GET',
            url: `${API_BASE}/pessoa/lista-com-contatos`,
            qs: {
                "idPessoa": id
            },
            headers: {
                Authorization: `Bearer ${TOKEN}`
            },
            failOnStatusCode: false
        }).then((response) => {
            //pegar o arquivo schema pasta fixtures e passar como parametro 
            cy.fixture(contrato).then((contrato) => {
                //compilar o arquivo, (jsonSchema)
                const validate = ajv.compile(contrato)

                //response da api (validacoes)
                const valid = validate(response.body)
                //validar erro
                if (!valid) cy.log(validate.errors).then(() => {
                    console.log(response.body);
                    throw new Error('Falha do contrato')
                })
            })
        })
    }
    contratoListaPorNome(contrato, nome) {
        cy.request({
            method: 'GET',
            url: `${API_BASE}/pessoa/byname`,
            qs: {
                "nome": nome
            },
            headers: {
                Authorization: `Bearer ${TOKEN}`
            },
            failOnStatusCode: false
        }).then((response) => {
            //pegar o arquivo schema pasta fixtures e passar como parametro 
            cy.fixture(contrato).then((contrato) => {
                //compilar o arquivo, (jsonSchema)
                const validate = ajv.compile(contrato)

                //response da api (validacoes)
                const valid = validate(response.body)
                //validar erro
                if (!valid) cy.log(validate.errors).then(() => {
                    console.log(response.body);
                    throw new Error('Falha do contrato')
                })
            })
        })
    }

}