package Test;

import static io.restassured.RestAssured.given;
import org.testng.Assert;
import org.testng.annotations.Test;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
public class TestCase02 {

	@Test
	public void tovalidateStatuCode()
	{
		//int expectedStatusCode=200;
		Response resp = given().contentType(ContentType.JSON)

				.when().get("https://dcatppe.savvas.com/dcatweb/object/downloadPIF/A0685000.zip")

				.then().log().all().using().extract().response();

		int actualStatusCode = resp.getStatusCode();
		Assert.assertEquals(actualStatusCode, 200);
		System.out.println("Status Code is Verified");

		//		if (actualStatusCode==200) {
		//			System.out.println("The status code is Validated "+actualStatusCode+" "+200+" are same");
		//		} else {
		//			System.out.println("The status code is Validated "+actualStatusCode+" "+200+" are not same");
		//		}

	}
}
