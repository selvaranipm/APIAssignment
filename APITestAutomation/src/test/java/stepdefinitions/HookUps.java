package stepdefinitions;



import org.json.JSONObject;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class HookUps {
	public static String id=null;
	
	@Before
	public void InitializeEndPoint() {
		System.out.println("Feature Test is in progress");
		System.out.println("***************************************");
		System.out.println("Before HookUp is called");
		RestAssured.baseURI="https://api.jsonbin.io/v3/b";
		
	}
	
	@Before("@smoke")
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
	
	@After
	public void TestCLose() {
		System.out.println("Test case is executed succesfully");
		System.out.println("***************************************\n\n\n\n\n\n");
		
	}

}
