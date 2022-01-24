package pages;

import baseEntities.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class GlobalProjectsPage extends BasePage {
    private static final By PAGE_OPENED_IDENTIFIER = By.xpath("//a[@onclick='this.blur(); " + "App.Admin.addExampleProject(); return false;']");
    private static String ENDPOINT = "/admin/projects/overview";
    private By SUCCESSFULLY_FOR_ADD_PROJECT = By.xpath("//div[text()='Successfully added the new project.']");
    private By BUTTON_ADD_PROJECT = By.xpath("//div/a[contains(text(),'Add Project')]");
    private By BUTTON_ADD_EXAMPLE_PROJECT = PAGE_OPENED_IDENTIFIER;
    private By SUCCESSFULLY_FOR_DELETE_PROJECT = By.xpath("//div[text()='Successfully deleted the project.']");


    public GlobalProjectsPage(WebDriver driver) {
        super(driver);
    }

    public GlobalProjectsPage(WebDriver driver, boolean openPageByUrl) {
        super(driver, openPageByUrl);
    }

    @Override
    protected void openPage() {
        driver.get(BASE_URL + ENDPOINT);
    }

    public boolean isPageOpened() {
        return waits.waitForVisibility(PAGE_OPENED_IDENTIFIER).isDisplayed();
    }

    public WebElement getSuccessfullyMessageAboutAddingProject() {
        return driver.findElement(SUCCESSFULLY_FOR_ADD_PROJECT);
    }

    public WebElement getSuccessfullyMessageAboutDeleteProject() {
        return driver.findElement(SUCCESSFULLY_FOR_DELETE_PROJECT);
    }

    public WebElement findAnyProjectInDashboard(String nameProject) {
        return driver.findElement(By.xpath(String.format("//a[contains(@href,'index.php?/admin/projects/') and text()='%s']", nameProject)));
    }

    public WebElement getCancelButton(String nameProject) {
        return driver.findElement(By.xpath("//a[contains(@href,'index.php?/admin/projects/edit/') and text()='" + nameProject + "']" +
                "/../..//div[@class='icon-small-delete']"));
    }

    public WebElement findAnyProjectInProject(String nameProject) {
        return driver.findElement(By.xpath("//a[contains(@href, 'index.php?/admin/projects/edit/') and text()='" + nameProject + "']"));
    }

    public WebElement getDeleteButtonAnyProject(String nameProject) {
        return driver.findElement(By.cssSelector("a[onclick*='" + nameProject + "'] .icon-small-delete"));
    }
}
