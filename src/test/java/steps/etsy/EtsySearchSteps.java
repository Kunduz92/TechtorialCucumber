package steps.etsy;

import io.cucumber.java.*;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import pages.etsy.EtsyHomePage;
import utils.BrowserUtils;
import utils.Driver;

public class EtsySearchSteps {

    WebDriver driver;
    EtsyHomePage homePage;

    @Before
    public void beforeScenario(){
        // it will run before each scenario
        System.out.println("Before annotation");
    }
    @Before("@tc2")
    public void conditionalHook(){
        System.out.println("Conditional annotation");
    }

    @BeforeStep
    public void beforeStep(){
        System.out.println("Before Each Step");
    }
    @AfterStep
    public void afterStep(){
        System.out.println("After Each Step");
    }

    @After
    public void afterScenario(Scenario scenario){
        // it'll run after each scenario
        System.out.println("After annotation");
        if (scenario.isFailed()){
            BrowserUtils.takeScreenshot();
        }


    }

    @Given("the user navigates to {string}")
    public void the_user_navigates_to(String url) {
        driver= Driver.getDriver();
        driver.get(url);
    }
    @When("the user search with {string}")
    public void the_user_search_with(String searchValue) {
        homePage=new EtsyHomePage(driver);
        homePage.sendSearchKey(searchValue);
    }
    @Then("the user should see the title {string}")
    public void the_user_should_see_the_title(String expectedTitle) {
        String actualTitle=driver.getTitle();

        Assert.assertEquals("Validation of Title",expectedTitle,actualTitle);



    }
}
