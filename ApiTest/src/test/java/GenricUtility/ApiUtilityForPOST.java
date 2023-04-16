package GenricUtility;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.when;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;

public class ApiUtilityForPOST {
	//to do POSTRequest
	public RequestSpecification precondition(String Pid,String Pvalue,JavaLibraray jobj)
	{
		RequestSpecification body = given().pathParam(Pid,Pvalue).contentType(ContentType.JSON).body(jobj);
		return body;
	}
	public Response action(String Pid,String Pvalue,JavaLibraray jobj,String URI)
	{
		return precondition(Pid, Pvalue, jobj).when().post(URI);
		
	}
	public ValidatableResponse Validation(String Pid,String Pvalue,JavaLibraray jobj,String URI,int statusCode)
	{
		Response resp = action(Pid, Pvalue, jobj, URI);
		return resp.then().assertThat().statusCode(statusCode).log().all();
	}
}
