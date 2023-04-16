package Test;

import static io.restassured.RestAssured.given;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;

public class TestCase07 {
	@Test
	public void toDisplayUserDetails()
	{

		given().contentType(ContentType.JSON)

		.when().get("https://reqres.in/api/users?page=2")

		.then().assertThat().statusCode(200).log().all();
	}
}
