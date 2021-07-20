import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC002_POST_Request {

    @Test
    void postCreateUser(){

        RestAssured.baseURI= "https://reqres.in";
        //Request Object
        RequestSpecification httpRequest = RestAssured.given();
        //Request Payload sending along with POST Request
        JSONObject requestParams = new JSONObject();
        requestParams.put("name", "Veda");
        requestParams.put("job", "Dr");
        httpRequest.header("Content-Type", "application/json");
        httpRequest.body(requestParams.toJSONString());

        //Creating Response Object and passing to String
        Response response = httpRequest.request(Method.POST,"/api/users/");
        //print response in console window
        String responseBody = response.getBody().asString();
        System.out.println("Response Body is   "+responseBody);
        //Status Code Validation
        int StatusCode = response.getStatusCode();
        System.out.println("status code is  " +StatusCode);
        Assert.assertEquals(StatusCode, 201);
        //Success code validation
        String SuccessCode = response.jsonPath().get("SuccessCode");





    }




}
