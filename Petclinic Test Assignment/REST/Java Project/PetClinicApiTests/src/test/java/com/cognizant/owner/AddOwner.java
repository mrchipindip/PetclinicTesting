package com.cognizant.owner;

import java.util.HashMap;

import org.json.JSONArray;
import org.json.JSONObject;
import org.junit.Test;

import com.sun.xml.xsom.impl.scd.Iterators.Map;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;

public class AddOwner {

	private RequestSpecification request;
	private Response response;
	private ValidatableResponse json;
	
	@Test
	public void postRequest() {
		request = RestAssured.given().contentType(ContentType.JSON);
		request.header("Content-Type", "application/json");
		
		
	

		response = request.post(Const.address + "/api/owners");
		json = response.then().statusCode(404);
	}
	
}