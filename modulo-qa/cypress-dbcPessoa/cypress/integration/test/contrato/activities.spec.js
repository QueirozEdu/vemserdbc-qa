/// <reference types="cypress"/>

import ContratoPessoa from '../../service/pessoaContratoService';
const contratoPessoa = new ContratoPessoa;


context('Contrato activities', () => {
    it('Contrato - validar contrato activities', () => {
        contratoPessoa.contratoRequest("pessoaSchema")
    })

    it('Contrato - validar busca por cpf', () => {
        contratoPessoa.contratoCpfRequest("pessoaCpfSchema", 12545214)
    });

    it('Contrato - validar busca de relatório', () => {
        contratoPessoa.contratoPessoaRelatorio("pessoaRelatorioSchema", 4343)
    });

    it('Contrato - validar busca de lista completa', () => {
        contratoPessoa.contratoPessoaListaCompleta("pessoaListaCompletaSchema", 4343)
    });

    it('Contrato - validar busca de pessoa com endereço', () => {
        contratoPessoa.contratoListaComContato("pessoaComContatoSchema", 4343)
    });

    it('Contrato - validar busca por nome', () => {
        contratoPessoa.contratoListaPorNome("pessoaBuscaNomeSchema", 4343)
    });

});