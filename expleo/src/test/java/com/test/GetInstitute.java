package com.test;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;
public class GetInstitute extends BaseTest {
    @Test
    public void getAllInstitutions() {

        Response response = RestAssured
                .given()
                .when()
                .get("/getAll/institution")
                .then()
                .statusCode(200)
                .extract()
                .response();
        System.out.println(response.asPrettyString());
        String message = response.jsonPath().getString("message[0].value");
        Assert.assertEquals(message, "Institution Retrieved successfully");
    }
}