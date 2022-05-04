package com.geekbrains.lesson3;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.ArrayList;
import java.util.List;

public class SetupDriverExamples {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();

        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--disable-notifications");
//        chromeOptions.addArguments("--headless");
        chromeOptions.addArguments("user-agent=Googlebot/2.1 (+http://www.google.com/bot.html)");
        WebDriver driver = new ChromeDriver(chromeOptions);
        driver.get("https://google.com");

        driver.manage().window().setSize(new Dimension(300, 700));
        Thread.sleep(5000);
        driver.manage().window().maximize();

        driver.switchTo().newWindow(WindowType.TAB);
        List<String> tabs = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(1));
        driver.get("https://ya.ru");

        Thread.sleep(5000);
        driver.close();
        Thread.sleep(5000);
        driver.switchTo().window(tabs.get(0));
        ((JavascriptExecutor)driver).executeScript("window.open('https://ya.ru', '_blank').focus()");

        Thread.sleep(5000);
        driver.quit();
    }
}
