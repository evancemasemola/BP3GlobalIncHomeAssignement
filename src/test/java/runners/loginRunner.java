package runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.DataProvider;

@CucumberOptions(
        glue = "stepDefinitions",
        features = "src/test/resources/Features",
        tags = "@locked or  @StandardUser",
        plugin = "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:",
        monochrome = true,
        publish = true)

public class loginRunner extends AbstractTestNGCucumberTests {

}