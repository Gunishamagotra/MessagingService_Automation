package stepDefinitions;

import io.restassured.response.ValidatableResponse;
import org.junit.Ignore;
import utils.payload;


import static io.restassured.RestAssured.given;

@Ignore

public class StepDefinitionBase {


  protected transient ValidatableResponse response;

    protected void createMessage(String url, String user1, String user2,String message ) {
        response = given().log().all()
                .headers("Content-Type","application/json")
                .body(payload.create_Message(user1, user2,message))
                .when()
                .port(3000)
                .post(url)
                .then();
    }

    // have added get instead of put - to check with team if this needs to be corrected
    protected void listMessage(String url, String User1, String User2 ) {
        response = given().queryParam("from",User1).queryParam("to",User2)
                .headers("Content-Type","application/json")
                .log().all()
                .when()
                .port(3000)
                .get(url)
                .then();
    }

    protected void getMessage(String url) {
        response = given().log().all()
                .when()
                .headers("Content-Type","application/json")
                .port(3000)
                .get(url)
                .then();
    }

    protected void deleteMessage(String url,String messageID ) {
        String newURL = url+"/"+messageID;
        response = given().log().all()
                .when()
                .headers("Content-Type","application/json")
                .port(3000)
                .delete(newURL)
                .then();
    }
}