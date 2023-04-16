package Test;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;

import java.util.HashMap;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;

public class TestCase09 {
	@Test
	public void toValidateRespondeBodyData()
	{
		//prerequisites
		baseURI="https://reqres.in";
		
		String expectedToken="QpwL5tke4Pnpja7X4";
		
		HashMap map = new HashMap<>();
		map.put("email", "eve.holt@reqres.in");
		map.put("password", "cityslicka");
		
		Response resp = given().pathParam("endPonit", "login")
		.contentType(ContentType.JSON)
		.body(map)
		
		//actions
		.when().get("/api/{endPonit}");
		resp.then().assertThat().log().all();
//		String actualToken = resp.jsonPath().get("token");
//		
//		Assert.assertEquals(actualToken, expectedToken);
//		System.out.println("Data is Verified");
//		
//		//Validations
//		resp.then().assertThat().statusCode(200).log().all();
	}
}
