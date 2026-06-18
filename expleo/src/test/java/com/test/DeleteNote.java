package com.test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DeleteNote extends CreateNote {

    @Test
    public void deleteNote() {

        Response response = RestAssured
                .given()
                .header("Authorization", "Bearer " + token)
                .pathParam("id", noteId)
                .when()
                .delete("/delete/notes/ById/{id}")
                .then()
                .statusCode(200)
                .extract()
                .response();

        System.out.println(response.asPrettyString());
        boolean success = response.jsonPath().getBoolean("success");
        Assert.assertTrue(success);
        String message = response.jsonPath().getString("message");
        Assert.assertEquals(message, "Notes deleted successfully");
        int deletedCount = response.jsonPath().getInt("deletedCount");
        Assert.assertEquals(deletedCount, 1);
        String deletedId = response.jsonPath().getString("deletedIds[0]");
        Assert.assertEquals(deletedId, noteId);
        System.out.println("Deleted Note ID: " + deletedId);
    }
}