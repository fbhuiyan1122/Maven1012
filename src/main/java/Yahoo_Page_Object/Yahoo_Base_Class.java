package Yahoo_Page_Object;

import Reusable_Classes.Abstract_Class;
import jxl.read.biff.BiffException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import java.io.IOException;

public class Yahoo_Base_Class extends Abstract_Class {

    //creating an object for this class, aka initializing method. inherits all methods from abstract class
    public Yahoo_Base_Class(WebDriver driver) {
        //creating the variable for methods from abstract class
        super();
        PageFactory.initElements(driver, this);
    }

    //// Object for yahoo home page. yahoo homepage is the new Yahoo Homepage.
    // new yahoo homepage is used to return stuff back, cuz the original won't.
    public static Yahoo_Homepage yahoo_homepage() {
        Yahoo_Homepage yahoo_homepage = new Yahoo_Homepage(driver);
        return yahoo_homepage;
    }

    //// Object for yahoo home page. This is the initial syntax for creating an object of a webpage
    public static Yahoo_SearchResultPage yahoo_searchResultPage() {
        Yahoo_SearchResultPage yahoo_searchResultPage = new Yahoo_SearchResultPage(driver);
        return yahoo_searchResultPage;
    }

    //Object for yahoo registration page
    public static Yahoo_RegistrationPage yahoo_registrationpage() throws IOException, BiffException {
        Yahoo_RegistrationPage yahoo_registrationpage = new Yahoo_RegistrationPage(driver);
        return yahoo_registrationpage;
    }

   /* //// Object for yahoo home page
    public static Login_Page login_page() {
        Login_Page login_page = new Login_Page(driver);
        return login_page;
    }*/



}
