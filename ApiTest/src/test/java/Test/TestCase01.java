package Test;

import static io.restassured.RestAssured.*;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import org.testng.Assert;
import org.testng.annotations.Test;

public class TestCase01 {
	@Test
	public void toValidateStatusCode()
	{
		int expectedStatusCode = 200;
		Response resp = given().contentType(ContentType.JSON)

				.when().get("https://dcatppe.savvas.com/dcatweb/object/downloadPIFMedium/A0716173.zip")

				.then().log().all().using().extract().response();

		int actualStatusCode = resp.getStatusCode();
		Assert.assertEquals(actualStatusCode,expectedStatusCode);

		//		if (actualStatusCode==expectedStatusCode) {
		//			System.out.println("The status code is Validated "+actualStatusCode+" "+expectedStatusCode+" are same");
		//		} else {
		//			System.out.println("The status code is Validated "+actualStatusCode+" "+expectedStatusCode+" are not same");
		//		}
	}
}
