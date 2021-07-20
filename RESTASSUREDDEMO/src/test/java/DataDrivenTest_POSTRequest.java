import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataDrivenTest_POSTRequest {
    @Test(dataProvider ="PostMethodValues" )
    void PostEmpData(String eName, String eJob){

        RestAssured.baseURI= "https://reqres.in";
        RequestSpecification httpRequest = RestAssured.given();

        //Creating JSON Object Parameters to send along with request

        JSONObject requestParams = new JSONObject();
        requestParams.put("name",eName);
        requestParams.put("job",eJob);
        httpRequest.header("ContentType", "application/json");
        httpRequest.body(requestParams.toJSONString());
        Response response = httpRequest.request(Method.POST, "/api/users/");
        String responseBody = response.getBody().asString();
        System.out.println("Response Body is   " + responseBody);
        Assert.assertEquals(responseBody.contains("id"),true);

    }

    @DataProvider(name="PostMethodValues")
    Object[] PostEmpDataParams(){

     String paramms [][]={{"Veda","Dr"},{"Keerthi", "HR"},{"Vijjj", "IT"}};
     return(paramms);


}



}
