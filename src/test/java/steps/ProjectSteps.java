package steps;

import baseEntities.BaseStep;
import models.Project;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import pages.AddProjectPage;
import pages.DeletePage;
import pages.GlobalProjectsPage;

public class ProjectSteps extends BaseStep {

    private AddProjectPage addProjectPage;
    private GlobalProjectsPage generalProjectsPage;
    private DeletePage confirmationDeletePopupPage;

    public ProjectSteps(WebDriver driver) {
        super(driver);
    }

    public void addProject(Project project) {
        addProjectPage = new AddProjectPage(driver);
        addProjectPage.getNameField().sendKeys(project.getName());
        addProjectPage.getAnnouncementField().sendKeys(project.getAnnouncement());
        addProjectPage.getCheckBoxShowAnnouncement().click();
        addProjectPage.setType(project.getTypeOfProject());
        addProjectPage.getAddProjectButton().click();
    }

    public void updateProject(Project currentProject, Project newProject) {
        generalProjectsPage = new GlobalProjectsPage(driver);
        generalProjectsPage.findAnyProjectInProject(currentProject.getName()).click();
        addProjectPage = new AddProjectPage(driver);
        addProjectPage.getNameField().clear();
        addProjectPage.getNameField().sendKeys(newProject.getName());
        addProjectPage.getAnnouncementField().sendKeys(newProject.getAnnouncement());
        addProjectPage.getCheckBoxShowAnnouncement().click();
        addProjectPage.setType(newProject.getTypeOfProject());
        addProjectPage.getSaveProjectButton().click();
        generalProjectsPage = new GlobalProjectsPage(driver);

    }

    public void deleteProject(Project project) {
        generalProjectsPage = new GlobalProjectsPage(driver);
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript("arguments[0].scrollIntoView();",
                generalProjectsPage.findAnyProjectInDashboard(project.getName()));
        generalProjectsPage.getDeleteButtonAnyProject(project.getName()).click();
        confirmationDeletePopupPage = new DeletePage(driver);
        confirmationDeletePopupPage.getCheckBoxForConfirmationDelete().click();
        confirmationDeletePopupPage.getButtonOk().click();

    }
}
