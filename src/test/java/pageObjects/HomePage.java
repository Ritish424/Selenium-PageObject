package pageObjects;

import base.BasePage;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.Constants;
import utilities.ElementUtils;

import java.time.Duration;

public class HomePage extends BasePage {
    private WebDriver driver;
    ElementUtils elementUtils;

    public HomePage(WebDriver driver) {
        this.driver = driver;
        elementUtils = new ElementUtils(driver);
    }

    By currency = By.xpath("//*[text()='Currency']");
    By euro = By.xpath("//*[@name='EUR']");
    By euroSymbol = By.xpath("//*[text()='€']");
    By searchBox = By.xpath("//*[@id='search']//input[@name='search']");
    By searchButton = By.xpath("//*[@class='btn btn-default btn-lg']");
    By searchedItem = By.xpath("//*[@id='content']//h1[text()='Search - iphone']");
    By iphoneImage = By.xpath("//*[@title='iPhone' and @class='img-responsive']");

    public String getHomePageTitle() {
        return elementUtils.returnPageTitle(Constants.HOME_PAGE_TITLE);
    }

    public void changeCurrecnyToEuro() {
        elementUtils.waitForElementToBeClickable(currency);
        elementUtils.clickAction(currency);
        elementUtils.waitForElementToBeClickable(euro);
        elementUtils.clickAction(euro);
    }

    public String getCurrency() {
        elementUtils.waitForElementToBeClickable(euroSymbol);
        return elementUtils.returnText(euroSymbol);
    }

    public void searchForIphone(String searchItem) {
        elementUtils.isElementDisplayed(searchBox);
        elementUtils.enterText(searchBox, searchItem);
        elementUtils.waitForElementToBeClickable(searchButton);
        elementUtils.clickAction(searchButton);
        elementUtils.waitForElementToBePresent(iphoneImage);
    }

    public String getSearchedItem() {
        elementUtils.waitForElementToBeClickable(searchedItem);
        return elementUtils.returnText(searchedItem);
    }

}
