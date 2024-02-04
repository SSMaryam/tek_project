package steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import pages.HomePage;
import utility.SeleniumUtility;

public class HomeSteps extends SeleniumUtility {
    @Given("landed on home page")
    public void landed_on_home_page() throws InterruptedException {
        Thread.sleep(5000);
    }
    @Given("wait {int} seconds")
        public void wait_seconds(int seconds){
    }

}
