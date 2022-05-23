package com.geekbrains.lesson6;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.ArrayList;
import java.util.List;

public class MainPage extends BaseView {
    public MainPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//div[contains(@class, 'images')]")
    public WebElement imagesIcon;

    @FindBy(xpath = "//input[@id = 'text']")
    public WebElement searchInputMain;

    @FindBy(xpath = "//button[@type='submit']")
    public WebElement submitButtonMain;

    public ImagesPage openImagesPage() {
        imagesIcon.click();
        List<String> tabs = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(1));
        return new ImagesPage(driver);
    }

    public void searchCats(String text) {
        searchInputMain.sendKeys(text);
        submitButtonMain.click();
        webDriverWait.until(ExpectedConditions.titleContains(text));
    }
}
