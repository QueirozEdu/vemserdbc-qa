package br.com.dbccompany.aceitacao;


import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.CoreMatchers.containsString;
import br.com.dbccompany.dto.ResponseDTO;
import br.com.dbccompany.dto.UserPayloadDTO;
import br.com.dbccompany.service.UserService;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class UserAceitacaoTeste {
    String jsonBody = lerJson("src/test/resources/data/user1.json");
    UserService service = new UserService();

    public UserAceitacaoTeste() throws IOException {

    }

    public String lerJson(String caminhoJson) throws IOException {
        return new String(Files.readAllBytes(Paths.get(caminhoJson)));
    }

    @Test
    public void testeDeveCriarUsuarioComArray() throws IOException{

        String jsonBody = lerJson("src/test/resources/data/user1.json");


        ResponseDTO resultBody = service.adicionarComArray(jsonBody);

        Assert.assertEquals(resultBody.getCode(), "200");
        Assert.assertEquals(resultBody.getType(), "unknown");
        Assert.assertEquals(resultBody.getMessage(), "ok");
    }
    @Test
    public void testeTentarCriarUsuarioComArrayVazio() throws IOException {

        ResponseDTO resultBody = service.adicionarComArray("");

        Assert.assertEquals(resultBody.getCode(), "405");
        Assert.assertEquals(resultBody.getType(), "unknown");

    }

    @Test
    public void testeDeveConsultarUsuarioPorUsername() throws IOException {

        String username = "Alice007";

        UserPayloadDTO resultService = service.consultarUserPorNome(username);

        Assert.assertEquals(resultService.getId(), "25485499855");
        Assert.assertEquals(resultService.getUsername(), "Alice007");
        Assert.assertEquals(resultService.getFirstName(), "Alice");
        Assert.assertEquals(resultService.getLastName(), "Barbuda");
        Assert.assertEquals(resultService.getEmail(), "alice@exemplo.com");
        Assert.assertEquals(resultService.getPhone(), "555-859-452");
        Assert.assertEquals(resultService.getUserStatus(), 0);
//        Assert.assertEquals(resultService.getStatusCode(), "200");
    }

    @Test
    public void testeDeveConsultarUsuarioInexistentePorUsername() throws IOException {
        String username = "nomeInexistente";

        ResponseDTO resultService = service.consultarUsuarioInexistente(username);

        Assert.assertEquals(resultService.getCode(), "1");
        Assert.assertEquals(resultService.getType(), "error");
        Assert.assertEquals(resultService.getMessage(), "User not found");
    }

    @Test
    public void testeDeveAtualizarUserPassandoUsername() throws IOException {
        String username = "Alice007";

        String jsonBody = lerJson("src/test/resources/data/user2.json");


        ResponseDTO resultService = service.atualizarUserPorUsername(username, jsonBody);

        Assert.assertEquals(resultService.getCode(), "200");
        Assert.assertEquals(resultService.getType(), "unknown");
        Assert.assertEquals(resultService.getMessage(), "747474");
    }

    @Test
    public void testeDeveTentarAtualizarUserInexistente() throws IOException {
        String username = "not_a_user";

        String jsonBody = lerJson("src/test/resources/data/user2.json");


        ResponseDTO resultService = service.atualizarUserPorUsername(username, jsonBody);

        Assert.assertEquals(resultService.getCode(), "404");
        Assert.assertEquals(resultService.getType(), "unknown");

    }

    @Test
    public void testeDeveDelatarUsuario() throws IOException {


        String jsonBody = lerJson("src/test/resources/data/user3.json");
        ResponseDTO resultBody = service.adicionarComArray(jsonBody);

        Assert.assertEquals(resultBody.getCode(), "200");
        Assert.assertEquals(resultBody.getType(), "unknown");
        Assert.assertEquals(resultBody.getMessage(), "ok");

        String username = "Prim009";
        ResponseDTO resultBody1 = service.deletarUser(username);

        Assert.assertEquals(resultBody1.getCode(), "200");
        Assert.assertEquals(resultBody1.getType(), "unknown");

    }

    @Test
    public void testeDeveTentarDeletarUsuarioInexistente() throws IOException {
        String username = "Primdfsd009";
        ResponseDTO resultBody1 = service.deletarUser(username);


        Assert.assertEquals(resultBody1.getCode(), "200");
        Assert.assertEquals(resultBody1.getType(), "unknown");
//        Assert.assertEquals(resultService.getType(), "unknown");
    }

    @Test
    public void testeDeveFazerLogin() {
        String username = "Alice007";
        String password = "12345aa";

        ResponseDTO resultBody = service.fazerLogin(username, password);

        Assert.assertEquals(resultBody.getCode(), "200");
        Assert.assertEquals(resultBody.getType(), "unknown");
        assertThat(resultBody.getMessage(), containsString("logged in user session:"));
    }

    @Test
    public void testeDeveTentarFazerLoginComSenhaIncorreta() throws IOException {

        //Criando novo usuário
        String jsonBody = lerJson("src/test/resources/data/user4.json");
        ResponseDTO resultBody = service.adicionarComArray(jsonBody);
        Assert.assertEquals(resultBody.getCode(), "200");
        Assert.assertEquals(resultBody.getType(), "unknown");
        Assert.assertEquals(resultBody.getMessage(), "ok");

        //Login com senha incorreta
        String username = "Navinda1050";
        String password = "wrongPassword";

        ResponseDTO responseResult = service.fazerLogin(username, password);

        Assert.assertEquals(responseResult.getCode(), "400");

    }

    @Test
    public void testeDeveFazerLogout() {

        ResponseDTO responseResult = service.fazerLogout();

        Assert.assertEquals(responseResult.getCode(), "200");
        Assert.assertEquals(responseResult.getType(), "unknown");
        Assert.assertEquals(responseResult.getMessage(), "ok");
    }

    @Test
    public void testeDeveCriarUsuario() throws IOException{

        String jsonBody = lerJson("src/test/resources/data/user5.json");

        ResponseDTO responseResult = service.criarUsuario(jsonBody);
        Assert.assertEquals(responseResult.getCode(), "200");
        Assert.assertEquals(responseResult.getType(), "unknown");
        Assert.assertNotNull(responseResult.getMessage());

    }

}
