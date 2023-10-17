package utils;

public class payload {
public static String create_Message(String user1, String user2,String message){
return "{\n" +
        "    \"from\": {\n" +
        "        \"id\": \""+user1+"\"\n" +
        "    },\n" +
        "    \"to\": {\n" +
        "        \"id\": \""+user2+"\"\n" +
        "    },\n" +
        "    \"message\": \""+message+"\"\n" +
        "}";
}
}
