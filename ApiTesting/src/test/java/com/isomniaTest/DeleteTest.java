package com.isomniaTest;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;
public class DeleteTest {

	@Test
	public void deleteTrainee() {

	    Response response =RestAssured
	               .given()
	               .when()
	               .delete("http://localhost:3001/trainees/z-BhoHz");
	    Assert.assertEquals(response.getStatusCode(),200);
	}
}
