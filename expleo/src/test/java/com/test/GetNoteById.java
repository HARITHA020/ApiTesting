package com.test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

public class GetNoteById extends CreateNote {

    @Test
    public void getNoteById() {
        Response response = RestAssured
                .given()
                .header("Authorization", "Bearer " + token)
                .pathParam("id", noteId)
                .when()
                .get("/getById/notes/{id}")
                .then()
                .statusCode(200)
                .extract()
                .response();
        System.out.println(response.asPrettyString());
        boolean success = response.jsonPath().getBoolean("success");
        Assert.assertTrue(success);
        String title = response.jsonPath().getString("data.title");
        System.out.println("Title: " + title);
        String id = response.jsonPath().getString("data._id");
        Assert.assertEquals(id, noteId);
    }
}