package pages;

import org.openqa.selenium.By;

public class HomePage {
    public static final By createAccountButton = By.linkText("Create Primary Account");
    public static By getLinkLocator(String linkText){
        return By.linkText(linkText);
    }
    public static final By SECTION_TITLE = By.xpath("//div[@id='root']/div/div[2]//div[contains(@class,'chakra-stack')]/h2[1]");
    public static By getButtonLocator(String buttonText){
        return By.xpath("//button[text()= '" + buttonText + "']");
    }
}
