package com.test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

public class GetAllNotes extends BaseTest {
    @Test(priority = 1)
    public void getAllNotes_valid() {

        Response response = RestAssured
                .given()
                .header("Authorization", "Bearer " + token)
                .queryParam("limit", 2)
                .queryParam("sortOrder", "desc")
                .when()
                .get("/getAll/notes");
        Assert.assertEquals(response.statusCode(), 200);
        Assert.assertTrue(response.jsonPath().getBoolean("success"));
        int dataSize = response.jsonPath().getList("data").size();
        Assert.assertTrue(dataSize <= 2);
        if (dataSize > 0) {
            String title = response.jsonPath().getString("data[0].title");
            System.out.println("First Note Title: " + title);
            Assert.assertNotNull(title);
        }

        System.out.println("VALID RESPONSE:");
        System.out.println(response.asPrettyString());
    }

    @Test(priority = 2)
    public void getAllNotes_invalid() {

        Response response = RestAssured
                .given()
                .queryParam("limit", 2)
                .queryParam("sortOrder", "desc")
                .when()
                .get("/getAll/notes");
        Assert.assertEquals(response.statusCode(), 401);

        System.out.println("INVALID RESPONSE:");
        System.out.println(response.asPrettyString());
    }
}