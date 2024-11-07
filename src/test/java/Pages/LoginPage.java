package Pages;

import org.openqa.selenium.By;

public class LoginPage extends BasePage{
    public By email_input_box = By.xpath("//input[@data-qa='login-email']");
    public By password_input_box = By.xpath("//input[@placeholder='Password']");
    public By login_btn = By.xpath("//button[normalize-space()='Login']");
    public By error_massage = By.xpath("//p[normalize-space()='Your email or password is incorrect!']");

    HomePage homePage = new HomePage();

    public void navigateToLoginPage(){
        homePage.loadHomePage();
        homePage.clickOnElement(homePage.login_signup);
    }
}
