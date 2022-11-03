package com.payload.address;

import com.pojo.address.AddUserAddress_Input_Pojo;
import com.pojo.address.DeleteUserAddress_Input_Pojo;
import com.pojo.address.GetCityId_Input_Pojo;
import com.pojo.address.UpdateUserAddress_Input_Pojo;

public class AddressPayload {

	public AddUserAddress_Input_Pojo addUserAddress(String first_name, String last_name, String mobile,
			String apartment, int state, int city, int country, String zipcode, String address, String address_type) {

		AddUserAddress_Input_Pojo addUserAddress_Input_Pojo = new AddUserAddress_Input_Pojo(first_name, last_name,
				mobile, apartment, state, city, country, zipcode, address, address_type);
		return addUserAddress_Input_Pojo;

	}
	public UpdateUserAddress_Input_Pojo updateUserAddress(String address_id, String first_name, String last_name,
			String mobile, String apartment, int state, int city, int country, String zipcode, String address,
			String address_type) {

		UpdateUserAddress_Input_Pojo updateUserAddress_Input_Pojo = new UpdateUserAddress_Input_Pojo(address_id,
				first_name, last_name, mobile, apartment, state, city, country, zipcode, address, address_type);
		return updateUserAddress_Input_Pojo;

	}

	public DeleteUserAddress_Input_Pojo deleteUserAddress(String address_id) {

		DeleteUserAddress_Input_Pojo deleteUserAddress_Input_Pojo = new DeleteUserAddress_Input_Pojo(address_id);
		return deleteUserAddress_Input_Pojo;
	}
	
	
	public GetCityId_Input_Pojo getCityId(String state_id) {

		GetCityId_Input_Pojo getCityId_Input_Pojo = new GetCityId_Input_Pojo(state_id);
		return getCityId_Input_Pojo;

	}

}
