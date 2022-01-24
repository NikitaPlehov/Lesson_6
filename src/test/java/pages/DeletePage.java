package pages;

import baseEntities.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class DeletePage extends BasePage {
    private static final By PAGE_OPENED_IDENTIFIER = By.id("ui-dialog-title-deleteDialog");
    private By CHECKBOX_DELETE = By.xpath("//strong [. = 'Yes, delete this project (cannot be undone)']/following::input");
    private By BUTTON_OK = By.xpath("//span[@id='ui-dialog-title-deleteDialog']/following::div/a[1]");


    public DeletePage(WebDriver driver) {
        super(driver);
    }

    public DeletePage(WebDriver driver, boolean openPageByUrl) {
        super(driver, openPageByUrl);
    }

    @Override
    protected void openPage() {
    }

    @Override
    protected boolean isPageOpened() {
        return waits.waitForVisibility(PAGE_OPENED_IDENTIFIER).isDisplayed();
    }

    public WebElement getCheckBoxForConfirmationDelete() {
        return driver.findElement(CHECKBOX_DELETE);
    }

    public WebElement getButtonOk() {
        return driver.findElement(BUTTON_OK);
    }
}
