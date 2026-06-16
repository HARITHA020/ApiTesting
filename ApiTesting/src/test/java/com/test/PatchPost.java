package com.test;

import java.util.HashMap;
import java.util.Map;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class PatchPost {

    @Test
    public void patchPost() {

        Map<String, Object> payload = new HashMap<>();

        payload.put("title", "Patched Title");

        Response response = RestAssured
                .given()
                .contentType(ContentType.JSON)
                .body(payload)
                .when()
                .patch("https://jsonplaceholder.typicode.com/posts/1");

        response.prettyPrint();

        Assert.assertEquals(response.getStatusCode(), 200);
    }
}