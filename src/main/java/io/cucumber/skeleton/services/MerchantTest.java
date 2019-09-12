package io.cucumber.skeleton.services;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import java.util.ArrayList;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;

public class MerchantTest {

    public static String ENDPOINT_GET_MERCHANT = "http://apollo-core-ecscluster-hml-1454189126.sa-east-1.elb.amazonaws.com/api/apollo/user-information/v1/merchant";

    private int status;
    private String token = "";
    private String nomeCompania;
    private String ec;
    private String cnpj;
    private String nomeContato;
    private ArrayList<String> emails;
    private String email;
    private String numeroTel;
    private String nomeRua;
    private String cep;
    private String cidade;
    private String bairro;
    private String estado;
    private String numero;
    private String invalidToken = "";
    private String msg;

    public void getMerchant() {
        baseURI = ENDPOINT_GET_MERCHANT;
        RequestSpecification request = given();
        token = invalidToken.isEmpty() ? LoginTest.getToken() : invalidToken+"a";
        request.header("access_token", token);
        request.header("client_id", "ZitZlNvXgAzb");
        Response response = request.get();
        status = response.getStatusCode();
        JsonPath json = response.jsonPath();
        nomeCompania = json.get("companyName");
        ec = json.get("number").toString();
        cnpj = json.get("cnpj");
        nomeContato = json.get("contacts.name[0]");
        emails = json.get("contacts.emails[0]");
        email = emails.get(0);
        numeroTel = json.get("contacts.phones[0].number[0]");
        nomeRua = json.get("addresses.streetAddress[0]");
        cep = json.get("addresses[0].zipCode");
        cidade = json.get("addresses[0].city");
        bairro = json.get("addresses[0].neighborhood");
        estado = json.get("addresses[0].state");
        numero = json.get("addresses[0].number");
        msg = json.get("message");

    }


    public int getStatus() {
        return status;
    }
    public String getMsg(){

        return msg;
    }

    public String getNomeCompania() {
        return nomeCompania;
    }

    public String getEc() {
        return ec;
    }

    public String getCnpj() {
        return cnpj;
    }

    public String getNomeContato() {
        return nomeContato;
    }

    public String getEmail() {
        return email;
    }

    public String getNumeroTel() {
        return numeroTel;
    }

    public String getNomeRua() {
        return nomeRua;
    }

    public String getCep() {
        return cep;
    }

    public String getCidade() {
        return cidade;
    }

    public String getBairro() {
        return bairro;
    }

    public String getEstado() {
        return estado;
    }

    public String getNum() {
        return numero;
    }
    public void setInvalidToken(String invalidToken) {
        this.invalidToken = invalidToken;
    }
}
