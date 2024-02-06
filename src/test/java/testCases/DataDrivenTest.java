package testCases;

import base.BaseClass;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.log4j.Logger;

public class DataDrivenTest extends BaseClass {
    LoginPage loginPage;
    HomePage homePage;

    Logger log=Logger.getLogger(LoginPage.class);
    DataDrivenTest(){
        super();
    }
    @BeforeMethod
    public void setLoginPage(){
        log.info("Starting Test Cases Execution");
        initialization();
        loginPage = new LoginPage();
    }
    @Test(dataProvider="Excel")
    public void loginTest(String mobile, String password){
        loginPage.login(mobile,password);
        log.info("Login Successful using mobile number"+mobile);
    }
    @DataProvider(name = "Excel")
    public Object[][] testDataGenerator() throws IOException {
        FileInputStream file = new FileInputStream("C:\\Users\\DELL\\IntelliJIdeaProjects\\Bookswagon\\TestFData\\TestData.xlsx");
       XSSFWorkbook workbook = new XSSFWorkbook(file);
        XSSFSheet loginSheet = workbook.getSheet("Login");
        int numberOfData = loginSheet.getPhysicalNumberOfRows();
        Object[][] testData = new Object[numberOfData][2];

        for (int i=0; i< numberOfData; i++){

            XSSFRow row = loginSheet.getRow(i);
            XSSFCell mobileNumber = row.getCell(0);
            XSSFCell password = row.getCell(1);
            double mobile = mobileNumber.getNumericCellValue();
            String mobileNumberString = String.valueOf((long) mobile);
            String passwordValue = password.getStringCellValue();
            testData[i][0] = mobileNumberString;
            testData[i][1] = passwordValue;
        }
        return testData;
    }
    @AfterMethod
    public void close() {
        webDriver.quit();
    }
}
