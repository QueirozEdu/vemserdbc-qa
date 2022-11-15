//Suite
context('Activity', () => {

    //Cenario
    it('GET - Buscar atividades', () => {

        cy.request({
            method: 'GET',
            url: 'https://fakerestapi.azurewebsites.net/api/v1/Activities',
            failOnStatusCode: false
        }).as('response').get('@response').should((response) => {
            expect(response.status).to.eq(200);
            expect(response.body).to.have.length(30);
            expect(response.body[0].id).to.eq(1);
        });
    });

    //Cenario
    it('GET - Buscar atividade por id', () => {
        let id = 1;
        cy.request({
            method: 'GET',
            url: `https://fakerestapi.azurewebsites.net/api/v1/Activities/${id}`,
            failOnStatusCode: false,
        }).as('response').get('@response').should((response) => {
            expect(response.status).to.eq(200);
            expect(response.body.id).to.eq(1);
            expect(response.body.title).to.eq("Activity 1");
        });
    });

    //Cenario
    it('POST - Criar nova atividade', () => {

        cy.request({
            method: 'POST',
            url: 'https://fakerestapi.azurewebsites.net/api/v1/Activities',
            body: {
                "id": 40,
                "title": "Nova Atividade",
                "dueDate": "2022-11-15T01:31:27.395Z",
                "completed": true
            },
            failOnStatusCode: false
        }).as('response').get('@response').should((response) => {
            expect(response.status).to.eq(200);
        });
    });

    it('PUT - Atualizar atividade', () => {

        let id = 20;
        cy.request({
            method: 'PUT',
            url: `https://fakerestapi.azurewebsites.net/api/v1/Activities/${id}`,
            body: {
                "id": 30,
                "title": "Novo titulo",
                "dueDate": "2022-11-15T02:22:48.011Z",
                "completed": true
            },
            failOnStatusCode: false
        }).as('response').get('@response').should((response) => {
            expect(response.status).to.eq(200);
            expect(response.body.id).to.eq(30);
            expect(response.body.title).to.eq("Novo titulo");
            expect(response.body.dueDate).to.eq("2022-11-15T02:22:48.011Z");
            expect(response.body.completed).to.eq(true);
        });
    });

    it('DELETE - Deletar atividade', () => {
        let id = 15;
        cy.request({
            method: 'DELETE',
            url: `https://fakerestapi.azurewebsites.net/api/v1/Activities/${id}`,
            failOnStatusCode: false
        }).as('response').get('@response').should((response) => {
            expect(response.status).to.eq(200);
            expect(response.headers.server).to.eq("Kestrel");
        });
    });

    it('DELETE - Tentar Deletar Atividade Inexistente', () => {
        let id = 15502;
        cy.request({
            method: 'DELETE',
            url: `https://fakerestapi.azurewebsites.net/api/v1/Activities/${id}`,
            failOnStatusCode: false
        }).as('response').get('@response').should((response) => {
            expect(response.status).to.eq(404);
            expect(response.headers.server).to.eq("Kestrel");
        });
    });
})