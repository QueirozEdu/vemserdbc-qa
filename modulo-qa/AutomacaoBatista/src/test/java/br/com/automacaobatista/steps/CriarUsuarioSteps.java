package br.com.automacaobatista.steps;

import br.com.automacaobatista.pages.CriarUserPage;
import com.github.javafaker.Faker;
import org.junit.Assert;
import org.junit.Test;

public class CriarUsuarioSteps extends BaseSteps{
    CriarUserPage userPage = new CriarUserPage();

    Faker fake = new Faker();
    String nome = fake.name().firstName();
    String ultimoNome = fake.name().lastName();
    String email = fake.internet().emailAddress();
    String endereco = fake.address().streetAddress();
    String universidade = fake.university().name();
    String profissao = fake.job().position();
    String genero = "Male";
    String idade = "34";

    @Test
    public void criarNovoUsuario(){

        userPage.clicarCampoFormulario();
        userPage.clicarBotaoCriarUsuario();

        userPage.escreverCampoNome(nome);
        userPage.escreverCampoUltimoNome(ultimoNome);
        userPage.escreverCampoEmail(email);
        userPage.escreverCampoEndereco(endereco);
        userPage.escreverCampoUniversidade(universidade);
        userPage.escreverCampoProfissao(profissao);
        userPage.escreverCampoGenero(genero);
        userPage.escreverCampoIdade(idade);
        userPage.clicarBotaoCriar();

        assertThat(nome, );
    }
}
