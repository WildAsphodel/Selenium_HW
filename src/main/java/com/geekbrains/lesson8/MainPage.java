package com.geekbrains.lesson8;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.*;

public class MainPage {

    private SelenideElement imagesIcon = $(By.xpath("//div[contains(@class, 'images')]"));

    private SelenideElement searchInputMain = $(By.xpath("//input[@id = 'text']"));

    private SelenideElement submitButtonMain = $(By.xpath("//button[@type='submit']"));

    private SelenideElement title = $("title");

    @Step("Переход на сервис Картинки")
    public ImagesPage openImagesPage() {
        imagesIcon.click();
        switchTo().window(1);
        return page(ImagesPage.class);
    }

    @Step("Вводим текст для поиска на главной странице")
    public MainPage searchCats(String text) {
        searchInputMain.sendKeys(text);
        submitButtonMain.click();
        return page(MainPage.class);
    }

    @Step("Проверка по заголовку страницы")
    public void checkTitle() {
        title.shouldHave(Condition.attributeMatching("text", "котики.*"));
    }
}
