package br.com.dbccompany.service;

import br.com.dbccompany.dto.RelatorioDTO;
import br.com.dbccompany.utils.Login;

import static io.restassured.RestAssured.*;

public class PessoaService {

    String baseUri = "http://vemser-dbc.dbccompany.com.br:39000/vemser/dbc-pessoa-api";

    //String token = "eyJhbGciOiJIUzI1NiJ9.eyJpc3MiOiJ2ZW1zZXItYXBpIiwianRpIjoiMiIsImNhcmdvcyI6WyJST0xFX01BUktFVElORyIsIlJPTEVfQURNSU4iLCJST0xFX1VTVUFSSU8iXSwiaWF0IjoxNjY3NDk3Mjk2LCJleHAiOjE2Njc1ODM2OTZ9.wyjh0xRdRdRBoQs22Qgt9UOcjTBHDIIDUG3ou5nc8Bk";
    String tokenAdm = new Login().autenticacaoAdmin();

    public RelatorioDTO[] buscarRelatorio(){
        //obter o relatório
        RelatorioDTO[] result =
        given()
                .log().all()
                .header("Authorization", tokenAdm)

                .when()
                .get(baseUri + "/pessoa/relatorio")

                .then()
                .log().all()
                .statusCode(200)
                .extract().as(RelatorioDTO[].class)
                ;
        return result;
    }
}
