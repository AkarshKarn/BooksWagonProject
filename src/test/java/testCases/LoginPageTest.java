package testCases;

import base.BaseClass;
import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;

@Listeners(Listener.class)
public class LoginPageTest extends BaseClass {

    public LoginPage loginPage;
Logger log= Logger.getLogger(LoginPage.class);
    public LoginPageTest(){
        super();
    }

    @BeforeMethod
    public void setLoginPage(){
        log.info("Login Test Cases Execution start");
        initialization();
        loginPage=new LoginPage();
    }

    @Test(priority = 1)
    public void validateLoginPageTest(){
        log.info("Login Page Title Test Successful");
        String titleLoginPage= loginPage.validatePageTitle();
        Assert.assertEquals(titleLoginPage,"Online Bookstore | Buy Books Online | Read Books Online");
        webDriver.close();
    }

    @Test(priority = 2)
    public void loginTest(){
        log.info("Login Test Successful");
       loginPage.login(prop.getProperty("mob"), prop.getProperty("password") );
    }


//    @AfterMethod
//    public void terminate(){
//        webDriver.close();
//    }

}
