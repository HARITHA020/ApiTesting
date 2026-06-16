package com.isomniaTest;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;
public class PatchTest {

	@Test
	public void patchTrainee() {

	    Map<String,Object> payload =new HashMap<>();

	    payload.put("email","hari@gmail.com");

	    Response response =RestAssured
	             .given()
	             .contentType(ContentType.JSON)
	             .body(payload)
	             .when()
	             .patch("http://localhost:3001/trainees/x3hDanm");

	    Assert.assertEquals(response.getStatusCode(),200);

	    String email =response.jsonPath().getString("email");

	    Assert.assertEquals(email,"hari@gmail.com");
	}
}
