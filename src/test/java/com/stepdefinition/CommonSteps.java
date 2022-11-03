package com.stepdefinition;

import org.junit.Assert;

import io.cucumber.java.en.Then;



public class CommonSteps {

	@Then("User should verify the status code is {int}")
	public void userShouldVerifyTheStatusCodeIs(int expStatusCode) {
	    int actStatusCode = TC1_LoginStep.globalDatas.getStatusCode();
	    Assert.assertEquals("verify status code",expStatusCode,actStatusCode );
		
	}
}
