package com.cognizant;

import org.json.JSONObject;
import org.junit.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;

public class PetType {

	private RequestSpecification request;
	private Response response;
	private ValidatableResponse json;

	@Test
	public void getAllPetTypes() {
		request = RestAssured.given().contentType(ContentType.JSON);
		response = request.when().get(Const.address + "/api/pettypes");
		json = response.then().statusCode(200);
	}

	@Test
	public void addPetType() {
		request = RestAssured.given().contentType(ContentType.JSON);
		request.header("Content-Type", "application/json");

		JSONObject jsonObject = new JSONObject();
		jsonObject.put("id", 0);
		jsonObject.put("name", "Chestar");

		request.body(jsonObject.toString());

		response = request.post(Const.address + "/api/pettypes");
		json = response.then().statusCode(201);
	}

	@Test
	public void deletePetType() {
		request = RestAssured.given().contentType(ContentType.JSON);
		response = request.when().delete(Const.address + "/api/pets/6");
		json = response.then().statusCode(204);
	}

	@Test
	public void getPet() {
		request = RestAssured.given().contentType(ContentType.JSON);
		response = request.when().get(Const.address + "/api/pettypes/1");
		json = response.then().statusCode(200);
	}

	@Test
	public void updatePet() {
		request = RestAssured.given().contentType(ContentType.JSON);
		request.header("Content-Type", "application/json");

		JSONObject jsonObject = new JSONObject();
		jsonObject.put("id", 7);
		jsonObject.put("name", "Chestar");

		request.body(jsonObject.toString());

		response = request.when().put(Const.address + "/api/pettypes/7");
		json = response.then().statusCode(204);
	}

}
