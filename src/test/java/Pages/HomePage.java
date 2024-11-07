package Pages;

import org.openqa.selenium.By;

public class HomePage extends BasePage{

    public String url = "https://automationexercise.com/";
    public String title = "Automation Exercise";


    public By login_signup = By.xpath("//a[normalize-space()='Signup / Login']");


}
