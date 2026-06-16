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
	               .delete("http://localhost:3001/trainees/JcT-mR3");
	    Assert.assertEquals(response.getStatusCode(),200);
	}
}
