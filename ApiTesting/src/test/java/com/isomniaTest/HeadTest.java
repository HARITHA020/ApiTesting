package com.isomniaTest;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

public class HeadTest {

	@Test
	public void headTest() {
	    Response response =RestAssured
	             .given()
	             .when()
	             .head("http://localhost:3001/");
	    Assert.assertEquals(response.getStatusCode(),200);
	}
}
