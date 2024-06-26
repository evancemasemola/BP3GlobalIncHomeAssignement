package runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        glue = "stepDefinitions",
        features = "src/test/resources/Features/products",
        tags = "@OrderBackpack",
        plugin = "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:",
        monochrome = true,
        publish = true)

public class productsRunner extends AbstractTestNGCucumberTests {

}