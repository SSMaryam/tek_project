package pages;

import org.openqa.selenium.By;

public class CreateAccountPage {
    public static final By emailInput = By.name("email");
    public static final By prefixSelect = By.name("title");
    public static final By firstNameInput = By.name("firstName");
    public static final By lastNameInput = By.name("lastName");
    public static final By genderSelect = By.name("gender");
    public static final By maritalStatusSelect = By.name("maritalStatus");
    public static final By employmentInput = By.name("employmentStatus");
    public static final By dobInput = By.name("dateOfBirth");
    public static final By fullNameTitle = By.xpath("///div[@id='root']/div/div[2]//div[contains(@class,'chakra-stack')]/h2[2]");
    public static final By emailTitle = By.xpath("//div[@id='root']/div/div[2]//div[contains(@class,'chakra-stack')]/h2[3]");
    public static By getInputLocator(String field){
        return By.xpath("//label[text() = '" + field + "']/..//input");
    }

}
