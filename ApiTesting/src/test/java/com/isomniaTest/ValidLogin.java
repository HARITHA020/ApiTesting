package com.isomniaTest;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

public class ValidLogin {

    @Test
    public void loginTest() {

        Map<String,Object> payload = new HashMap<>();

        payload.put("username", "admin");
        payload.put("password", "admin123");

        Response response =
                RestAssured
                        .given()
                        .contentType(ContentType.JSON)
                        .body(payload)
                        .when()
                        .post("http://localhost:5000/login");

        Assert.assertEquals(response.getStatusCode(),200);

        String token =
                response.jsonPath().getString("token");

        Assert.assertNotNull(token);

        System.out.println(token);
    }
}