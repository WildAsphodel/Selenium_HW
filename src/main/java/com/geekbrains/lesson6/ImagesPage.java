package com.geekbrains.lesson6;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ImagesPage extends BaseView {
    public ImagesPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//input[@name='text']")
    public WebElement searchInput;

    @FindBy(xpath = "//button[@type='submit']")
    public WebElement submitButton;

//    @Step ("Вводим текст запроса") Idea не находит такой аннотации @Step
    public ImagesSearchResultPage search(String text) {
        searchInput.sendKeys(text);
        submitButton.click();
        return new ImagesSearchResultPage(driver);
    }

}
