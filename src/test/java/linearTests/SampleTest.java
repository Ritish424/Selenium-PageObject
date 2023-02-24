package linearTests;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.netty.handler.codec.http.websocketx.extensions.WebSocketExtensionEncoder;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.Color;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class SampleTest {
    public static WebDriver driver;
    public static WebDriverWait wait;
    public static Actions actions;

    public static void main(String[] args) throws IOException, InterruptedException {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.setAcceptInsecureCerts(true);
        driver = new ChromeDriver(options);
        driver.get("https://petdiseasealerts.org/alerts-map/#/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        clickOnState("California");

        /*driver.get("https://demoqa.com/broken");
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        actions = new Actions(driver);
        List<WebElement> links = driver.findElements(By.tagName("a"));
        for (WebElement e : links) {
            String url = e.getAttribute("href");
            verifyURL(url);
        }
        List<WebElement> img_links = driver.findElements(By.tagName("img"));
        for (WebElement img : img_links) {
            if (img.getAttribute("naturalWidth").equals("0")) {
                System.out.println(img.getAttribute("outerHTML") + " Image is broken");
            } else if (!img.getAttribute("naturalWidth").equals("0")) {
                System.out.println(img.getAttribute("outerHTML") + " Image is good");

            }
        }*/

        //driver.findElement(By.id("windowButton")).click();
       /* driver.findElement(By.id("tabButton")).click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        String mainWindow = driver.getWindowHandle();
        System.out.println(mainWindow);
        Set<String> windows = driver.getWindowHandles();
        System.out.println(windows);
        for (String childWindow : windows) {
            if (!childWindow.equalsIgnoreCase(mainWindow)) {
                driver.switchTo().window(childWindow);
                System.out.println(driver.getCurrentUrl());
                driver.close();
            }
        }
        driver.switchTo().window(mainWindow);*/

        // WebElement image = driver.findElement(By.xpath("//a[text()='View an alert message']"));
      /*  JavascriptExecutor js = (JavascriptExecutor) driver;
        WebElement t = driver.findElement(By.name("leftClick"));
        String s = t.getCssValue("background-color");
        String c = Color.fromString(s).asHex();
        System.out.println("Color is :" + s);
        System.out.println("Hex code for color:" + c);*/
//        String pageTitle = js.executeScript("return document.title;").toString();
//        String url = js.executeScript("return document.URL;").toString();
//        System.out.println("URL is " + url + "\nTitle is " + pageTitle);
//        js.executeScript("window.scrollBy(0,600)");
//        Thread.sleep(5000);
//        js.executeScript("arguments[0].click();", image);
//        image.click();
//        driver.switchTo().alert().dismiss();
//        SampleTest.screenShot();
//        SampleTest.elementScreenshot(image);
        driver.quit();
    }

    public static void clickOnState(String state) {
        List<WebElement> states = driver.findElements(By.xpath("//*[local-name()='g' and @id='states']/*[local-name()='g' and @class='state']/*[local-name()='path' and @class='child']"));
        for (WebElement e : states) {
            try {
                if (e.getAttribute("name").equals(state)) {
                    e.click();
                    Thread.sleep(5000);
                    driver.findElement(By.xpath("//a[text()='United States']")).click();
                    Thread.sleep(5000);
                }
            } catch (InterruptedException ie) {
                System.out.println(ie);
            }
        }
    }

    public static void screenShot() throws IOException {
        File source = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(source, new File("E:\\Testing\\Selenium Codes\\screenshot.png"));
    }

    public static void elementScreenshot(WebElement element) throws IOException {
        File source = element.getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(source, new File("E:\\Testing\\Selenium Codes\\screenshotElement.png"));
    }

    public static void verifyURL(String link) {
        try {
            URL url = new URL(link);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setConnectTimeout(5000);
            connection.connect();
            if (connection.getResponseCode() >= 400) {
                System.out.println("Link " + link + "Response code is " + connection.getResponseCode() + " is broken link");
            } else {
                System.out.println("Link is good " + link + " Response code is " + connection.getResponseCode());
            }
        } catch (Exception e) {

        }

    }
}
