package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DuckDuckGoHomePage {

    public DuckDuckGoHomePage(WebDriver driver){
        PageFactory.initElements(driver, this);
    }

    @FindBy(name = "q")
    public WebElement googleSearchField;

    @FindBy(xpath = "//span[text()='DuckDuckGo — Privacy, simplified.']")
    public WebElement duckduckgo;

}
