package br.eduardo.rest;

import io.restassured.http.ContentType;
import org.hamcrest.Matchers;
import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class RestAssuredExemplo {

    private String baseUri = "https://reqres.in/api";

    @Test
    public void testeDeveConsultarPagina2(){

        given()
                .log().all()
                .queryParam("page", "2")
                .when()
                .get(baseUri + "/users")
                .then()
                .log().all()
                .statusCode(200)
                .body("page", equalTo(2))
                .body("data", hasSize(6))
                .body("data.first_name", hasItem("Michael"))
                .body("data[1].id", is(8))
        ;
    }

    @Test
    public void testeDeveSalvarUsuario(){

        given()
                .log().all()
                .contentType(ContentType.JSON)
                .body("{\"name\" : \"Ályson\", \"job\" : \"QA\"}")
                .when()
                .post(baseUri + "/users")
                .then()
                .log().all()
                .statusCode(201)
                .body("name", is("Ályson"))
                .body("job", is("QA"))
                .body("id", not(nullValue()))
                .body(containsString("createdAt"))
        ;
    }

    @Test
    public void testeDeveSerializarMapEObjetoAoSalvarUsuario(){

        Map<String, Object> params = new HashMap<String, Object>();
        params.put("name", "Ályson");
        params.put("job", "QA");


        UserTeste user = new UserTeste("Ályson com objeto", "QA com objeto");

        given()
                .log().all()
                .contentType(ContentType.JSON)
                .body(user)
                .when()
                .post(baseUri + "/users")
                .then()
                .log().all()
                .statusCode(201)
                .body("name", is("Ályson com objeto"))
                .body("job", is("QA com objeto"))
                .body("id", not(nullValue()))
                .body(containsString("createdAt"))
        ;
    }

    @Test
    public void testeDeveDesserializarObjetoAoSalvarUsuario(){
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("name", "Ályson");
        params.put("job", "QA");

        UserTeste usuarioInserido =
                given()
                        .log().all()
                        .contentType(ContentType.JSON)
                        .body(params)
                        .when()
                        .post(baseUri + "/users")
                        .then()
                        .log().all()
                        .statusCode(201)
                        .extract().body().as(UserTeste.class)
                ;

        Assert.assertEquals("Ályson", usuarioInserido.getName());
        Assert.assertEquals("QA", usuarioInserido.getJob());
        Assert.assertThat(usuarioInserido.getCreatedAt(), Matchers.notNullValue());
    }

    @Test
    public void testeDeveAtualizarUsuario(){
        Integer idUser = 2;

        given()
                .log().all()
                .contentType(ContentType.JSON)
                .body("{\"name\" : \"Ályson Campos\", \"job\" : \"QA/DEV\"}")
                .pathParam("id", idUser)
                .when()
                .put(baseUri + "/users/{id}")
                .then()
                .statusCode(200)
                .body("name", Matchers.is("Ályson Campos"))
                .body(Matchers.containsString("updatedAt"))
        ;
    }

    @Test
    public void testeDeveDeletarUsuario(){
        given()
                .log().all()
                .pathParam("id", 2)
                .when()
                .delete(baseUri + "/users/{id}")
                .then()
                .statusCode(204)
        ;
    }

    @Test
    public void testeDeveConsultarUsuarioNaoExistente() {
        given()
                .log().all()

                .when()
                .get(baseUri + "/users/23")

                .then()
                .statusCode(404)
                ;
    }

    @Test
    public void testeRegistrarSemSenha() {
        given()
                .log().all()
                .contentType(ContentType.JSON)
                .body("{\"email\" : \"eduardo@gmail.com\"}")

                .when()
                .post(baseUri + "/register")

                .then()
                .statusCode(400)
                .log().body()
                ;
    }
    @Test
    public void testeCriarUsuario() {
        given()
                .log().all()
                .contentType(ContentType.JSON)
                .body("{\"name\": \"eduardo\", \"job\": \"leader\"}")

                .when()
                .post(baseUri + "/users")

                .then()
                .statusCode(201)
                ;

    }

    @Test
    public void testeRegistrarCorretamente() {
        given()
                .log().all()
                .contentType(ContentType.JSON)
                .body("{\"email\" : \"eve.holt@reqres.in\", \"password\" : \"cityslicka\"}")

                .when()
                .post(baseUri + "/register")

                .then()
                .statusCode(200)
                .log().body()
        ;
    }

    @Test
    public void testeListarUsuariosComDelay() {
        given()
                .log().all()

                .when()
                .get(baseUri + "/users?delay=3")

                .then()
                .statusCode(200)
                ;
    }

    @Test
    public void testeFazerLoginCorretamente() {
        given()
                .log().all()
                .contentType(ContentType.JSON)
                .body("{\"email\" : \"eve.holt@reqres.in\", \"password\" : \"cityslicka\"}")

                .when()
                .post(baseUri + "/login")

                .then()
                .statusCode(200)
                .body(containsString("token"))
                ;
    }

    @Test
    public void testeFazerLoginSemSenha() {
        given()
                .log().all()
                .contentType(ContentType.JSON)
                .body("{\"email\" : \"eve.holt@reqres.in\"}")

                .when()
                .post(baseUri + "/login")

                .then()
                .statusCode(400)
                .body(containsString("error"))

                ;
    }

    @Test
    public void testeDeveAtualizarUsuarioComMetodoPatch() {
        given()
                .log().all()
                .contentType(ContentType.JSON)
                .body("{\"name\" : \"batman\", \"job\" : \"Piloto de Dirigível\"}")

                .when()
                .patch(baseUri + "/users/2")

                .then()
                .statusCode(200)
                .body(containsString("updatedAt"))
                ;
    }
}