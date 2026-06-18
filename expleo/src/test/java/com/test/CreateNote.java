package com.test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CreateNote extends BaseTest {

    public static String noteId;

    @Test
    public void createNote() {
        JSONObject body = new JSONObject();
        body.put("title", "API Test Note");
        body.put("content", "Created by tester");
        body.put("tags", new String[]{"qa", "demo"});
        body.put("color", "#ffeb3b");
        body.put("isPinned", false);
        Response response = RestAssured
                .given()
                .header("Authorization", "Bearer " + token)
                .contentType(ContentType.JSON)
                .body(body.toString())
                .when()
                .post("/create/notes")
                .then()
                .statusCode(201)
                .extract()
                .response();
        System.out.println(response.asPrettyString());
        String message = response.jsonPath().getString("message");
        Assert.assertEquals(message, "Note created successfully");
        noteId = response.jsonPath().getString("data._id");
        System.out.println("NOTE ID = " + noteId);
    }
}