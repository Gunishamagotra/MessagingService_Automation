package utils;

import io.restassured.path.json.JsonPath;

public class apiUtil {

        public JsonPath rawToJson(String response){
            JsonPath js1= new JsonPath(response);
            return js1;
        }

}

