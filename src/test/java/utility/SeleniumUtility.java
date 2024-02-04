package utility;

import base.BaseSetup;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

import java.time.Duration;

public class SeleniumUtility extends BaseSetup {
    public WebDriverWait getWait(){
        return new WebDriverWait(getDriver(), Duration.ofSeconds(Constants.WAIT_IN_SECONDS));
    }
    public WebElement waitTillVisibility(By locator){
        return getWait().until(ExpectedConditions.visibilityOfElementLocated(locator));
    }
    public void clickOnElement(By locator){
        getWait().until(ExpectedConditions.elementToBeClickable(locator)).click();
    }
    public String getElementText(By locator){
        return waitTillVisibility(locator).getText();
    }
    public void sendText(By locator , String text){
        waitTillVisibility(locator).sendKeys(text);
    }
    public void selectFromDropDown(By locator, String visibleText ){
        WebElement element = waitTillVisibility(locator);
        Select select = new Select(element);
        select.selectByVisibleText(visibleText);
    }
    public void selectFromDropDown(By locator, int index){
        WebElement element = waitTillVisibility(locator);
        Select select = new Select(element);
        select.selectByIndex(index);
    }


}
