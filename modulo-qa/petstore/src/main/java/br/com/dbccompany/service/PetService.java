package br.com.dbccompany.service;

import br.com.dbccompany.dto.NoPageDTO;
import br.com.dbccompany.dto.PetPayloadDTO;
import br.com.dbccompany.dto.ResponseDTO;
import io.restassured.http.ContentType;
import io.restassured.response.ValidatableResponse;
import org.jvnet.staxex.BinaryText;

import java.io.IOException;
import java.util.ArrayList;

import static io.restassured.RestAssured.*;

public class PetService {
    //Especificar a baseUri
    String baseUri = "https://petstore.swagger.io/v2";


    public PetPayloadDTO adicionarPet(String requestBody) {
        PetPayloadDTO result =
        given()
                .log().all()
                .contentType(ContentType.JSON)
                .body(requestBody)

                .when()
                .post(baseUri + "/pet")

                .then()
                .log().all()
                .extract().as(PetPayloadDTO.class)
                ;

        return result;

    }

    public PetPayloadDTO consultarPetPorId(Integer idPet) {
        PetPayloadDTO result =
                given()
                        .log().all()
                        .pathParam("idPet", idPet)

                        .when()
                        .get(baseUri + "/pet/{idPet}")

                        .then()
                        .extract().as(PetPayloadDTO.class)

                ;
        return result;
    }

    public PetPayloadDTO atualizarPetPorId(Integer idPet) {
        PetPayloadDTO result =
                given()
                        .log().all()
                        .pathParam("idPet", idPet)

                        .when()
                        .put(baseUri + "/pet/{idPet}")

                        .then()
                        .extract().as(PetPayloadDTO.class)
                ;
        return result;
    }

    public ResponseDTO deletarPet(Integer idPet) {

        ResponseDTO result =
                given()
                        .log().all()
                        .pathParam("idPet", idPet)

                        .when()
                        .delete(baseUri + "/pet/{idPet}")

                        .then()
                        .log().all()
                        .extract().as(ResponseDTO.class)
                ;
        return result;
    }

    public NoPageDTO deletarPetInexistente(Integer idPet) {
        NoPageDTO result =
                given()
                        .log().all()
                        .pathParam("idPet", idPet)

                        .when()
                        .delete(baseUri + "/pet/")

                        .then()
                        .log().all()
                        .extract().as(NoPageDTO.class)
                ;
        return result;
    }

    public PetPayloadDTO atualizarPet(String jsonBody) throws IOException {
        PetPayloadDTO result =
                given()
                        .contentType(ContentType.JSON)
                        .log().all()
                        .body(jsonBody)

                        .when()
                        .put(baseUri + "/pet")

                        .then()
                        .log().all()
                        .statusCode(200)
                        .extract().as(PetPayloadDTO.class)
                ;
        return result;
    }

    public PetPayloadDTO consultaPetPassandoId(Integer idPet) throws IOException {
        PetPayloadDTO result =
                given()
                        .contentType(ContentType.JSON)
                        .log().all()

                        .when()
                        .get(baseUri + "/pet/"+ idPet)

                        .then()
                        .log().all()
//                        .statusCode(200)
                        .extract().as(PetPayloadDTO.class)
                ;
        return result;
    }

    public ResponseDTO consultarPetSemId(Integer idPet) throws IOException {
        ResponseDTO result =
                given()
                        .contentType(ContentType.JSON)
                        .log().all()

                        .when()
                        .get(baseUri + "/pet/" + idPet)

                        .then()
                        .log().all()
                        .extract().as(ResponseDTO.class)
                ;
        return result;
    }

    public PetPayloadDTO listarPetsPorStatus(String status) throws IOException {
        PetPayloadDTO result =
                given()
                        .contentType(ContentType.JSON)
                        .log().all()

                        .when()
                        .get(baseUri + "/pet/findByStatus?status=/" + status)

                        .then()
                        .log().all()
                        .extract().as(PetPayloadDTO.class);


        return result;
    }
}
