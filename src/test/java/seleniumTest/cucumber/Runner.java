package seleniumTest.cucumber;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;


@RunWith(Cucumber.class)
@CucumberOptions(monochrome = true, strict = true,
        tags= {"@CreateCurrentAccount"},
        features ="src/test/resources/com.xceptor.selenium.features/UITest",
        plugin = {"html:target/cucumber-pretty","json:target/cucumber.json"},
        glue = {"seleniumTest/step_def"}
)

public class Runner {

}
