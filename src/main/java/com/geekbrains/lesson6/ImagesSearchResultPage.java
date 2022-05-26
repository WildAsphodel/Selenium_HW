package com.geekbrains.lesson6;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class ImagesSearchResultPage extends BaseView {
    public ImagesSearchResultPage(WebDriver driver) {
        super(driver);
    }
    private final static String FIRST_IMAGE_XPATH_LOCATOR = "(//img[contains(@class, 'serp-item')]) [1]";
    @FindBy(xpath = FIRST_IMAGE_XPATH_LOCATOR)
    public WebElement firstImageElement;

    @FindBy(xpath = "//img[@class='MMImage-Origin']")
    public WebElement originImageElement;

    @FindBy(xpath = "(//a[@class='ViewerTags-Item']) [1]")
    public WebElement firstImageTag;

    @Step("Поиск картинки по тегу")
    public void selectImageTag() {
        webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(FIRST_IMAGE_XPATH_LOCATOR)));
        firstImageElement.click();
        originImageElement.click();
        firstImageTag.click();
        webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(FIRST_IMAGE_XPATH_LOCATOR)));
    }

}
