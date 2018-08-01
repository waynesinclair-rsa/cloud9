package cloud9;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Utilities {

    public static void login(WebDriver driver, String email, String password){
        //driver.get(baseip + "/sqlite/Main/login.html");
        driver.findElement(By.name("email")).sendKeys("wsi@netactive.co.za");
        driver.findElement(By.name("password")).sendKeys("xxx");
        driver.findElement(By.xpath("/html/body/div/form/button")).click();

        String bodyText = driver.findElement(By.tagName("body")).getText();
        //System.out.println("Body Text is: " + bodyText);
        Assert.assertTrue("Text not found!", bodyText.contains("Welcome"));
    }

}
