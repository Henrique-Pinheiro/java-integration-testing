package io.cucumber.skeleton.steps;

import cucumber.api.java.pt.Dado;
import cucumber.api.java.pt.E;
import cucumber.api.java.pt.Então;
import cucumber.api.java.pt.Quando;
import io.cucumber.skeleton.services.LoginTest;
import io.cucumber.skeleton.services.MeTest;
import org.junit.Assert;

public class MeSteps {

    private MeTest meTest = new MeTest();

    @Quando("eu enviar a requisição")
    public void euEnviarARequisção() {
        meTest.getMe();
    }

    @Então("os dados nome do usário (.*), usuário (.*), email (.*), data de aniversario (.*) devem ser retornados")
    public void osDadosNomeDoUsárioUsernameUsuárioUserEmailEmailDataDeAniversarioDt_aniversarioDevemSerRetornados(String username, String user, String email, String dtAniversario) {
        Assert.assertEquals(username, meTest.getUsername());
        Assert.assertEquals(user, meTest.getUser());
        Assert.assertEquals(email, meTest.getEmail());
        Assert.assertEquals(dtAniversario, meTest.getDtAniversario());
    }

    @E("os dados cpf (.*), ec (.*), nome do estabelecimento (.*) e cnpj (.*) também devem ser retornados")
    public  void osDadosCpfCpfEcEcNomeDoEstabelecimentoNome_ecECnpjCnpjTambémDevemSerRetornados(String cpf, String ec, String nomeEc, String cnpj) {
        Assert.assertEquals(cpf, meTest.getCpf());
        Assert.assertEquals(ec, meTest.getEc());
        Assert.assertEquals(nomeEc, meTest.getNomeEc());
        Assert.assertEquals(cnpj, meTest.getCnpj());
    }

    @E("receber o status (.*)")
    public void receberOStatusStatus(int status) {
        Assert.assertEquals(status, meTest.getStatus());
    }

    @E("o token esteja expirado")
    public void oTokenEstejaExpirado() {
       meTest.setInvalidToken(LoginTest.getInvalidToken());
    }

    @E("deve ser exibida a mensagem {string}")
    public void entãoDeveSerExibidaAMensagem(String msg) {
        Assert.assertEquals(msg, meTest.getMsg());
    }
}
