package runner.etsy;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/com.etsy/EtsySearchOutline.feature",
        glue = {"steps/com/etsy", "steps"},
        dryRun = false,
        tags = "@outline"
)

public class EtsyRunner {
}
