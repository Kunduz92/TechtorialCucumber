package pages.com.weborderpage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class GroupOrderPage {

   public GroupOrderPage(WebDriver driver){
       PageFactory.initElements(driver, this);
   }

   @FindBy(id="InviteNote")
 mvn brew install mavenhttps://raw.githubusercontent.com/Homebrew/install/HEAD/install.sh)"   public WebElement inviteNote;

   @FindBy (id="inviteList")
    public WebElement inviteList;

   @FindBy(id="createGroupOrder")
    public WebElement createGroup;

   @FindBy(name="topBannerHeader")
    public WebElement viewGroupOrderHeader;

   @FindBy(xpath ="//label[.='Total Participants:']/following-sibling::div")
    public WebElement participants;

   public void sendInviteeNote(String note){
       inviteNote.sendKeys(note);
   }

   public void sendInviteList(String list){
       inviteList.sendKeys(list);
   }
   public void  clickCreateGroup(){
       createGroup.click();
   }

   public int getParticipantsNumber(){
       return Integer.parseInt(participants.getText().trim());

   }

}
