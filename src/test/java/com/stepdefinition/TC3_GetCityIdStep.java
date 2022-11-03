package com.stepdefinition;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;

import com.baseclass.BaseClass;
import com.endpoints.EndPoints;
import com.payload.address.AddressPayload;
import com.pojo.address.CityList;
import com.pojo.address.GetCityId_Input_Pojo;
import com.pojo.address.GetCityId_Output_Pojo;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.response.Response;

public class TC3_GetCityIdStep extends BaseClass {
	
	Response response;
	int cityIdNum;
	

	@Given("User add Header for CityList endpoint")
	public void userAddHeaderForCityListEndpoint() {
		List<Header> listHeader = new ArrayList<Header>();
		Header h1 = new Header("accept", "application/json");
		Header h2 = new Header("Content-Type", "application/json");
		listHeader.add(h1);
		listHeader.add(h2);
		Headers headers = new Headers(listHeader);
		addHeaders(headers);

	}
	@When("User add request body for CityList {string}")
	public void userAddRequestBodyForCityList(String stateId) {
		
		AddressPayload addressPayload = new AddressPayload();
		GetCityId_Input_Pojo getCityId_Input_Pojo = addressPayload.getCityId(stateId);
	    addBody(getCityId_Input_Pojo);
		
	}
	@When("User should send {string} request for CityId endpoint")
	public void userShouldSendRequestForCityIdEndpoint(String type) {
	  
		
		response = requestType(type, EndPoints.CITYLIST);
		int statusCode = getStatusCode(response);
		TC1_LoginStep.globalDatas.setStatusCode(statusCode);
		
		
	}
	@Then("User should verify the CityId response body message matches {string}")
	public void userShouldVerifyTheCityIdResponseBodyMessageMatches(String expCityName) {
	  
		GetCityId_Output_Pojo as = response.as(GetCityId_Output_Pojo.class);
		ArrayList<CityList> listCityDetails = as.getData();
		for (CityList eachCityList : listCityDetails) {
			String actCityName = eachCityList.getName();
			if (actCityName.equals(expCityName)) {
				cityIdNum = eachCityList.getId();
				//System.out.println(cityIdNum);
				Assert.assertEquals( "verify Yercaud is present",expCityName,actCityName);
				break;

			}
		}
		
		
	}




}
