package com.test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.annotations.Test;

public class OptionsTest extends BaseTest {

    @Test
    public void optionsRequest() {

        Response response =
                RestAssured
                        .given()
                        .when()
                        .options("/posts");

        System.out.println("Status Code: " + response.getStatusCode());

        System.out.println("Allowed Methods:");
        System.out.println(response.getHeader("Allow"));
    }
}