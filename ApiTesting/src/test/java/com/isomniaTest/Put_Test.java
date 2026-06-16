package com.isomniaTest;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;
public class Put_Test {
	@Test
	public void put() {
		Map<String,Object> payload= new HashMap();
		payload.put("name","harithaD");
		payload.put("company", "ExpleoSolution");
		Response response= RestAssured
		.given()
		.contentType(ContentType.JSON)
        .body(payload)
        .when()
		.get("http://localhost:3001/trainees/x3hDanm");
		 Assert.assertEquals(response.getStatusCode(),200);
		 String company =response.jsonPath().getString("company");
		 Assert.assertEquals(company,"ExpleoSolution");
		
		
	}
	
}
