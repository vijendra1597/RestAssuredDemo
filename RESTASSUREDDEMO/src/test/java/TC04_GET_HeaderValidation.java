import io.restassured.RestAssured;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;


public class TC04_GET_HeaderValidation {

    @Test
    void GetHeaderValidation(){

        RestAssured.baseURI= "https://reqres.in";
        RequestSpecification httpRequest = RestAssured.given();
        Response response = httpRequest.request(Method.GET, "/api/users?page=2");
        String responseStr = response.getBody().asString();
        Headers allheader = response.headers();
        for(Header headerItem : allheader){

         System.out.println("Header Name is   "+ headerItem.getName() +"Header Value is " + headerItem.getValue());




        }


        
        









    }





}
