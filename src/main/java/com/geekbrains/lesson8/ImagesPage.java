package com.geekbrains.lesson8;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.By;


import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.page;

public class ImagesPage {

    private SelenideElement searchInput = $(By.xpath("//input[@name='text']"));

    private SelenideElement submitButton = $(By.xpath("//button[@type='submit']"));

   @Step("Вводим текст запроса")
    public ImagesSearchResultPage search(String text) {
        searchInput.sendKeys(text);
        submitButton.click();
        return page(ImagesSearchResultPage.class);
    }

}
