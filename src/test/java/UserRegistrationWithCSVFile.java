import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.RegistrationPage;
import utilities.DataReader;



public class UserRegistrationWithCSVFile extends BaseTest{
    HomePage homePage;
    RegistrationPage registrationPage;
    @Test(dataProvider = "CSVUserData")
    public void userCanRegisterSuccessfully (String firstName, String lastName, String mail,
                                             String pass, String confirm){
        homePage = new HomePage(uniqueKey);
        homePage.clickOnRegistrationLink();
        registrationPage = new RegistrationPage(uniqueKey);
        registrationPage.register(firstName, lastName,mail, pass, confirm);
        registrationPage.checkIfUserRegisteredSuccessfully();

    }
    @DataProvider(name= "CSVUserData")
    public Object[][] readUserDataFromCSVFile() {
        DataReader reader = new DataReader();
        return reader.readDataFromCsv(System.getProperty("user.dir")+"\\testData\\userdata.csv");
    }
}
