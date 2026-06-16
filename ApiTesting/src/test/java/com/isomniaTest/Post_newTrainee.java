package com.isomniaTest;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;
public class Post_newTrainee {

	@Test
	public void createTrainee() {

	    Map<String,Object> payload = new HashMap<>();

	    payload.put("name","HarithaSR");
	    payload.put("company","ExpleoSolution");

	    Response response =RestAssured
	                    .given()
	                    .contentType(ContentType.JSON)
	                    .body(payload)
	                    .when()
	                    .post("http://localhost:3001/trainees");

	    Assert.assertEquals(response.getStatusCode(),201);

	    String traineeId =response.jsonPath().getString("id");

	    System.out.println(traineeId);
	}
}
