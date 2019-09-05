package io.cucumber.skeleton.steps;

import cucumber.api.java.pt.Dado;
import cucumber.api.java.pt.E;
import cucumber.api.java.pt.Então;
import cucumber.api.java.pt.Quando;
import io.cucumber.skeleton.services.FaqTest;
import io.cucumber.skeleton.services.LoginTest;
import io.cucumber.skeleton.services.PagamentoPorLinkTest;
import org.junit.Assert;

public class PagamentoPorLinkSteps {

    private LoginTest login = new LoginTest();
    private PagamentoPorLinkTest pagamentoPorLink = new PagamentoPorLinkTest();
    private FaqTest faq = new FaqTest();
    private String token;

    @Dado("que eu esteja logado com o EC (.*) o usuário (.*) e a senha (.*)")
    public void queEuEstejaLogadoComOECECOUsuárioUserEASenhaSenha(String ec, String user, String senha) {
        login.setEc(ec);
        login.setUser(user);
        login.setSenha(senha);
        login.postLogin();
        token = login.getToken();
        pagamentoPorLink.setToken(token);
        faq.setToken(token);
    }

    @Quando("eu enviar a requisição para o serviço de eligibilidade informando o EC (.*)")
    public void euEnviarARequisiçãoParaOServiçoDeElibilidadeInformandoOECEC(String ec) {
        pagamentoPorLink.setEc(ec);
        pagamentoPorLink.postEligibility();
    }

    @E("o status (.*) for exibido")
    public void oStatusStatusForExibido(int status) {
        Assert.assertEquals(status, pagamentoPorLink.getStatus());
    }

    @E("o status (.*) for exibido pelo FAQ")
    public void oStatusStatusForExibidoPeloFaq(int status) {
        Assert.assertEquals(status, faq.getStatus());
    }


    @Então("a eligibilidade (.*) deve ser validada")
    public void aEligibilidadeEligibilidadeDeveSerValidada(String eligibilidade) {
        Assert.assertEquals(eligibilidade.equalsIgnoreCase("sim"), pagamentoPorLink.getEligibility());
    }

    @Quando("eu enviar a requisição para o serviço de FAQ")
    public void euEnviarARequisiçãoParaOServiçoDeFAQ() {
        faq.postFaq();
    }

    @Então("as informações referentes ao FAQ do Pagamento por Link devem ser retornadas")
    public void asInformaçõesReferentesAoFAQDoPagamentoPorLinkDevemSerRetornadas() {
        Assert.assertNotNull("O FAQ do pagamento por Link não foi retornado", faq.getPagamentoPorLinkFaq());
    }

    @E("o titulo deve ser {string}")
    public void oTituloDeveSer(String title) {
        Assert.assertEquals(title, faq.getHelpTitle(title));
    }
}
