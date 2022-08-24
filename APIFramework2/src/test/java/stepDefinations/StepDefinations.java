package stepDefinations;

import io.cucumber.java.en.Given;
import static io.restassured.RestAssured.given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import resources.APIresources;
import resources.TestDataBuild;
import resources.Utils;
import static org.junit.Assert.*;

import java.io.IOException;

public class StepDefinations extends Utils{
	
//	RequestSpecification req;
//	ResponseSpecification res;
	
	RequestSpecification request;
	Response response;
	
	
	TestDataBuild data = new TestDataBuild();
	static String place_id;
	
	
	@Given("Add Place Payload with {string} {string} {string}")
	public void add_place_payload_with(String name, String language, String address) throws IOException {
	    // Write code here that turns the phrase above into concrete actions
	    request = given().spec(requestSpecification()).body(data.addPlacePayload(name, language, address));
	}
	@When("user calls {string} with {string} http request")
	public void user_calls_with_http_request(String resource, String httpMethod) {
	    // Write code here that turns the phrase above into concrete actions
		// Constructor will be called with value of resource you pass
		
		APIresources resourceAPI = APIresources.valueOf(resource);
		System.out.println(resourceAPI.getResource());
		
		if(httpMethod.equalsIgnoreCase("POST"))
			response = request.when().post(resourceAPI.getResource());
		else if(httpMethod.equalsIgnoreCase("GET"))
			response = request.when().get(resourceAPI.getResource());
	    		
	    		
//	    		.then().spec(responseSpecification()).extract().response();
	}
	@Then("the API call got success with status code {int}")
	public void the_api_call_got_success_with_status_code(Integer sCode) {
	    // Write code here that turns the phrase above into concrete actions
	    assertEquals(response.getStatusCode(),200);
	}
	@Then("{string} in response body is {string}")
	public void in_response_body_is(String key, String expectedValue) {
	    // Write code here that turns the phrase above into concrete actions
//	    String resp = response.asString();
//		JsonPath js = new JsonPath(resp);
	    
	    String actualValue = getJsonPath(response, key);
	    
	    assertEquals(actualValue,expectedValue);
	}
	
	@Then("verify place_Id created maps to {string} using {string}")
	public void verify_place_id_created_maps_to_using(String name, String resource) throws IOException {
	    // Write code here that turns the phrase above into concrete actions
	    place_id = getJsonPath(response, "place_id");
	    
	    request = given().spec(requestSpecification()).queryParam("place_id", place_id);
	    user_calls_with_http_request(resource, "GET");
	    
	    String actualName = getJsonPath(response, "name");
	    
	    assertEquals(actualName,name);
	}
	
	@Given("DeletePlace Payload")
	public void deleteplace_Payload() throws IOException {
	    // Write code here that turns the phrase above into concrete actions
	   
		request =given().spec(requestSpecification()).body(data.deletePlacePayload(place_id));
	}

}
