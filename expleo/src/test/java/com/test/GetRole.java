package com.test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

public class GetRole extends BaseTest {

    @Test
    public void getAllRoles() {

        System.out.println("TOKEN USED = " + token);

        Response response = RestAssured
                .given()
                .header("Authorization", "Bearer " + token)
                .when()
                .get("/roles/getAll")
                .then()
                .statusCode(200)
                .extract()
                .response();

        System.out.println(response.asPrettyString());

        String message = response.jsonPath().getString("message[0].value");

        Assert.assertEquals(message, "Role Retrieved successfully");
    }
}