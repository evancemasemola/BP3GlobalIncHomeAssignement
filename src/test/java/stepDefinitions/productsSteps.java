package stepDefinitions;
import pages.*;

import org.openqa.selenium.WebDriver;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import utilitis.WebDriverManagerClass;

public class productsSteps {

    public loginPage login;
    public productsPage products;

    @Before
    public void setup() {

        WebDriver driver = WebDriverManagerClass.getDriver();
        login = new loginPage(driver);
        products = new productsPage(driver);

    }

    @When("I am on the products page")
    public void i_am_on_the_products_page() {
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
    @When("I click on the checkout button")
    public void i_click_on_the_checkout_button() {
        products.clickCheckoutButton();
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

    @After
    public void tearDown() {
        WebDriverManagerClass.quitDriver();
    }
}
