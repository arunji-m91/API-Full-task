package com.stepdefinition;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;

import com.baseclass.BaseClass;
import com.endpoints.EndPoints;
import com.pojo.address.AddUserAddress_Input_Pojo;
import com.pojo.address.AddUserAddress_Output_Pojo;
import com.pojo.address.DeleteUserAddress_Input_Pojo;
import com.pojo.address.DeleteUserAddress_Output_Pojo;
import com.pojo.address.GetUserAddress_Output_Pojo;
import com.pojo.address.UpdateUserAddress_Input_Pojo;
import com.pojo.address.UpdateUserAddress_Output_Pojo;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.response.Response;

public class TC4_AddressStep extends BaseClass {
	Response response;
	int countryInt;

	@Given("User add Header and bearer authorization for accessing address endpoints")
	public void userAddHeaderAndBearerAuthorizationForAccessingAddressEndpoints() {
		List<Header> listHeader = new ArrayList<Header>();
		Header h1 = new Header("accept", "application/json");
		Header h2 = new Header("Authorization", " Bearer " + TC1_LoginStep.globalDatas.getLogtoken());
		Header h3 = new Header("Content-Type", "application/json");
		listHeader.add(h1);
		listHeader.add(h2);
		listHeader.add(h3);
		Headers headers = new Headers(listHeader);
		addHeaders(headers);
	}

	@When("User add request body for add new address {string},{string},{string},{string},{string},{string},{string},{string},{string} and {string}")
	public void userAddRequestBodyForAddNewAddressAnd(String first_name, String last_name, String mobile,
			String apartment, String state, String city, String country, String zipcode, String address,
			String address_type) {
		countryInt = Integer.parseInt(country);
		AddUserAddress_Input_Pojo addUserAddress_Input_Pojo = new AddUserAddress_Input_Pojo(first_name, last_name,
				mobile, apartment, TC1_LoginStep.globalDatas.getStateId(), TC1_LoginStep.globalDatas.getCityId(),
				countryInt, zipcode, address, address_type);
		addBody(addUserAddress_Input_Pojo);
	}

	@When("User send {string} request for addUserAddress endpoint")
	public void userSendRequestForAddUserAddressEndpoint(String type) {
		response = requestType(type, EndPoints.ADDUSERADDRESS);
		int statusCode = getStatusCode(response);
		TC1_LoginStep.globalDatas.setStatusCode(statusCode);
	}

	@Then("User should verify the addUserAddress response message {string}")
	public void userShouldVerifyTheAddUserAddressResponseMessage(String expMessage) {
		AddUserAddress_Output_Pojo addUserAddress_Output_Pojo = response.as(AddUserAddress_Output_Pojo.class);
		String actMessage = addUserAddress_Output_Pojo.getMessage();
		int address_id = addUserAddress_Output_Pojo.getAddress_id();
		String addressId = String.valueOf(address_id);
		TC1_LoginStep.globalDatas.setAddressId(addressId);
		Assert.assertEquals("verify addUserAddress response message", expMessage, actMessage);
	}

	@When("User add request body for update address {string},{string},{string},{string},{string},{string},{string},{string},{string},{string} and {string}")
	public void userAddRequestBodyForUpdateAddressAnd(String addressId, String first_name, String last_name,
			String mobile, String apartment, String state, String city, String country, String zipcode, String address,
			String address_type) {

		UpdateUserAddress_Input_Pojo updateUserAddress_Input_Pojo = new UpdateUserAddress_Input_Pojo(
				TC1_LoginStep.globalDatas.getAddressId(), first_name, last_name, mobile, apartment,
				TC1_LoginStep.globalDatas.getStateId(), TC1_LoginStep.globalDatas.getCityId(), countryInt, zipcode,
				address, address_type);
		addBody(updateUserAddress_Input_Pojo);

	}

	@When("User send {string} request for updateUserAddress endpoint")
	public void userSendRequestForUpdateUserAddressEndpoint(String type) {

		response = requestType(type, EndPoints.UPDATEUSERADDRESS);
		int statusCode = getStatusCode(response);
		System.out.println(statusCode);
		TC1_LoginStep.globalDatas.setStatusCode(statusCode);

	}

	@Then("User should verify the updateUserAddress response message {string}")
	public void userShouldVerifyTheUpdateUserAddressResponseMessage(String expMessage) {

		UpdateUserAddress_Output_Pojo updateUserAddress_Output_Pojo = response.as(UpdateUserAddress_Output_Pojo.class);
		String actMessage = updateUserAddress_Output_Pojo.getMessage();
		Assert.assertEquals("verify the updateUserAddress success message", expMessage, actMessage);
	}

	@Given("User send {string} request for getUserAddress endpoint")
	public void userSendRequestForGetUserAddressEndpoint(String type) {
		response = requestType(type, EndPoints.GETUSERADDRESS);
		int statusCode = getStatusCode(response);
		TC1_LoginStep.globalDatas.setStatusCode(statusCode);

	}

	@Then("User should verify the getUserAddress response message {string}")
	public void userShouldVerifyTheGetUserAddressResponseMessage(String expMessage) {

		GetUserAddress_Output_Pojo getUserAddress_Output_Pojo = response.as(GetUserAddress_Output_Pojo.class);
		String actMessage = getUserAddress_Output_Pojo.getMessage();
		Assert.assertEquals("verify getUserAddress response message", expMessage, actMessage);

	}

	@When("User add request body for Delete user address {string}")
	public void userAddRequestBodyForDeleteUserAddress(String addressId) {

		DeleteUserAddress_Input_Pojo deleteUserAddress_Input_Pojo = new DeleteUserAddress_Input_Pojo(
				TC1_LoginStep.globalDatas.getAddressId());
		addBody(deleteUserAddress_Input_Pojo);
	}

	@When("User send {string} request for DeleteUserAddress endpoint")
	public void userSendRequestForDeleteUserAddressEndpoint(String type) {

		response = requestType(type, EndPoints.DELETEADDRESS);
		int statusCode = getStatusCode(response);
		TC1_LoginStep.globalDatas.setStatusCode(statusCode);
	}

	@Then("User should verify the DeleteUserAddress response message {string}")
	public void userShouldVerifyTheDeleteUserAddressResponseMessage(String expMessage) {

		DeleteUserAddress_Output_Pojo deleteUserAddress_Output_Pojo = response.as(DeleteUserAddress_Output_Pojo.class);
		String actMessage = deleteUserAddress_Output_Pojo.getMessage();
		System.out.println(actMessage);
		Assert.assertEquals("verify delete address response message", expMessage, actMessage);
	}

}
