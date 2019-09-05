package io.cucumber.skeleton.services;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;

public class PagamentoPorLinkTest {

    protected static String ENDPOINT_GET_ELIGIBILITY = "https://apihom.cielo.com.br/appcielo/v1/user/eligibility/pagamento-link";
    private String token = "";
    private String ec = "";
    private int status = 0;
    private boolean eligibility;

    public boolean getEligibility() {
        return eligibility;
    }

    public int getStatus() {
        return status;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public void setEc(String ec) {
        this.ec = ec;
    }

    public void postEligibility() {
        baseURI = ENDPOINT_GET_ELIGIBILITY;
        RequestSpecification request = given();
//        JSONObject requestParams = new JSONObject();
        request.header("Content-Type", "application/json");
        request.header("ec", ec);
        request.header("clint_id", "ZitZlNvXgAzb");
        request.header("token", token);
        Response response = request.get();
        status = response.getStatusCode();
        JsonPath json = response.jsonPath();
        response.prettyPrint();
        eligibility = json.get("eligible");
    }
}
