package test;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class NavigationTest {

    @Test
    void navigationTesting() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\b00988791\\Downloads\\chromedriver-win64\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        // Navigating to Google page
        driver.get("https://www.google.com");

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        WebElement rejectCookies = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[text()='Reject all']")));

        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", rejectCookies);

        rejectCookies.click();

        // Clicking the "Gmail" link
        WebElement gmailLink = wait.until(ExpectedConditions.elementToBeClickable(By.linkText("Gmail")));
        gmailLink.click();

        // Waiting for the Gmail page to load and check if title is correct
        wait.until(ExpectedConditions.titleContains("Gmail"));
        assertTrue(driver.getTitle().contains("Gmail"), "Page title does not match!");

        // Navigating back to Google page
        driver.navigate().back();

        // Validating that we are back to the Google page
        assertTrue(driver.getTitle().contains("Google"), "Nagivation back failed!");

        //driver.quit();


    }
}
