package com.test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TogglePin extends CreateNote {

    @Test
    public void togglePinNote() {

        Response response = RestAssured
                .given()
                .header("Authorization", "Bearer " + token)
                .pathParam("id", noteId)
                .when()
                .put("/toggle-pin/notes/{id}")
                .then()
                .statusCode(200)
                .extract()
                .response();

        System.out.println(response.asPrettyString());
        boolean success = response.jsonPath().getBoolean("success");
        Assert.assertTrue(success);
        String message = response.jsonPath().getString("message");
        Assert.assertEquals(message, "Note pinned successfully");
        boolean isPinned = response.jsonPath().getBoolean("data.isPinned");
        Assert.assertTrue(isPinned);
        System.out.println("Pinned Status: " + isPinned);
    }
}