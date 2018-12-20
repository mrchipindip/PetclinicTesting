package com.cognizant;

import java.util.HashMap;

import org.json.JSONObject;
import org.junit.Test;

import com.sun.xml.xsom.impl.scd.Iterators.Map;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;

public class Pet {

	private RequestSpecification request;
	private Response response;
	private ValidatableResponse json;

	@Test
	public void getPets() {
		request = RestAssured.given().contentType(ContentType.JSON);
		response = request.when().get(Const.address + "/api/pets");
		json = response.then().statusCode(200);
	}

	@Test
	public void addPets() {
		request = RestAssured.given().contentType(ContentType.JSON);
		request.header("Content-Type", "application/json");


		JSONObject jsonObject = new JSONObject();
		jsonObject.put("birthDate", "2018/12/20");
		jsonObject.put("id", 0);
		jsonObject.put("name", "Chestar");
		jsonObject.put("type", "1");

		request.body(jsonObject.toString());

		response = request.post(Const.address + "/api/pets");
		json = response.then().statusCode(201);
	}

	@Test
	public void getPetTypes() {
		request = RestAssured.given().contentType(ContentType.JSON);
		response = request.when().get(Const.address + "/api/pets/pettypes");
		json = response.then().statusCode(200);
	}

//	@Test
//	public void deletePet() {
//		request = RestAssured.given().contentType(ContentType.JSON);
//		response = request.when().delete(Const.address + "/api/pets/13");
//		json = response.then().statusCode(204);
//	}

	@Test
	public void getPet() {
		request = RestAssured.given().contentType(ContentType.JSON);
		response = request.when().get(Const.address + "/api/owners/2");
		json = response.then().statusCode(200);
	}

//	@Test
//	public void updatePet() {
//		request = RestAssured.given().contentType(ContentType.JSON);
//		request.header("Content-Type", "application/json");
//
//		JSONObject jsonObject = new JSONObject();
//		jsonObject.put("address", "Anchorage");
//		jsonObject.put("city", "Manchester");
//		jsonObject.put("firstName", "Man");
//		jsonObject.put("id", 13);
//		jsonObject.put("lastName", "Chester");
//		jsonObject.put("telephone", "07000000000");
//
//		request.body(jsonObject.toString());
//
//		response = request.when().put(Const.address + "/api/owners/13");
//		json = response.then().statusCode(204);
//	}
	
}