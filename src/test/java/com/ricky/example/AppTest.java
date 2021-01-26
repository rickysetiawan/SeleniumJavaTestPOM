package com.ricky.example;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import com.ricky.example.App;

public class AppTest {

    String driverPath = "/Users/Rise5599/Downloads/geckodriver";
    WebDriver driver;

    App objLogin;

    @BeforeTest
    public void setup(){

	System.setProperty("webdriver.gecko.driver", driverPath);  
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("http://demo.guru99.com/V4/");
    }

    @Test(priority=0)
    public void test_Home_Page_Appear_Correct(){
    objLogin = new App(driver);
    String loginPageTitle = objLogin.getLoginTitle();
    Assert.assertTrue(loginPageTitle.toLowerCase().contains("guru99 bank"));
    objLogin.loginToGuru99("mgr123", "mgr!23");

    }

}