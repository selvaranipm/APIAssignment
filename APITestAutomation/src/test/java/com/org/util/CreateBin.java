package com.org.util;

import org.json.JSONObject;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class CreateBin {
	public static String id;
	
	@BeforeTest
	public void GenerateID() {
		System.out.println("Before Method");
		  String baseURI="https://api.jsonbin.io/v3/b";
		  
		  JSONObject json=new JSONObject();
		  json.put("sample","Hello universe");
		  
	 		RestAssured.baseURI=baseURI;
	 		Response response=RestAssured.given()
	 						.header("X-Master-Key","$2b$10$dlREyBjuOSWligP1B6ZJ5OiRtk8MHcoBEdnWl2Skoc.CO7HQlw4xW")
	 						.header("X-Bin-Private","false")
	 						.contentType("application/json")
	 						.body(json.toString())
	 						.post();
	 		
	 		JsonPath js=response.jsonPath();
	 		id=js.get("metadata.id");
	 		System.out.println(id);

}
}
