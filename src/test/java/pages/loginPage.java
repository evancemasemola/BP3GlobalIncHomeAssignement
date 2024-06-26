package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import java.util.concurrent.TimeUnit;

public class loginPage {

    private final WebDriver webDriver;

    public loginPage(WebDriver webDriver) {
        this.webDriver = webDriver;
        webDriver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }

    //login page locators
    private By userNameTextField = By.id("user-name");
    private By passwordTextField = By.id("password");
    private By loginButton = By.id("login-button");
    private By errorMessageLockedOut = By.xpath("//*[text()='Epic sadface: Sorry, this user has been locked out.']");

    public void enterUserName(String username){

        webDriver.findElement(userNameTextField).sendKeys(username);
    }

    public void enterPassword(String password){
        webDriver.findElement(passwordTextField).sendKeys(password);
    }

    public void clickLoginButton(){
        webDriver.findElement(loginButton).click();
    }

    public void verifyLockedOutErrorMessage(){

        String errorMessage = webDriver.findElement(errorMessageLockedOut).getText();
        Assert.assertEquals("Epic sadface: Sorry, this user has been locked out.",errorMessage);
    }

}
