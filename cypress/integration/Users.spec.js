//Suite
context('Users', () => {

    //Cenario
    it('GET - Buscar usuário', () => {

        cy.request({
            method: 'GET',
            url: 'https://fakerestapi.azurewebsites.net/api/v1/Users',
            failOnStatusCode: false
        }).as('response').get('@response').should((response) => {
            expect(response.status).to.eq(200);
            expect(response.body[0].id).to.eq(1);
            expect(response.body[0].userName).to.eq("User 1");
            expect(response.body[0].password).to.contain("Password1")
        });
    });

    //Cenario
    it('POST - Inserir usuário', () => {

        cy.request({
            method: 'POST',
            url: 'https://fakerestapi.azurewebsites.net/api/v1/Users',
            body: {
                "id": 0,
                "userName": "Pati Farias",
                "password": "senhaSecreta123"
            },
            failOnStatusCode: false
        }).as('response').get('@response').should((response) => {
            expect(response.status).to.eq(200);
            expect(response.body.id).to.eq(0);
            expect(response.body.userName).to.eq("Pati Farias");
            expect(response.body.password).to.contain("senhaSecreta")
        });
    });

    //Cenario
    it('POST - Tentar inserir usuário vazio', () => {

        cy.request({
            method: 'POST',
            url: 'https://fakerestapi.azurewebsites.net/api/v1/Users',
            body: {},
            failOnStatusCode: false
        }).as('response').get('@response').should((response) => {
            expect(response.status).to.eq(200);
            expect(response.body.id).to.eq(0);
            expect(response.body.userName).to.eq(null);
        });
    });

    //Cenario
    it('GET - Buscar usuário por ID', () => {

        let id = 5;
        cy.request({
            method: 'GET',
            url: `https://fakerestapi.azurewebsites.net/api/v1/Users/${id}`,
            failOnStatusCode: false
        }).as('response').get('@response').should((response) => {
            expect(response.status).to.eq(200);
            expect(response.body.id).to.eq(5);
            expect(response.body.userName).to.eq("User 5");
            expect(response.body.password).to.contain("Password")
        });
    });

    //Cenario
    it('GET - Tentar buscar usuário por ID inválido', () => {

        let id = NaN;
        cy.request({
            method: 'GET',
            url: `https://fakerestapi.azurewebsites.net/api/v1/Users/${id}`,
            failOnStatusCode: false
        }).as('response').get('@response').should((response) => {
            expect(response.status).to.eq(400);
        });
    });

    //Cenario
    it('PUT - Atualizar usuário', () => {

        let id = 5;
        cy.request({
            method: 'PUT',
            url: `https://fakerestapi.azurewebsites.net/api/v1/Users/${id}`,
            body: {
                "id": 5,
                "userName": "Omar Telo",
                "password": "SenhaDificil10"
            },
            failOnStatusCode: false
        }).as('response').get('@response').should((response) => {
            expect(response.status).to.eq(200);
            expect(response.body.id).to.eq(5);
            expect(response.body.userName).to.eq("Omar Telo");
            expect(response.body.password).to.contain("Senha")
        });
    });

    //Cenario
    it('PUT - Tentar atualizar usuário com ID nulo', () => {

        let id = null;
        cy.request({
            method: 'PUT',
            url: `https://fakerestapi.azurewebsites.net/api/v1/Users/${id}`,
            body: {
                "id": 5,
                "userName": "Omar Telo",
                "password": "SenhaDificil10"
            },
            failOnStatusCode: false
        }).as('response').get('@response').should((response) => {
            expect(response.status).to.eq(400);
        });
    });


    //Cenario
    it('PUT - Tentar atualizar usuário com ID válido mas corpo vazio', () => {

        let id = 45;
        cy.request({
            method: 'PUT',
            url: `https://fakerestapi.azurewebsites.net/api/v1/Users/${id}`,
            body: {},
            failOnStatusCode: false
        }).as('response').get('@response').should((response) => {
            expect(response.status).to.eq(200);
            expect(response.body.id).to.eq(0);
        });
    });


    //Cenario
    it('DELETE - Deletar usuário', () => {

        let id = 45;
        cy.request({
            method: 'DELETE',
            url: `https://fakerestapi.azurewebsites.net/api/v1/Users/${id}`,
            body: {},
            failOnStatusCode: false
        }).as('response').get('@response').should((response) => {
            expect(response.status).to.eq(200);
        });
    });

    //Cenario
    it('DELETE - Tentar deletar usuário nulo', () => {

        let id = null;
        cy.request({
            method: 'DELETE',
            url: `https://fakerestapi.azurewebsites.net/api/v1/Users/${id}`,
            body: {},
            failOnStatusCode: false
        }).as('response').get('@response').should((response) => {
            expect(response.status).to.eq(400);
        });
    });
})