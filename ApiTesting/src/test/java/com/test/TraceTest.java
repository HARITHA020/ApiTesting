package com.test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.annotations.Test;

public class TraceTest extends BaseTest {

    @Test
    public void traceRequest() {

        Response response =
                RestAssured
                        .given()
                        .when()
                        .request("TRACE", "/posts/1");

        System.out.println("Status Code: " + response.getStatusCode());

        System.out.println("Response Body:");
        System.out.println(response.asString());
    }
}