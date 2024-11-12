package Pages;

import io.qameta.allure.Allure;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;

import java.io.ByteArrayInputStream;

import static Utilities.DriverSetup.getDriver;

public class BasePage {

    public void loadAWebpage(String url){
        getDriver().get(url);
    }

    public WebElement GetElement(By locator){
        return getDriver().findElement(locator);
    }

    public void clickOnElement(By locator){
        GetElement(locator).click();
    }

    public void WriteOnElement(By locator, String text){
        GetElement(locator).clear();
        GetElement(locator).sendKeys(text);
    }

    public String getPageUrl(){
       return getDriver().getCurrentUrl();
    }

    public String getPageTitle(){
        return getDriver().getTitle();
    }

    public Boolean is_element_visible(By locator){
        try {
            return GetElement(locator).isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    public String getErrorMassage(By locator){
        return GetElement(locator).getText();
    }

    public String getAttributeName(By locator){
        return GetElement(locator).getAttribute("validationMessage");
    }

    public void addScreenshot(){
        Allure.addAttachment("After Test", new ByteArrayInputStream(((TakesScreenshot)getDriver()).getScreenshotAs(OutputType.BYTES)));
    }

}
