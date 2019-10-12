package testNG_0928;

import Reusable_Classes.Reusable_Library;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.io.IOException;

public class Yahoo_testNG {
    //declare driver variable outside so it can be resused on all annotation methods
    WebDriver driver = null;

    @BeforeSuite
    public void openBrowser() throws IOException {
        //define the driver here
        driver = Reusable_Library.navigate(driver,"http://www.google.com");

    }//end of before suit

    @Test
    public void googlesearch () {
        //verify google title matches using hard assert
        Assert.assertEquals("Google",driver.getTitle());
        //using soft assert
        //SoftAssert softAssert = new SoftAssert();
        //softAssert.assertEquals(driver.getTitle(),"Google");
        //enter a keyword to google search field
        Reusable_Library.userInput(driver,"//*[@name='q']","Cars","Search field");

        //to catch exception from soft assert
        //softAssert.assertAll();

    }//end of test assertion

    @AfterSuite
    public void close() {
        //quit the driver
        //driver.quit


    }//end of after suit
}//end
