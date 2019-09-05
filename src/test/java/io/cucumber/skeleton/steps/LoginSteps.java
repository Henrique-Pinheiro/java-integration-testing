package io.cucumber.skeleton.steps;

import cucumber.api.java.pt.Dado;
import cucumber.api.java.pt.E;
import cucumber.api.java.pt.Então;
import cucumber.api.java.pt.Quando;
import io.cucumber.skeleton.services.LoginTest;
import org.junit.Assert;

import static java.lang.Boolean.parseBoolean;

public class LoginSteps {

    private LoginTest login = new LoginTest();

    @Dado("que eu informe o EC (.*) o usuário (.*) e a senha (.*)")
    public void queEuInformeOECECOUsuárioUserEASenhaSenha(String ec, String user, String senha) {
        login.setEc(ec);
        login.setUser(user);
        login.setSenha(senha);
    }

    @Quando("eu enviar a resquisição")
    public void euEnviarAResquisição() {
        login.postLogin();
    }

    @Então("o status (.*) deve ser exibido")
    public void oStatusStatusDeveSerExibido(int status) {
        Assert.assertEquals(status, login.getStatus());
    }

    @E("os Tokens de autentificação devem ser retornados e validados")
    public void oTokenDeAutentificaçãoDeveSerRetornado() {
        Assert.assertNotNull("O Token não foi gerado", login.getToken());
        Assert.assertNotNull("O Token de refresh não foi gerado", login.getRefreshoken());
        Assert.assertTrue("O Token não é valido", login.validateToken());
    }


    @E("o usuario deve possuir a convivencia igual a (.*)")
    public void oUsuarioDeveSerConvivencia(String convivencia) {
        Assert.assertEquals(parseBoolean(convivencia), login.getConvivencia());
    }
}
