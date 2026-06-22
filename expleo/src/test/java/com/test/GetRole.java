package com.test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

public class GetRole extends BaseTest{

    @Test(priority = 1)
    public void getAllRoles_ValidToken() {

        Response response = RestAssured
                .given()
                .header("Authorization", "Bearer " + token)
                .when()
                .get("/roles/getAll");

        Assert.assertEquals(response.statusCode(), 200);

        String message = response.jsonPath().getString("message[0].value");
        Assert.assertEquals(message, "Role Retrieved successfully");

        Assert.assertTrue(response.jsonPath().getList("roles").size() > 0);

        System.out.println("VALID RESPONSE:");
        System.out.println(response.asPrettyString());
    }

    @Test(priority = 2)
    public void getAllRoles_NoToken() {

        Response response = RestAssured
                .given()
                .when()
                .get("/roles/getAll");

        Assert.assertEquals(response.statusCode(), 401);

        String message = response.jsonPath().getString("message[0].value");
        Assert.assertEquals(message, "User is not logged in");

        System.out.println("INVALID RESPONSE (NO TOKEN):");
        System.out.println(response.asPrettyString());
    }

    @Test(priority = 3)
    public void getAllRoles_InvalidToken() {

        Response response = RestAssured
                .given()
                .header("Authorization", "Bearer invalidToken123")
                .when()
                .get("/roles/getAll");

        Assert.assertEquals(response.statusCode(), 401);

        System.out.println("INVALID TOKEN RESPONSE:");
        System.out.println(response.asPrettyString());
    }
}