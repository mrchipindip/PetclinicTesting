package com.cognizant;

import org.json.JSONObject;
import org.junit.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;

public class Owner {

	private RequestSpecification request;
	private Response response;
	private ValidatableResponse json;

	@Test
	public void getOwners() {
		request = RestAssured.given().contentType(ContentType.JSON);
		response = request.when().get(Const.address + "/api/owners");
		json = response.then().statusCode(200);
	}

	@Test
	public void addOwner() {
		request = RestAssured.given().contentType(ContentType.JSON);
		request.header("Content-Type", "application/json");

		JSONObject jsonObject = new JSONObject();
		jsonObject.put("address", "Anchorage");
		jsonObject.put("city", "Manchester");
		jsonObject.put("firstName", "Man");
		jsonObject.put("id", 0);
		jsonObject.put("lastName", "Chester");
		jsonObject.put("telephone", "07000000000");

		request.body(jsonObject.toString());

		response = request.post(Const.address + "/api/owners");
		json = response.then().statusCode(201);
	}

	@Test
	public void getOwnersList() {
		request = RestAssured.given().contentType(ContentType.JSON);
		response = request.when().get(Const.address + "/api/owners/*/lastname/Davis");
		json = response.then().statusCode(200);
	}

	@Test
	public void deleteOwner() {
		request = RestAssured.given().contentType(ContentType.JSON);
		response = request.when().delete(Const.address + "/api/owners/11");
		json = response.then().statusCode(204);
	}

	@Test
	public void getOwner() {
		request = RestAssured.given().contentType(ContentType.JSON);
		response = request.when().get(Const.address + "/api/owners/2");
		json = response.then().statusCode(200);
	}

	@Test
	public void updateOwner() {
		request = RestAssured.given().contentType(ContentType.JSON);
		request.header("Content-Type", "application/json");

		JSONObject jsonObject = new JSONObject();
		jsonObject.put("address", "Anchorage");
		jsonObject.put("city", "Manchester");
		jsonObject.put("firstName", "Man");
		jsonObject.put("id", 13);
		jsonObject.put("lastName", "Chester");
		jsonObject.put("telephone", "07000000000");

		request.body(jsonObject.toString());

		response = request.when().put(Const.address + "/api/owners/13");
		json = response.then().statusCode(204);
	}

}
