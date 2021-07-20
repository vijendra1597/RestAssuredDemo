import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class SecondSampleProg {
	@Test 
	public	void RegisterUsers()
	{
	
		//specify base URI
		
		
		RestAssured.baseURI ="https://reqres.in/api";
		
		//Request object
		RequestSpecification httpRequest = RestAssured.given();
		
		//Response Object
		
		JSONObject requestparams = new JSONObject();
		requestparams.put("id","101");
		requestparams.put("email","byron.fields101@reqres.in");
		requestparams.put("first_name","vijendra");
		requestparams.put("last_name","Babu");
		requestparams.put("avatar","https://reqres.in/img/faces/10-image.jpg");
		
		//Need to specify content type which is JSON in current example
		httpRequest.header("Content-Type", "application/json");
		//Convert the body to JSON Request
		httpRequest.body(requestparams.toJSONString());
		//Response Object
		Response response = httpRequest.request(Method.POST,"/users");
		
		
		//print response in console window
		
		String responseBody = response.getBody().asString();
		System.out.println("Response Body is :" +responseBody);
		
		//status code validation
		
		int statusCode = response.getStatusCode();
		System.out.println("Status code is "+ statusCode);
		Assert.assertEquals(statusCode,201);
		
				
		
		
		
	}
	
	
	
	
	
	
	
	

}
