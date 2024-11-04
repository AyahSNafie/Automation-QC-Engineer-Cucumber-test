package API_testing_Rest;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import static io.restassured.RestAssured.given;

import io.cucumber.java.en.When;

public class testingByAPI {

	// Set up base URI
	static {
		RestAssured.baseURI = "https://api-sandbox.orangehrm.com";
	}


	@When("API Auth")
	public static String getAuthToken() {
		RequestSpecification request = given().contentType("application/json");
		Response response = request
				.body("{\"client_id\": \"XXXXXXX\",, \"client_secret \": \"XXXXXXX\", \"grant_type\":\"XXXXXX \", \"username\": \"Admin\", \"password\": \"admin123\"}")
				.post("/oauth/issueToken");

		return response.jsonPath().getString("token");
	}
	

	@When("Add candidate")
	public static int addCandidate(String token) {
		// Create the request to add a candidate
		RequestSpecification request = given()
				.header("Authorization", "Bearer " + token)
				.contentType("application/json")
				.body("{ \"firstName\": \"Amina\", \"middleName\": \"Mohamed\", \"lastName\": \"Hossam\", \"email\": \"amina.hossam@ut.com\", \"joinedDate\": \"2022-04-05\", \"contactNo\": \"01111111111\" }");

		Response response = request.post("/api/recruitment/recruitedEmployees");

		if (response.statusCode() == 201) {
			int candidateId = response.jsonPath().getInt("id");
			System.out.println("Candidate added with ID: " + candidateId);
			return candidateId;
		} else {
			throw new RuntimeException("Failed to add candidate. Status Code: " + response.statusCode());
		}
	}

	@When("Delete Candidate")
	public static void deleteCandidate(String token, int candidateId) {
		// Delete the candidate by ID
		RequestSpecification request = given()
				.header("Authorization", "Bearer " + token)
				.contentType("application/json");

		Response response = request.delete("api/recruitment/candidate/" + candidateId+"/candidateDocuments");

		if (response.statusCode() == 200) {
			System.out.println("Candidate deleted successfully.");
		} else {
			throw new RuntimeException("Failed to delete candidate. Status Code: " + response.statusCode());
		}
	}
}