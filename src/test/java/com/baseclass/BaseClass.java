package com.baseclass;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import io.restassured.RestAssured;
import io.restassured.http.Headers;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

/**
 * Hi here i commit check
 * @author ARUN Kumar M
 * @Description Maintains All Reusable Methods
 * @Date 29-10-2022
 */
public class BaseClass {

	Response response;
	RequestSpecification reqSpec;
	/**
	 * @Description Get Value From Property File
	 * @Date 29-10-2022
	 * @param key
	 * @return
	 * @throws FileNotFoundException
	 * @throws IOException
	 */
	
	public static String getPropertyFileValue(String key) throws FileNotFoundException, IOException {
		String projectPath = getProjectPath();
		Properties properties = new Properties();
		properties.load(new FileInputStream(projectPath + "//Config//Config.properties"));
		Object object = properties.get(key);
		String value = (String) object;
		return value;
	}
	
	/**
	 * @Description Uploading File
	 * @Date 29-10-2022
	 * @param key
	 * @param value
	 */
	
	public void formData(String key,File value) {

		reqSpec = reqSpec.multiPart(key,value);
	}

	/**
	 * @Description Adding Multiple Headers
	 * @Date 29-10-2022
	 * @param headers
	 */
	
	public void addHeaders(Headers headers) {
		reqSpec = RestAssured.given().headers(headers);
	}

	/**
	 * @Description Add Object Payload 
	 * @Date 29-10-2022
	 * @param body
	 */
	public void addBody(Object body) {
		reqSpec = reqSpec.body(body);

	}

	/**
	 * @Description Add Single Header
	 * @Date 29-10-2022
	 * @param key
	 * @param value
	 */
	public void addHeader(String key, String value) {
		reqSpec = RestAssured.given().header(key, value);

	}

	/**
	 * @Description Get Response Body As String Format
	 * @Date 29-10-2022
	 * @param response
	 * @return asString
	 */
	public String getResBodyAsString(Response response) {
		String asString = response.asString();
		return asString;
	}

	/**
	 * @Description Get Response Body As A String Pretty Format
	 * @Date 29-10-2022
	 * @param response
	 * @return asPrettyString;
	 */
	public String getResBodyAsPrettyString(Response response) {
		String asPrettyString = response.asPrettyString();
		return asPrettyString;
	}
/**
 * @Description Adding Query Parameter
 * @Date 29-10-2022
 * @param key
 * @param value
 */
	public void addQueryParam(String key, String value) {
		reqSpec = reqSpec.queryParam(key, value);

	}
	/**
	 * @Description Add Path Parameter
	 * @Date 29-10-2022
	 * @param key
	 * @param value
	 */

	public void addPathParam(String key, String value) {
		reqSpec = reqSpec.pathParam(key, value);

	}

	/**
	 * @Description Add String Payload 
	 * @Date 29-10-2022
	 * @param bodyAdd
	 */
	public void addBody(String bodyAdd) {
		reqSpec = reqSpec.body(bodyAdd);
	}
	
	/**
	 * @Description Get Status Code
	 * @Date 29-10-2022
	 * @param response
	 * @return statusCode
	 */

	public int getStatusCode(Response response) {
		int statusCode = response.getStatusCode();
		return statusCode;
	}

	/**
	 * @Description Get Response From Request Type
	 * @Date 29-10-2022
	 * @param type
	 * @param endPoint
	 * @return response
	 */
	
	public Response requestType(String type, String endPoint) {
		switch (type) {
		case "GET":
			response = reqSpec.get(endPoint);
			break;
		case "POST":
			response = reqSpec.post(endPoint);
			break;
		case "PUT":
			response = reqSpec.put(endPoint);
			break;
		case "DELETE":
			response = reqSpec.delete(endPoint);
			break;

		default:
			break;
		}
		return response;

	}

	/**
	 * @Description Perform Basic Authentication
	 * @Date 29-10-2022
	 * @param userName
	 * @param password
	 */
	public void basicAuth(String userName, String password) {

		reqSpec.auth().preemptive().basic(userName, password);

	}
	/**
	 * @Description Get Project Path
	 * @Date 29-10-2022
	 * @return path
	 */
	public static String getProjectPath() {
		String path = System.getProperty("user.dir");
		return path;
	}
}
