package com.cognizant;

import org.json.JSONArray;
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
		request = RestAssured.given().contentType(ContentType.JSON);
		request.header("Content-Type", "application/json");

		JSONObject jsonObject = new JSONObject();
		JSONArray jsonArray = new JSONArray();
		jsonObject.put("enabled", true);
		jsonObject.put("password", "admin");
		jsonObject.put("roles", jsonArray);
		jsonArray.put("id", 0);
		jsonArray.put("name", "Chestar");
		jsonObject.put("username", "admin");

		request.body(jsonObject.toString());

		response = request.post(Const.address + "/api/users");
		json = response.then().statusCode(201);
	}

}