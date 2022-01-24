package tests;

import baseEntities.BaseTest;
import com.tms.core.ReadProperties;
import enums.ProjectType;
import models.Project;
import models.User;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.GlobalProjectsPage;
import utils.Randomization;

public class AddProjectTest extends BaseTest {
    Project project;
    Project currentProject;
    Project updateProject;
    User user;

    @Test
    public void addProject(){
        user = new User.BuilderUser.Builder()
                .withEmail(ReadProperties.getUsername())
                .withPassword(ReadProperties.getPassword())
                .build();
        project = new Project.BuilderProject.Builder()
                .withName(Randomization.getRandomString(9))
                .withAnnouncement(Randomization.getRandomString(18))
                .withIsShowAnnouncement(true)
                .withTypeOfProject(ProjectType.SINGLE)
                .build();
        loginSteps.loginGeneralUsers(user);
        driver.get("https://qa1504.testrail.io/index.php?/admin/projects/add/1");
        projectSteps.addProject(project);
        GlobalProjectsPage generalProjectsPage = new GlobalProjectsPage(driver);
        Assert.assertTrue(generalProjectsPage.getSuccessfullyMessageAboutAddingProject().isDisplayed());
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript("arguments[0].scrollIntoView();",
                generalProjectsPage.findAnyProjectInDashboard(project.getName()));
        Assert.assertTrue(waits.waitForVisibility(generalProjectsPage.findAnyProjectInDashboard(project.getName())),
                "Не создан");
    }

        @Test(dependsOnMethods = "addProject")
        public void updateProject(){
            currentProject = project;
            updateProject = new Project.BuilderProject.Builder()
                    .withName(Randomization.getRandomString(8))
                    .withAnnouncement(Randomization.getRandomString(18))
                    .withTypeOfProject(Randomization.getRandomType())
                    .build();
            loginSteps.loginGeneralUsers(user);
            driver.get("https://qa1504.testrail.io/index.php?/admin/projects/overview");
            GlobalProjectsPage generalProjectsPage = new GlobalProjectsPage(driver);
            projectSteps.updateProject(currentProject, updateProject);
            Assert.assertTrue(generalProjectsPage.findAnyProjectInProject(updateProject.getName()).isDisplayed());
        }

        @Test(dependsOnMethods = "updateProject")
        public void deleteProject(){
            loginSteps.loginGeneralUsers(user);
            driver.get("https://qa1504.testrail.io/index.php?/admin/projects/overview");
            GlobalProjectsPage generalProjectsPage = new GlobalProjectsPage(driver);
            projectSteps.deleteProject(updateProject);
            Assert.assertTrue(generalProjectsPage.getSuccessfullyMessageAboutDeleteProject().isDisplayed());
        }
    }
