package cloud9;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class logInPageObject {
    WebDriver driver;

    private By emailAddressLocator = By.name("email");
    private By passwordLocator = By.name("password");
    private By signInButtonLocator = By.xpath(("/html/body/div/form/button"));
    private By bodyTextLocator = By.tagName("body");
    private String loginHeader = "Cloud9 - Sign in";
    private String loginSuccessful = "Welcome";

    public logInPageObject(WebDriver driver) {

        this.driver = driver;
    }

    public void assertLoginHeader(){
        String bodyText = driver.findElement(bodyTextLocator).getText();
        Assert.assertTrue("Text not found!", bodyText.contains(loginHeader));
    }

    public void assertLoginSuccessful(){
        String bodyText = driver.findElement(bodyTextLocator).getText();
        Assert.assertTrue("Text not found!", bodyText.contains(loginSuccessful));
    }

    public void clickSignIn(WebDriver driver){

        driver.findElement(signInButtonLocator).click();
    }

    public void populateLogIn(WebDriver driver, String email, String password) {
;
        assertLoginHeader();
        driver.findElement(emailAddressLocator).sendKeys(email);
        driver.findElement(passwordLocator).sendKeys(password);
        //driver.findElement(signInButtonLocator).click();
        clickSignIn(driver);
        assertLoginSuccessful();
    }
}
