package com.cognizant;

import org.json.JSONObject;
import org.junit.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;

public class User {

	private RequestSpecification request;
	private Response response;
	private ValidatableResponse json;

	@Test
	public void addOwner() {
//		request = RestAssured.given().contentType(ContentType.JSON);
//		request.header("Content-Type", "application/json");
//
//		JSONObject jsonObject = new JSONObject();
//		jsonObject.put("id", 0);
//		jsonObject.put("name", "Chestar");
//
//		request.body(jsonObject.toString());
//
//		response = request.post(Const.address + "/api/specialties");
//		json = response.then().statusCode(201);
	}
	
}