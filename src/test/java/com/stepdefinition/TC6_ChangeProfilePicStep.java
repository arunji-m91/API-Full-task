package com.stepdefinition;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import org.junit.Assert;
import com.baseclass.BaseClass;
import com.endpoints.EndPoints;
import com.pojo.changeprofilepic.ChangeProfilePic_Output_Pojo;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.response.Response;

public class TC6_ChangeProfilePicStep extends BaseClass {

	Response response;

	@Given("User add Header and bearer authorization for accessing profile picture endpoints")
	public void userAddHeaderAndBearerAuthorizationForAccessingProfilePictureEndpoints() {
		List<Header> listHeader = new ArrayList<Header>();
		Header h1 = new Header("accept", "application/json");
		Header h2 = new Header("Authorization", "Bearer " + TC1_LoginStep.globalDatas.getLogtoken());
		Header h3 = new Header("Content-Type", "multipart/form-data");
		listHeader.add(h1);
		listHeader.add(h2);
		listHeader.add(h3);
		Headers headers = new Headers(listHeader);
		addHeaders(headers);
	}

	@When("User add form data for add profile picture")
	public void userAddFormDataForAddProfilePicture() {
		formData("profile_picture", new File(System.getProperty("user.dir") + "\\Images\\Koala.jpg"));

	}

	@When("User should send {string} request for change profile picture endpoint")
	public void userShouldSendRequestForChangeProfilePictureEndpoint(String type) {
		response = requestType(type, EndPoints.CHANGEPROFILEPIC);
		int statusCode = getStatusCode(response);
		TC1_LoginStep.globalDatas.setStatusCode(statusCode);

	}

	@Then("User should verify change profile picture success message {string}")
	public void userShouldVerifyChangeProfilePictureSuccessMessage(String expMessage) {
		ChangeProfilePic_Output_Pojo changeProfilePic_Output_Pojo = response.as(ChangeProfilePic_Output_Pojo.class);
		String actMessage = changeProfilePic_Output_Pojo.getMessage();
		Assert.assertEquals("verify change profile picture success message", expMessage, actMessage);
	}

}
