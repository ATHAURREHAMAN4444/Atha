package Test;

import static io.restassured.RestAssured.given;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;

public class TestCase04 {
	@Test
	public void tovalidateStatuCodeAndResponseMsg()
	{

		String expectedResponseMsg="SCO A0678615 in DCAT Project hsss_hsus is not in published state";
		
		Response resp = given().contentType(ContentType.JSON)

				.when().get("https://dcatppe.savvas.com/dcatweb/object/downloadPIF/A0678615.zip")

				.then().log().all().using().extract().response();

		int actualStatusCode = resp.getStatusCode();
		Assert.assertEquals(actualStatusCode, 404);
		System.out.println("Status Code is Verified");

		ResponseBody body = resp.getBody();
		String actualResponseMsg = body.asPrettyString();
		System.out.println("actualResponseMsg is ="+actualResponseMsg);
		
		Assert.assertEquals(actualResponseMsg, expectedResponseMsg);
		System.out.println("Response MSG is Verified");
	}
}
