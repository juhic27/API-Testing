package steps;

import Utility.reportgenerator;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;

public class tc6_get extends reportgenerator{
	private static final String BASE_URL = "https://api.restful-api.dev";
	Response response;
	RequestSpecification request;
	ResponseBody body;
	String output;
	@Given("the user has Fake REST API endpoint")
	public void the_user_has_Fake_REST_API_endpoint() {
		startTest();
		System.out.println("User accessing the restful API endpoint");
		RestAssured.baseURI = BASE_URL;
		request = RestAssured.given();
	   
	}

	@When("the user retrieves the data")
	public void the_user_retrieves_the_data() {
		System.out.println("LIST OF ALL OBJECTS");
		request = RestAssured.given();
		response = request.get("/ojects");
	    
	}

	@Then("the system returns status  {int} OK")
	public void the_system_returns_status_OK(Integer int1) {
		output = response.asString();
		System.out.println(output);
		int statuscode = response.getStatusCode();
		System.out.println(statuscode);
		endTest();
		endReport();
	   
	}

}
