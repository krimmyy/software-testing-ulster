package test;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class GoogleSearchTest {
    @Test
        void SearchTest() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\b00988791\\Downloads\\chromedriver-win64\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.google.com");

        // Waiting 10 seconds for page to load
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        // Waiting for the cookies and data pop up to load and then finding the reject all button to click
        WebElement rejectCookies = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[text()='Reject all']")));

        // Using JavaScript to scroll down for the button to be visible
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", rejectCookies);

        // carrying out the clicking of the button
        rejectCookies.click();

        WebElement searchBox = driver.findElement(By.name("q"));
        searchBox.sendKeys("Selenium WebDriver");
        searchBox.submit();

        // TODO: fix program getting stuck after CAPTCHA has been solved manually
        // Pausing the test to allow for manual CAPTCHA solving if a CAPTCHA is detected
        while (driver.getPageSource().contains("detected unusual traffic")) {
            System.out.println("CAPTCHA detected! Solve it manually then press Enter to continue with the test...");
            new Scanner(System.in).nextLine();

            wait.until(ExpectedConditions.urlContains("search?q=Selenium+WebDriver"));
        }

        assertTrue(driver.getTitle().contains("Selenium WebDriver"), "Search result title mismatch");

        //driver.quit();
    }

}
