package Week2;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class FormSubmissionTest {
    @Test
    void testLogin() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\B00988791\\Downloads\\chromedriver-win64\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://practicetestautomation.com/practice-test-login/");
        WebElement username = driver.findElement(By.id("username"));
        WebElement password = driver.findElement(By.id("password"));

        WebElement loginButton = driver.findElement(By.id("login"));
        username.sendKeys("student");
        password.sendKeys("Password123");
        loginButton.click();
        String expectedUrl = "https://practicetestautomation.com/logged-in-successfully/";
        assertEquals(expectedUrl, driver.getCurrentUrl());
        driver.quit();
    }
}
