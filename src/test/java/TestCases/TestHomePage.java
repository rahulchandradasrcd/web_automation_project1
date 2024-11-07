package TestCases;

import Pages.HomePage;
import Utilities.DriverSetup;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import static Utilities.DriverSetup.getDriver;

public class TestHomePage extends DriverSetup{

    HomePage homePage = new HomePage();

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

    @Test
    public void LoginButton(){
        getDriver().get(homePage.url);
        homePage.clickOnElement(homePage.login_signup);
    }

}
