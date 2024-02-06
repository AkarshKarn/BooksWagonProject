package testCases;

import base.BaseClass;
import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;

public class HomePageTest extends BaseClass {
    HomePage homePage;
    LoginPage loginPage;

    Logger log=Logger.getLogger(HomePage.class);

    public HomePageTest(){
        super();
    }

    @BeforeMethod
    public void setHomePage(){
        log.info("Homepage Test Cases Execution started...");
        initialization();
        loginPage= new LoginPage();
        loginPage.login(prop.getProperty("mob"), prop.getProperty("password"));
    }

    @Test(priority = 1)
    public void navigateHomePageTest(){
        log.info("Homepage Navigation Successful");
        homePage.navigateHomePage();
    }

    @Test(priority = 2)
    public void validateHomePageTest(){
        log.info("Homepage Title Validation Test Successful");
        String homePageTitle=homePage.validateHomePageTitle();
        Assert.assertEquals(homePageTitle,"Online BookStore India, Buy Books Online, Buy Book Online India - Bookswagon.com");
        webDriver.close();
    }


//    @AfterMethod
//    public void terminate(){
//        log.info("Closed Browser successful");
//        webDriver.close();
//    }
}
