package pages;

import base.BaseClass;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static org.openqa.selenium.support.PageFactory.initElements;

public class HomePage extends BaseClass {

    @FindBy(className = "desktopdropdowninit dropdown-toggle")
    WebElement books;


    public HomePage() {
        PageFactory.initElements(webDriver, this);
    }

    public static String validateHomePageTitle() {
        return webDriver.getTitle();
    }

    public void navigateHomePage() {
        books.click();
    }


}
