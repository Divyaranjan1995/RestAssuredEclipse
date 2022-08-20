package stepDefinations;

import static io.restassured.RestAssured.given;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

//import groovyjarjarantlr4.v4.misc.Utils;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import static org.junit.Assert.*;
import pojo.Location;
import pojo.addPlace;
import resources.TestDataBuild;
import resources.Utils;

public class stepDefination extends Utils {
	
	RequestSpecification req;
	ResponseSpecification res;
	RequestSpecification request;
	Response response;
	
	TestDataBuild data = new TestDataBuild();
	
	
	@Given("Add Place Payload with {string} {string} {string}")
	public void add_place_payload_with(String name, String language, String address) throws IOException {
	    // Write code here that turns the phrase above into concrete actions
		
		
		
		request = given().spec(requestSpecfification()).
		body(data.addPlacePayload(name, language, address));
		
	}
	@When("user calls {string} with POST http request")
	public void user_calls_with_post_http_request(String string) {
	    // Write code here that turns the phrase above into concrete actions
		response = request.
				when().post("maps/api/place/add/json").
				then().spec(responseSpecfification()).extract().response();
	}
	@Then("the API call got success with status code {int}")
	public void the_api_call_got_success_with_status_code(Integer int1) {
	    // Write code here that turns the phrase above into concrete actions
	    assertEquals(response.getStatusCode(),200);
	}
	@Then("{string} in response body is {string}")
	public void in_response_body_is(String key, String expectedValue) {
	    // Write code here that turns the phrase above into concrete actions
	    String resp = response.asString();
	    
	    JsonPath js = new JsonPath(resp);
	    
	    String acualValue = js.getString(key);
	    
	    assertEquals(acualValue,expectedValue);
	    
	}

}
