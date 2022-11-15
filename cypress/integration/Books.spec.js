//Suite
context('Books', () => {

    //Cenario
    it('GET - Buscar Livros', () => {

        cy.request({
            method: 'GET',
            url: 'https://fakerestapi.azurewebsites.net/api/v1/Books',
            failOnStatusCode: false
        }).as('response').get('@response').should((response) => {
            expect(response.status).to.eq(200);
            expect(response.body[0].id).to.eq(1);
            expect(response.body[0].title).to.eq("Book 1");
            expect(response.body[0].description).to.contain("Lorem");
            expect(response.body[0].pageCount).to.be.above(1);
        });
    });

    //Cenario
    it('POST - Criar livro', () => {

        cy.request({
            method: 'POST',
            url: 'https://fakerestapi.azurewebsites.net/api/v1/Books',
            body: {
                "id": 10,
                "title": "Rapido & Devagar",
                "description": "A Hommel Bier related to a Brewers Reserve requires assistance from the dude",
                "pageCount": 520,
                "excerpt": " The wavy dude reads a magazine, or the keg can be kind to a shabby Long Trail Ale.",
                "publishDate": "2022-11-15T03:54:11.722Z"
            },
            failOnStatusCode: false
        }).as('response').get('@response').should((response) => {
            expect(response.status).to.eq(200);
            expect(response.body.id).to.eq(10);
            expect(response.body.title).to.eq("Rapido & Devagar");
            expect(response.body.description).to.contain("Hommel Bier");
            expect(response.body.pageCount).to.be.above(1);
        });
    });

    //Cenario
    it('POST - Tentar criar livro vazio', () => {

        cy.request({
            method: 'POST',
            url: 'https://fakerestapi.azurewebsites.net/api/v1/Books',
            body: {

            },
            failOnStatusCode: false
        }).as('response').get('@response').should((response) => {
            expect(response.status).to.eq(200);
            expect(response.body.id).to.eq(0);
        });
    });

    //Cenario
    it('GET - Buscar Livro por ID', () => {

        let id = 10;
        cy.request({
            method: 'GET',
            url: `https://fakerestapi.azurewebsites.net/api/v1/Books/${id}`,
            failOnStatusCode: false
        }).as('response').get('@response').should((response) => {
            expect(response.status).to.eq(200);
            expect(response.body.id).to.eq(10);
            expect(response.body.title).to.eq("Book 10");
            expect(response.body.description).to.contain("Lorem");
            expect(response.body.pageCount).to.be.above(1);
        });
    });

    it('GET - Tentar buscar Livro por ID inválido', () => {

        let id = 999999;
        cy.request({
            method: 'GET',
            url: `https://fakerestapi.azurewebsites.net/api/v1/Books/${id}`,
            failOnStatusCode: false
        }).as('response').get('@response').should((response) => {
            expect(response.status).to.eq(404);
        });
    });

    //Cenario
    it('PUT - Atualizar livro', () => {

        let id = 10;
        cy.request({
            method: 'PUT',
            url: `https://fakerestapi.azurewebsites.net/api/v1/Books/${id}`,
            body: {
                "id": 0,
                "title": "O cérebro ansioso",
                "description": "If a Stella Artois cooks cheese grits for a bar tab, then a skinny mating ritual sweeps the floor. ",
                "pageCount": 250,
                "excerpt": "A Kashmir IPA ruminates, but a tipsy Corona recognizes another childlike black",
                "publishDate": "2022-11-15T04:03:54.682Z"
            },
            failOnStatusCode: false
        }).as('response').get('@response').should((response) => {
            expect(response.status).to.eq(200);
            expect(response.body.id).to.eq(0);
            expect(response.body.title).to.eq("O cérebro ansioso");
            expect(response.body.description).to.contain("Stella");
            expect(response.body.pageCount).to.be.above(1);
        });
    });

    //Cenario
    it('PUT - Tentar atualizar livro com ID inválido', () => {

        let id = null;
        cy.request({
            method: 'PUT',
            url: `https://fakerestapi.azurewebsites.net/api/v1/Books/${id}`,
            body: {
                "id": 0,
                "title": "O cérebro ansioso",
                "description": "If a Stella Artois cooks cheese grits for a bar tab, then a skinny mating ritual sweeps the floor. ",
                "pageCount": 250,
                "excerpt": "A Kashmir IPA ruminates, but a tipsy Corona recognizes another childlike black",
                "publishDate": "2022-11-15T04:03:54.682Z"
            },
            failOnStatusCode: false
        }).as('response').get('@response').should((response) => {
            expect(response.status).to.eq(400);
        });
    });

    //Cenario
    it('DELETE - Deletar livro', () => {

        let id = 30;
        cy.request({
            method: 'DELETE',
            url: `https://fakerestapi.azurewebsites.net/api/v1/Books/${id}`,
            failOnStatusCode: false
        }).as('response').get('@response').should((response) => {
            expect(response.status).to.eq(200);
            expect(response.headers.server).to.eq("Kestrel");
        });
    });

    it('DELETE - Testar deletar livro com ID inválido', () => {

        let id = null;
        cy.request({
            method: 'DELETE',
            url: `https://fakerestapi.azurewebsites.net/api/v1/Books/${id}`,
            failOnStatusCode: false
        }).as('response').get('@response').should((response) => {
            expect(response.status).to.eq(400);
        });
    });
})