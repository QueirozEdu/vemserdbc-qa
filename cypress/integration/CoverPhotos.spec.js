//Suite
context('Cover Photos', () => {

    //Cenario
    it('GET - Buscar capa', () => {

        cy.request({
            method: 'GET',
            url: 'https://fakerestapi.azurewebsites.net/api/v1/CoverPhotos',
            failOnStatusCode: false
        }).as('response').get('@response').should((response) => {
            expect(response.status).to.eq(200);
            expect(response.body[0].id).to.eq(1);
            expect(response.body[0].idBook).to.eq(1);
            expect(response.body[0].url).to.contain("placeholdit")
        });
    });

    it('POST - Inserir capa', () => {

        cy.request({
            method: 'POST',
            url: 'https://fakerestapi.azurewebsites.net/api/v1/CoverPhotos',
            body: {
                "id": 10,
                "idBook": 20,
                "url": "urlplaceholder.com"
            },
            failOnStatusCode: false
        }).as('response').get('@response').should((response) => {
            expect(response.status).to.eq(200);
            expect(response.headers.server).to.eq("Kestrel");
        });
    });

    it('POST - Testar inserir capa com campos vazios', () => {

        cy.request({
            method: 'POST',
            url: 'https://fakerestapi.azurewebsites.net/api/v1/CoverPhotos',
            body: {},
            failOnStatusCode: false
        }).as('response').get('@response').should((response) => {
            expect(response.status).to.eq(400);
        });
    });


    it('GET - Buscar capa por ID', () => {

        let id = 20;
        cy.request({
            method: 'GET',
            url: `https://fakerestapi.azurewebsites.net/api/v1/CoverPhotos/${id}`,
            failOnStatusCode: false
        }).as('response').get('@response').should((response) => {
            expect(response.status).to.eq(200);
            expect(response.body.id).to.eq(20);
            expect(response.body.idBook).to.eq(20);
            expect(response.body.url).to.contain("placeholdit")
        });
    });

    it('GET - Tentar buscar capa por ID inválido', () => {

        let id = null;
        cy.request({
            method: 'GET',
            url: `https://fakerestapi.azurewebsites.net/api/v1/CoverPhotos/${id}`,
            failOnStatusCode: false
        }).as('response').get('@response').should((response) => {
            expect(response.status).to.eq(400);
        });
    });

    it('GET - Buscar capa por ID do livro', () => {

        let id = 20;
        cy.request({
            method: 'GET',
            url: `https://fakerestapi.azurewebsites.net/api/v1/CoverPhotos/books/covers/${id}`,
            failOnStatusCode: false
        }).as('response').get('@response').should((response) => {
            expect(response.status).to.eq(200);
            expect(response.body[0].id).to.eq(20);
            expect(response.body[0].idBook).to.eq(20);
            expect(response.body[0].url).to.contain("placeholdit")
        });
    });

    it('GET - Tentar buscar capa por ID do livro inválido', () => {

        let id = NaN;
        cy.request({
            method: 'GET',
            url: `https://fakerestapi.azurewebsites.net/api/v1/CoverPhotos/books/covers/${id}`,
            failOnStatusCode: false
        }).as('response').get('@response').should((response) => {
            expect(response.status).to.eq(400);
        });
    });

    it('PUT - Atualizar capa do livro', () => {

        let id = 100;
        cy.request({
            method: 'GET',
            url: `https://fakerestapi.azurewebsites.net/api/v1/CoverPhotos/${id}`,
            body: {
                "id": 80,
                "idBook": 30,
                "url": "placeholdit"
            },
            failOnStatusCode: false
        }).as('response').get('@response').should((response) => {
            expect(response.status).to.eq(200);
            expect(response.body.id).to.eq(100);
        });
    });

    it('PUT - Atualizar capa do livro com id Nan', () => {

        let id = NaN;
        cy.request({
            method: 'GET',
            url: `https://fakerestapi.azurewebsites.net/api/v1/CoverPhotos/${id}`,
            body: {
                "id": 80,
                "idBook": 30,
                "url": "placeholdit"
            },
            failOnStatusCode: false
        }).as('response').get('@response').should((response) => {
            expect(response.status).to.eq(400);
        });
    });

    it('DELETE - Deletar capa do livro', () => {

        let id = 10;
        cy.request({
            method: 'DELETE',
            url: `https://fakerestapi.azurewebsites.net/api/v1/CoverPhotos/${id}`,
            failOnStatusCode: false
        }).as('response').get('@response').should((response) => {
            expect(response.status).to.eq(200);
            expect(response.headers.server).to.contain("Kestrel")
        });
    });

    it('DELETE - Tentar deletar capa do livro nulo', () => {

        let id = null;
        cy.request({
            method: 'DELETE',
            url: `https://fakerestapi.azurewebsites.net/api/v1/CoverPhotos/${id}`,
            failOnStatusCode: false
        }).as('response').get('@response').should((response) => {
            expect(response.status).to.eq(400);
        });
    });
})