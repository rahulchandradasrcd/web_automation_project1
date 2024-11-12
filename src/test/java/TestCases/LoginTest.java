package TestCases;

import Pages.HomePage;
import Pages.LoginPage;
import Utilities.DataSet;
import Utilities.DriverSetup;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.IAssert;

import java.time.Duration;

public class LoginTest extends DriverSetup {

    HomePage homePage = new HomePage();
    LoginPage loginPage = new LoginPage();

    @BeforeMethod
    public void LoadLoginPage() {
        loginPage.navigateToLoginPage();
    }

    @AfterMethod
    public void AddScreenshotAfterTest(){
        loginPage.addScreenshot();
    }

    @Test(description = "validCredentials")
    @Description("User trying validCredentials")
    @Severity(SeverityLevel.CRITICAL)
    public void TestWithValidCredential() {

        loginPage.WriteOnElement(loginPage.email_input_box, "litecic778@edectus.com");
        loginPage.WriteOnElement(loginPage.password_input_box, "Luis5555@");
        loginPage.clickOnElement(loginPage.login_btn);
        Assert.assertTrue(homePage.is_element_visible(homePage.logout_btn));
        Assert.assertFalse(homePage.is_element_visible(homePage.login_signup), "successfully Login");
    }

    @Test
    public void TestWithValidEmailAndInvalidPassword() {

        loginPage.WriteOnElement(loginPage.email_input_box, "litecic778@edectus.com");
        loginPage.WriteOnElement(loginPage.password_input_box, "hjfsdhf");
        loginPage.clickOnElement(loginPage.login_btn);
        Assert.assertEquals(loginPage.getErrorMassage(loginPage.error_massage), "Your email or password is incorrect!");
        Assert.assertFalse(homePage.is_element_visible(homePage.logout_btn));
    }

    @Test
    public void TestWithInvalidEmailAndValidPassword() {

        loginPage.WriteOnElement(loginPage.email_input_box, "litecifgc778@edectus.com");
        loginPage.WriteOnElement(loginPage.password_input_box, "Luis5555@");
        loginPage.clickOnElement(loginPage.login_btn);
        Assert.assertEquals(loginPage.getErrorMassage(loginPage.error_massage), "Your email or password is incorrect!");
        Assert.assertFalse(homePage.is_element_visible(homePage.logout_btn));
    }

    @Test
    public void TestWithEmptyEmailAndPassword() {

        loginPage.WriteOnElement(loginPage.email_input_box, "");
        loginPage.WriteOnElement(loginPage.password_input_box, "");
        loginPage.clickOnElement(loginPage.login_btn);
        Assert.assertEquals(loginPage.getAttributeName(loginPage.email_input_box), "Please fill out this field.");
        Assert.assertFalse(homePage.is_element_visible(homePage.logout_btn));
    }

    @Test
    public void TestWithEmailAndEmptyPassword() {

        loginPage.WriteOnElement(loginPage.email_input_box, "litecifgc778@edectus.com");
        loginPage.WriteOnElement(loginPage.password_input_box, "");
        loginPage.clickOnElement(loginPage.login_btn);
        Assert.assertEquals(loginPage.getAttributeName(loginPage.password_input_box), "Please fill out this field.");
        Assert.assertFalse(homePage.is_element_visible(homePage.logout_btn));
    }

    @Test(dataProvider = "invalidCredentials", dataProviderClass = DataSet.class)
    public void TestWithInvalidCredentials(String email, String pass, String error_msg, String validation_msg) {
        loginPage.WriteOnElement(loginPage.email_input_box, email);
        loginPage.WriteOnElement(loginPage.password_input_box, pass);
        loginPage.clickOnElement(loginPage.login_btn);
        Assert.assertEquals(loginPage.getAttributeName(loginPage.email_input_box), validation_msg);
        Assert.assertEquals(loginPage.getAttributeName(loginPage.password_input_box), validation_msg);
        if (loginPage.is_element_visible(loginPage.error_massage))
            Assert.assertEquals(loginPage.getErrorMassage(loginPage.error_massage), error_msg);
        Assert.assertTrue(loginPage.is_element_visible(loginPage.login_btn));

    }
}
