package stepDefinations;

import io.cucumber.java.en.Given;
import static io.restassured.RestAssured.given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
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
	
	
	@Given("Add Place Payload")
	public void add_place_payload() throws IOException {
	    // Write code here that turns the phrase above into concrete actions
	    request = given().spec(requestSpecification()).body(data.addPlacePayload());
	}
	@When("user calls {string} with Post http request")
	public void user_calls_with_post_http_request(String string) {
	    // Write code here that turns the phrase above into concrete actions
	    response = request
	    		.when().post("maps/api/place/add/json")
	    		.then().spec(responseSpecification()).extract().response();
	}
	@Then("the API call got success with status code {int}")
	public void the_api_call_got_success_with_status_code(Integer sCode) {
	    // Write code here that turns the phrase above into concrete actions
	    assertEquals(response.getStatusCode(),200);
	}
	@Then("{string} in response body is {string}")
	public void in_response_body_is(String key, String expectedValue) {
	    // Write code here that turns the phrase above into concrete actions
	    String resp = response.asString();
		JsonPath js = new JsonPath(resp);
	    
	    String actualValue = js.getString(key);
	    
	    assertEquals(actualValue,expectedValue);
	}

}
