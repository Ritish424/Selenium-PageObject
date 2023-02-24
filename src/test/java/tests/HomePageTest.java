package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.Constants;

import java.io.IOException;

public class HomePageTest extends BaseTest {

    @Test(priority = 1)
    public void homePage_verifyHomePageTitle() {
        Assert.assertEquals(homepage.getHomePageTitle(), Constants.HOME_PAGE_TITLE);
    }

    @Test (priority = 2)
    public void homePage_verifyChangeCurrencyToEuro() {
        homepage.changeCurrecnyToEuro();
        Assert.assertEquals(homepage.getCurrency(), Constants.HOME_PAGE_CURRENCY);
    }

    @Test (priority = 3)
    public void homePage_verifySearchForIphone() {
        homepage.searchForIphone("iphone");
        Assert.assertEquals(homepage.getSearchedItem(), Constants.HOME_PAGE_SEARCH_CRITERIA);
    }


}
