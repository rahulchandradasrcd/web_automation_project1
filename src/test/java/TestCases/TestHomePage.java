package TestCases;

import Pages.HomePage;
import Utilities.DriverSetup;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static Utilities.DriverSetup.getDriver;

public class TestHomePage extends DriverSetup{

    HomePage homePage = new HomePage();

   @AfterMethod
   public void AddScreenshotAfterTest(){
       homePage.addScreenshot();
   }

    @Test
    public void TestPageUrl(){
        getDriver().get(homePage.url);
        Assert.assertEquals(homePage.getPageUrl(), homePage.url);
    }

    @Test
    public void TestPageTitle(){
       getDriver().get(homePage.url);
       Assert.assertEquals(homePage.getPageTitle(), homePage.title);
    }

}
