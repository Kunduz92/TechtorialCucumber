package steps.com.webordersteps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import pages.com.weborderpage.GroupOrderPage;
import pages.com.weborderpage.HomePage;
import pages.com.weborderpage.LoginPage;
import utils.BrowserUtils;
import utils.ConfigReader;
import utils.Driver;

public class NewGroupSteps {

    WebDriver driver;
    LoginPage loginPage;
    HomePage homePage;
    GroupOrderPage groupOrderPage;

    @Given("the user is on weborder home page")
    public void the_user_is_on_weborder_home_page() {
        driver= Driver.getDriver();
        loginPage=new LoginPage(driver);
        driver.navigate().to(ConfigReader.getProperty("webOrderUrl"));
//        loginPage.login(ConfigReader.getProperty("webOrderUserName"),(ConfigReader.getProperty("webOrderPassword")));
    }
    @Then("the user select {string} option")
    public void the_user_select_option(String text) {
        homePage=new HomePage(driver);
        BrowserUtils.selectByText(homePage.deliveryOptions, text);
    }
    @Then("the user is on the group order page")
    public void the_user_is_on_the_group_order_page() {
        homePage.groupOrder.click();
        homePage.nextButton.click();
    }
    @Then("the user send invitees note {string}")
    public void the_user_send_invitees_note(String note) {
        groupOrderPage=new GroupOrderPage(driver);
        groupOrderPage.sendInviteeNote(note);

    }
    @Then("the user send invite list {string} and {string}")
    public void the_user_send_invite_list_and(String person1, String person2) {
        groupOrderPage.sendInviteList(person1+","+person2);
        groupOrderPage.clickCreateGroup();

    }
    @Then("the user validate {string} text")
    public void the_user_validate_text(String expectedText) {
        String actualText = groupOrderPage.viewGroupOrderHeader.getText();

        Assert.assertEquals(expectedText,actualText);
    }
    @Then("the user validate total participant is {int}")
    public void the_user_validate_total_participant_is(Integer int1) {
        Integer participantsNumber=groupOrderPage.getParticipantsNumber();
        Assert.assertEquals(int1,participantsNumber);

    }
}
