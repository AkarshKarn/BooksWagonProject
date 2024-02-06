package pages;

import base.BaseClass;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends BaseClass {

    @FindBy(linkText = "My Account")
    WebElement myAccount;

    @FindBy(id = "ctl00_phBody_SignIn_txtEmail")
    WebElement mob;

    @FindBy(id = "ctl00_phBody_SignIn_txtPassword")
    WebElement password;

    @FindBy(id = "ctl00_phBody_SignIn_btnLogin")
    WebElement loginBtn;


    public LoginPage(){
        PageFactory.initElements(webDriver,this);
    }

    public String validatePageTitle(){
        return webDriver.getTitle();
    }

    public void login(String mobile,String pass){

        myAccount.click();
        mob.sendKeys(mobile);
        password.sendKeys(pass);
        loginBtn.click();

    }
}
