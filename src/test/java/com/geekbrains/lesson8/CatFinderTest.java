package com.geekbrains.lesson8;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Epic;
import io.qameta.allure.Story;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

@Epic("Поиск котиков")
public class CatFinderTest {
    public SelenideElement fade = $(By.xpath("//div[contains(@class,'fade')]"));
    @BeforeEach
            void openMainPage() {
        Selenide.open("https://yandex.ru/");
    }

    @Test
    @Story("Поиск котиков в Картинках")
    void catsImageSearch() {
        new com.geekbrains.lesson8.MainPage()
                .openImagesPage()
                .search("котики")
                .selectImageTag()
                .checkInvisibilityFade()
                .checkVisibilityNewImages();
    }


    @Test
    @Story("Поиск котиков с главной страницы")
    void catsSearch() {
        new MainPage()
                .searchCats("котики")
                .checkTitle();
    }

        @AfterEach
        void tearDown() {
          Selenide.closeWebDriver();
        }

}
