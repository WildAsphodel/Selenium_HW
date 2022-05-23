package com.geekbrains.lesson5;

import com.geekbrains.lesson6.ImagesSearchResultPage;
import com.geekbrains.lesson6.MainPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;


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
        new MainPage(driver)
                .openImagesPage()
                .search("котики")
                .selectImageTag();
        Assertions.assertTrue(new ImagesSearchResultPage(driver).firstImageElement.isDisplayed());
    }



    @Test
    void catsSearch() {
        new MainPage(driver)
                .searchCats("котики");
        Assertions.assertTrue(driver.getTitle().contains("котики"));
    }

        @AfterEach
        void tearDown() {
            driver.quit();
        }

}
