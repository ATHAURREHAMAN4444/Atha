package ApiTask;

import static io.restassured.RestAssured.baseURI;
import org.testng.Assert;
import org.testng.annotations.Test;

import GenricUtility.ApiUtilityForGET;
import GenricUtility.ApiUtilityForPOST;
import GenricUtility.Iconstants;
import GenricUtility.JavaLibraray;
import io.restassured.response.Response;

public class testClass {
	@Test
	public void toValidateStatusCode()
	{
		//01
		baseURI=Iconstants.A0716173URI;
		ApiUtilityForGET utility = new ApiUtilityForGET();
		Response resp = utility.ValidationWithoutBody(baseURI, 200).using().extract().response();
		int actualStatusCode = resp.getStatusCode();
		Assert.assertEquals(actualStatusCode, 200);
		System.out.println("Status Code is Veridied");
		//02
		Response response = utility.ValidationWithoutBody(Iconstants.A0685000URI, 200).using().extract().response();
		int actualStatusCode1 = response.getStatusCode();
		Assert.assertEquals(actualStatusCode1, 200);   //404
		System.out.println("Status Code is Verified");	
	}
	@Test
	public void toValidateStatusCodeAndResponsMsg()
	{
		//03
		String expectedResponseMsg=Iconstants.A0716333ResponseMessage;
		ApiUtilityForGET utility = new ApiUtilityForGET();
		Response resp = utility.actionWithoutBody(Iconstants.A0716333URI).then().using().extract().response();
		int actualStatusCode = resp.getStatusCode();
		Assert.assertEquals(actualStatusCode, 404);
		String actualResponseMsg = resp.getBody().asPrettyString();
		Assert.assertEquals(actualResponseMsg, expectedResponseMsg);
		System.out.println("Status Code and Response Message is Verified");
		//04
		String expectedResponseMsg1=Iconstants.A0678615ResponseMessage;
		Response response = utility.actionWithoutBody(Iconstants.A0678615URI).then().using().extract().response();
		int actualStatusCode1 = response.getStatusCode();
		Assert.assertEquals(actualStatusCode1, 404);
		String actualResponseMsg1 = response.getBody().asPrettyString();
		Assert.assertEquals(actualResponseMsg1, expectedResponseMsg1);
		System.out.println("Status Code and Response Message is Verified");
	}
	@Test
	public void toValidateStatusCodeAndResponseMsg()
	{
		//05
		String expectedResponseMsg=Iconstants.A07163323ResponseMessage;
		ApiUtilityForGET utility = new ApiUtilityForGET();
		Response resp = utility.actionWithoutBody(Iconstants.A07163323URI).then().using().extract().response();
		int actualStatusCode = resp.getStatusCode();
		Assert.assertEquals(actualStatusCode, 404);
		String actualResponseMsg = resp.getBody().asPrettyString();
		Assert.assertEquals(actualResponseMsg, expectedResponseMsg);
		System.out.println("Status Code and Response Message is Verified");
		//06
		String expectedResponseMsg1=Iconstants.A06786315ResponseMessage;
		Response response = utility.actionWithoutBody(Iconstants.A06786315URI).then().using().extract().response();
		int actualStatusCode1 = response.getStatusCode();
		Assert.assertEquals(actualStatusCode1, 404);
		String actualResponseMsg1 = response.getBody().asPrettyString();
		Assert.assertEquals(actualResponseMsg1, expectedResponseMsg1);
		System.out.println("Status Code and Response Message is Verified");

	}

	@Test
	public void toDisplayUserDetails()
	{
		//07
		baseURI="https://reqres.in/api";
		ApiUtilityForGET utility = new ApiUtilityForGET();
		utility.ValidationWithoutBody(baseURI+"/users?page=2", 200);
	}
	@Test
	public void PostRequest()
	{
		//08
		baseURI="https://reqres.in/api/";
		JavaLibraray Jobj = new JavaLibraray("eve.holt@reqres.in", "pistol");
		ApiUtilityForPOST utility = new ApiUtilityForPOST();
		Response resp = utility.action("RPid", "register", Jobj, baseURI+"{RPid}");
		String rigesterToken = resp.jsonPath().get("token");
		//09
		JavaLibraray Jobj1 = new JavaLibraray("eve.holt@reqres.in", "cityslicka");
		Response response = utility.action("LPid", "login", Jobj1, baseURI+"{LPid}");
		String loginToken = response.jsonPath().get("token");
		
		Assert.assertEquals(rigesterToken, loginToken);
		System.out.println("Tokens are Verfied");
		response.then().statusCode(200).log().all();
		System.out.println("Token and Status code is Verified");
	}

}
