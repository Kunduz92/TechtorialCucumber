package steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pages.DuckDuckGoHomePage;
import pages.DuckDuckGoResultPage;
import utils.Driver;

public class DuckDuckGoSteps {
    WebDriver driver;
    DuckDuckGoHomePage duckDuckGoHomePage;
    DuckDuckGoResultPage duckDuckGoResultPage;


    @Given("user on google page")
    public void user_on_google_page() {
        driver=Driver.getDriver();
        driver.get("https://www.google.com/");

    }
    @When("user search for duckduckgo search page")
    public void user_search_for_duckduckgo_search_page() {
        duckDuckGoHomePage=new DuckDuckGoHomePage(driver);
        duckDuckGoHomePage.googleSearchField.sendKeys("duckduckgo"+ Keys.ENTER);


    }
    @Then("user search selenium")
    public void user_search_selenium() {
        duckDuckGoHomePage=new DuckDuckGoHomePage(driver);
        duckDuckGoHomePage.duckduckgo.click();

    }
    @Then("the texts are contains selenium")
    public void the_texts_are_contains_selenium() {
        duckDuckGoResultPage=new DuckDuckGoResultPage(driver);
        duckDuckGoResultPage.searchField.sendKeys("selenium"+Keys.ENTER);

        for (WebElement result:duckDuckGoResultPage.listOfResult) {
            System.out.println(result.getText());
        }
        Assert.assertTrue(duckDuckGoResultPage.searchField.getText().contains("Selenium") );



    }
}
