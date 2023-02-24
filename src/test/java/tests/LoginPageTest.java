package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.Constants;
import utilities.ExcelReader;

import static utilities.ExcelReader.*;

public class LoginPageTest extends BaseTest {
    @Test(priority = 1)
    public void loginPage_verifyLoginPageTitle() {
        Assert.assertEquals(loginPage.getLoginPageTitle(), Constants.LOGIN_PAGE_TITLE);
    }

    @Test(priority = 2)
    public void loginPage_verifyLoginWithCorrectCredentials() {
        loginPage.loginToApp(username, password);
        Assert.assertTrue(loginPage.isUserLoggedIn());
    }

    @Test(priority = 3)
    public void loginPage_verifyRegisterNewUser() {
        loginPage.registerNewUser(firstName, lastName, email, telephone, createPassword, confirmPassword);
        Assert.assertEquals(loginPage.getRegisterSuccessMessage(), Constants.LOGIN_PAGE_REGISTER_SUCCESS_MESSAGE);
    }
}
