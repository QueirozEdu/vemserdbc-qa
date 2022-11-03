package br.com.dbccompany.service;


import br.com.dbccompany.dto.UserPayloadDTO;
import br.com.dbccompany.dto.ResponseDTO;
import io.restassured.http.ContentType;


import static io.restassured.RestAssured.*;

public class UserService {
    //Especificar a baseUri
    String baseUri = "https://petstore.swagger.io/v2";


    public ResponseDTO adicionarComArray(String requestBody) {
        ResponseDTO result =
        given()
                .log().all()
                .contentType(ContentType.JSON)
                .body(requestBody)

                .when()
                .post(baseUri + "/user/createWithArray")

                .then()
                .log().all()
                .extract().as(ResponseDTO.class)
                ;

        return result;

    }

    public UserPayloadDTO consultarUserPorNome(String username) {
        UserPayloadDTO result =
                given()
                        .log().all()
                        .pathParam("username", username)

                        .when()
                        .get(baseUri + "/user/{username}")

                        .then()
                        .extract().as(UserPayloadDTO.class)

                ;
        return result;
    }
    public ResponseDTO consultarUsuarioInexistente(String username) {
        ResponseDTO result =
                given()
                        .log().all()
                        .pathParam("username", username)

                        .when()
                        .get(baseUri + "/user/{username}")

                        .then()
                        .extract().as(ResponseDTO.class)
                ;
        return result;
    }

    public ResponseDTO atualizarUserPorUsername(String username, String jsonBody) {
        ResponseDTO result =
                given()
                        .log().all()
                        .contentType(ContentType.JSON)
                        .pathParam("username", username)
                        .body(jsonBody)

                        .when()
                        .put(baseUri + "/user/{username}")

                        .then()
                        .extract().as(ResponseDTO.class)
                ;
        return result;
    }

    public ResponseDTO deletarUser(String username) {
        ResponseDTO result =
                given()
                        .log().all()
                        .pathParam("username", username)

                        .when()
                        .delete(baseUri + "/user/{username}")

                        .then()
                        .extract().as(ResponseDTO.class)
                ;
        return result;
    }

    public ResponseDTO fazerLogin(String username, String password) {
        ResponseDTO result =
                given()
                        .log().all()
                        .pathParam("username", username)
                        .pathParam("password", password)

                        .when()
                        .get(baseUri + "/user/login?username={username}&password={password}")

                        .then()
                        .extract().as(ResponseDTO.class)
                ;
        return result;
    }

    public ResponseDTO fazerLogout() {
        ResponseDTO result =
        given()
                .log().all()

                .when()
                .get(baseUri + "/user/logout")

                .then()
                .extract().as(ResponseDTO.class)
                ;
        return result;
    }

    public UserPayloadDTO atualizarPetPorId(Integer idPet) {
        UserPayloadDTO result =
                given()
                        .log().all()
                        .pathParam("idPet", idPet)

                        .when()
                        .put(baseUri + "/pet/{idPet}")

                        .then()
                        .extract().as(UserPayloadDTO.class)
                ;
        return result;
    }

    public ResponseDTO criarUsuario(String jsonBody) {
        ResponseDTO result =
                given()
                        .log().all()
                        .contentType(ContentType.JSON)
                        .body(jsonBody)

                        .when()
                        .post(baseUri + "/user")

                        .then()
                        .extract().as(ResponseDTO.class)
                ;
        return result;
    }
}
