package com.stepdefinition;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.junit.Assert;

import com.baseclass.BaseClass;
import com.endpoints.EndPoints;
import com.globaldata.GlobalDatas;
import com.pojo.login.Login_Output_Pojo;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;


public class TC1_LoginStep extends BaseClass {
	
static GlobalDatas globalDatas =new GlobalDatas();
      Response response;

	@Given("User add Header")
	public void userAddHeader() {
		addHeader("Content-Type", "application/json");
		
	}
	@When("User add basic authentication for login")
	public void userAddBasicAuthenticationForLogin() throws FileNotFoundException, IOException {
		basicAuth(getPropertyFileValue("userName"), getPropertyFileValue("password"));
		
	}
	@When("User should send {string} request for login endpoint")
	public void userShouldSendRequestForLoginEndpoint(String type) {
		response = requestType(type, EndPoints.POSTMANBASICAUTH);
		int statusCode = getStatusCode(response);
		//System.out.println(statusCode);
		globalDatas.setStatusCode(statusCode);
	}
	
	@Then("User should verify the login response body firstName present as {string} and get the logtoken saved")
	public void userShouldVerifyTheLoginResponseBodyFirstNamePresentAsAndGetTheLogtokenSaved(String expFirstName) {
		Login_Output_Pojo login_Output_Pojo = response.as(Login_Output_Pojo.class);
		String logtoken = login_Output_Pojo.getData().getLogtoken();
		globalDatas.setLogtoken(logtoken);
		String first_name = login_Output_Pojo.getData().getFirst_name();
		Assert.assertEquals("verify firstname",expFirstName,first_name );
		
	}




}
