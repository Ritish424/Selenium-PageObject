package utilities;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.*;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

public class ElementUtils {
    private WebDriver driver;

    public ElementUtils(WebDriver driver) {
        this.driver = driver;
    }

    public WebElement getElement(By locator) {
        WebElement element = null;
        try {
            element = driver.findElement(locator);
        } catch (Exception e) {
            System.out.println("Element could not be located with given locator " + locator);
        }
        return element;
    }

    public void clickAction(By locator) {
        getElement(locator).click();
    }

    public void submitForm(By locator) {
        getElement(locator).submit();
    }

    public void enterText(By locator, String text) {
        getElement(locator).sendKeys(text);
    }

    public String returnText(By locator) {
        return getElement(locator).getText();
    }

    public boolean isElementDisplayed(By locator) {
        return getElement(locator).isDisplayed();
    }

    public void selectDropDownValueByText(By locator, String text) {
        new Select(getElement(locator)).selectByVisibleText(text);
    }

    public List<String> returnDropDownValues(By locator) {
        List<String> dropDownValues = new ArrayList<String>();
        Select select = new Select(getElement(locator));
        List<WebElement> dropDownList = select.getOptions();
        for (WebElement element : dropDownList) {
            dropDownValues.add(element.getText());
        }
        return dropDownValues;

    }

    public WebElement waitForElementToBePresent(By locator) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        return wait.until(ExpectedConditions.presenceOfElementLocated(locator));
    }

    public WebElement waitForElementToBeClickable(By locator) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        return wait.until(ExpectedConditions.elementToBeClickable(locator));
    }

    public WebElement waitForElementVisibility(By locator) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    public List<WebElement> waitForVisibilityOfAllElements(By locator) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        return wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(locator));
    }

    public Alert waitForAlertPresence() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        return wait.until(ExpectedConditions.alertIsPresent());
    }

    public WebElement waitForRefreshedElement(By locator) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        return wait.until(ExpectedConditions.refreshed(ExpectedConditions.elementToBeClickable(locator)));
    }

    public WebElement waitForElementWithFluentWait(By locator) {
        Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(15)).pollingEvery(Duration.ofSeconds(2)).ignoring(NoSuchElementException.class);
        return wait.until(ExpectedConditions.elementToBeClickable(locator));
    }

    public String returnPageTitle(String title) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        wait.until(ExpectedConditions.titleContains(title));
        return driver.getTitle();
    }

}
