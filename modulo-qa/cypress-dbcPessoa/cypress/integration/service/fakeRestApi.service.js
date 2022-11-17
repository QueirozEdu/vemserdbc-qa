import Ajv from "ajv";
const ajv = new Ajv;

const API_BASE = Cypress.env('API_BASE');
const TOKEN = Cypress.env('TOKEN');

export default class Contrato {
    contratoRequest(contrato) {
        cy.request({
            method: 'GET',
            url: `${API_BASE}/api/v1/Activities`,
            failOnStatusCode: false
        }).then((response) => {
            //pegar o arquivo schema pasta fixtures e passar como parametro 
            cy.fixture(contrato).then((contrato) => {
                //compilar o arquivo, (jsonSchema)
                const validate = ajv.compile(contrato)

                //response da api (validacoes)
                const response = validade(response.body)

                //validar erro
                if (!responseApi) cy.log(validade.errors).then(() => {
                    throw new Error('Falha do contrato')
                })
            })
        })
    }
}