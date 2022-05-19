package com.geekbrains.lesson5;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class CatFinderTest {
    WebDriver driver;
    WebDriverWait webDriverWait;

    @BeforeAll
    static void registerDriver() {
        WebDriverManager.chromedriver().setup();
    }

    @BeforeEach
    void initDriver() {
        driver = new ChromeDriver();
        webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(5));
        driver.get("https://yandex.ru/");
    }

    @Test
    void catsImageSearch() {
        driver.findElement(By.xpath("//div[contains(@class, 'images')]")).click();
        List<String> tabs = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(1));
        driver.findElement(By.xpath("//input[@name='text']")).sendKeys("котики");
        driver.findElement(By.xpath("//button[@type='submit']")).click();
        webDriverWait.until(ExpectedConditions.presenceOfElementLocated
                (By.xpath("(//img[contains(@class, 'serp-item')]) [1]")));
        driver.findElement(By.xpath("(//img[contains(@class, 'serp-item')]) [1]")).click();
        driver.findElement(By.xpath("//img[@class='MMImage-Origin']")).click();
        driver.findElement(By.xpath("(//a[@class='ViewerTags-Item']) [1]")).click();
        webDriverWait.until(ExpectedConditions.presenceOfElementLocated
                (By.xpath("(//img[contains(@class, 'serp-item')]) [1]")));
        Assertions.assertTrue(driver.findElement(By.xpath("(//img[contains(@class, 'serp-item')]) [1]")).isDisplayed());
    }

    @Test
    void catsSearch() {
        driver.findElement(By.xpath("//input[@id = 'text']")).sendKeys("котики");
        driver.findElement(By.xpath("//button[@type='submit']")).click();
        webDriverWait.until(ExpectedConditions.titleContains("котики"));
        Assertions.assertTrue(driver.getTitle().contains("котики"));
    }

        @AfterEach
        void tearDown() {
            driver.quit();
        }

}
