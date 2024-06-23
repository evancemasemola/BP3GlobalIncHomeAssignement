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
        js =  (JavascriptExecutor) webDriver;
        webDriver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }

    //locate elements
    private By sideMenu = By.id("react-burger-menu-btn");
    private By cartIcon = By.id("shopping_cart_container");
    private By addToCartBackPack = By.id("add-to-cart-sauce-labs-backpack");
    private By removeButtonBackPack = By.id("remove-sauce-labs-backpack");
    private By continueShoppingButton = By.id("continue-shopping");
    private By checkoutButton = By.id("checkout");
    private By logoutButton = By.id("logout_sidebar_link");

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
        JavascriptExecutor js = (JavascriptExecutor) webDriver;
        js.executeScript("arguments[0].style.border='3px solid red'", webDriver.findElement(logoutButton));
        webDriver.findElement(logoutButton).click();
    }

    public void addSauceLabsBackpackToCart(){
        JavascriptExecutor js = (JavascriptExecutor) webDriver;
        js.executeScript("arguments[0].style.border='3px solid red'", webDriver.findElement(addToCartBackPack));
        webDriver.findElement(addToCartBackPack).click();
    }

    public void clickCartIcon(){
        JavascriptExecutor js = (JavascriptExecutor) webDriver;
        js.executeScript("arguments[0].style.border='3px solid red'", webDriver.findElement(cartIcon));
        webDriver.findElement(cartIcon).click();
    }

    public void clickRemoveButton(){
        JavascriptExecutor js = (JavascriptExecutor) webDriver;
        js.executeScript("arguments[0].style.border='3px solid red'", webDriver.findElement(removeButtonBackPack));
        webDriver.findElement(removeButtonBackPack).click();
    }
    public void clickContinueShoppingButton(){
        JavascriptExecutor js = (JavascriptExecutor) webDriver;
        js.executeScript("arguments[0].style.border='3px solid red'", webDriver.findElement(continueShoppingButton));
        webDriver.findElement(continueShoppingButton).click();
    }

    public void clickCheckoutButton(){
        JavascriptExecutor js = (JavascriptExecutor) webDriver;
        js.executeScript("arguments[0].style.border='3px solid red'", webDriver.findElement(checkoutButton));
        webDriver.findElement(checkoutButton).click();
    }

    public void enterFirstName(String firstName){
        JavascriptExecutor js = (JavascriptExecutor) webDriver;
        js.executeScript("arguments[0].style.border='3px solid red'", webDriver.findElement(firstNameTextField));
        webDriver.findElement(firstNameTextField).sendKeys(firstName);
    }

    public void enterLastName(String lastName){
        JavascriptExecutor js = (JavascriptExecutor) webDriver;
        js.executeScript("arguments[0].style.border='3px solid red'", webDriver.findElement(lastNameTextField));
        webDriver.findElement(lastNameTextField).sendKeys(lastName);
    }
    public void enterZipCode(String zipCode){
        JavascriptExecutor js = (JavascriptExecutor) webDriver;
        js.executeScript("arguments[0].style.border='3px solid red'", webDriver.findElement(postalCodeTextField));
        webDriver.findElement(postalCodeTextField).sendKeys(zipCode);
    }

    public void clickCancelButton(){
        JavascriptExecutor js = (JavascriptExecutor) webDriver;
        js.executeScript("arguments[0].style.border='3px solid red'", webDriver.findElement(cancelButton));
        webDriver.findElement(cancelButton).click();
    }

    public void clickContinueButton(){
        JavascriptExecutor js = (JavascriptExecutor) webDriver;
        js.executeScript("arguments[0].style.border='3px solid red'", webDriver.findElement(continueButton));
        webDriver.findElement(continueButton).click();
    }

    public void clickFinishButton(){

        //assert price total
        String priceTotal = webDriver.findElement(priceTotalText).getText();
        Assert.assertEquals("Price Total", priceTotal);

        JavascriptExecutor js = (JavascriptExecutor) webDriver;
        js.executeScript("arguments[0].style.border='3px solid red'", webDriver.findElement(finishButton));
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
        JavascriptExecutor js = (JavascriptExecutor) webDriver;
        js.executeScript("arguments[0].style.border='3px solid red'", webDriver.findElement(backHomeButton));
        webDriver.findElement(backHomeButton).click();
    }

}
