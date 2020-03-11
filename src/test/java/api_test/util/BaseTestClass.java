package api_test.util;

import static com.jayway.restassured.RestAssured.given;

import com.jayway.restassured.builder.RequestSpecBuilder;
import com.jayway.restassured.specification.RequestSpecification;

import api_test.utilities.PropertyManager;

public class BaseTestClass {

	private final String token = PropertyManager.get("git.token");
    private final String baseUrl = PropertyManager.get("url");
    private final RequestSpecification requestSpecification = new RequestSpecBuilder().setBaseUri(baseUrl).build();
    
    
    //to handle auth based in token provided by property file
    protected RequestSpecification getGivenAuth() {
    	System.out.println("token 	= " + token);
    	System.out.println("url 	= " + baseUrl);
        return given().spec(requestSpecification).auth().oauth2(token);
    }
    
}
