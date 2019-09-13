package io.cucumber.skeleton.services;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.json.JSONObject;

import java.util.HashMap;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;

public class MeTest {

    protected static String ENDPOINT_GET_ME = "http://apollo-core-ecscluster-hml-1454189126.sa-east-1.elb.amazonaws.com/api/apollo/user-information/v1/me";

    private int status;
    private String token = "";
    private String username;
    private String user;
    private String email;
    private String dtAniversario;
    private String cpf;
    private String ec;
    private String nomeEc;
    private String cnpj;
    private String msg;
    private String invalidToken = "";

    public void getMe() {
        baseURI = ENDPOINT_GET_ME;
        RequestSpecification request = given();
        token = invalidToken.isEmpty() ? LoginTest.getToken() : invalidToken + "a";
        request.header("access_token", token);
        request.header("client_id", "ZitZlNvXgAzb");
        Response response = request.get();
        status = response.getStatusCode();
        JsonPath json = response.jsonPath();
//        response.prettyPrint();
        username = json.get("username");
        user = json.get("login");
        email = json.get("email");
        dtAniversario = json.get("birthDate");
        cpf = json.get("identity.cpf");
            ec = json.get("merchant.id");
        nomeEc = json.get("merchant.name");
        cnpj = json.get("merchant.cnpj.rootNumber");
        msg = json.get("message");
    }

    public int getStatus() {
        return status;
    }

    public String getUsername() {
        return username;
    }

    public String getUser() {
        return user;
    }

    public String getEmail() {
        return email;
    }

    public String getDtAniversario() {
        return dtAniversario;
    }

    public String getCpf() {
        return cpf;
    }

    public String getEc() {
        return ec;
    }

    public String getNomeEc() {
        return nomeEc;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setInvalidToken(String invalidToken) {
        this.invalidToken = invalidToken;
    }

    public String getMsg() {
        return msg;
    }
}
