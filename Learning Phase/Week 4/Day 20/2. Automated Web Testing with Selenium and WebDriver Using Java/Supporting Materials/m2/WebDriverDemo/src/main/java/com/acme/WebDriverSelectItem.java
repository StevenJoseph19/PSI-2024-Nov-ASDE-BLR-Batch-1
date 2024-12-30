package com.acme;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.io.File;

public class WebDriverSelectItem {

    public static void main(String args[]) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        // Load the local HTML file
        // driver.get("file:///D:/Test/Testing/Selenium/m5/after/src/main/webapp/SelectItemTest.html");

        // Get the absolute path of the HTML file
        File htmlFile = new File("src/main/webapp/SelectItemTest.html");
        String filePath = htmlFile.getAbsolutePath();

        // Load the local HTML file using the file URL
        driver.get("file:///" + filePath);

        WebElement selectElement = driver.findElement(By.id("select1"));
        Select select = new Select(selectElement);
        Thread.sleep(1000);
        select.selectByVisibleText("Maybe");
        Thread.sleep(1000);

    }
}