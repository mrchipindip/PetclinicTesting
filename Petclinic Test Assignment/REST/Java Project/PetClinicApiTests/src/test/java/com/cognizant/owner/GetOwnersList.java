package com.cognizant.owner;

import org.junit.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;

public class GetOwnersList {

	private RequestSpecification request;
	private Response response;
	private ValidatableResponse json;
	
	@Test
	public void getRequest(String owner) {
		request = RestAssured.given().contentType(ContentType.JSON);
		response = request.when().get("http://localhost:4200/petclinic/");
		json = response.then().statusCode(404);
	}
	
	
	
}