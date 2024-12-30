package com.acme;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;

public class WebDriverTables {

    public static void main(String args[]) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        driver.get("file:///Users/me/dev/workspace/WebDriverDemo/src/main/webapp/TableTest.html");

        // Load the local HTML file
        // driver.get("file:///D:/Test/Testing/Selenium/m5/after/src/main/webapp/TableTest.html");

        // Get the absolute path of the HTML file
        File htmlFile = new File("src/main/webapp/TableTest.html");
        String filePath = htmlFile.getAbsolutePath();

        // Load the local HTML file using the file URL
        driver.get("file:///" + filePath);

        WebElement outerTable = driver.findElement(By.tagName("table"));
        WebElement innerTable = outerTable.findElement(By.tagName("table"));
        WebElement row = innerTable.findElements(By.tagName("td")).get(1);

//        WebElement row = driver.findElement(By.xpath("/html/body/table/tbody/tr/td[2]/table/tbody/tr[2]/td"));
        System.out.println(row.getText());
    }
}
