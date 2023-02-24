package utilities;

import base.BasePage;
import base.BaseTest;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.Markup;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;

public class ReportLog extends BasePage implements ITestListener {

    private static final String OUTPUT_FOLDER = "./build/";
    private static final String FILE_NAME = "TestExecutionReport.html";

    private static ExtentReports extent = init();
    public ThreadLocal<ExtentTest> test = new ThreadLocal<>();

    public static ExtentReports init() {
        Path path = Paths.get(OUTPUT_FOLDER);
        if (!Files.exists(path)) {
            try {
                Files.createDirectories(path);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        ExtentSparkReporter spark = new ExtentSparkReporter(OUTPUT_FOLDER + FILE_NAME);
        spark.config().setDocumentTitle("Automation Test Results");
        spark.config().setReportName("Automation Test Results");
        spark.config().setTheme(Theme.DARK);

        extent = new ExtentReports();
        extent.attachReporter(spark);
        System.out.println("** Test Suite Started! **");
        return extent;
    }

    public void onStart(ITestContext context) {
        System.out.println("Test Started!");
    }

    public void onEnd() {
        System.out.println("** Test Suite finished! **");
        extent.flush();
        test.remove();
    }

    public synchronized void onTestStart(ITestResult result) {
        String methodName = result.getMethod().getMethodName();
        String qualifiedName = result.getMethod().getQualifiedName();
        int last = qualifiedName.lastIndexOf(".");
        int mid = qualifiedName.substring(0, last).lastIndexOf(".");
        String className = qualifiedName.substring(mid + 1, last);

        System.out.println(methodName + " started!");
        ExtentTest extentTest = extent.createTest(result.getMethod().getMethodName(),
                result.getMethod().getDescription());

        extentTest.assignCategory(result.getTestContext().getSuite().getName());
        extentTest.assignCategory(className);
        test.set(extentTest);
        test.get().getModel().setStartTime(getTime(result.getStartMillis()));
    }

    public synchronized void onTestSuccess(ITestResult result) {
        String logText = "<b>Test Method " + result.getMethod().getMethodName() + " Successful </b>";
        Markup m = MarkupHelper.createLabel(logText, ExtentColor.GREEN);
        test.get().log(Status.PASS, m);
        System.out.println((result.getMethod().getMethodName() + " passed!"));
        test.get().pass("Test passed");
        test.get().getModel().setEndTime(getTime(result.getEndMillis()));
    }

    public synchronized void onTestFailure(ITestResult result) {
        String logText = "<b>Test Method " + result.getMethod().getMethodName() + " Failed </b>";
        Markup m = MarkupHelper.createLabel(logText, ExtentColor.RED);
        test.get().log(Status.FAIL, m);

        System.out.println((result.getMethod().getMethodName() + " failed!"));
        String exceptionMessage = Arrays.toString(result.getThrowable().getStackTrace());

        test.get().fail("<details><summary><b><font color=red>" + "Error occured, click to see details" + "</font></b></summary>"
                + exceptionMessage.replaceAll(",", "<br>") + "</details> \n");
        test.get().fail("<b><font color=red>" + "Screenshot of Failure" + "</font></b>",
                MediaEntityBuilder.createScreenCaptureFromPath(getScreenshot()).build());
        test.get().getModel().setEndTime(getTime(result.getEndMillis()));
    }

    public synchronized void onTestSkipped(ITestResult result) {
        String logText = "<b>Test Method " + result.getMethod().getMethodName() + " Successful </b>";
        Markup m = MarkupHelper.createLabel(logText, ExtentColor.GREEN);
        test.get().log(Status.PASS, m);
        System.out.println((result.getMethod().getMethodName() + " skipped!"));
        test.get().skip(result.getThrowable(),
                MediaEntityBuilder.createScreenCaptureFromPath(getScreenshot()).build());
        test.get().getModel().setEndTime(getTime(result.getEndMillis()));
    }

    public synchronized void onTestFailedButWithinSuccessPercentage(ITestResult result) {
        System.out.println(("Test Failed But Within Success Percentage for " + result.getMethod().getMethodName()));
    }

    private Date getTime(long millis) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(millis);
        return calendar.getTime();
    }


}
