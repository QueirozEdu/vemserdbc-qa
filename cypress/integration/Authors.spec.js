//Suite
context('Authors', () => {

    //Cenario
    it('GET - Buscar Autores', () => {

        cy.request({
            method: 'GET',
            url: 'https://fakerestapi.azurewebsites.net/api/v1/Authors',
            failOnStatusCode: false
        }).as('response').get('@response').should((response) => {
            expect(response.status).to.eq(200);
            expect(response.body[0].id).to.eq(1);
            expect(response.body[0].idBook).to.eq(1);
            expect(response.body[0].firstName).to.contain("First Name")
        });
    });

    //Cenario
    it('POST - Inserir autor', () => {
        cy.request({
            method: 'POST',
            url: 'https://fakerestapi.azurewebsites.net/api/v1/Authors',
            body: {
                "id": 30,
                "idBook": 30,
                "firstName": "Sujiro",
                "lastName": "Kesuma"
            },
            failOnStatusCode: false
        }).as('response').get('@response').should((response) => {
            expect(response.status).to.eq(200);
            expect(response.headers.server).to.contain("Kestrel");
            expect(response.body.id).to.eq(30);
            expect(response.body.idBook).to.eq(30);
        });
    });

    //Cenario
    it('POST - Tentar inserir autor com dados inválidos', () => {
        cy.request({
            method: 'POST',
            url: 'https://fakerestapi.azurewebsites.net/api/v1/Authors',
            body: {

            },
            failOnStatusCode: false
        }).as('response').get('@response').should((response) => {
            expect(response.status).to.eq(400);
        });
    });


    //Cenario
    it('GET - Buscar livro específico de autor', () => {
        let id = 10;
        cy.request({
            method: 'GET',
            url: `https://fakerestapi.azurewebsites.net/api/v1/Authors/authors/books/${id}`,
            failOnStatusCode: false
        }).as('response').get('@response').should((response) => {
            expect(response.status).to.eq(200);
            expect(response.body[0].idBook).to.eq(id);
        });
    });

    //Cenario
    it('GET - Tetar Buscar livro específico de autor com id inválido', () => {
        let id = 888888;
        cy.request({
            method: 'GET',
            url: `https://fakerestapi.azurewebsites.net/api/v1/Authors/authors/books/${id}`,
            failOnStatusCode: false
        }).as('response').get('@response').should((response) => {
            expect(response.status).to.eq(200);
            expect(response.body).to.have.length(0)
        });
    });

    //Cenario
    it('GET - Buscar autor por ID', () => {
        let id = 5;
        cy.request({
            method: 'GET',
            url: `https://fakerestapi.azurewebsites.net/api/v1/Authors/${id}`,
            failOnStatusCode: false
        }).as('response').get('@response').should((response) => {
            expect(response.status).to.eq(200);
            expect(response.body.id).to.eq(5);
            expect(response.body.idBook).to.be.above(1);
            expect(response.body.firstName).to.eq("First Name 5")
            expect(response.body.lastName).to.eq("Last Name 5")
        });
    });

    //Cenario
    it('PUT - Atualizar autor por ID', () => {
        let id = 10;
        cy.request({
            method: 'PUT',
            url: `https://fakerestapi.azurewebsites.net/api/v1/Authors/${id}`,
            body: {
                "id": 50,
                "idBook": 60,
                "firstName": "Alan",
                "lastName": "Brado"
            },
            failOnStatusCode: false
        }).as('response').get('@response').should((response) => {
            expect(response.status).to.eq(200);
            expect(response.body.id).to.eq(50);
            expect(response.body.idBook).to.eq(60);
            expect(response.body.firstName).to.contain("Alan");
            expect(response.body.lastName).to.contain("Brado");

        });
    });

    //Cenario
    it('PUT - Tentar Atualizar autor por ID inválido', () => {
        let id = 10010;
        cy.request({
            method: 'PUT',
            url: `https://fakerestapi.azurewebsites.net/api/v1/Authors/${id}`,
            body: {
                "id": 50,
                "idBook": 60,
                "firstName": "Alan",
                "lastName": "Brado"
            },
            failOnStatusCode: false
        }).as('response').get('@response').should((response) => {
            expect(response.status).to.eq(200);
        });
    });

    //Cenario
    it('DELETE - Deltar autor por ID', () => {
        //Criando autor
        cy.request({
            method: 'POST',
            url: 'https://fakerestapi.azurewebsites.net/api/v1/Authors',
            body: {
                "id": 30,
                "idBook": 30,
                "firstName": "Ema",
                "lastName": "Thomas"
            },
            failOnStatusCode: false
        });

        //Deletando autor
        let id = 30;
        cy.request({
            method: 'DELETE',
            url: `https://fakerestapi.azurewebsites.net/api/v1/Authors/${id}`,
            failOnStatusCode: false
        }).as('response').get('@response').should((response) => {
            expect(response.status).to.eq(200);
            expect(response.headers.server).to.eq("Kestrel")
        });
    });
})