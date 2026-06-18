package com.test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

public class UpdateNote extends CreateNote {

    @Test
    public void updateNote() {

        JSONObject body = new JSONObject();
        body.put("title", "API Test Note (edited)");
        body.put("content", "Updated content");

        Response response = RestAssured
                .given()
                .header("Authorization", "Bearer " + token)
                .contentType(ContentType.JSON)
                .pathParam("id", noteId)
                .body(body.toString())
                .when()
                .put("/update/notes/{id}")
                .then()
                .statusCode(200)
                .extract()
                .response();

        System.out.println(response.asPrettyString());
        boolean success = response.jsonPath().getBoolean("success");
        Assert.assertTrue(success);
        String message = response.jsonPath().getString("message");
        Assert.assertEquals(message, "Note updated successfully");
        String updatedTitle = response.jsonPath().getString("data.title");
        Assert.assertEquals(updatedTitle, "API Test Note (edited)");
        String updatedContent = response.jsonPath().getString("data.content");
        Assert.assertEquals(updatedContent, "Updated content");
    }
}