package com.acme;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;
import java.util.List;

public class WebDriverRadioButtons {

    public static void main (String args []) {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        // Load the local HTML file
        // driver.get("file:///D:/Test/Testing/Selenium/m5/after/src/main/webapp/RadioButtonTest.html");

        // Get the absolute path of the HTML file
        File htmlFile = new File("src/main/webapp/RadioButtonTest.html");
        String filePath = htmlFile.getAbsolutePath();

        // Load the local HTML file using the file URL
        driver.get("file:///" + filePath);

        List<WebElement> radioButtons = driver.findElements(By.name("color"));
        radioButtons.get(1).click();

        for (WebElement radioButton : radioButtons) {
            if(radioButton.isSelected()) {
                System.out.println(radioButton.getAttribute("value"));
            }
        }
    }
}
