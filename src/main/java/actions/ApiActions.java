package actions;


import io.restassured.response.Response;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.*;

public class ApiActions {
    public Map<String, String> headers= new HashMap<>();
    public Response getApi(String baseUrl, String EndPoint,String cookie ){
        baseURI = baseUrl;
        resetHeaders();
        Response response = given()
                .cookie(cookie)
                .headers(this.headers)
                .when()
                .get(EndPoint).andReturn();
        System.out.println(response.asPrettyString());
        return response;
    }
    public Response postApi(String baseUrl, String EndPoint,Object body,String cookie ){
        baseURI = baseUrl;
        resetHeaders();
        Response response = given()
                .cookie(cookie)
                .headers(this.headers)
                .body(body)
                .when()
                .post(EndPoint).andReturn();
        System.out.println(response.asPrettyString());
        return response;
    }
    public Response putApi(String baseUrl, String EndPoint,Object body,String cookie ){
        baseURI = baseUrl;
        resetHeaders();
        Response response = given()
                .cookie(cookie)
                .headers(this.headers)
                .body(body)
                .when()
                .put(EndPoint).andReturn();
        System.out.println(response.asPrettyString());
        return response;
    }
    public Response deleteApi(String baseUrl, String EndPoint,Object body,String cookie ){
        baseURI = baseUrl;
        resetHeaders();
        Response response = given()
                .cookie(cookie)
                .headers(this.headers)
                .body(body)
                .when()
                .delete(EndPoint).andReturn();
        System.out.println(response.asPrettyString());
        return response;
    }
    public void resetHeaders(){
        headers.put("Content-Type","application/json");
        headers.put("Accept","application/json");
    }
}
