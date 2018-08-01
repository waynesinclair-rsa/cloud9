package cloud9;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class registrationPageObj {
    WebDriver driver;

    private By firstNameLocator = By.name("firstname");
    private By lastNameLocator = By.name("lastname");
    private By emailLocator = By.name("email");
    private By passwordLocator = By.name("password");
    private By registerButtonLocator = By.xpath("/html/body/div/form/button");
    private By bodyTextLocator = By.tagName("body");

    private String cloud9RegisterHeader = "Cloud9 - Register";
    private String registrationSuccessful = "Registration Successful";

    public registrationPageObj(WebDriver driver) {

        this.driver = driver;
    }

    public void clickRegister(WebDriver driver){

        //System.out.println("Click Register Button");
        driver.findElement(registerButtonLocator).click();
    }

    public void assertRegistrationHeader(){
        String bodyText = driver.findElement(bodyTextLocator).getText();
        Assert.assertTrue("Text not found!", bodyText.contains(cloud9RegisterHeader));
    }

    public void assertRegistrationSuccessful(){
        String bodyText = driver.findElement(bodyTextLocator).getText();
        Assert.assertTrue("Text not found!", bodyText.contains(registrationSuccessful));
    }

    public void populateRegistration(String firstName, String lastName, String emailAddress, String password){

        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyyMMddHHmmss");
        LocalDateTime now = LocalDateTime.now();
        System.out.println(dtf.format(now));
        emailAddress = emailAddress + dtf.format(now);

        assertRegistrationHeader();
        driver.findElement(firstNameLocator).sendKeys(firstName);
        driver.findElement(lastNameLocator).sendKeys(lastName);
        driver.findElement(emailLocator).sendKeys(emailAddress);
        driver.findElement(passwordLocator).sendKeys(password);
        clickRegister(driver);
        assertRegistrationSuccessful();
    }
}
