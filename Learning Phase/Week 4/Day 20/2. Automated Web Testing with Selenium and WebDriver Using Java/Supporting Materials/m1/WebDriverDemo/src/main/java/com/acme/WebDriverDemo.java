package com.acme;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.time.Duration;

public class WebDriverDemo {

    public static void main(String[] args) throws InterruptedException {
        // Set up WebDriver
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        try {
            // Navigate to Google
            driver.get("https://www.google.com");

            // Accept cookies if prompted (common on Google)
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            try {
                WebElement acceptCookiesButton = wait.until(ExpectedConditions.elementToBeClickable(By.id("L2AGLb"))); // Adjust ID based on region
                acceptCookiesButton.click();
            } catch (Exception e) {
                System.out.println("No cookies prompt detected.");
            }

            // Search for 'q'
            WebElement searchField = wait.until(ExpectedConditions.elementToBeClickable(By.name("q")));
            searchField.click();
            searchField.sendKeys("Sapient");
            searchField.sendKeys(Keys.ENTER);
            System.out.println("Entered text in search box..");

            // Wait for "Images" link to appear and click it
            WebElement imagesLink = wait.until(ExpectedConditions.elementToBeClickable(By.linkText("Images")));
            imagesLink.click();
            System.out.println("Clicked on Images link.");

            Thread.sleep(5000);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // Close the browser
            driver.quit();
        }
    }
}



