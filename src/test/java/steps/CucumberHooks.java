package steps;


import base.BaseSetup;
import io.cucumber.java.After;
import io.cucumber.java.Before;

public class CucumberHooks extends BaseSetup {
@Before
    public void initializedTest(){
    initialFramework();
}
    @After
    public void cleanupTests(){
    recorder.clear(); //cleans data for the next test
    closeBrowser();
    }
}
