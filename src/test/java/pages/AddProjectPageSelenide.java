package pages;

import com.codeborne.selenide.SelenideElement;
import models.Project;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class AddProjectPageSelenide {

    private final By name_selector = By.id("name");
    private final By radio_selector = By.id("suite_mode_single");
    private final By addPrj_button_selector = By.id("accept");

    public SelenideElement getNameField() {
        return $(name_selector);
    }
    public SelenideElement getRadioField() {
        return $(radio_selector);
    }
    public SelenideElement getAddPrjButton() {
        return $(addPrj_button_selector);
    }

    public void addProject (Project project){
        getNameField().val(project.getName());
        getRadioField().click();
        getAddPrjButton().click();
    }
}
