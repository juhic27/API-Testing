package steps;
import org.json.simple.JSONObject;

import Utility.reportgenerator;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;
public class tc5_patch  extends reportgenerator{
	private static final String BASE_URL = "https://jsonplaceholder.typicode.com/posts/1";
	Response response;
	RequestSpecification request;
	String output;
	ResponseBody body;

	@Given("the user in the HOME page for patch data")
	public void the_user_in_the_HOME_page_for_patch_data() {
		startTest();
		
		System.out.println("user in the home page");
		RestAssured.baseURI = BASE_URL;
		request = RestAssured.given();
	}

	@When("he patch the data")
	public void he_patch_the_data() {
		JSONObject requestParams = new JSONObject();
		requestParams.put("juhi27", 11);
		requestParams.put("id", 101);
		requestParams.put("title", "testing");
		requestParams.put("body", "user access the data");
		request.header("Content-Type", "application/json");
		request.body(requestParams.toJSONString());
		response = request.patch();
		body = response.body();
	}

	@Then("the system return the status code as {int}")
	public void the_system_return_the_status_code_as(Integer int1) {
		System.out.println("Validates status code");
		System.out.println(response.getStatusLine());
		System.out.println(body.asString());
		assert response.getStatusCode() == int1
				: "Expected status code " + int1 + " but got " + response.getStatusCode();
		endTest();
		//endReport();
		
	}

}
