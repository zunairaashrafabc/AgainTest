package testing;
import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginTest {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "C:\\chromedriver-win64\\chromedriver.exe");

//         Enable headless mode
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless");

        WebDriver driver = new ChromeDriver(options);
        driver.navigate().to("http://127.0.0.1:8000/login");

        driver.findElement(By.name("email")).sendKeys("admin@gmail.com");
        driver.findElement(By.name("password")).sendKeys("12345678");
        driver.findElement(By.name("remember")).click();
        driver.findElement(By.xpath("//button[contains(text(), 'Login')]")).click();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        try {
            // Validate successful login by waiting for a specific element on the next page
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"accordionSidebar\"]/a/div[2]")));
            System.out.println("Login successful! : Passed");
        } catch (Exception e) {
            System.out.println("Login successful! : Failed");
        } finally {
            driver.quit();
        }
    }
}



