package com.isomniaTest;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
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

        String token =
                RestAssured
                        .given()
                            .contentType(ContentType.JSON)
                            .body(payload)
                        .when()
                            .post("http://localhost:5000/login")
                        .then()
                            .statusCode(200)
                            .extract()
                            .jsonPath()
                            .getString("token");

        System.out.println(token);

        Assert.assertNotNull(token);
    }
}