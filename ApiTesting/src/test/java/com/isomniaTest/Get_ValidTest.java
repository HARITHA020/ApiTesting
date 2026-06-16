package com.isomniaTest;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class Get_ValidTest {

	@Test
	public void getTrainee() {
	    Response response =RestAssured
	                    .given()
	                    .when()
	                    .get("http://localhost:3001/trainees/4");

	    Assert.assertEquals(response.getStatusCode(),200);
	    String company =response.jsonPath().getString("company");
	    Assert.assertEquals(company,"TCS");
	}
}
