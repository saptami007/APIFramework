package settingAPI;

import java.util.List;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class TC001_Alternative_PostAPI_Call {
	@SuppressWarnings("unchecked")
	@Test
	public void alternativePostSetUp() {
		RequestSpecification httpRequest=RestAssured.given();
		Response response;
		int statusCode;
		JSONObject jsonObj=new JSONObject();
		Map<String,Object> locationArray=new HashMap<String,Object>();
		Map<String,Object> circuitArray=new HashMap<String, Object>();
		Map<String,Object> circuitTable=new HashMap<String, Object>();
		Map<String,Object> mrData=new HashMap<String, Object>();
		List<Map<String,Object>> circuits=new ArrayList<Map<String, Object>>();
		locationArray.put("lat", "-37.8497");
		locationArray.put("long", "144.968");
		locationArray.put("locality", "Melbourne");
		locationArray.put("country", "Australia");
		circuitArray.put("circuitId", "albert_park");
		circuitArray.put("url", "http:\\/\\/en.wikipedia.org\\/wiki\\/Melbourne_Grand_Prix_Circuit");
		circuitArray.put("circuitName", "Albert Park Grand Prix Circuit");
		circuitArray.put("Location", locationArray);
		circuits.add(circuitArray);
		circuitTable.put("season", "2017");
		circuitTable.put("Circuits",circuits);
		mrData.put("xmlns", "http:\\/\\/ergast.com\\/mrd\\/1.4");
		mrData.put("series", "f1");
		mrData.put("url", "http://ergast.com/api/f1/2017/circuits.json");
		mrData.put("limit", "30");
		mrData.put("offset", "0");
		mrData.put("total", "20");
		mrData.put("CircuitTable", circuitTable);
		
		jsonObj.put("MRData", mrData);
		System.out.println(jsonObj.toJSONString());
		httpRequest.header("Content-Type","application/json");
		httpRequest.body(jsonObj.toJSONString());
		response=httpRequest.post("http://ergast.com/api/f1/2017/circuit.json");
		System.out.println(response.asString());
		statusCode=response.getStatusCode();
				if(statusCode==400) {
					System.out.println("Successful Response: "+statusCode);
				}
		
	}

}
