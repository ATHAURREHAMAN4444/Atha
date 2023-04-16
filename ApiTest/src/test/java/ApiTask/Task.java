package ApiTask;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;
import org.testng.Assert;
import org.testng.annotations.Test;

import GenricUtility.ApiUtilityForPOST;
import GenricUtility.Iconstants;
import GenricUtility.JavaLibraray;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class Task {
	@Test
	public void toValidateStatusCode()
	{
		//01
		Response resp = given().contentType(ContentType.JSON)
				.when().get(Iconstants.A0716173URI)
				.then().log().all().using().extract().response();
		int actualStatusCode = resp.getStatusCode();
		Assert.assertEquals(actualStatusCode,200);
		System.out.println("Status Code is Verified");
		//02
		Response response = given().contentType(ContentType.JSON)
				.when().get(Iconstants.A0685000URI)
				.then().log().all().using().extract().response();
		int actualStatusCode1 = response.getStatusCode();
		Assert.assertEquals(actualStatusCode1, 200);//404
		System.out.println("Status Code is Verified");
	}

	@Test
	public void toValidateStatusCodeAndResponsMsg()
	{
		//03
		String expectedResponseMsg=Iconstants.A0716333ResponseMessage;
		Response resp = given().contentType(ContentType.JSON)
				.when().get(Iconstants.A0716333URI)
				.then().log().all().using().extract().response();
		int actualStatusCode = resp.getStatusCode();
		Assert.assertEquals(actualStatusCode, 404);
		String actualResponseMsg = resp.getBody().asPrettyString();
		Assert.assertEquals(actualResponseMsg, expectedResponseMsg);
		System.out.println("Status Code and Response Message is Verified");
		//04
		String expectedResponseMsg1=Iconstants.A0678615ResponseMessage;
		Response response = given().contentType(ContentType.JSON)
				.when().get(Iconstants.A0678615URI)
				.then().log().all().using().extract().response();
		int actualStatusCode1 = response.getStatusCode();
		Assert.assertEquals(actualStatusCode1, 404);
		String actualResponseMsg1 = resp.getBody().asPrettyString();
		Assert.assertEquals(actualResponseMsg1, expectedResponseMsg1);
		System.out.println("Status Code and Response Message is Verified");
	}

	@Test
	public void toValidateStatusCodeAndResponseMsg()
	{
		//05
		String expectedResponseMsg=Iconstants.A07163323ResponseMessage; 
		Response resp = given().contentType(ContentType.JSON)
				.when().get(Iconstants.A07163323URI)
				.then().log().all().using().extract().response();
		int actualStatusCode = resp.getStatusCode();
		Assert.assertEquals(actualStatusCode, 404);
		String actualResponseMsg = resp.getBody().asPrettyString();
		Assert.assertEquals(actualResponseMsg, expectedResponseMsg);
		System.out.println("Status Code and Response Message is Verified");
		//06
		String expectedResponseMsg1=Iconstants.A06786315ResponseMessage;
		Response response = given().contentType(ContentType.JSON)
				.when().get(Iconstants.A06786315URI)
				.then().log().all().using().extract().response();
		int actualStatusCode1 = response.getStatusCode();
		Assert.assertEquals(actualStatusCode1, 404);
		String actualResponseMsg1 = resp.getBody().asPrettyString();
		Assert.assertEquals(actualResponseMsg1, expectedResponseMsg1);
		System.out.println("Status Code and Response Message is Verified");
	}
	@Test
	public void toDisplayUserDetails()
	{
		//prerequisites
		baseURI="https://reqres.in/api";
		given().contentType(ContentType.JSON)
		//actions
		.when().get("/users?page=2")
		//Validations
		.then().assertThat().statusCode(200).log().all();
	}
	@Test
	public void toCreateRequest()
	{
		//08
		baseURI="https://reqres.in";
		JavaLibraray jObj = new JavaLibraray("eve.holt@reqres.in", "pistol");

		Response resp = given().pathParam("registerEndPonit", "register")
				.contentType(ContentType.JSON)
				.body(jObj)
				.when().post("/api/{registerEndPonit}");
		String registerToken = resp.jsonPath().get("token");
		//09
		JavaLibraray jObj1 = new JavaLibraray("eve.holt@reqres.in", "cityslicka");
		Response response = given().pathParam("loginEndPonit", "login")
				.contentType(ContentType.JSON)
				.body(jObj1)
				.when().post("/api/{loginEndPonit}");
		String loginToken = response.jsonPath().get("token");
		Assert.assertEquals(loginToken, registerToken);
		System.out.println("Token is Verified");
		resp.then().assertThat().statusCode(200).log().all();
		
	}
}
