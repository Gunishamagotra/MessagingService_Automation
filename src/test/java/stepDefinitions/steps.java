package stepDefinitions;


import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.restassured.path.json.JsonPath;
import org.junit.Assert;
import utils.ConfigFileReader;
import utils.apiUtil;

import java.util.Map;

public class steps extends StepDefinitionBase {
    apiUtil apiUtil = new apiUtil();
    ConfigFileReader configFileReader = new ConfigFileReader();
    //To check later and delete if not required
    static String messageID;
    static String userID1;
    static String userID2;
    static String messageNew;
    String URL = configFileReader.getUrl("BASE_URL");

    private void performHttpMethod(String method, String url, Map<String, String> headers,String user1,String user2,String message) {
        switch (method) {
            case "get":
                getMessage(url);
                break;
            case "post":
                createMessage(url, headers,user1, user2,message);
                break;
            case "delete":
                deleteMessage(url, headers,messageID);
                break;
            case "put":
                listMessage(url, headers,user1,user2);
                break;
        }
    }

    @Given("Messaging service API is up and running")
    public void messagingServiceAPIIsUpAndRunning() {
        System.out.println("Api is up and running");
    }

    @When("{string} sends a {string} to {string}")
    public void sendsATo(String user1, String message, String user2) {
        userID1 = user1;
        userID2 = user2;
        messageNew = message;
        performHttpMethod("post",configFileReader.getUrl("BASE_URL"),getValidHeaders(),user1,user2,message);
    }

    @And("Verify that message is sent successfully")
    public void verifyThatMessageIsSentSuccessfully() {
        try {
            Assert.assertEquals(response.extract().statusCode(), 200);
            JsonPath js =  apiUtil.rawToJson(response.extract().body().asString());
            Assert.assertEquals(js.get("from.id"),userID1);
            Assert.assertEquals(js.get("to.id"),userID2);
            Assert.assertEquals(js.get("message"),messageNew);
            messageID =  response.extract().body().jsonPath().get("id");

        } catch (Exception e){
            e.printStackTrace();
        }
    }

    @When("User is able to retrieve message")
    public void userIsAbleToRetrieveMessage() {
        String NewURL = configFileReader.getUrl("BASE_URL")+"/"+messageID;
        performHttpMethod("get", NewURL,getValidHeaders(),"","","" );
    }

    @And("Verify that all the messages are retrieved successfully")
    public void verifyThatAllTheMessagesAreRetrievedSuccessfully() {
        Assert.assertEquals(response.extract().statusCode(),200);
        JsonPath js =  apiUtil.rawToJson(response.extract().body().asString());
        Assert.assertEquals(js.get("message"),messageNew);
    }

    @When("User is able to view list of messages between User{int} and User{int}")
    public void userIsAbleToViewListOfMessagesBetweenUserAndUser(int user1, int user2) {
        performHttpMethod("get", configFileReader.getUrl("BASE_URL"),getValidHeaders(),userID1,userID2,"" );
    }

    @And("Verify that all the messages are listed successfully")
    public void verifyThatAllTheMessagesAreListedSuccessfully() {
        Assert.assertEquals(response.extract().statusCode(),200);
    }

    @When("User is able to delete the message")
    public void userIsAbleToDeleteTheMessage() {
        performHttpMethod("delete", URL, getValidHeaders(),"","" ,"");
    }

    @And("Verify that the message is deleted successfully")
    public void verifyThatTheMessageIsDeletedSuccessfully() {
        Assert.assertEquals(response.extract().statusCode(),204);
    }
}
