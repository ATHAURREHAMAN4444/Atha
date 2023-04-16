package GenricUtility;
import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.when;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;

public class ApiUtilityForGET {
	//to do GETRequest With Body
	public RequestSpecification preconditionWithBody(JavaLibraray jobj)
	{
		RequestSpecification body = given().contentType(ContentType.JSON).body(jobj);
		return body;
	}
	public Response actionWithBody(JavaLibraray jobj,String URI)
	{
		return preconditionWithBody(jobj).when().get(URI);
		 
	}
	public ValidatableResponse ValidationWithBody(JavaLibraray jobj,String URI,int statusCode)
	{
		return actionWithBody(jobj, URI).then().assertThat().statusCode(statusCode).log().all();
		
	}
	
	//to do GETRequst Without Body
	public RequestSpecification preconditionWithoutBody()
	{
		RequestSpecification body = given().contentType(ContentType.JSON);
		return body;
	}
	public Response actionWithoutBody(String URI)
	{
		return preconditionWithoutBody().when().get(URI);
	}
	public ValidatableResponse ValidationWithoutBody(String URI,int statusCode)
	{
		 return actionWithoutBody(URI).then().assertThat().statusCode(statusCode).log().all();
	
	}
}
