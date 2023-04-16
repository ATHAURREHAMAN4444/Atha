package Test;

import static io.restassured.RestAssured.given;

import java.util.Map;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import io.restassured.http.Headers;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;

public class TestCase03 {
	@Test
	public void tovalidateStatuCodeAndResponseMsg()
	{
		String expectedResponseMsg="SCO   in DCAT Project hsss_hsus is not in published state";

		Response resp = given().contentType(ContentType.JSON)

				.when().get("https://dcatppe.savvas.com/dcatweb/object/downloadPIFMedium/A0716333.zip")

				.then().log().all().using().extract().response();

		int actualStatusCode = resp.getStatusCode();
		Assert.assertEquals(actualStatusCode, 404);
		System.out.println("Status Code is Verified");

		ResponseBody body = resp.getBody();
		String actualResponseMsg = body.asPrettyString();
		System.out.println("actualResponseMsg ="+actualResponseMsg);

		Assert.assertEquals(actualResponseMsg, expectedResponseMsg);
		System.out.println("Response MSG is Verified");
	}
}
