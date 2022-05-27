package com.geekbrains.lesson5;

import com.geekbrains.lesson6.ImagesSearchResultPage;
import com.geekbrains.lesson6.MainPage;
import com.geekbrains.lesson7.CustomLogger;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.qameta.allure.Allure;
import io.qameta.allure.Epic;
import io.qameta.allure.Story;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.logging.LogEntries;
import org.openqa.selenium.logging.LogEntry;
import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.support.events.EventFiringDecorator;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

@Epic("Поиск котиков")
public class CatFinderTest {
    WebDriver driver;
    WebDriverWait webDriverWait;

    @BeforeAll
    static void registerDriver() {
        WebDriverManager.chromedriver().setup();
    }

    @BeforeEach
    void initDriver() {
        driver = new EventFiringDecorator(new CustomLogger()).decorate(new ChromeDriver());
        webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(5));
        driver.get("https://yandex.ru/");
    }

    @Test
    @Story("Поиск котиков в Картинках")
    void catsImageSearch() {
        new MainPage(driver)
                .openImagesPage()
                .search("котики")
                .selectImageTag();
        webDriverWait.until(ExpectedConditions.presenceOfElementLocated
                (By.xpath("//div[contains(@class, 'spin2')]")));
        webDriverWait.until(ExpectedConditions.not(ExpectedConditions.presenceOfElementLocated
                (By.xpath("//div[contains(@class, 'spin2_js')]"))));
        Assertions.assertTrue(new ImagesSearchResultPage(driver).firstImageElement.isDisplayed());
    }



    @Test
    @Story("Поиск котиков с главной страницы")
    void catsSearch() {
        new MainPage(driver)
                .searchCats("котики");
        Assertions.assertTrue(driver.getTitle().contains("котики"));
    }

        @AfterEach
        void tearDown() {
            LogEntries logEntries = driver.manage().logs().get(LogType.BROWSER);

            for (LogEntry logEntry : logEntries) {
                Allure.addAttachment("Элемент лога браузера", logEntry.getMessage());
            }

            driver.quit();
        }

}
