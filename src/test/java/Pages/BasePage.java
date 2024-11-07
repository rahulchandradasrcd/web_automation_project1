package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.w3c.dom.Text;

import static Utilities.DriverSetup.getDriver;

public class BasePage {

    public WebElement GetElement(By locator){
        return getDriver().findElement(locator);
    }

    public void clickOnElement(By locator){
        GetElement(locator).click();
    }

    public void WriteOnElement(By locator, String text){
        GetElement(locator).clear();
        GetElement(locator).sendKeys();
    }

    public String getPageUrl(){
       return getDriver().getCurrentUrl();
    }

    public String getPageTitle(){
        return getDriver().getTitle();
    }

}
