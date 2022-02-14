//package tests.selenide;
//
//import baseEntities.BaseApiSelenideTest;
//import models.Milestone;
//import models.MilestoneSelenide;
//import models.Project;
//import org.openqa.selenium.By;
//import org.testng.annotations.Test;
//import pages.AddMilestoneSelenide;
//import pages.AddProjectPageSelenide;
//import pages.LoginPageSelenide;
//import static com.codeborne.selenide.Condition.visible;
//import static com.codeborne.selenide.Selectors.byText;
//import static com.codeborne.selenide.Selenide.*;
//import static com.codeborne.selenide.Condition.text;
//
//
//public class MilestoneSelenideTest extends BaseApiSelenideTest {
//
//    Project addProject;
//    MilestoneSelenide addMilestone;
//    MilestoneSelenide updateMilestone;
//
//    @Test
//    public void loginTest() {
//
//        open("/");
//
//        LoginPageSelenide loginPageSelenide = new LoginPageSelenide();
//        loginPageSelenide.getUsernameField().setValue(username);
//
//        loginPageSelenide.getPasswordField().val(password);
//        loginPageSelenide.getLoginButton().click();
//
//        $(".page_title").shouldBe(visible).shouldHave(text("All Projects"));
//    }
//
//    @Test(dependsOnMethods = "loginTest")
//    public void addProjectTest() {
//
//        open("/index.php?/admin/projects/add/1");
//        addProject = new Project();
//        addProject.setName("AudiRSQ8");
//
//        AddProjectPageSelenide addProjectPageSelenide = new AddProjectPageSelenide();
//        addProjectPageSelenide.addProject(addProject);
//
//        $(By.xpath("//*[@class = 'message message-success']")).shouldBe(visible).shouldHave(text("Successfully added the new project."));
//    }
//
//    @Test(dependsOnMethods = "addProjectTest")
//    public void addMilestonesTest() {
//
//        open("/index.php?/dashboard");
//        $(byText(addProject.getName())).click();
//        $("#navigation-overview-addmilestones").click();
//
//        addMilestone = new MilestoneSelenide();
//        addMilestone.setName("AUDI_Milestone");
//        addMilestone.setReference("BMW");
//        addMilestone.setDescription("GOOD");
//
//        AddMilestoneSelenide addMilestoneSelenide = new AddMilestoneSelenide();
//        addMilestoneSelenide.addMilestone(addMilestone);
//
//        $(By.xpath("//*[@class = 'message message-success']")).shouldBe(visible).shouldHave(text("Successfully added the new milestone."));
//    }
//
//    @Test(dependsOnMethods = "addMilestonesTest")
//    public void updateMilestoneTest() {
//
//        $(byText(addMilestone.getName())).click();
//        $(byText("Edit")).click();
//
//        updateMilestone = new MilestoneSelenide();
//        updateMilestone.setName("Update_AUDI_Milestone");
//        updateMilestone.setReference("Update_BMW");
//        updateMilestone.setDescription("Update_GOOD");
//
//        AddMilestoneSelenide updateMilestoneSelenide = new AddMilestoneSelenide();
//        updateMilestoneSelenide.updateMilestone(updateMilestone);
//        $(By.xpath("//*[@class = 'message message-success']")).shouldBe(visible).shouldHave(text("Successfully updated the milestone."));
//    }
//
//    @Test(dependsOnMethods = "updateMilestoneTest")
//    public void deleteMilestoneTest() {
//        $(byText(updateMilestone.getName())).click();
//        $(byText("Edit")).click();
//        $(By.xpath("//*[@class = 'button button-negative button-delete']")).click();
//        $(byText("Yes, delete this milestone (cannot be undone)")).click();
//        $(By.xpath("//div[@id='deleteDialog']//a[@class = 'button button-ok button-left button-positive dialog-action-default']")).click();
//        $(By.xpath("//*[@class = 'message message-success']")).shouldBe(visible).shouldHave(text("Successfully deleted the milestone."));
//    }
//}
