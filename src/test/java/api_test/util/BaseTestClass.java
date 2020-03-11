package api_test.util;

import com.jayway.restassured.builder.RequestSpecBuilder;
import com.jayway.restassured.specification.RequestSpecification;
import api_test.utilities.PropertyManager;

import static com.jayway.restassured.RestAssured.given;

public class BaseTestClass {

	private final String token = PropertyManager.get("git.token");
    private final String baseUrl = "https://api.github.com/gists"; //PropertyManager.get("url");
    private final RequestSpecification requestSpecification = new RequestSpecBuilder().setBaseUri(baseUrl).build();
    
    public  RequestSpecification getGivenAuth() {
    	System.out.println("token 	= " + token);
    	System.out.println("url 	= " + baseUrl);
        return given().spec(requestSpecification).auth().oauth2(token);
    }
    
    
    
}
