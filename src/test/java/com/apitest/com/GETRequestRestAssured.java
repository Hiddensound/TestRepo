package com.apitest.com;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import org.hamcrest.Matchers.*;
import org.hamcrest.core.*;
import static org.hamcrest.Matchers.equalTo;

public class GETRequestRestAssured {
	
	@Test
	public void getWeatherDetails() {
		
		  given()
		  .when()
		  	.get("http://demo.guru99.com/V4/sinkministatement.php?CUSTOMER_ID=68195&PASSWORD=1234!&Account_No=1")
		  	.body();
		
	}
	
	@Test
	public void anotherExample() {
	  given()
	  .when()
	  	.get("https://official-joke-api.appspot.com/random_joke")
	  	.body();
	}
	
	@Test
	public void GetBookDetails() {
		
		RestAssured.baseURI = "https://demoqa.com/BookStore/v1/Books";
		RequestSpecification httpRequest = RestAssured.given();
		Response response = httpRequest.request(Method.GET,"");
		System.out.println("Status of the call received: " + response.getStatusCode());
		System.out.println("The Response is: " + response.prettyPrint());
		System.out.println("The Headers are: " + response.getHeaders());
		
	}
	
	@Test
	public void DemoPOST() {
		
		final String body = "{\"name\":\"spidey\",\"job\":\"employee\"}";
		RestAssured.baseURI = "https://reqres.in/api/users";
	     
		Response response = given()
				.header("Content-Type", "application/json")
				.and()
				.body(body)
				.when()
				.post()
				.then()
				.extract().response();
		
		String pretty = response.asPrettyString();
		System.out.println(pretty);
		
		RequestSpecification httpRequest = RestAssured.given();
		Response response1 = httpRequest.get();
		System.out.println(response1.prettyPrint());

	}
	}


