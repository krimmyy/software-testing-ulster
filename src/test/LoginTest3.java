package test;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LoginTest3 {
    @Test
    void testLoginCorrect() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\b00988791\\Downloads\\chromedriver-win64\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://the-internet.herokuapp.com/login");

        WebElement username = driver.findElement(By.id("username"));
        WebElement password = driver.findElement(By.id("password"));
        WebElement login = driver.findElement(By.className("radius"));

        username.sendKeys("tomsmith");
        password.sendKeys("SuperSecretPassword!");
        login.click();

        String expectedUrl = "https://the-internet.herokuapp.com/secure";
        assertEquals(expectedUrl, driver.getCurrentUrl());

        //driver.quit();
    }

    @Test
    void testLoginIncorrect() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\b00988791\\Downloads\\chromedriver-win64\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://the-internet.herokuapp.com/login");

        WebElement username = driver.findElement(By.id("username"));
        WebElement password = driver.findElement(By.id("password"));
        WebElement login = driver.findElement(By.className("radius"));

        username.sendKeys("eligijusciza");
        password.sendKeys("Password!");
        login.click();

        String expectedUrl = "https://the-internet.herokuapp.com/login";
        assertEquals(expectedUrl, driver.getCurrentUrl());

        //driver.quit();
    }
}
