package com.stepdefinition;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;

import com.baseclass.BaseClass;
import com.endpoints.EndPoints;
import com.pojo.product.ProductSearch_Input_Pojo;
import com.pojo.product.ProductSearch_Output_Pojo;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.response.Response;

public class TC5_ProductSearchStep extends BaseClass {

	Response response;

	@Given("User add Header for Search Product endpoint")
	public void userAddHeaderForSearchProductEndpoint() {
		List<Header> listHeader = new ArrayList<Header>();
		Header h1 = new Header("accept", "application/json");
		Header h2 = new Header("Content-Type", "application/json");
		listHeader.add(h1);
		listHeader.add(h2);
		Headers headers = new Headers(listHeader);
		addHeaders(headers);

	}

	@When("User add request body for Search Product {string}")
	public void userAddRequestBodyForSearchProduct(String nuts) {
		ProductSearch_Input_Pojo productSearch_Input_Pojo = new ProductSearch_Input_Pojo(nuts);
		addBody(productSearch_Input_Pojo);

	}

	@When("User should send {string} for Search Product endpoint")
	public void userShouldSendForSearchProductEndpoint(String type) {
		response = requestType(type, EndPoints.SEARCHPRODUCT);
		int statusCode = getStatusCode(response);
		TC1_LoginStep.globalDatas.setStatusCode(statusCode);

	}

	@Then("User should verify Search Product response body message {string}")
	public void userShouldVerifySearchProductResponseBodyMessage(String expMessage) {
		ProductSearch_Output_Pojo productSearch_Output_Pojo = response.as(ProductSearch_Output_Pojo.class);
		String actMessage = productSearch_Output_Pojo.getMessage();
		Assert.assertEquals("verify search product response body message", expMessage, actMessage);
	}

}
