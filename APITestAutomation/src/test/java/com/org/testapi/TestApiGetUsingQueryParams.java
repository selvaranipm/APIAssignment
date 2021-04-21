package com.org.testapi;

import static org.testng.Assert.assertEquals;

import org.json.JSONObject;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import com.org.util.CreateBin;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class TestApiGetUsingQueryParams {
     static String id=null;
	
	@BeforeTest
	public void GenerateID() {
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
	 		System.out.println(response.getStatusCode());
	 		System.out.println(response.getBody().asString());
   }
	
	@Test(priority=1)
	public void readjasonBin()
	{
        String baseURI="https://api.jsonbin.io/v3/b";
 		
 		RestAssured.baseURI=baseURI;
 		RestAssured.basePath=id;
 		Response response=RestAssured
 				.given()
 				.header("X-Master-Key","$2b$10$dlREyBjuOSWligP1B6ZJ5OiRtk8MHcoBEdnWl2Skoc.CO7HQlw4xW")
 				.get();
 		
 		System.out.println(response.getStatusCode());
 		System.out.println(response.getBody().asString());
	}
	
	@Test (priority=2)
	public void AupdatejasonBin()
	{
		String baseURI="https://api.jsonbin.io/v3/b";
		  
		  JSONObject json=new JSONObject();
			 json.put("sample","Hello world");
		  
	 		RestAssured.baseURI=baseURI;
	 		RestAssured.basePath=id;
	 		Response response=RestAssured.given()
	 						.header("X-Master-Key","$2b$10$dlREyBjuOSWligP1B6ZJ5OiRtk8MHcoBEdnWl2Skoc.CO7HQlw4xW")
	 						.header("X-Bin-Private","true")
	 						.contentType("application/json")
	 						.body(json.toString())
	 						.put();
	 		
	 		System.out.println(response.getStatusCode());
	 		System.out.println(response.getBody().asString());	
	}
    	@Test(priority=5)
		public void deletejasonBin()
		{
			RestAssured.baseURI="https://api.jsonbin.io/v3/b";
			RestAssured.basePath=id;
				Response putObject1=RestAssured.given()
						.header("X-Master-Key","$2b$10$dlREyBjuOSWligP1B6ZJ5OiRtk8MHcoBEdnWl2Skoc.CO7HQlw4xW")
						.delete();
				System.out.println(putObject1.getStatusCode());
		 		System.out.println(putObject1.getBody().asString());
		}
		
		@Test(priority=6)
		public void delversionsBin()
		{
			RestAssured.baseURI="https://api.jsonbin.io/v3/b/607c91f25b165e19f622f0e3/versions";
		//	RestAssured.basePath=id+"/versions";
			Response putObject1=RestAssured.given()
					.header("X-Master-Key","$2b$10$dlREyBjuOSWligP1B6ZJ5OiRtk8MHcoBEdnWl2Skoc.CO7HQlw4xW")
					
					.delete();
			System.out.println(putObject1.getStatusCode());
	 		System.out.println(putObject1.getBody().asString());
		}

    @Test (priority=3)
		public void changeprivacyBin()
		{
			String baseURI="https://api.jsonbin.io/v3/b/607c9356ee971419c4dc7984/meta/privacy";
			  
			  JSONObject json=new JSONObject();
				 json.put("sample","Hello worldies");
			  
		 		RestAssured.baseURI=baseURI;
		 		RestAssured.basePath=id;
		 		Response response=RestAssured.given()
		 						.header("X-Master-Key","$2b$10$dlREyBjuOSWligP1B6ZJ5OiRtk8MHcoBEdnWl2Skoc.CO7HQlw4xW")
		 						.header("X-Bin-Private","true")
		 						.contentType("application/json")
		 						.body(json.toString())
		 						.put();
		 		
		 		System.out.println(response.getStatusCode());
		 		System.out.println(response.getBody().asString());	
		}
		
		@Test (priority=4)
		public void versionscountBin()
		{
	       String baseURI="https://api.jsonbin.io/v3/b/607c9356ee971419c4dc7984/versions/count";
	 		
	 		RestAssured.baseURI=baseURI;
	 		RestAssured.basePath=id;
	 		Response response=RestAssured.given()
	 				.header("X-Master-Key","$2b$10$dlREyBjuOSWligP1B6ZJ5OiRtk8MHcoBEdnWl2Skoc.CO7HQlw4xW")
	 				.header("X-Bin-Private","true")
					.contentType("application/json")
	 				.get();
	 		System.out.println(response.getStatusCode());
	 		System.out.println(response.getBody().asString());
		}
		
	//@Test
    public void queryParameter() {

		RestAssured.baseURI ="https://samples.openweathermap.org/data/2.5/"; 
		RequestSpecification request = RestAssured.given();
		
		Response response =  request
							.queryParam("q", "London,UK") 
							.queryParam("appid", "2b1fd2d7f77ccf1b7de9b441571b39b8") 
							.get("/weather");
		
		assertEquals(response.getStatusCode(), 200);
		System.out.println(response.getStatusCode());
		System.out.println(response.asString());
		//Assert.assertEquals(jsonString.contains("London"), true);
		
		JsonPath js = response.jsonPath();
			System.out.println("coord " + js.get("coord"));
			System.out.println("name " + js.get("name"));
			System.out.println("country " + js.get("country"));
			System.out.println("clouds " + js.get("clouds"));
			System.out.println("main.humidity " + js.get("main.humidity"));
			System.out.println("main.temp_min " + js.get("main.temp_min"));
		
			 JSONObject jsonResponseResult=new JSONObject(response.getBody().asString()); 
				System.out.println(jsonResponseResult.get("name"));
}
	
    }
	

