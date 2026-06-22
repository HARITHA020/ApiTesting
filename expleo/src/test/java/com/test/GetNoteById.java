package com.test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

public class GetNoteById extends CreateNote {

    @Test(priority = 1)
    public void getNoteById_valid() {

        Response response = RestAssured
                .given()
                .header("Authorization", "Bearer " + token)
                .pathParam("id", noteId)
                .when()
                .get("/getById/notes/{id}");
        Assert.assertEquals(response.statusCode(), 200);
        Assert.assertTrue(response.jsonPath().getBoolean("success"));
        String id = response.jsonPath().getString("data._id");
        Assert.assertEquals(id, noteId);
        String title = response.jsonPath().getString("data.title");
        Assert.assertNotNull(title);

        System.out.println("VALID RESPONSE:");
        System.out.println(response.asPrettyString());
    }
    @Test(priority = 2)
    public void getNoteById_invalid() {

        String invalidId = "6a321e2bd22ace8c6babeef6";

        Response response = RestAssured
                .given()
                .header("Authorization", "Bearer " + token)
                .pathParam("id", invalidId)
                .when()
                .get("/getById/notes/{id}");
        Assert.assertEquals(response.statusCode(), 404);
        String message = response.jsonPath().getString("message");
        Assert.assertEquals(message, "Note not found");

        System.out.println("INVALID RESPONSE:");
        System.out.println(response.asPrettyString());
    }
}