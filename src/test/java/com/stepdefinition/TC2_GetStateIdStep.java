package com.stepdefinition;

import java.util.ArrayList;

import org.junit.Assert;

import com.baseclass.BaseClass;
import com.endpoints.EndPoints;

import com.pojo.address.GetStateId_Output_Pojo;
import com.pojo.address.StateList;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;

public class TC2_GetStateIdStep extends BaseClass {
	Response response;
	int stateIdNum;
	String state_id;

	@Given("User add Header for StateList endpoint")
	public void userAddHeaderForStateListEndpoint() {
		addHeader("accept", "application/json");
	}

	@When("User should send {string} request for StateId endpoint")
	public void userShouldSendRequestForStateIdEndpoint(String type) {
		response = requestType(type, EndPoints.STATELIST);
		int statusCode = getStatusCode(response);
		TC1_LoginStep.globalDatas.setStatusCode(statusCode);
	}

	@Then("User should verify the getStateId response message matches {string}")
	public void userShouldVerifyTheGetStateIdResponseMessageMatches(String expStateName) {
		GetStateId_Output_Pojo as = response.as(GetStateId_Output_Pojo.class);
		ArrayList<StateList> listStateDetails = as.getData();
		for (StateList eachStateList : listStateDetails) {
			String actStateName = eachStateList.getName();
			if (actStateName.equals(expStateName)) {
				stateIdNum = eachStateList.getId();
				state_id = String.valueOf(stateIdNum);
				TC1_LoginStep.globalDatas.setStateIdText(state_id);
				// System.out.println(state_id);
				Assert.assertEquals("verify state name", expStateName, actStateName);
				break;
			}

		}
	}
}
