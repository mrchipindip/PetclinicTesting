package com.cognizant;

import org.json.JSONObject;
import org.junit.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;

public class Specialty {

	private RequestSpecification request;
	private Response response;
	private ValidatableResponse json;

	@Test
	public void getAllSpecialtys() {
		request = RestAssured.given().contentType(ContentType.JSON);
		response = request.when().get(Const.address + "/api/specialties");
		json = response.then().statusCode(200);
	}

	@Test
	public void addSpecialty() {
		request = RestAssured.given().contentType(ContentType.JSON);
		request.header("Content-Type", "application/json");

		JSONObject jsonObject = new JSONObject();
		jsonObject.put("id", 0);
		jsonObject.put("name", "Chestar");

		request.body(jsonObject.toString());

		response = request.post(Const.address + "/api/specialties");
		json = response.then().statusCode(201);
	}

	@Test
	public void deleteSpecialty() {
		request = RestAssured.given().contentType(ContentType.JSON);
		response = request.when().delete(Const.address + "/api/specialties/4");
		json = response.then().statusCode(204);
	}

	@Test
	public void getSpecialty() {
		request = RestAssured.given().contentType(ContentType.JSON);
		response = request.when().get(Const.address + "/api/specialties/1");
		json = response.then().statusCode(200);
	}

	@Test
	public void updateSpecialty() {
		request = RestAssured.given().contentType(ContentType.JSON);
		request.header("Content-Type", "application/json");

		JSONObject jsonObject = new JSONObject();
		jsonObject.put("id", 5);
		jsonObject.put("name", "Chestars");

		request.body(jsonObject.toString());

		response = request.when().put(Const.address + "/api/specialties/5");
		json = response.then().statusCode(204);
	}
	
}