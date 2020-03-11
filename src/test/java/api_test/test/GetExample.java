package api_test.test;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.jayway.restassured.response.Response;

import api_test.gist.Gist;
import api_test.util.BaseTestClass;


public class GetExample extends BaseTestClass{

	private final String gistId = "54d4b4a68737a81c73b307309d9e1d4d";
	
	@Test(description = "List a user's gists")
    public void listUsersGistsTest() {
        Response response = getGivenAuth().get().andReturn();
        Gist[] gists = response.as(Gist[].class);
        Assert.assertEquals(response.statusCode(), 200);
        Assert.assertTrue(gists.length > 0);
    }
	
	
	
}
