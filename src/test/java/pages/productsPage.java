package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import java.util.concurrent.TimeUnit;


public class productsPage {

    private final WebDriver webDriver;
    JavascriptExecutor js;


    public productsPage(WebDriver webDriver) {
        this.webDriver = webDriver;
        webDriver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }

    //locate elements
    private By sideMenu = By.cssSelector("#react-burger-menu-btn");
    private By cartIcon = By.cssSelector("#shopping_cart_container");
    private By addToCartBackPack = By.cssSelector("#add-to-cart-sauce-labs-backpack");
    private By removeButtonBackPack = By.cssSelector("#remove-sauce-labs-backpack");
    private By continueShoppingButton = By.cssSelector("#continue-shopping");
    private By checkoutButton = By.cssSelector("#checkout");
    private By logoutButton = By.cssSelector("#logout_sidebar_link");

    //delivery address locators
    private By firstNameTextField = By.id("first-name");
    private By lastNameTextField = By.id("last-name");
    private By postalCodeTextField = By.id("postal-code");
    private By cancelButton = By.id("cancel");
    private By continueButton = By.id("continue");
    private By finishButton =By.id("finish");
    private By priceTotalText = By.xpath("//*[text()='Price Total']");

    //checkout completed locators
    private By backHomeButton = By.id("back-to-products");
    private By thankYouMessageText = By.xpath("//*[text()='Thank you for your order!']");
    private By orderInfoMessage = By.xpath("//*[text()='Your order has been dispatched, and will arrive just as fast as the pony can get there!']");

    public void verifyProductsPage(){

        Assert.assertTrue(webDriver.findElement(sideMenu).isDisplayed());
        Assert.assertTrue(webDriver.findElement(cartIcon).isDisplayed());
    }
    public void clickLockOutButton(){
                webDriver.findElement(logoutButton).click();
    }

    public void addSauceLabsBackpackToCart(){
                webDriver.findElement(addToCartBackPack).click();
    }

    public void clickCartIcon(){
                webDriver.findElement(cartIcon).click();
    }

    public void clickRemoveButton(){
                webDriver.findElement(removeButtonBackPack).click();
    }
    public void clickContinueShoppingButton(){
               webDriver.findElement(continueShoppingButton).click();
    }

    public void clickCheckoutButton(){
                webDriver.findElement(checkoutButton).click();
    }

    public void enterFirstName(String firstName){
                webDriver.findElement(firstNameTextField).sendKeys(firstName);
    }

    public void enterLastName(String lastName){
        webDriver.findElement(lastNameTextField).sendKeys(lastName);
    }
    public void enterZipCode(String zipCode){
        webDriver.findElement(postalCodeTextField).sendKeys(zipCode);
    }

    public void clickCancelButton(){
        webDriver.findElement(cancelButton).click();
    }

    public void clickContinueButton(){
        webDriver.findElement(continueButton).click();
    }

    public void clickFinishButton(){

        //assert price total
        String priceTotal = webDriver.findElement(priceTotalText).getText();
        Assert.assertEquals("Price Total", priceTotal);
        webDriver.findElement(finishButton).click();

    }

    public void verifyOrderCompletedPage(){

        //assert checkout completed page
        String thankYouText = webDriver.findElement(thankYouMessageText).getText();
        String orderInfoText = webDriver.findElement(orderInfoMessage).getText();
        Assert.assertEquals("Thank you for your order!", thankYouText);
        Assert.assertEquals("Your order has been dispatched, and will arrive just as fast as the pony can get there!", orderInfoText);
       Assert.assertTrue(webDriver.findElement(backHomeButton).isDisplayed());
    }
    public void clickBackHomeButton(){
        webDriver.findElement(backHomeButton).click();
    }

}
