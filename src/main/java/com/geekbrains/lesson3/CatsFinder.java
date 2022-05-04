package com.geekbrains.lesson3;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.ArrayList;
import java.util.List;

public class CatsFinder {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();

        WebDriver driver = new ChromeDriver();
        driver.get("https://yandex.ru/");

        driver.findElement(By.xpath("//div[contains(@class, 'images')]")).click();
        List<String> tabs = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(1));
        driver.findElement(By.xpath("//input[@name='text']")).sendKeys("котики");
        driver.findElement(By.xpath("//button[@type='submit']")).click();
        Thread.sleep(5000);
        driver.findElement(By.xpath("(//img[contains(@class, 'serp-item')]) [1]")).click();
        driver.findElement(By.xpath("//img[@class='MMImage-Origin']")).click();
        driver.findElement(By.xpath("(//a[@class='ViewerTags-Item']) [1]")).click();
        Thread.sleep(5000);
        driver.quit();
    }
}
