package stepDefinitions;

import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
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

public class productsSteps {

    public loginPage login;
    public productsPage products;
    protected WebDriver driver;

    @Before
    public void setup() throws IOException {
       // I couldn't use chrome driver on my local getting only allows local connections error.

        System.setProperty("webdriver.chrome.driver", "src/test/resources/Drivers/chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--enable-javascript");
        options.addArguments("--allow-insecure-localhost");
        WebDriver driver = new ChromeDriver(options);

        login = new loginPage(driver);
        products = new productsPage(driver);


    }


    @Given("I am on the products page")
    public void i_am_on_the_products_page(String name, String password) {
        driver.get("https://www.saucedemo.com/");
        driver.manage().window().maximize();

        login.enterUserName(name);
        login.enterPassword(password);
        login.clickLoginButton();

        products.verifyProductsPage();
    }
    @When("I click on the Backpack add to cart button")
    public void i_click_on_the_backpack_add_to_cart_button() {
        products.addSauceLabsBackpackToCart();
    }
    @When("I click on the cart icon")
    public void i_click_on_the_cart_icon() {
        products.clickCartIcon();
    }
    @When("I enter First Name {string}")
    public void i_enter_first_name(String firstName) {
        products.enterFirstName(firstName);
    }
    @When("I enter Last Name {string}")
    public void i_enter_last_name(String lastName) {
        products.enterLastName(lastName);
    }
    @When("I enter Zip code {string}")
    public void i_enter_zip_code(String zipcode) {
        products.enterZipCode(zipcode);
    }
    @When("I click on the continue button")
    public void i_click_on_the_continue_button() {
        products.clickContinueButton();
    }
    @When("I click on the Finish button")
    public void i_click_on_the_finish_button() {
        products.clickFinishButton();
    }
    @Then("I should be displayed with an Checkout Completed Page")
    public void i_should_be_displayed_with_an_checkout_completed_page() {
        products.verifyOrderCompletedPage();
    }
}
