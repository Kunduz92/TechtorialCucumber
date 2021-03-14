package steps.com.productsteps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pages.com.productspage.ProductLoginPage;
import pages.com.productspage.ProductsOrderPage;
import utils.ConfigReader;
import utils.Driver;

import java.util.List;

public class ProductSteps {

    WebDriver driver;
    ProductLoginPage loginPage;
    ProductsOrderPage orderPage;

    @Given("the user navigates to product website home page")
    public void the_user_navigates_to_product_website_home_page() {
      driver= Driver.getDriver();
      driver.get("http://secure.smartbearsoftware.com/samples/testcomplete11/WebOrders/login.aspx");
      loginPage=new ProductLoginPage(driver);
      loginPage.login(ConfigReader.getProperty("productsUsername"),ConfigReader.getProperty("productsPassword"));

    }
    @Then("the user enters the product info {string} and {string}")
    public void the_user_enters_the_product_info_and(String productName, String quantity) {
        orderPage=new ProductsOrderPage(driver);
        orderPage.clickOrder();
        orderPage.sendProductInfo(productName, quantity);

    }
    @When("the user enters the address info {string}, {string}, {string}, {string}, {string}")
    public void the_user_enters_the_address_info(String customerName, String street, String city, String state, String zip) {
        orderPage.sendAddressInfo(customerName,street,city,state,zip);
    }
    @When("the user enters the card info {string}, {string}, {string}")
    public void the_user_enters_the_card_info(String cardType, String cardNumber, String expireDate) {
        orderPage.sendPaymentInfo(cardType, cardNumber, expireDate);
        orderPage.clickProcess();

    }

    @When("the user validate success message")
    public void the_user_validate_success_message() {

       String actualMessage=orderPage.getMessageText();
        Assert.assertEquals("New order has been successfully added.",actualMessage);

    }
    @Then("the user validates product details {string}, {string} , {string} , {string} , {string} , {string} , {string} , {string} , {string} , {string}")
    public void the_user_validates_product_details(String productName, String quantity, String customerName,  String street, String city, String state, String zip, String cardType, String cardNumber, String expireDate) {

//        orderPage.sendAddressInfo(customerName,street,city,state,zip);

        orderPage.clickAllOrders();
        List<WebElement> details = orderPage.productInfo;

        Assert.assertEquals(details.get(1).getText().trim(), customerName);
        Assert.assertEquals(details.get(2).getText().trim(), productName);
        Assert.assertEquals(details.get(3).getText().trim(), quantity);
        Assert.assertEquals(details.get(5).getText().trim(), street);
        Assert.assertEquals(details.get(6).getText().trim(), city);
        Assert.assertEquals(details.get(7).getText().trim(), state);
        Assert.assertEquals(details.get(8).getText().trim(), zip);
        Assert.assertEquals(details.get(9).getText().trim(), cardType);
        Assert.assertEquals(details.get(10).getText().trim(), cardNumber);
        Assert.assertEquals(details.get(11).getText().trim(), expireDate);



    }


}
