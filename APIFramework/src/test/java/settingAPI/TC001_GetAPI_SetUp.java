package settingAPI;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import configPackage.ReadConfigFile;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import java.io.IOException;
import java.io.InputStream;

import io.restassured.response.Response;

public class TC001_GetAPI_SetUp {
	static Response response;
	@Test
	public void setUp() throws IOException {
		
		String url=ReadConfigFile.getConfigData("url");
		System.out.println("The URL is : "+url);
		response = given().
				when().
				get(url).
				then().
				extract().
				response();
		System.out.println("The Json is: " + response.asString());
		  
	}

}
