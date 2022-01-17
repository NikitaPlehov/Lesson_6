package pages;

import baseEntities.BasePage;
import models.Project;
import models.User;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AddProjectPage extends BasePage {

    private static String ENDPOINT = "/projects/add/1";

    private static final By PAGE_OPENED_IDENTIFIER = By.id("content-header");

    protected By addProjectButtonSelector = By.id("sidebar-projects-add");

    protected By nameSelector = By.xpath("//*[@class='form-control ' and @type='text' and @id='name']");
    protected By announcementSelector = By.id("announcement");
    protected By addSelector = By.id("accept");

    public AddProjectPage(WebDriver driver) {
        super(driver);
    }

    public AddProjectPage(WebDriver driver, boolean openPageByUrl) {
        super(driver, openPageByUrl);
    }

    @Override
    protected void openPage() {
        driver.get(BASE_URL + ENDPOINT);
    }

    @Override
    protected boolean isPageOpened() {
        return waits.waitForVisibility(PAGE_OPENED_IDENTIFIER).isDisplayed();
    }

    public WebElement getAddProjectButton() {
        return driver.findElement(addProjectButtonSelector);
    }

    public WebElement getNameField() {
        return driver.findElement(nameSelector);
    }

    public WebElement getAnnouncementField() {
        return driver.findElement(announcementSelector);
    }

    public WebElement getAddButton() {
        return driver.findElement(addSelector);
    }

    public void AddProjectPage(Project project) {
        getAddProjectButton().click();
        getNameField().sendKeys(project.getName());
        getAnnouncementField().sendKeys(project.getAnnouncement());
        getAddButton().click();

    }

}
