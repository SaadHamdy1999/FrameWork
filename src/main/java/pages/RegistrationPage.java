package pages;

public class RegistrationPage extends BasePage{
    public RegistrationPage() {
        super();
    }
    public void register(String firstName, String lastname, String email, String password, String confirmPassword){
        clickOnGenderBtn();
        insertFirstName(firstName);
        insertLastName(lastname);
        insertEmail(email);
        insertPassword(password);
        insertConfirmPassword(confirmPassword);
        clickOnRegisterBtn();

    }
    public void insertFirstName(String firstName){
        readLocator("firstNameBox");
        uiActions.writeInTextBox(locatorValueAndType[0],
                convertTypefromStringToENUM(locatorValueAndType[1]),firstName);
    }
    public void insertLastName(String lastName){
        readLocator("lastNameBox");
        uiActions.writeInTextBox(locatorValueAndType[0],
                convertTypefromStringToENUM(locatorValueAndType[1]),lastName);
    }
    public void insertEmail(String mail){
        readLocator("emailBox");
        uiActions.writeInTextBox(locatorValueAndType[0],
                convertTypefromStringToENUM(locatorValueAndType[1]),mail);
    }
    public void insertPassword(String password){
        readLocator("passwordBox");
        uiActions.writeInTextBox(locatorValueAndType[0],
                convertTypefromStringToENUM(locatorValueAndType[1]),password);

    }
    public void insertConfirmPassword(String confirmPassword){
        readLocator("confirmPasswordBox");
        uiActions.writeInTextBox(locatorValueAndType[0],
                convertTypefromStringToENUM(locatorValueAndType[1]),confirmPassword);
    }
    public void clickOnGenderBtn(){
        readLocator("genderBtn");
        uiActions.clickOnElement(locatorValueAndType[0],
                convertTypefromStringToENUM(locatorValueAndType[1]));

    }
    public void clickOnRegisterBtn(){
        readLocator("registerBtn");
        uiActions.clickOnElement(locatorValueAndType[0],
                convertTypefromStringToENUM(locatorValueAndType[1]));

    }
    public void checkIfUserRegisteredSuccessfully(){
        readLocator("resultMessage");
        String actualText =uiActions.getElementText(locatorValueAndType[0],
                convertTypefromStringToENUM(locatorValueAndType[1]));
        assertions.assertOnElementText(actualText,
                "Your registration completed");

    }



}
