package testing;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PlaceOrderTest {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "C:\\chromedriver-win64\\chromedriver.exe");

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless"); // Enable headless mode

        WebDriver driver = new ChromeDriver(options);
        driver.navigate().to("http://127.0.0.1:8000");

        driver.findElement(By.xpath("/html/body/header/div[3]/div/div/div/div/div/nav/div/div/ul/li[4]/a")).click();
        driver.findElement(By.xpath("/html/body/header/div[3]/div/div/div/div/div/nav/div/div/ul/li[4]/ul/li[3]/a")).click();

        driver.findElement(By.xpath("/html/body/form/section/div/div/div[2]/div[2]/div[1]/div/div[2]/div/div/h3/a")).click();

        driver.findElement(By.xpath("/html/body/section/div/div/div/div[1]/div[2]/div/div[3]/form/div[2]/button")).click();
        driver.findElement(By.name("email")).sendKeys("shanza@gmail.com");
        driver.findElement(By.name("password")).sendKeys("Abc!2345");
        driver.findElement(By.xpath("/html/body/section/div/div/div/div/form/div/div[3]/div[1]/button")).click();

        driver.findElement(By.xpath("/html/body/header/div[2]/div/div/div[3]/div/div[2]/a/i")).click();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        
        try {
        	 // Validate successful login by waiting for a specific element on the next page
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[2]/div/div/div/div/ul/li[2]/a")));
            System.out.println("Order placed successfully! : Passed");
        } catch (Exception e) {
            System.out.println("Order placed successfully! : Failed");
        } finally {
            driver.quit();
        }
    }
}

