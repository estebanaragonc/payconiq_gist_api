# payconiq_gist_api
payconiq_gist_api

In order to execute the test scripts please follow: 
1. Clone the repo
2. Generate a personal access token in https://github.com/settings/tokens
3. Update the token in the property file in payconiq_gist_api/target/test-classes/gist.properties
4.  Open bash in the directory where the repository was cloned
5. Execute mvn eclipse:eclipse and wait until get the BUILD SUCCESS message in console
6. Open eclipse and add a new maven project and specify the directory cloned, then finish the import
7. Right click in the project and properties/testNG and uncheck the 'use project testNG jar'
8. Go to payconiq_gist_api/src/test/java/api_test/test/GistCRUD.java and right click and then "Run As -> TestNG Test"

To validate until the 'update process' please comment the "deleteGist()" method , then execute steps 7 and 8 and then go to https://gist.github.com/YOUR-REPOSITORY-HERE and then validate that the gist 'elvis.payconiq' was created and check the 'revisions' to validate it was updated.

To validate the 'delete' process just let the method 'deleteGist()' uncommented and execute steps 7 and 8. The gist is not going to be displayed in gist list because it was deleted.
