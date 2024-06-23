package stepDefinitions;

import io.cucumber.java.*;
import io.cucumber.java.en.*;
import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import pages.loginPage;
import pages.productsPage;

import java.io.IOException;
import java.net.URL;
import java.util.HashMap;


public class loginSteps {

    public loginPage login;
    public productsPage products;
    protected WebDriver driver;

    @Before
    public void setup() throws IOException{
       // I couldn't use chrome driver on my local getting only allows local connections error

        System.setProperty("webdriver.chrome.driver", "src/test/resources/Drivers/chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--enable-javascript");
        options.addArguments("--allow-insecure-localhost");
        WebDriver driver = new ChromeDriver(options);
        login = new loginPage(driver);
        products = new productsPage(driver);


    }
    @Given("I am on the sauce demo website")
    public void gotoURL(){
        driver.get("https://www.saucedemo.com/");
        driver.manage().window().maximize();
    }
    @When("I enter UserName locked_out_user")
    public void i_enter_user_name_locked_out_user(String username) {
        login.enterUserName(username);
    }

    @When("I enter Password secret_sauce")
    public void i_enter_password_secret_sauce(String password) {
        login.enterPassword(password);
    }

    @When("I click on the login button")
    public void clickLoginButton(){
        login.clickLoginButton();
    }
    @Then("I should be displayed with an error message")
    public void verifyErrorMessage(){
        login.verifyLockedOutErrorMessage();
    }

    @Then("I should be redirected to the products page")
    public void verifyProductPageIsDisplayed(){
        products.verifyProductsPage();
    }

    @After
    public void complete() throws IOException {
        if(driver != null) {
            driver.close();
            driver.quit();
        }
    }
}
