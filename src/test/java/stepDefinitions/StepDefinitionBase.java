package stepDefinitions;

import io.restassured.response.ValidatableResponse;
import org.apache.commons.lang3.ObjectUtils;
import org.junit.Ignore;
import utils.payload;
import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;

@Ignore

public class StepDefinitionBase {

    public Map<String, String> getValidHeaders() {
        Map<String, String> headers = new HashMap<>();
        headers.put("Content-Type", "application/json");
        return headers;
    }
  protected transient ValidatableResponse response;

    protected void createMessage(String url, Map<String,String> headers, String user1, String user2,String message ) {
        response = given().log().all()
                .headers(ObjectUtils.defaultIfNull(headers, new HashMap<>()))
                .body(payload.create_Message(user1, user2,message))
                .when()
                .port(3000)
                .post(url)
                .then();
    }

    // have added get instead of put - to check with team if this needs to be corrected
    protected void listMessage(String url, Map<String,String> headers, String User1, String User2 ) {
        response = given().queryParam("from",User1).queryParam("to",User2)
                .log().all()
                .headers(ObjectUtils.defaultIfNull(headers, new HashMap<>()))
                .when()
                .port(3000)
                .get(url)
                .then();
    }

    protected void getMessage(String url) {
        response = given().log().all()
                .when()
                .port(3000)
                .get(url)
                .then();
    }

    protected void deleteMessage(String url, Map<String,String> headers,String messageID ) {
        String newURL = url+"/"+messageID;
        response = given().log().all()
                .headers(ObjectUtils.defaultIfNull(headers, new HashMap<>()))
                .when()
                .port(3000)
                .delete(newURL)
                .then();
    }
}