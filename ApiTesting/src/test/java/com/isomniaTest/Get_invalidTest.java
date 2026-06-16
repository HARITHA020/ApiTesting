package com.isomniaTest;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class Get_invalidTest {
	@Test
	public void invalidTest() {
		Response response= RestAssured
				.given()
				.when()
				.get("http://localhost:3001/trainees/999");
		Assert.assertEquals(response.getStatusCode(),404);
	}
}
