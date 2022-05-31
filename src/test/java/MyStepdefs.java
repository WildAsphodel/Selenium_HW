import com.codeborne.selenide.Selenide;
import com.geekbrains.lesson8.ImagesPage;
import com.geekbrains.lesson8.ImagesSearchResultPage;
import com.geekbrains.lesson8.MainPage;
import io.cucumber.java.After;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static com.codeborne.selenide.Selenide.open;

public class MyStepdefs {
    @Given("Open Main page")
    public void openMainPage() {
        open("https://yandex.ru/");
    }

    @When("Open Image page")
    public void openImagePage() {
        new MainPage().openImagesPage();
    }

    @When("Search by text from Image page")
    public void searchByTextFromImagePage() {
        new ImagesPage().search("котики");

    }

    @And("Search image by tag")
    public void searchImageByTag() {
        new ImagesSearchResultPage().selectImageTag();
    }

    @Then("New images should be visible")
    public void newImagesShouldBeVisible() {
        new ImagesSearchResultPage().checkVisibilityNewImages();
    }

    @When("Search by text from Main page")
    public void searchByTextFromMainPage() {
        new MainPage().searchCats("котики");
    }

    @Then("Title should be correct")
    public void titleShouldBeCorrect() {
        new MainPage().checkTitle();
    }

    @After(value = "@close")
    public void quitBrowser() {
        Selenide.closeWebDriver();
    }

}
