package com.test;
import io.restassured.RestAssured;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ApiValidatorTest {
	@Test
	public void validator() {
		String email=RestAssured
				.given()
				.when()
				.get("https://jsonplaceholder.typicode.com/users/1")
				.jsonPath()
				.getString("email");
		System.out.println("Email:"+email);
		Assert.assertEquals(email,"Sincere@april.biz");
	}

}