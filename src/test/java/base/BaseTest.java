package base;

import com.aventstack.extentreports.ExtentReports;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.ITestContext;
import org.testng.annotations.*;
import pageObjects.HomePage;
import pageObjects.LoginPage;
import utilities.ReportLog;

import java.lang.reflect.Method;
import java.time.Duration;
import java.util.Properties;

import static utilities.ExcelReader.getTestCredentials;

public class BaseTest {
    public WebDriver driver;
    public BasePage basePage;
    public LoginPage loginPage;
    public HomePage homepage;
    public Properties prop;
    public static String methodName;
    public ReportLog report;

    @BeforeSuite
    public void startReport(){
        report.init();
    }

    @BeforeMethod
    public void setUp(Method method) {
        basePage = new BasePage();
        prop = basePage.init_Prop();

        String browser = prop.getProperty("browser");
        if (browser.equals("chrome")) {
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
        }
        if (browser.equals("edge")) {
            WebDriverManager.edgedriver().setup();
            driver = new EdgeDriver();
        }
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get(prop.getProperty("url"));

        methodName = method.getName();
        getTestCredentials(methodName);

        loginPage = new LoginPage(driver);
        homepage = new HomePage(driver);
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }

    @AfterSuite
    public void endReport(){
        report.onEnd();
    }
}
