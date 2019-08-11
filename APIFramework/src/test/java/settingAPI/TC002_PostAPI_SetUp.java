package settingAPI;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;


public class TC002_PostAPI_SetUp {
	static Response response;
	int statusCode;
@Test
	public void setUp() {
		RequestSpecification httpRequest=RestAssured.given();
		JSONObject requestParam=new JSONObject();
		requestParam.put("FirstName","JohnXYZ");
		requestParam.put("lastName","XYZJohn");
		requestParam.put("UserName","JohnXYZ");
		requestParam.put("Password","JohnXYZxyz");
		requestParam.put("Email","JohnXYZ@gmail.com");
		//System.out.println(httpRequest.body(requestParam.toJSONString()));
		System.out.println(requestParam.toJSONString());
		response=given().
				contentType("application/json").
				accept("application/json").
				body(requestParam).
				when().
				post("http://restapi.demoqa.com/customer/register").
				then().
				extract().
				response();
		System.out.println(response.asString());
		statusCode=response.getStatusCode();
		if(statusCode==400) {
			System.out.println("The Status Code is: "+statusCode);
			System.out.println("Successful Transaction");
		}
		
	}
	
}
