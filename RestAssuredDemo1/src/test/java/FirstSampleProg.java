import org.testng.annotations.Test;
import static org.testng.Assert.assertEquals;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

@Test
public class FirstSampleProg {
@Test public	void getweatherDetails()
	{
	
		//specify base URI
		
		//RestAssured.baseURI ="http://restapi.demoqa.com/utilities/weather/city";
		RestAssured.baseURI ="https://reqres.in/api/users";
		
		//Request object
		RequestSpecification httpRequest = RestAssured.given();
		
		//Response Object
		
		Response response = httpRequest.request(Method.GET, "/1");
		
		//print response in console window
		
		String responseBody = response.getBody().asString();
		System.out.println("Response Body is :" +responseBody);
		
		//status code validation
		
		int statusCode = response.getStatusCode();
		System.out.println("Status code is "+ statusCode);
		Assert.assertEquals(statusCode,200);
		
		
		
		
		
		
	}

}
