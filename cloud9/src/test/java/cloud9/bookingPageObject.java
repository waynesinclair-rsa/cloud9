package cloud9;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class bookingPageObject {
    WebDriver driver;

    private By homePageLinkLocator = By.linkText("Homepage");
    private By bookFlightLinkLocator = By.linkText("Book Flight");
    private By signInButtonLocator = By.xpath(("/html/body/div/form/button")); // ***** continue
    private By bodyTextLocator = By.tagName("body");
    private String bookingHeader = "Book Flight";
    private String bookingSuccessful = "Flight booked successfully";

    public bookingPageObject(WebDriver driver) {

        this.driver = driver;
    }

    public void assertBookingHeader(){
        String bodyText = driver.findElement(bodyTextLocator).getText();
        Assert.assertTrue("Text not found!", bodyText.contains(bookingHeader));
    }

    public void assertBookingSuccessful(){
        String bodyText = driver.findElement(bodyTextLocator).getText();
        Assert.assertTrue("Text not found!", bodyText.contains(bookingSuccessful));
    }

    public void clickBookButton(WebDriver driver){

        driver.findElement(signInButtonLocator).click();
    }

    public void populateBooking(WebDriver driver, String origin, String destination, String seat, String flightClass) {
;
        assertBookingHeader();
        driver.findElement(homePageLinkLocator).click();
        driver.findElement(bookFlightLinkLocator).click();
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
        //clickBookButton(driver);
    }

