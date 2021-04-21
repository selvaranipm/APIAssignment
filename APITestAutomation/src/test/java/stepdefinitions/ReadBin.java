package stepdefinitions;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.Test;

import cucumber.api.java.en.*;
import io.restassured.RestAssured;
import io.restassured.response.Response;

@Test(priority=1)
public class ReadBin {
	
	static Response response=null;
	static String basePath=null;
	static String id=null;
	
	@Given("^the endpoint URl$")
	public void the_endpoint_URl() throws Throwable {
		basePath="https://api.jsonbin.io/v3/b";
		 
	}

	@When("^I send a get request$")
	public void i_send_a_get_request() throws Throwable {
		RestAssured.basePath=basePath;
 		RestAssured.basePath=id;
		 
		  response=RestAssured.given()
					.header("X-Master-Key","$2b$10$dlREyBjuOSWligP1B6ZJ5OiRtk8MHcoBEdnWl2Skoc.CO7HQlw4xW")
					.get();
	}


	@Then("^verify the Bin is read$")
	public void verify_the_new_user_is_created() throws Throwable {
		
 		System.out.println(response.getStatusCode());
 		System.out.println(response.getBody().asString());
 		
 		
 		
	}

	@Then("^status code should be success$")
	public void status_code_should_be_success() throws Throwable {
		System.out.println(response.getStatusCode());
 		System.out.println(response.getBody().asString());
 		assertEquals(response.getStatusCode(), 200);
	}

}
