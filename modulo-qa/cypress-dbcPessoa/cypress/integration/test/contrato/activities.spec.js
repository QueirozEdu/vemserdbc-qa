import Activities from '../../service/fakeRestApi.service'
const activities = new Activities;


context('Contrato activities', () => {
    it('Contrato - validar contrato activities', () => {
        activities.contratoRequest("activities.contrato")
    })
});