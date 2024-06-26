package stepDefinitions;

import pages.*;
import utilitis.WebDriverManagerClass;

import io.cucumber.java.en.Given;
import org.openqa.selenium.WebDriver;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class loginSteps {

    public loginPage login;
    public productsPage products;
    private WebDriver driver;

    @Before
    public void setup(){

        WebDriverManagerClass.initializeDriver();
        driver = WebDriverManagerClass.getDriver();

        login = new loginPage(driver);
        products = new productsPage(driver);
    }
    @Given("I am on the sauce demo website {string}")
    public void gotoURL(String Url){
        if (driver != null) {
            driver.get(Url);
            driver.manage().window().maximize();
        } else {
            throw new IllegalStateException("WebDriver is not initialized properly");
        }

    }
    @When("I enter UserName {string}")
    public void i_enter_user_name_locked_out_user(String username) {
        login.enterUserName(username);
    }

    @When("I enter Password {string}")
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
    public void tearDown(){
        WebDriverManagerClass.quitDriver();
    }
}
