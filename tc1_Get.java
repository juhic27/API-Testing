package steps;

import Utility.reportgenerator;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;

public class tc1_Get extends reportgenerator{
	private static final String BASE_URL = "https://api.restful-api.dev";
	Response response;
	RequestSpecification request;
	ResponseBody body;
	String output;

	@Given("the user has the Fake REST API endpoint")
	public void the_user_has_the_Fake_REST_API_endpoint() {
		startReport();
		startTest();
		System.out.println("User accessing the restful API endpoint");
		RestAssured.baseURI = BASE_URL;
		request = RestAssured.given();
	}

	@When("the user retrieves user data")
	public void the_user_retrieves_user_data() {
		System.out.println("LIST OF ALL OBJECTS");
		request = RestAssured.given();
		response = request.get("/objects");
	}

	@Then("the system returns status code 200OK")
	public void the_system_returns_status_code() {
		output = response.asString();
		System.out.println(output);
		int statuscode = response.getStatusCode();
		System.out.println(statuscode);
		endTest();
	}

}
