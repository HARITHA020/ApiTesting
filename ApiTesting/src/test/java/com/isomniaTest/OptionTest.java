package com.isomniaTest;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;
public class OptionTest {

	@Test
	public void optionsTest() {

	    Response response =RestAssured
	             .given()
	             .when()
	             .options("http://localhost:3001/trainees/3");

	    Assert.assertTrue(response.getStatusCode() == 200|| response.getStatusCode() == 204);
	    String allow =response.getHeader("Allow");
	    System.out.println(allow);
	}
}
