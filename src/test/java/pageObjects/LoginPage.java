package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utilities.Constants;
import utilities.ElementUtils;

public class LoginPage {
    private WebDriver driver;
    ElementUtils elementUtils;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        elementUtils = new ElementUtils(driver);
    }

    By emailId = By.id("input-email");
    By password = By.id("input-password");
    By forgotPassword = By.xpath("//*[@class='form-group']//a[text()='Forgotten Password']");
    By loginButton = By.xpath("//*[@class='btn btn-primary' and @type='submit']");
    By loginDropDown = By.xpath("//*[@class='dropdown-menu dropdown-menu-right']//li//a[text()='Login']");
    By myAccount = By.xpath("//*[@id='top-links']//ul//li//a//span[text()='My Account']");
    By editAccount = By.xpath("//*[text()='Edit Account']");
    By register = By.xpath("//*[text()='Register']");
    By firstName = By.xpath("//*[@name='firstname']");
    By lastName = By.id("input-lastname");
    By email = By.id("input-email");
    By telephone = By.id("input-telephone");
    By createPassword = By.id("input-password");
    By confirmPassword = By.id("input-confirm");
    By confirmPolicy = By.xpath("//input[@name='agree']");
    By submitRegister = By.xpath("//input[@value='Continue']");
    By registerSuccessMessage = By.xpath("//h1[starts-with(text(),'Your Account')]");

    public void loginToApp(String username, String passcode) {
        elementUtils.waitForElementToBeClickable(myAccount);
        elementUtils.clickAction(myAccount);
        elementUtils.waitForElementToBeClickable(loginDropDown);
        elementUtils.clickAction(loginDropDown);
        elementUtils.waitForElementToBeClickable(emailId);
        elementUtils.enterText(emailId, username);
        elementUtils.waitForElementToBeClickable(password);
        elementUtils.enterText(password, passcode);
        elementUtils.waitForElementToBeClickable(loginButton);
        elementUtils.clickAction(loginButton);
    }

    public String getLoginPageTitle() {
        elementUtils.waitForElementToBeClickable(myAccount);
        elementUtils.clickAction(myAccount);
        elementUtils.waitForElementToBeClickable(loginDropDown);
        elementUtils.clickAction(loginDropDown);
        return elementUtils.returnPageTitle(Constants.LOGIN_PAGE_TITLE);
    }

    public boolean isUserLoggedIn() {
        return elementUtils.isElementDisplayed(editAccount);
    }

    public void registerNewUser(String fName, String lName, String eMailId, String phoneNumber, String enterPassword, String confirmSame) {
        elementUtils.waitForElementToBeClickable(myAccount);
        elementUtils.clickAction(myAccount);
        elementUtils.waitForElementToBeClickable(register);
        elementUtils.clickAction(register);
        elementUtils.waitForElementToBeClickable(firstName);
        elementUtils.enterText(firstName, fName);
        elementUtils.waitForElementToBePresent(lastName);
        elementUtils.enterText(lastName, lName);
        elementUtils.waitForElementToBePresent(email);
        elementUtils.enterText(email, eMailId);
        elementUtils.waitForElementToBePresent(telephone);
        elementUtils.enterText(telephone, phoneNumber);
        elementUtils.waitForElementToBePresent(createPassword);
        elementUtils.enterText(createPassword, enterPassword);
        elementUtils.waitForElementToBePresent(confirmPassword);
        elementUtils.enterText(confirmPassword, confirmSame);
        elementUtils.waitForElementToBeClickable(confirmPolicy);
        elementUtils.clickAction(confirmPolicy);
        elementUtils.waitForElementToBeClickable(submitRegister);
        elementUtils.submitForm(submitRegister);
    }

    public String getRegisterSuccessMessage() {
        elementUtils.waitForElementToBePresent(registerSuccessMessage);
        return elementUtils.returnText(registerSuccessMessage);
    }
}
