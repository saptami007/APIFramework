package settingAPI;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import configPackage.ReadConfigFile;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import io.restassured.response.Response;

public class TC001_GetAPI_SetUp {
	static Response response;
	@Test
	public void setUp() throws IOException {
		
		String url=ReadConfigFile.getConfigData("url");
		System.out.println("The URL is : "+url);
		String contentType=ReadConfigFile.getConfigData("contentType");
		System.out.println("The Content Type is "+contentType);
		response = given().
				when().
				get(url).
				then().
				extract().
				response();
		System.out.println("The Json is: " + response.asString());
		List<Map<String, Object>> circuits=new ArrayList<Map<String,Object>>();
		circuits=response.jsonPath().get("MRData.CircuitTable.Circuits");
		for(Map<String,Object>index : circuits) {
			System.out.println("The Circuit Ids are: "+index.get("circuitId"));
			Map<String,Object> location=new HashMap<String, Object>();
			location=(Map<String, Object>) index.get("Location");
				System.out.println("The Latitudes are: "+location.get("lat"));
		}
		  
	}

}
