package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class DuckDuckGoResultPage {

    public DuckDuckGoResultPage(WebDriver driver){
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "search_form_input_homepage")
    public WebElement searchField;

    @FindBy(xpath = "//a[@class='result__a']")
    public List<WebElement> listOfResult;


}
