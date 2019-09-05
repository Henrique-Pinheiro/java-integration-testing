package io.cucumber.skeleton.services;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import java.util.List;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;

public class FaqTest {

    protected static String ENDPOINT_POST_HELP_CENTER = "https://apihom.cielo.com.br/appcielo/v1/help/help-center";
    private String token = "";
    private int status = 0;
    private JsonPath json;
    private List<String> pagamentoPorLinkFaq = null;

    public int getStatus() {
        return status;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public void postFaq() {
        baseURI = ENDPOINT_POST_HELP_CENTER;
        RequestSpecification request = given();
//      JSONObject requestParams = new JSONObject();
//        request.header("Content-Type", "application/json");
        request.header("client_id", "ZitZlNvXgAzb");
        request.header("token", token);
        Response response = request.get();
        status = response.getStatusCode();
        json = response.jsonPath();
        pagamentoPorLinkFaq = json.get("helpCenter");
//        response.prettyPrint();
    }

    public String getHelpTitle(String title){
       return json.get("helpCenter.title[1]");
    }

    public List<String> getPagamentoPorLinkFaq() {
        return pagamentoPorLinkFaq;
    }
}
