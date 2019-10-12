package action_Item;

import Reusable_Classes.Reusable_Library;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.io.IOException;
import java.util.List;

    public class yahoo {

        //declare driver variable outside so it can be resused on all annotation methods
        WebDriver driver = null;

        @BeforeSuite
        public void openBrowser() throws IOException {
            //define the driver here
            driver = Reusable_Library.navigate(driver,"https://www.yahoo.com/us");

        }//end of before

        @Test
        public void YahooSearch() throws InterruptedException {

            SoftAssert softAssert = new SoftAssert();
            softAssert.assertEquals(driver.getTitle(), "Yahoo");

            List<WebElement> tabsCount = driver.findElements(By.xpath("//*[contains(@class,'Mstart(21px)')]"));
            System.out.println("tab count is " + tabsCount.size());


            Reusable_Library.userInput(driver, "//*[@name='p']", "Nutrition", "Search bar");

            Reusable_Library.click(driver, "//*[@id='uh-search-button']", "Search Button");

            Thread.sleep(3000);
            JavascriptExecutor jes = (JavascriptExecutor) driver;
            jes.executeScript("window.scrollBy(0,2500)");


            String result = Reusable_Library.captureTextByIndex(driver, "//*[@class='compPagination']", 0, "Search results");
            String[] resultArray = result.split("Next");
            System.out.println("The Search result is " + resultArray[1]);

            Thread.sleep(2000);
            JavascriptExecutor jess = (JavascriptExecutor) driver;
            jess.executeScript("window.scrollBy(0,-2500)");

            Reusable_Library.click(driver,"//*[contains(text(),'Images')]","Image Section");

            List<WebElement> imagePG1 = driver.findElements(By.xpath("//*[contains(@style,'0px')]"));
            System.out.println("Total images on page one are " + imagePG1.size());

            Reusable_Library.click(driver,"//*[@id='yucs-login_signIn']","Sign in");

            boolean elementState = driver.findElement(By.xpath("//*[@type='checkbox']")).isSelected();
            System.out.println("is element selected? " + elementState);

            Reusable_Library.userInput(driver,"//*[@name='username']","zidane1122","Invalid Username");

            //(this don't work) Reusable_Library.click(driver,"//*[contains(@id,'login-signin') and @name='signin']","Next button");
            driver.findElement(By.xpath("//*[contains(@id,'login-signin') and @name='signin']")).submit();

            Reusable_Library.captureTextByIndex(driver,"//*[@class='row error']",0,"Err message");

            String errMsg = driver.getTitle();
            if (errMsg.equals("Sorry, we don't recognize this email.")) {
                System.out.println("Error message is ");
            } else {
                System.out.println("Error message doesn't match " + errMsg);
            }


        }//end of test

        @AfterSuite
        public void close() {
            //quit driver
            //driver.quit();
        }//end of after
    }
