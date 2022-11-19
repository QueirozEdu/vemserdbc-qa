import Ajv from "ajv";
const ajv = new Ajv({
    allErrors: true,
    verbose: true
});


const API_BASE = Cypress.env('API_BASE');
const TOKEN = 'eyJhbGciOiJIUzI1NiJ9.eyJpc3MiOiJ2ZW1zZXItYXBpIiwianRpIjoiMiIsImNhcmdvcyI6WyJST0xFX1VTVUFSSU8iLCJST0xFX0FETUlOIiwiUk9MRV9NQVJLRVRJTkciXSwiaWF0IjoxNjY4NzkzNzA4LCJleHAiOjE2Njg4ODAxMDh9.Olj_48TPpjW52lLj2FzRAqToFNIZnHTviOT2_WQbgDU'

export default class ContratoContato {

    listarContatos(contrato) {
        cy.request({
            method: 'GET',
            url: `${API_BASE}/contato`,
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
}