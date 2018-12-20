package com.cognizant;

import org.json.JSONObject;
import org.junit.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;

public class Visit {

	private RequestSpecification request;
	private Response response;
	private ValidatableResponse json;

	@Test
	public void getAllVisits() {
		request = RestAssured.given().contentType(ContentType.JSON);
		response = request.when().get(Const.address + "/api/visits");
		json = response.then().statusCode(200);
	}

//	@Test
//	public void addVisit() {
//		request = RestAssured.given().contentType(ContentType.JSON);
//		request.header("Content-Type", "application/json");
//
//		JSONObject jsonObject = new JSONObject();
//		jsonObject.put("date", "2018/12/20");
//		jsonObject.put("description", "Chestar");
//		jsonObject.put("id", 0);
//
//		request.body(jsonObject.toString());
//
//		response = request.post(Const.address + "/api/visits");
//		json = response.then().statusCode(201);
//	}
//
	@Test
	public void deleteVisit() {
		request = RestAssured.given().contentType(ContentType.JSON);
		response = request.when().delete(Const.address + "/api/visits/4");
		json = response.then().statusCode(204);
	}

	@Test
	public void getVisit() {
		request = RestAssured.given().contentType(ContentType.JSON);
		response = request.when().get(Const.address + "/api/visits/1");
		json = response.then().statusCode(200);
	}

//	@Test
//	public void updateVisit() {
//		request = RestAssured.given().contentType(ContentType.JSON);
//		request.header("Content-Type", "application/json");
//
//		JSONObject jsonObject = new JSONObject();
//		jsonObject.put("date", "2018/12/20");
//		jsonObject.put("description", "Chestar");
//		jsonObject.put("id", 0);
//
//		request.body(jsonObject.toString());
//
//		response = request.when().put(Const.address + "/api/visits/8");
//		json = response.then().statusCode(204);
//	}
	
}