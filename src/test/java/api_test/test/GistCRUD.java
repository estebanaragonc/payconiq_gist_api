package api_test.test;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.jayway.restassured.response.Response;

import api_test.gist.Gist;
import api_test.gist.GistFiles;
import api_test.util.BaseTestClass;


public class GistCRUD extends BaseTestClass{

	
	//Suite by elvis.
	private String gistId;
    private final String fileName = "elvis.payconiq";
    
    //to prepare gist info to create it.
    private Gist getGist() {
        Gist gist = new Gist();
        gist.setDescription("This is a test file created using API - Payconiq");
        gist.setPublic(true);
        gist.setFile(fileName, new GistFiles("I'm not an expert using gist, but in 1 day I learned how to connect to this madness"));
        return gist;
    }
    
    
    @Test(description = "Step 1 - Create a gist using API's")
    public void createGistTest() {
    	// POST /gists
    	// based in documentation: https://developer.github.com/v3/gists/#create-a-gist
        Response myResponse  = getGivenAuth().body(getGist()).with().contentType("application/json").post().andReturn();
        Assert.assertEquals(myResponse.statusCode(), 201);
   
        //get the gist ID
        gistId = myResponse.as(Gist.class).getId();
        System.out.println ("Gist created with id : [ " + gistId + " ]");
    }
    
    @Test(description = "Step 2 - To check the gist created with elvis.payconiq was already and successfully created",
    		dependsOnMethods = "createGistTest")
    public void checkGistJustCreatedByID() {
    	// based in documentation https://developer.github.com/v3/gists/#get-a-gist
    	// GET /gists/:gist_id
    	Response myResponse = getGivenAuth().get("/" + gistId).andReturn();
        Gist gist = myResponse.as(Gist.class);
        
        System.out.println("Checking gist with id [ " + gistId + " ] was created");
        
        //status code
        Assert.assertEquals(myResponse.statusCode(), 200);
        
        // comparte key Map comparation using containsKey
        Assert.assertTrue(gist.getFiles().containsKey(fileName));
    }
    
    @Test(description = "Step 3 - Based in gist just created, then modify with a new text",
    		dependsOnMethods = "checkGistJustCreatedByID")
    public void updateGist() {
    	// based in documentation https://developer.github.com/v3/gists/#update-a-gist
    	// PATCH /gists/:gist_id
    	
    	//to build a new structure with updated information
    	Gist gist = getGist();
    	
    	/*handle descripton*/
    	String newDescription = "If this text is present in gist, that means it was updated successfully.";
    	String oldDescription = gist.getDescription();
    	System.out.println("Updating gist with id [ "+ gistId +  " ] Old description was: [ " + oldDescription + " ]");
    	
    	/*handle file*/
    	String newFile = "I want to work in payconiq, hell yeah. (this text was an update)";
    	System.out.println("Updating gist with id [ "+ gistId +  " ] with new content: [ " + newFile + " ]");
    	     	
    	//set new description and file to structure
    	gist.setDescription(newDescription);    	
    	gist.setFile(fileName, new GistFiles(newFile));
    	
    	//creating patch / update
    	Response myResponse = getGivenAuth().body(gist).with().contentType("application/json").patch("/" + gistId).andReturn();
    	
    	//getting actual description and file (the new one) once patch was made
    	String actualDescriptionUpdated = myResponse.as(Gist.class).getDescription();
    	
    	/*
    	 * before modify, createGistTest is exeuted to validate gist is present and created
    	 * */

    	//first validate status code
    	Assert.assertEquals(myResponse.statusCode(), 200);
    	
    	/* Validating Description */ 
    	//actual description obtained after path is the one used in new description
        Assert.assertEquals(actualDescriptionUpdated, newDescription);
        //actual description is not equal to old description obtained before patch
        Assert.assertNotEquals(actualDescriptionUpdated, oldDescription);
	}
    
    @Test(description = "Step 4 - Delete the gist created and updated",
    		dependsOnMethods = "updateGist")
    public void deleteGist()
   {
    	// based in documentation https://developer.github.com/v3/gists/#delete-a-gist
    	// DELETE /gists/:gist_id
    	Response response = getGivenAuth().delete("/" + gistId).andReturn();
        //if status code of delete response is 201, then response is , gist was deleted
    	Assert.assertEquals(response.statusCode(), 204);
    	
    }
    
    
    
	
}
