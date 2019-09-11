package io.cucumber.skeleton.services;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.json.JSONObject;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;

public class LoginTest {

    protected static String ENDPOINT_POST_LOGIN_AUTH = "http://apollo-core-ecscluster-hml-1454189126.sa-east-1.elb.amazonaws.com/api/apollo/user-login/v1/token";
    protected static String ENDPOINT_GET_LOGIN_AUTH = "https://apihom.cielo.com.br/site-cielo/v1/me";
    //    protected static String ENDPOINT_POST_LOGIN_AUTH = "https://digitalhml.hdevelo.com.br/authentication";
//    private static String ENDPOINT_POST_LOGIN_AUTH = "https://postman-echo.com/get";
    private String ec = "";
    private String user = "";
    private String senha = "";
    private int status = 0;
    private static String token = "";
    private String refreshToken = null;
    private Object convivencia = null;

    public static String getInvalidToken() {
        return token + "a";
    }


    public void setEc(String ec) {
        this.ec = ec;
    }

    public String getEc() {
        return ec;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getUser() {
        return user;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getSenha() {
        return senha;
    }

    public int getStatus() {
        return status;
    }

    public static String getToken() {
        return token;
    }

    public String getRefreshoken() {
        return refreshToken;
    }

    public boolean getConvivencia() {
        return (boolean) convivencia;
    }

    public void postLogin() {
        baseURI = ENDPOINT_POST_LOGIN_AUTH;
        RequestSpecification request = given();
        JSONObject requestParams = new JSONObject();
        requestParams.put("merchant", ec);
        requestParams.put("username", user);
        requestParams.put("password", senha);
        request.header("Content-Type", "application/json");
        request.body(requestParams.toString());
        Response response = request.post();
        status = response.getStatusCode();
        JsonPath json = response.jsonPath();
        if (json.get("access_token") != null) {
            token = json.get("access_token").toString();
        }
        refreshToken = json.get("refresh_token");
        convivencia = json.get("isConvivenciaUser");
//        response.prettyPrint();
    }


    public boolean validateToken() {
        if (token.startsWith("I0") || token.startsWith("QY")){
            return true;
        }else{
            System.out.println(token);
            baseURI = ENDPOINT_GET_LOGIN_AUTH;
            RequestSpecification request = given();
            JSONObject requestParams = new JSONObject();
            request.header("client_id", "ZitZlNvXgAzb");
            request.header("access_token", token);
            request.header("Content-Type", "application/json");
            request.body(requestParams.toString());
            Response response = request.get();
            JsonPath json = response.jsonPath();
//            response.prettyPrint();
            String username = (json.get("username"));
            return !(username.isEmpty());
        }
    }
}
