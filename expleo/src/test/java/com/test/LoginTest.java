package com.test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest {
    @Test(priority = 1)
    public void validLoginTest() {

        JSONObject body = new JSONObject();
        body.put("email", "sam@gmail.com");
        body.put("password", "123");

        Response response = RestAssured
                .given()
                .contentType(ContentType.JSON)
                .body(body.toString())
                .post("/user/login");

        Assert.assertEquals(response.statusCode(), 201);
        Assert.assertNotNull(response.jsonPath().getString("token"));
    }
    @Test(priority = 2)
    public void invalidEmailTest() {

        JSONObject body = new JSONObject();
        body.put("email", "test@gmail.com");
        body.put("password", "123");

        Response response = RestAssured
                .given()
                .contentType(ContentType.JSON)
                .body(body.toString())
                .post("/user/login");

        Assert.assertEquals(response.statusCode(), 400);
        Assert.assertTrue(response.asString().contains("Email is invalid"));
    }
    @Test(priority = 3)
    public void invalidPasswordTest() {

        JSONObject body = new JSONObject();
        body.put("email", "sam@gmail.com");
        body.put("password", "test123");

        Response response = RestAssured
                .given()
                .contentType(ContentType.JSON)
                .body(body.toString())
                .post("/user/login");

        Assert.assertEquals(response.statusCode(), 400);
        Assert.assertTrue(response.asString().contains("Password is incorrect"));
    }
    @Test(priority = 4)
    public void missingFieldsTest() {

        JSONObject body = new JSONObject();
        body.put("email", "");

        Response response = RestAssured
                .given()
                .contentType(ContentType.JSON)
                .body(body.toString())
                .post("/user/login");

        Assert.assertEquals(response.statusCode(), 400);
        Assert.assertTrue(response.asString().contains("All fields are required"));
    }
}