package com.acme;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

import java.io.File;

public class WebDriverCheckboxes {

    public static void main(String[] args) {
        // Setup WebDriver using WebDriverManager
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        try {
            // Load the local HTML file
//            driver.get("file:///D:/Test/Testing/Selenium/m5/after/src/main/webapp/CheckboxTest.html");

            // Get the absolute path of the HTML file
            File htmlFile = new File("src/main/webapp/CheckboxTest.html");
            String filePath = htmlFile.getAbsolutePath();

            // Load the local HTML file using the file URL
            driver.get("file:///" + filePath);

            // Find the checkbox element and interact with it
            WebElement checkbox = driver.findElement(By.id("lettuceCheckbox"));
            checkbox.click(); // Check the checkbox
            System.out.println("Checked the lettuce checkbox.");
            Thread.sleep(2000);
            checkbox.click(); // Uncheck the checkbox
            System.out.println("Unchecked the lettuce checkbox.");

            Thread.sleep(2000);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // Close the browser
            driver.quit();
        }
    }
}
