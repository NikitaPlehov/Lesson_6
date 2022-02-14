package tests.dbTests;

import baseEntities.BaseTest;
import dbEntries.MilestoneTable;
import dbEntries.ProjectTable;
import models.Milestone;
import models.MilestoneSelenide;
import models.Project;
import org.openqa.selenium.By;
import org.testng.annotations.Test;
import org.testng.log4testng.Logger;
import pages.*;

import java.sql.ResultSet;
import java.sql.SQLException;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class DBMilestoneTest extends BaseTest {

    public static Logger logger = Logger.getLogger(DBMilestoneTest.class);

    Project addProject;
    MilestoneSelenide addMilestone;
    MilestoneSelenide updateMilestone;

    @Test
    public void loginTest() {

        open("/");

        LoginPageSelenide loginPageSelenide = new LoginPageSelenide();
        loginPageSelenide.getUsernameField().setValue(username);

        loginPageSelenide.getPasswordField().val(password);
        loginPageSelenide.getLoginButton().click();

        $(".page_title").shouldBe(visible).shouldHave(text("All Projects"));
    }

    @Test(dependsOnMethods = "loginTest")
    public void addProjectTest() {

        ProjectTable projectsTable = new ProjectTable(dataBaseService);

        projectsTable.createTable();
        projectsTable.addProject("Drive412234", "Drive412321234");

        String nameProject = null;
        String announcement = null;

        ResultSet rs = projectsTable.getProjectByID(1);

        try {
            while (rs.next()) {
                nameProject = rs.getString("project");
                announcement = rs.getString("announcement");

                logger.info("nameProject: " + nameProject);
                logger.info("lastname: " + announcement);
            }
        } catch (SQLException e) {
            logger.error(e.toString());
        }
        projectsTable.dropTable();

        open("/index.php?/admin/projects/add/1");
        addProject = new Project();
        addProject.setName(nameProject);
        addProject.setAnnouncement(announcement);


        AddProjectPageSelenide addProjectPageSelenide = new AddProjectPageSelenide();
        addProjectPageSelenide.addProject(addProject);

        $(By.xpath("//*[@class = 'message message-success']")).shouldBe(visible).shouldHave(text("Successfully added the new project."));
    }

    @Test(dependsOnMethods = {"loginTest", "addProjectTest"})
    public void addMilestonesTest() {

        open("/index.php?/dashboard");
        $(byText(addProject.getName())).click();
        $("#navigation-overview-addmilestones").click();

        MilestoneTable milestoneTable = new MilestoneTable(dataBaseService);

        milestoneTable.createTable();
        milestoneTable.addMilestone("1234Mile_ST1", "123REF1", "123DESC1");
        milestoneTable.addMilestone("UPDATE_123Mile_ST1", "UPDATE_123REF1", "UPDATE_123DESC1");

        String nameMilestone = null;
        String reference = null;
        String description = null;

        ResultSet rs = milestoneTable.getMilestoneByID(1);

        try {
            while (rs.next()) {
                nameMilestone = rs.getString("milestone");
                reference = rs.getString("reference");
                description = rs.getString("description");

                logger.info("nameMilestone: " + nameMilestone);
                logger.info("reference: " + reference);
                logger.info("description: " + description);
            }
        } catch (SQLException e) {
            logger.error(e.toString());
        }

        addMilestone = new MilestoneSelenide();
        addMilestone.setName(nameMilestone);
        addMilestone.setReference(reference);
        addMilestone.setDescription(description);

        AddMilestoneSelenide addMilestoneSelenide = new AddMilestoneSelenide();
        addMilestoneSelenide.addMilestone(addMilestone);

        $(By.xpath("//*[@class = 'message message-success']")).shouldBe(visible).shouldHave(text("Successfully added the new milestone."));

    }

    @Test(dependsOnMethods = "addMilestonesTest")
    public void updateMilestoneTest() {
        $(byText(addMilestone.getName())).click();
        $(byText("Edit")).click();

        MilestoneTable milestoneTable = new MilestoneTable(dataBaseService);

        String nameMilestone = null;
        String reference = null;
        String description = null;

        ResultSet rs = milestoneTable.getMilestoneByID(2);

        try {
            while (rs.next()) {
                nameMilestone = rs.getString("milestone");
                reference = rs.getString("reference");
                description = rs.getString("description");

                logger.info("nameMilestone: " + nameMilestone);
                logger.info("reference: " + reference);
                logger.info("description: " + description);
            }
        } catch (SQLException e) {
            logger.error(e.toString());
        }

        milestoneTable.dropTable();

        updateMilestone = new MilestoneSelenide();
        updateMilestone.setName(nameMilestone);
        updateMilestone.setReference(reference);
        updateMilestone.setDescription(description);

        AddMilestoneSelenide updateMilestoneSelenide = new AddMilestoneSelenide();
        updateMilestoneSelenide.updateMilestone(updateMilestone);
        $(By.xpath("//*[@class = 'message message-success']")).shouldBe(visible).shouldHave(text("Successfully updated the milestone."));
    }

    @Test(dependsOnMethods = "updateMilestoneTest")
    public void deleteMilestoneTest() {
        $(byText(updateMilestone.getName())).click();
        $(byText("Edit")).click();
        $(By.xpath("//*[@class = 'button button-negative button-delete']")).click();
        $(byText("Yes, delete this milestone (cannot be undone)")).click();
        $(By.xpath("//div[@id='deleteDialog']//a[@class = 'button button-ok button-left button-positive dialog-action-default']")).click();
        $(By.xpath("//*[@class = 'message message-success']")).shouldBe(visible).shouldHave(text("Successfully deleted the milestone."));

    }

}
