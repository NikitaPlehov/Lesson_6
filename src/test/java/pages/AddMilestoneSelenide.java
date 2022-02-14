package pages;

import com.codeborne.selenide.SelenideElement;
import models.Milestone;
import models.MilestoneSelenide;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class AddMilestoneSelenide {

    private final By nameSelector = By.id("name");
    private final By refSelector = By.id("reference");
    private final By descriptionSelector = By.id("description_display");
    private final By isShowCompletedSelector = By.id("is_completed");
    private final By addMilestoneButton = By.id("accept");

    public SelenideElement getNameField(){return $(nameSelector);}
    public SelenideElement getRefField(){return $(refSelector);}
    public SelenideElement getDescriptionField(){return $(descriptionSelector);}
    public SelenideElement getIsShowCompletedField(){return $(isShowCompletedSelector);}
    public SelenideElement getAddMilestoneButton(){return $(addMilestoneButton);}

    public void addMilestone(MilestoneSelenide addMilestone){
        getNameField().val(addMilestone.getName());
        getRefField().val(addMilestone.getReference());
        getDescriptionField().val(addMilestone.getDescription());
        getAddMilestoneButton().click();
    }

    public void updateMilestone(MilestoneSelenide updateMilestone){
        getNameField().clear();
        getNameField().val(updateMilestone.getName());
        getRefField().clear();
        getRefField().val(updateMilestone.getReference());
        getDescriptionField().clear();
        getDescriptionField().val(updateMilestone.getDescription());
        getIsShowCompletedField().click();
        getAddMilestoneButton().click();
    }
}
