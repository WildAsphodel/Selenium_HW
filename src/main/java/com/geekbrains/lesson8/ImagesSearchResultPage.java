package com.geekbrains.lesson8;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.By;


import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.page;

public class ImagesSearchResultPage {

    private SelenideElement firstImageElement = $(By.xpath("(//img[contains(@class, 'serp-item')]) [1]"));

    private SelenideElement originImageElement = $(By.xpath("//img[@class='MMImage-Origin']"));

    private SelenideElement firstImageTag = $(By.xpath("(//a[@class='ViewerTags-Item']) [1]"));

    public SelenideElement fade = $(By.xpath("//div[contains(@class,'fade')]"));
    @Step("Поиск картинки по тегу")
    public ImagesSearchResultPage selectImageTag() {
        firstImageElement.click();
        originImageElement.click();
        firstImageTag.click();
        return page(ImagesSearchResultPage.class);
    }

    @Step("Проверка завершения подгрузки")
    public ImagesSearchResultPage checkInvisibilityFade() {
        fade.shouldNotBe(visible);
        return page(ImagesSearchResultPage.class);
    }
    @Step("Проверка видимости первой картинки")
    public void checkVisibilityNewImages() {
        firstImageElement.shouldBe(visible);
    }
}
