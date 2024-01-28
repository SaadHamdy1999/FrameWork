package ApiEntities;

import actions.ApiActions;
import com.github.javafaker.Faker;
import io.restassured.response.Response;
import org.json.JSONObject;

public class User {
    ApiActions actions;
    Faker dataFaker = new Faker();
    public User(ApiActions apiActions){
        actions = apiActions;
    }
    public Response getUserByName(String name){
        return actions.getApi("https://petstore.swagger.io/v2",
                "/user/"+name,"");
    }
    public Response addNewUser(JSONObject body){
        return actions.postApi("https://petstore.swagger.io/v2",
                "/user",body,"");
    }
    public String setNewUsername(JSONObject body){
        String newUsername = dataFaker.name().username();
        body.put("username",newUsername);
        return newUsername;
    }
}
