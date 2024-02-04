import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "classpath:features",
        glue = "steps",
        tags = "@CreateAccount",
       dryRun = false,
        monochrome = true,
        snippets = CucumberOptions.SnippetType.CAMELCASE,
        plugin =  {
                "html:target/report/report.html",
                "json:target/jsonReports/jsonReport.json"
                  }
                )
public class TestRunner {
}
