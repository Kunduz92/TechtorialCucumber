package runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = {"src/test/resources/herokuapp.feature"},
        glue = "steps/herokuappsteps",
        dryRun = false
)
public class cukesRunner {


}
