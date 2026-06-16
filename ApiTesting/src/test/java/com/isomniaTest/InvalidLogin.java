package com.isomniaTest;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;
public class InvalidLogin {
	@Test
	public void invalidLogin() {

	    Map<String,Object> payload =new HashMap<>();

	    payload.put("username","admin");
	    payload.put("password","wrong");

	    Response response =RestAssured
	    		.given()
	            .contentType(ContentType.JSON)
	            .body(payload)
	            .when()
	            .post("http://localhost:5000/login");
	    Assert.assertEquals(response.getStatusCode(),401);
	}

}
