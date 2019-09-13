package io.cucumber.skeleton.steps;

import cucumber.api.java.pt.Dado;
import cucumber.api.java.pt.E;
import cucumber.api.java.pt.Então;
import cucumber.api.java.pt.Quando;
import io.cucumber.skeleton.services.LoginTest;
import io.cucumber.skeleton.services.MerchantTest;
import org.junit.Assert;

public class MerchantSteps {

    private MerchantTest merchantTest = new MerchantTest();


    @E("eu envie a requisição")
    public void euEnvieARequisição() {
        merchantTest.getMerchant();
    }

    @Quando("eu receber o status (.*) da requisição")
    public void receberOStatusStatus(int status) {
        Assert.assertEquals(status, merchantTest.getStatus());
    }

    @E("os dados do estabalecimento: nome da compania (.*), numero do ec (.*) e cnpj (.*) devem ser retornados")
    public void osDadosDoEstabalecimentoNomeDaCompaniaNome_companiaNumeroDoEcEcCnpjCnpjDevemSerRetornados(String nomeCompania, String ec, String cnpj) {
        Assert.assertEquals(nomeCompania, merchantTest.getNomeCompania());
        Assert.assertEquals(ec, merchantTest.getEc());
        Assert.assertEquals(cnpj, merchantTest.getCnpj());

    }

    @E("os dados do contato: nome do contato (.*), email (.*) e numero do telefone (.*) também devem ser retornados")
    public void osDadosDoContatoNomeDoContatoNome_contatoEmailEmailNumeroDoTelefoneNumero_telTambémDevemSerRetornados(String nomeContato, String email, String numeroTel) {
        Assert.assertEquals(nomeContato, merchantTest.getNomeContato());
        Assert.assertEquals(email, merchantTest.getEmail());
        Assert.assertEquals(numeroTel, merchantTest.getNumeroTel());

    }

    @Então("os dados do endereço: nome da rua (.*), cep (.*), cidade (.*), bairro (.*), estado (.*) e numero (.*) devem exibidos")
    public void osDadosDoEndereçoNomeDaRuaNome_ruaCepCepCidadeCidadeBairroBairroEstadoEstadoNumeroDoEstabelecimentoNumero_estabDevemExibidos(String nomeRua, String cep, String cidade, String bairro, String estado, String num) {
        Assert.assertEquals(nomeRua, merchantTest.getNomeRua());
        Assert.assertEquals(cep, merchantTest.getCep());
        Assert.assertEquals(cidade, merchantTest.getCidade());
        Assert.assertEquals(bairro, merchantTest.getBairro());
        Assert.assertEquals(estado, merchantTest.getEstado());
        Assert.assertEquals(num, merchantTest.getNum());
    }

    @E("o token deve estar expirado")
    public void oTokenDeveEstarExpirado() {
        merchantTest.setInvalidToken(LoginTest.getInvalidToken());
    }

    @Então("devera ser exibida a mensagem {string}")
    public void deveraSerExibidaAMensagem(String msg) {
        Assert.assertEquals(msg,merchantTest.getMsg());

    }

}
