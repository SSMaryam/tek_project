package broswers;

import org.openqa.selenium.WebDriver;

public interface IBroswer {
    WebDriver setupBrowser(boolean isHeadless);
}
