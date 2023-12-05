package testing;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class AddReviewTest {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "C:\\chromedriver-win64\\chromedriver.exe");

        // Enable headless mode
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless");

        WebDriver driver = new ChromeDriver(options);
        driver.navigate().to("http://127.0.0.1:8000/product-detail/melange-casual-black");
        
		driver.findElement(By.xpath("//*[@id=\"myTab\"]/li[2]/a")).click();
		driver.findElement(By.xpath("//*[@id=\"reviews\"]/div/div/div/div[1]/div[2]/p/a[1]")).click();
		driver.findElement(By.name("email")).sendKeys("shanza@gmail.com");
	    driver.findElement(By.name("password")).sendKeys("Abc!2345");
		driver.findElement(By.xpath("/html/body/section/div/div/div/div/form/div/div[3]/div[1]/button")).click();
		driver.findElement(By.xpath("/html/body/header/div[3]/div/div/div/div/div/nav/div/div/ul/li[3]/a")).click();
		driver.findElement(By.xpath("/html/body/form/section/div/div/div[2]/div[2]/div[1]/div/div[2]/h3/a")).click();
		driver.findElement(By.xpath("//*[@id=\"myTab\"]/li[2]/a")).click();
		driver.findElement(By.xpath("//*[@id=\"reviews\"]/div/div/div/div[1]/div[2]/form/div/div[1]/div/div/div/label[1]")).click();
		driver.findElement(By.xpath("//*[@id=\"reviews\"]/div/div/div/div[1]/div[2]/form/div/div[2]/div/textarea")).sendKeys("Good Product");
		driver.findElement(By.xpath("//*[@id=\"reviews\"]/div/div/div/div[1]/div[2]/form/div/div[3]/div/button")).click();

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        try {
            // Validate successful login by waiting for a specific element on the next page
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[3]/div/div/div/div/ul/li[2]/a")));
            System.out.println("Review added successfully! : Passed");
        } catch (Exception e) {
            System.out.println("Review added successfully! : Failed");
        } finally {
            driver.quit();
        }
    }
}

