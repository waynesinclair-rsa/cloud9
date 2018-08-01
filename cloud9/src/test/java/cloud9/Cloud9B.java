package cloud9;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Cloud9B {
    private WebDriver driver;
    String baseip1 = "http://192.168.56.1:81";
    String baseip2 = "http://10.9.10.139:81";
    String baseip = baseip2;
    String expectedTitle = "Cloud9 Airlines";
    String cloud9SigninHeader = "Cloud9 - Sign in";
    private String registrationSuccessful = "Registration Successful";
    String bookingHeader = "Book Flight";
    String bookingSuccessful = "Flight booked successfully";

    @Before
    public void setupBeforeTest() {

        System.setProperty("ChromeDriver", "C:/Drivers/chromedriver");
        driver = new ChromeDriver();
        String baseUrl = baseip + "/sqlite/Main/login.html";
        driver.get(baseUrl);
        String actualTitle = driver.getTitle();
        Assert.assertEquals(actualTitle, expectedTitle);
        String bodyText1 = driver.findElement(By.tagName("body")).getText();
        //System.out.println("Body Text is: " + bodyText);
        Assert.assertTrue("Text not found!", bodyText1.contains(cloud9SigninHeader));
    }

    @After
    public void tearDownAfterTest() {
        //  driver.close();
    }


    @Test
    public void register() {

        // Click the register tab on the login screen (Login screen is entry into system)
        driver.findElement(By.linkText("Register")).click();

        registrationPageObj registrationPage;
        registrationPage = new registrationPageObj(driver);
        registrationPage.populateRegistration("Wayne","Sinclair", "ws15@sqs.com", "xxx");
    }

    @Test
    public void loginTest() {

        logInPageObject loginPage;
        loginPage = new logInPageObject(driver);
        loginPage.populateLogIn(driver, "wsi@netactive.co.za", "xxx");
    }

    @Test
    public void bookingTest() {
        Utilities.login(driver,"wsi@netactive.co.za", "xxx");
        booking();
    }

    @Test
    public void ItineraryScan() {

        logInPageObject loginPage;
        loginPage = new logInPageObject(driver);
        loginPage.populateLogIn(driver, "wsi@netactive.co.za", "xxx");

        //driver.findElement(By.linkText("Homepage")).click();
        itineraryPageObj itineraryPage = new itineraryPageObj(driver);
        itineraryPage.scanBookingsAndClickUpdate("A23");
    }

    public void booking(){

        driver.findElement(By.linkText("Homepage")).click();
        driver.findElement(By.linkText("Book Flight")).click();
        String bodyText1 = driver.findElement(By.tagName("body")).getText();
        Assert.assertTrue("Text not found!", bodyText1.contains(bookingHeader));

        WebElement Origin = driver.findElement(By.name("Origin"));
        Select OriginDropDownSelect = new Select(Origin);
        OriginDropDownSelect.selectByVisibleText("Durban");

        WebElement Destination = driver.findElement(By.name("Destination"));
        Select DestinationDropDownSelect = new Select(Destination);
        DestinationDropDownSelect.selectByVisibleText("Johannesburg");

        driver.findElement(By.id("seat")).sendKeys("A23");

        WebElement Flightclass = driver.findElement(By.name("Flightclass"));
        Select FlightclassDropDownSelect = new Select(Flightclass);
        FlightclassDropDownSelect.selectByVisibleText("Business");

        driver.findElement(By.xpath("/html/body/div/div/div[2]/form/button")).click();

        String bodyText2 = driver.findElement(By.tagName("body")).getText();
        Assert.assertTrue("Text not found!", bodyText2.contains(bookingSuccessful));
    }
}