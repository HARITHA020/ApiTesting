package com.test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.annotations.Test;

public class HeadTest extends BaseTest {

    @Test
    public void headRequest() {

        Response response =
                RestAssured
                        .given()
                        .when()
                        .head("/posts/1");

        System.out.println("Status Code: " + response.getStatusCode());

        System.out.println("Headers:");
        System.out.println(response.getHeaders());
    }
}