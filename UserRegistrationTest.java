package testing;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class UserRegistrationTest {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "C:\\chromedriver-win64\\chromedriver.exe");

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless"); // Enable headless mode

        WebDriver driver = new ChromeDriver(options);
        driver.navigate().to("http://127.0.0.1:8000/user/register");
        driver.findElement(By.name("name")).sendKeys("Shanza");
        driver.findElement(By.name("email")).sendKeys("shanza@gmail.com");
        driver.findElement(By.name("password")).sendKeys("Abc!2345");
        driver.findElement(By.name("password_confirmation")).sendKeys("Abc!2345");
        driver.findElement(By.xpath("/html/body/section/div/div/div/div/form/div/div[5]/div/button")).click();
      
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        try {
            // Validate successful login by waiting for a specific element on the next page
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/header/div[2]")));
            System.out.println("User Registration successful! : Passed");
        } catch (Exception e) {
            System.out.println("User Registration successful! : Failed");
        } finally {
            driver.quit();
        }
    }
}
