import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
@Test
public class TC001_GET_Request {

	@Test
	void getWeatherDetails()
	{

		//specify Base URI

		RestAssured.baseURI = "https://reqres.in";

		RequestSpecification httpRequest = RestAssured.given();

		//To Capture Response

		Response response = httpRequest.request(Method.GET, "/api/users?page=2");

		String responseOutput = response.getBody().asString();
		System.out.print("Response Body is  " + responseOutput);

		//Validating status code

		int StatusCode = response.getStatusCode();
		System.out.println("Status Code  is  " + StatusCode);
		Assert.assertEquals(StatusCode, 200);

		//Validating status Line

		String StatusLine = response.getStatusLine();
		System.out.print("Status Line  is  " + StatusLine);
		Assert.assertEquals(StatusLine, "HTTP/1.1 200 OK");




	}


}
 