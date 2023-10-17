package utils;

import io.restassured.path.json.JsonPath;

public class apiUtil {

        public JsonPath rawToJson(String response){
            JsonPath jsonPath= new JsonPath(response);
            return jsonPath;
        }

}

