package com.test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

public class GetAllNotes extends BaseTest {

    @Test
    public void getAllNotes() {

        Response response = RestAssured
                .given()
                .header("Authorization", "Bearer " + token)
                .queryParam("limit", 2)
                .queryParam("sortOrder", "desc")
                .when()
                .get("/getAll/notes")
                .then()
                .statusCode(200)
                .extract()
                .response();

        System.out.println(response.asPrettyString());
        boolean success = response.jsonPath().getBoolean("success");
        Assert.assertTrue(success);
        String title = response.jsonPath().getString("data[0].title");
        System.out.println("First Note Title: " + title);
        int totalNotes = response.jsonPath().getInt("pagination.totalNotes");
        System.out.println("Total Notes: " + totalNotes);
        Assert.assertTrue(totalNotes >= 0);
    }
}