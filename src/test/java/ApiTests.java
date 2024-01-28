import ApiEntities.User;
import actions.Assertions;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.testng.annotations.Test;
import utilities.DataReader;

import java.io.FileNotFoundException;

import static actions.BrowserActions.apiHandler;

public class ApiTests extends BaseTest {
    User user;
    Assertions assertions = new Assertions();
    @Test
    public void getAllUsers() throws FileNotFoundException {
        DataReader reader = new DataReader();
        JSONObject body =reader.readJsonFile(System.getProperty("user.dir")+"/testData/users.json");
        user = new User(apiHandler.get());
        //String newUsername = user.setNewUsername(body);
       // System.out.println(newUsername);
        Response addNewUserResponse = user.addNewUser(body);
        assertions.assertStatusCode(200, addNewUserResponse);
        assertions.assertKeyEqualsExpectedValue("type",
                "unknown",addNewUserResponse);
        Response getUserResponse = user.getUserByName("string");
        assertions.assertStatusCode(200, getUserResponse);
        assertions.assertKeyEqualsExpectedValue("userStatus","0",
                getUserResponse);
    }
}
