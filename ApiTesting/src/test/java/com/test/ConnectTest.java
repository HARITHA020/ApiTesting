package com.test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.annotations.Test;

public class ConnectTest extends BaseTest {

    @Test
    public void connectRequest() {

        Response response =
                RestAssured
                        .given()
                        .when()
                        .request("CONNECT", "example.com:443");

        System.out.println("Status Code: " + response.getStatusCode());

        System.out.println("Response:");
        System.out.println(response.asString());
    }
}