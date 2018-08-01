package cloud9;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
public class cloudApp {

    String expectedTitle = "Cloud9 Airlines";

   // @before
    public static void setupBeforeTest() {

        WebDriver driver = new ChromeDriver();
        System.setProperty("ChromeDriver", "C:/Drivers/chromedriver");
        String baseUrl = "http://10.9.10.139:81/sqlite/Main/login.html";
        driver.get(baseUrl);
        String actualTitle = driver.getTitle();
        // Assert.assertEquals(actualTitle, expectedTitle);
    }
    @Test
    public void dftdfy()
    {

    }

    public static void main(String[] args) {
        }



        public static void register(WebDriver driver) {
            ;
            driver.findElement(By.linkText("Register")).click();
            driver.findElement(By.name("firstname")).sendKeys("Wayne");
            driver.findElement(By.name("lastname")).sendKeys("Sinclair");
            driver.findElement(By.name("email")).sendKeys("wsi@netactive.co.za");
            driver.findElement(By.name("password")).sendKeys("xxx");
            driver.findElement(By.xpath("/html/body/div/form/button")).click();

        }
}