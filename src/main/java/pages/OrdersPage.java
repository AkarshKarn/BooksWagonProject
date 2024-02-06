package pages;

import base.BaseClass;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrdersPage extends BaseClass {

    @FindBy(linkText = "Your Orders")
    WebElement myOrders;

    public OrdersPage(){
        PageFactory.initElements(webDriver,this);
    }

    public OrdersPage myOrders(){
        myOrders.click();

        return new OrdersPage();
    }
}
