import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class LoginTest1 {
    @Test
    void testLoginCorrect() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\b00988791\\Downloads\\chromedriver-win64\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://practicetestautomation.com/practice-test-login/");

        WebElement username = driver.findElement(By.id("username"));
        WebElement password = driver.findElement(By.id("password"));
        WebElement login = driver.findElement(By.id("submit"));

        username.sendKeys("student");
        password.sendKeys("Password123");
        login.click();

        String expectedUrl = "https://practicetestautomation.com/logged-in-successfully/";
        assertEquals(expectedUrl, driver.getCurrentUrl());

        //driver.quit();
    }

    @Test
    void testLoginIncorrect() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\b00988791\\Downloads\\chromedriver-win64\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://practicetestautomation.com/practice-test-login/");

        WebElement username = driver.findElement(By.id("username"));
        WebElement password = driver.findElement(By.id("password"));
        WebElement login = driver.findElement(By.id("submit"));

        username.sendKeys("eligijus");
        password.sendKeys("Password2025");
        login.click();

        String expectedUrl = "https://practicetestautomation.com/practice-test-login/";
        assertEquals(expectedUrl, driver.getCurrentUrl());

        //driver.quit();
    }
}
