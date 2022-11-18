/// <reference types="cypress"/>

import ContratoEndereco from '../../service/enderecoContratoService';
const contratoEndereco = new ContratoEndereco;


context('Endereco Contrato', () => {
    it('Contrato - validar busca de endereço por ID', () => {
        contratoEndereco.contratoEnderecoId("enderecoIdSchema", 191)
    })

    it('Contrato - validar busca de endereços', () => {
        contratoEndereco.buscarEndereco("enderecosSchema")
    })

    it('Contrato - validar busca por país', () => {
        contratoEndereco.contratoBuscarPorPais("enderecoPorPaisSchema", "Brasil")
    })

    it('Contrato - validar busca por id', () => {
        contratoEndereco.contratoBuscaPorId("enderecoPorIdSchema", 4091)
    })

})