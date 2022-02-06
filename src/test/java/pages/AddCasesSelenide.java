package pages;

import com.codeborne.selenide.SelenideElement;
import models.CasesSelenide;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
import static java.lang.Thread.sleep;

public class AddCasesSelenide {

    private final By titleCaseSelector = By.id("title");
    private final By addCaseButton = By.id("accept");

    public SelenideElement getTitleCaseField() {
        return $(titleCaseSelector);
    }
    public SelenideElement getAddCaseButton() {
        return $(addCaseButton);
    }

    public void addCase(CasesSelenide addCase) throws InterruptedException {
        sleep(500);
        getTitleCaseField().val(addCase.getTitle());
        getAddCaseButton().click();
    }

    public void updateCase(CasesSelenide updateCase) throws InterruptedException {
        getTitleCaseField().clear();
        sleep(500);
        getTitleCaseField().val(updateCase.getTitle());
        getAddCaseButton().click();
    }
}
