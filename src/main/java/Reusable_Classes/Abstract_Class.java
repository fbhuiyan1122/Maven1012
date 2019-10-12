package Reusable_Classes;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.*;

import java.io.IOException;
import java.lang.reflect.Method;

import static Reusable_Classes.Reusable_Library_Loggers_POM.getDateTime;


public class Abstract_Class extends Reusable_Library_Loggers {
    public static WebDriver driver = null;
    public static ExtentReports report = null;
    public static ExtentTest logger = null;


    @BeforeSuite()
    public void openBrowser(){
        //path to your report
        report = new ExtentReports("src\\main\\java\\Report_Folder\\AutomationReport"+ getDateTime()+".html",true);

    }//end of beforesuite

    @Parameters("Browser")
    @BeforeMethod
    public static void captureTestName(String Browser, Method methodName) throws IOException {
        if(Browser.equalsIgnoreCase("Firefox")){
            System.setProperty("webdriver.gecko.driver","src\\main\\resources\\geckodriver.exe");
            driver = new FirefoxDriver();
            driver.manage().window().maximize();
        } else if(Browser.equalsIgnoreCase("Chrome")) {
            driver = navigate(driver, "https://www.google.com");
        }
        //logger below will get the actual name of each of your @Test method(s)
        logger = report.startTest(methodName.getName()+"--"+Browser);
        logger.log(LogStatus.INFO,"Automation Test Scenario Started....");
    }//end of before method

    @AfterMethod
    public static void endTest(){
        report.endTest(logger);
        logger.log(LogStatus.INFO,"Automation Test Scenario ended.....");
    }//end of after method

    @AfterSuite
    public void closerBrowser(){
        report.flush();
        report.close();
        //driver.quit();

    }//end of aftersuite

}//end of class
