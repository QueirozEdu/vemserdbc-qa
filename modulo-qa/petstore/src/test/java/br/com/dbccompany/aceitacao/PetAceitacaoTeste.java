package br.com.dbccompany.aceitacao;

import br.com.dbccompany.dto.NoPageDTO;
import br.com.dbccompany.dto.PetPayloadDTO;
import br.com.dbccompany.dto.ResponseDTO;
import br.com.dbccompany.service.PetService;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;

import static java.lang.Integer.parseInt;

public class PetAceitacaoTeste {
    String jsonBody = lerJson("src/test/resources/data/pet1.json");
    PetService service = new PetService();

    public PetAceitacaoTeste() throws IOException {
    }

    public String lerJson(String caminhoJson) throws IOException {
        return new String(Files.readAllBytes(Paths.get(caminhoJson)));
    }

    @Test
    public void testeDeveAdicionarPet() throws IOException{

        String jsonBody = lerJson("src/test/resources/data/pet1.json");


        PetPayloadDTO resultBody = service.adicionarPet(jsonBody);

        Assert.assertEquals(resultBody.getId(), "205413685");
        Assert.assertEquals(resultBody.getName(), "Luke");
        Assert.assertEquals(resultBody.getCategory().getId(), "2");
        Assert.assertEquals(resultBody.getCategory().getName(), "dog");
        Assert.assertEquals(resultBody.getTags().get(0).getId(), "2022");
        Assert.assertEquals(resultBody.getTags().get(0).getName(), "qa");
        Assert.assertEquals(resultBody.getStatus(), "available");


    }



    @Test
    public void testeCriarNovoCachorro() throws IOException {
        String jsonBody = lerJson("src/test/resources/data/pet3.json");


        PetPayloadDTO resultBody = service.adicionarPet(jsonBody);

        Assert.assertEquals(resultBody.getId(), "2222");
        Assert.assertEquals(resultBody.getName(), "Biela");
        Assert.assertEquals(resultBody.getCategory().getId(), "2");
        Assert.assertEquals(resultBody.getCategory().getName(), "dog");
        Assert.assertEquals(resultBody.getTags().get(0).getId(), "2040");
        Assert.assertEquals(resultBody.getTags().get(0).getName(), "Torta");
        Assert.assertEquals(resultBody.getStatus(), "available");
    }
    @Test
    public void testeDeveTentarCriarPetSemNome() throws IOException{
        String jsonBody = lerJson("src/test/resources/data/petSemNome.json");
        PetPayloadDTO resultService = service.adicionarPet(jsonBody);


        //Api não deveria permitir criar Pet com nome null
        Assert.assertEquals(resultService.getStatus(), "400");

    }
    @Test
    public void testeDeveConsultarPetPorId() throws IOException {

        int idPet = 205413685;

        PetPayloadDTO resultService = service.consultaPetPassandoId(idPet);

        Assert.assertEquals(resultService.getId(), "205413685");
        Assert.assertEquals(resultService.getName(), "Luke");
        Assert.assertEquals(resultService.getCategory().getId(), "2");
        Assert.assertEquals(resultService.getCategory().getName(), "dog");
        Assert.assertEquals(resultService.getTags().get(0).getName(), "qa");
        Assert.assertEquals(resultService.getStatus(), "available");
    }

    @Test
    public void atualizarPet() throws IOException {

        //Massa de dadis
        String jsonBody = lerJson("src/test/resources/data/pet3.json");

        //Chama o serviço
        PetPayloadDTO resultBody = service.atualizarPet(jsonBody);

        Assert.assertEquals(resultBody.getId(), "2222");
        Assert.assertEquals(resultBody.getName(), "Biela");
        Assert.assertEquals(resultBody.getTags().get(0).getName(), "Torta");

    }

    @Test
    public void testeDeveDeletarPet() throws IOException{

        //Criando um novo Pet
        Integer idPet = 2323;
        String jsonBody = lerJson("src/test/resources/data/pet4.json");
        PetPayloadDTO resultBody = service.adicionarPet(jsonBody);
        Assert.assertEquals(resultBody.getId(), "2323");
        Assert.assertEquals(resultBody.getName(), "Turbo");
        Assert.assertEquals(resultBody.getTags().get(0).getName(), "3kilo");
        Assert.assertEquals(resultBody.getStatus(), "available");


        //Deletando o Pet criado
        ResponseDTO resultService = service.deletarPet(idPet);
        Assert.assertEquals(resultService.getCode(), "200");
        Assert.assertEquals(resultService.getType(), "unknown");
        Assert.assertEquals(resultService.getMessage(), "2323");
    }

    @Test
    public void testeDeveDeletarPetQueNaoExiste() throws IOException {

        Integer idPet = 226563;


        NoPageDTO resultService = service.deletarPetInexistente(0);

//        Assert.assertEquals(resultService.getType(), "unknown");
//        Assert.assertEquals(resultService.getMessage(), "2323");
    }


    @Test
    public void testeDeveConsultarPetQueNaoExiste() throws IOException {
        Integer idPet = 5558555;

        ResponseDTO resultService = service.consultarPetSemId(idPet);

        Assert.assertEquals(resultService.getCode(), "1");
        Assert.assertEquals(resultService.getType(), "error");
        Assert.assertEquals(resultService.getMessage(), "Pet not found");
    }

    @Test
    public void testeEncontrarPetsDisponiveis() throws IOException {
        String status = "available";

        PetPayloadDTO resultService = service.listarPetsPorStatus(status);

        Assert.assertEquals(resultService.getId(), "0");
//        Assert.assertEquals(resultService.getName(), "doggie");
//        Assert.assertEquals(resultService.getCategory().getId(), "2");
//        Assert.assertEquals(resultService.getCategory().getName(), "dog");
//        Assert.assertEquals(resultService.getTags().get(0).getName(), "dog");
//        Assert.assertEquals(resultService.getStatus(), "available");



    }

}
