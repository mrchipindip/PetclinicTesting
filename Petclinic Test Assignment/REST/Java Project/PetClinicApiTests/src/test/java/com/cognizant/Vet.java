package com.cognizant;

import org.json.JSONObject;
import org.junit.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;

public class Vet {

	private RequestSpecification request;
	private Response response;
	private ValidatableResponse json;

	@Test
	public void getAllVets() {
		request = RestAssured.given().contentType(ContentType.JSON);
		response = request.when().get(Const.address + "/api/vets");
		json = response.then().statusCode(200);
	}

	@Test
	public void addVet() {
		request = RestAssured.given().contentType(ContentType.JSON);
		request.header("Content-Type", "application/json");

		JSONObject jsonObject = new JSONObject();
		jsonObject.put("firstName", "Chest");
		jsonObject.put("id", 0);
		jsonObject.put("lastName", "Star");

		request.body(jsonObject.toString());

		response = request.post(Const.address + "/api/vets");
		json = response.then().statusCode(201);
	}

	@Test
	public void deleteVet() {
		request = RestAssured.given().contentType(ContentType.JSON);
		response = request.when().delete(Const.address + "/api/vets/7");
		json = response.then().statusCode(204);
	}

	@Test
	public void getVet() {
		request = RestAssured.given().contentType(ContentType.JSON);
		response = request.when().get(Const.address + "/api/vets/1");
		json = response.then().statusCode(200);
	}

	@Test
	public void updateVet() {
		request = RestAssured.given().contentType(ContentType.JSON);
		request.header("Content-Type", "application/json");

		JSONObject jsonObject = new JSONObject();
		jsonObject.put("firstName", "Chest");
		jsonObject.put("id", 8);
		jsonObject.put("lastName", "Star");

		request.body(jsonObject.toString());

		response = request.when().put(Const.address + "/api/vets/8");
		json = response.then().statusCode(204);
	}

}