package seleniumTest.cucumber;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;


@RunWith(Cucumber.class)
@CucumberOptions(monochrome = true, strict = true,
        tags= {"@CreateCurrentAccount"},
        features ="src/test/resources/com.xceptor.selenium.features/UITest",
        glue = {"seleniumTest/step_def"}
)

public class Runner {

}
