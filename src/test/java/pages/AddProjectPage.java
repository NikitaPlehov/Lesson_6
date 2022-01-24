package pages;

import baseEntities.BasePage;
import enums.ProjectType;
import models.Project;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.Locale;


public class AddProjectPage extends BasePage {


    // Идентификатор страницы
    private static final By PAGE_OPENED_IDENTIFIER = By.id("accept");
    private static String ENDPOINT = "/admin/projects/add/1";
    private static String typeRadioButtonSelector = "//*[@name = 'suite_mode' and @value='replace']";
    private By NAME_PROJECT = By.id("name");
    private By ANNOUNCEMENT_FIELD = By.id("announcement");
    private By CHECKBOX_SHOW_ANNOUNCEMENT = By.id("show_announcement");
    private By ADD_PROJECT_BUTTON = By.id("accept");
    private By BUTTON_FOR_SMALL_FILTER = By.cssSelector(".icon-display-small");
    private By BUTTON_FOR_BIG_FILTER = By.cssSelector("icon-display-large-inactive");
    private By SUCCESSFULLY_ADDED_PROJECT = By.cssSelector(".message-success");
    private By SAVE_PROJECT = By.id("accept");


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

    public WebElement getNameField() {
        return driver.findElement(NAME_PROJECT);
    }

    public WebElement getAnnouncementField() {
        return driver.findElement(ANNOUNCEMENT_FIELD);
    }

    public WebElement getCheckBoxShowAnnouncement() {
        return driver.findElement(CHECKBOX_SHOW_ANNOUNCEMENT);
    }

    public WebElement getAddProjectButton() {
        return driver.findElement(ADD_PROJECT_BUTTON);
    }

    public WebElement getSaveProjectButton() {
        return driver.findElement(SAVE_PROJECT);
    }

    public WebElement getSmallFilterButton() {
        return driver.findElement(BUTTON_FOR_SMALL_FILTER);
    }

    public WebElement getBigFilterButton() {
        return driver.findElement(BUTTON_FOR_BIG_FILTER);
    }

    public WebElement findAnyProjectInProject(String nameProject) {
        return driver.findElement(By.xpath("//a[contains(@href, 'index.php?/admin/projects/edit/') and text()='" + nameProject + "']"));
    }

        public WebElement getSuccessfullyMessage() {
            return driver.findElement(SUCCESSFULLY_ADDED_PROJECT);
        }
        public void setType(ProjectType type) {
            driver.findElement(By.xpath(typeRadioButtonSelector.replace("replace", String.valueOf(type))));
    }

    public void createProject(String name, String announcement) {
        driver.findElement(NAME_PROJECT).sendKeys(name);
        driver.findElement(ANNOUNCEMENT_FIELD).sendKeys(announcement);
        driver.findElement(CHECKBOX_SHOW_ANNOUNCEMENT).click();
        driver.findElement(ADD_PROJECT_BUTTON).click();
    }
}
