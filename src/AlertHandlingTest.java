import org.junit.jupiter.api.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import static org.junit.jupiter.api.Assertions.*;

public class AlertHandlingTest {

    @Test
    void TestingAlerts() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\b00988791\\Downloads\\chromedriver-win64\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://the-internet.herokuapp.com/javascript_alerts");

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        WebElement rejectCookies = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[text()='Reject all']")));

        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", rejectCookies);

        rejectCookies.click();

        // TODO: Fix alert tests not working properly
        // Handling simple alert
        WebElement simpleAlertButton = driver.findElement(By.xpath("//button[text()='Click for JS Alert']"));
        simpleAlertButton.click();

        // Waiting for alert and accepting it
        Alert simpleAlert = wait.until(ExpectedConditions.alertIsPresent());
        simpleAlert.accept();

        // Handling confirmation alert
        WebElement confirmationAlertButton = driver.findElement(By.xpath("//button[text()='Click for JS Confirm']"));
        confirmationAlertButton.click();

        // Waiting for confirmation alert and accepting it
        Alert confirmationAlert = wait.until(ExpectedConditions.alertIsPresent());
        confirmationAlert.accept();

        // Handling prompt alert
        WebElement promptAlertButton = driver.findElement(By.xpath("//button[text()='Click for JS Prompt']"));
        promptAlertButton.click();

        // Waiting for prompt alert and sending text input
        Alert promptAlert = wait.until(ExpectedConditions.alertIsPresent());
        promptAlert.sendKeys("Hello, World!");
        promptAlert.accept();

        // Verifying if a prompt is successfully handled
        WebElement result = driver.findElement(By.id("result"));
        assertTrue(result.getText().contains("You entered: Hello, World!"), "Prompt alert was not handled correctly!");

        //driver.quit();
    }
}
