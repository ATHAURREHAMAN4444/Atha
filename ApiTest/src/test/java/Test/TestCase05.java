package Test;

import static io.restassured.RestAssured.given;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;

public class TestCase05 {
	@Test
	public void tovalidateStatuCodeAndResponseMsg()
	{
		String expectedResponseMsg="SCO A07163323 is not available in DCAT"; 
		Response resp = given().contentType(ContentType.JSON)

				.when().get("https://dcatppe.savvas.com/dcatweb/object/downloadPIFMedium/A07163323.zip")

				.then().log().all().using().extract().response();

		int actualStatusCode = resp.getStatusCode();
		Assert.assertEquals(actualStatusCode, 404);

		ResponseBody body = resp.getBody();
		String actualResponseMsg = body.asPrettyString();
		System.out.println("error msg is = "+actualResponseMsg); 

		Assert.assertEquals(actualResponseMsg, expectedResponseMsg);
	}
}
