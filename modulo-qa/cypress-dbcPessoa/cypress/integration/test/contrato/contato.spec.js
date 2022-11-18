/// <reference types="cypress"/>
import ContratoContato from '../../service/contatoContratoService';
const contratoContato = new ContratoContato;


context('Endereco Contrato', () => {
    it('Contrato - validar listar contatos', () => {
        contratoContato.listarContatos("contatoSchema")
    })
})