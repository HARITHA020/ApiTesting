package com.test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.testng.annotations.BeforeClass;

public class BaseTest {

    public static String token;

    @BeforeClass
    public void setup() {

        RestAssured.baseURI = "https://lms-server-3-wedg.onrender.com";
        JSONObject body = new JSONObject();
        body.put("email", "sam@gmail.com");
        body.put("password", "123");

        Response response = RestAssured
                .given()
                .contentType(ContentType.JSON)
                .body(body.toString())
                .when()
                .post("/user/login");
        if (response.statusCode() == 201) {
            token = response.jsonPath().getString("token");
            System.out.println("LOGIN SUCCESS");
            System.out.println("TOKEN: " + token);
        } else {
            throw new RuntimeException("Login failed. Cannot proceed tests.");
        }
    }
}