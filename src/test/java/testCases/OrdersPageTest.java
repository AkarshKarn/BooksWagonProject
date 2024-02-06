package testCases;

import base.BaseClass;
import org.apache.log4j.Logger;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;
import pages.OrdersPage;

public class OrdersPageTest extends BaseClass {

   public LoginPage loginPage;
    OrdersPage ordersPage;

    Logger log=Logger.getLogger(OrdersPage.class);

    public OrdersPageTest(){
        super();
    }

    @BeforeMethod
    public void setOrdersPage(){
        log.info("Order Page Test Cases Execution Start");
        initialization();
        loginPage=new LoginPage();
        loginPage.login(prop.getProperty("mob"), prop.getProperty("password") );
    }

    @Test
    public void myOrdersPage(){
        log.info("Order Page Test Successful");
        ordersPage=ordersPage.myOrders();
    }


}
