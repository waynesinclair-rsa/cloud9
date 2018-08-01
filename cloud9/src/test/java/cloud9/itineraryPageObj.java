package cloud9;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class itineraryPageObj {
    WebDriver driver;

    public itineraryPageObj(WebDriver driver) {
        this.driver = driver;
    }

    public void scanBookingsAndClickUpdate(String bookingID){
        //Utilities.login(driver,"wsi@netactive.co.za", "xxx");
        driver.findElement(By.linkText("Homepage")).click();

        List<WebElement> rows = driver.findElements(By.xpath("//table[@class='table table-striped']/tbody/tr"));

        System.out.println("Number of rows is " + rows.size());

        int rowNum =  rows.size();

        // Get booking id for latest booking
        List<WebElement> colVals2 = rows.get(rowNum-1).findElements(By.tagName("td"));
        System.out.println(colVals2.get(3).getText());

        for(int i=1; i<rowNum; i++){
            List<WebElement> colVals1 = rows.get(i).findElements(By.tagName("td"));
            for(int j=0; j<6; j++){
                System.out.println(colVals1.get(j).getText());
            }
        }
    }
}
