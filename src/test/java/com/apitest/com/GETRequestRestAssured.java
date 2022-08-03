package com.apitest.com;

import org.testng.annotations.Test;
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
		  .then().
		  		log()
		  		.all();
	}

}
