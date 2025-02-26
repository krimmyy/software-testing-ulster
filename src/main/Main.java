package main;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

 class Main {
     public static void main(String[] args) {

         System.setProperty("webdriver.chrome.driver", "C:\\Users\\B00988791\\Downloads\\chromedriver-win64\\chromedriver.exe");
         WebDriver driver = new ChromeDriver();
         driver.get("https://www.google.co.uk/");
         driver.manage().window().maximize();
     }
}
