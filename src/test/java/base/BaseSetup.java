package base;

import exceptions.FrameworkSetupExceptions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import utility.Constants;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

public class BaseSetup {
    private static WebDriver driver;
    public static Map<String, String> recorder = new HashMap<>();
    public WebDriver getDriver(){
        return driver;  // static so we can directly call it
    }
    private final Properties properties;
public BaseSetup(){
    // system variable are those that are assigned to the system
    // maven goal will be mvn clean test -Dtek_env=qa
    String targetEnvironment = System.getProperty("tek_env"); // custom property
   String configFilePath;
    if (targetEnvironment == null) {
        configFilePath = Constants.CONFIG_FILE_BASE_PATH + "qa_env.properties";
    } else {
         configFilePath = Constants.CONFIG_FILE_BASE_PATH + "dev_env.properties";
    }
    this.properties = new Properties();
    try {
        FileInputStream inputStream =  new FileInputStream(new File(configFilePath));
        this.properties.load(inputStream);
    } catch (IOException ex) {
        throw new FrameworkSetupExceptions("Can not load property file with message" + ex.getMessage());

    }
}
public String getProperty(String Key){
    return this.properties.get(Key).toString();
}
    public void initialFramework() {
        String browser = getProperty("browserType");
        switch (browser.toLowerCase()) {
            case "chrome":
                driver = new ChromeDriver();
                break;
            case "firefox":
                driver = new FirefoxDriver();
                break;
            case "edge":
                driver = new EdgeDriver();
                break;
            default:
                throw new FrameworkSetupExceptions("Wrong browser type");

        }

        driver.manage().window().maximize();
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(Constants.WAIT_IN_SECONDS));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(Constants.WAIT_IN_SECONDS));
        driver.get(getProperty("baseURL"));

    }

    public void closeBrowser() {
        if (driver != null) {
            driver.quit();
        }
    }


}
