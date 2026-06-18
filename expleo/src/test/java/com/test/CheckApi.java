package com.test;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CheckApi extends BaseTest {
    @Test
    public void healthCheck() {
        Response response = RestAssured
                .given()
                .when()
                .get("/")
                .then()
                .statusCode(200)
                .extract()
                .response();
        System.out.println("Response: " + response.asString());
        Assert.assertEquals(response.asString(), "API Running");
    }
}
