package Test;

import static io.restassured.RestAssured.*;

import java.util.HashMap;

import org.testng.annotations.Test;

import com.google.gson.JsonObject;

import io.restassured.http.ContentType;

public class TestCase08 {
	@Test
	public void toCreateRequest()
	{
		//prerequisites
		baseURI="https://reqres.in";
		
		String expectedToken="QpwL5tke4Pnpja7X4";
		
		HashMap map = new HashMap<>();
		map.put("email", "eve.holt@reqres.in");
		map.put("password", "pistol");
		
		given().pathParam("endPonit", "register")
		.contentType(ContentType.JSON)
		.body(map)
		//actions
		.when().post("/api/{endPonit}")
		//Validations
		.then().assertThat().statusCode(200).log().all();
	}
}
