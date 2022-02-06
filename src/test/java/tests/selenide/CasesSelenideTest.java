package tests.selenide;

import baseEntities.BaseApiSelenideTest;
import models.CasesSelenide;
import models.Project;
import org.openqa.selenium.By;
import org.testng.annotations.Test;
import pages.AddCasesSelenide;
import pages.AddProjectPageSelenide;
import pages.LoginPageSelenide;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class CasesSelenideTest extends BaseApiSelenideTest {

    Project addProject;
    CasesSelenide addCase;
    CasesSelenide updateCase;

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

        open("/index.php?/admin/projects/add/1");
        addProject = new Project();
        addProject.setName("12345sa6ert23");

        AddProjectPageSelenide addProjectPageSelenide = new AddProjectPageSelenide();
        addProjectPageSelenide.addProject(addProject);

        $(By.xpath("//*[@class = 'message message-success']")).shouldBe(visible).shouldHave(text("Successfully added the new project."));
    }

    @Test(dependsOnMethods = {"loginTest", "addProjectTest"})
    public void addCaseTest() throws InterruptedException {

        open("/index.php?/dashboard");
        $(byText(addProject.getName())).click();
        $("#sidebar-cases-add").click();

        addCase = new CasesSelenide();
        addCase.setTitle("Title_MR");

        AddCasesSelenide addCasesSelenide = new AddCasesSelenide();
        addCasesSelenide.addCase(addCase);

        $(By.xpath("//*[@class = 'message message-success']")).shouldBe(visible);
        $(byText("Add another")).shouldBe(visible);
    }

    @Test(dependsOnMethods = "addCaseTest")
    public void updateCaseTest() throws InterruptedException {
        $(byText("Edit")).click();

        updateCase = new CasesSelenide();
        updateCase.setTitle("Title_MR_upd");

        AddCasesSelenide updateCasePage = new AddCasesSelenide();
        updateCasePage.updateCase(updateCase);
        $(By.xpath("//*[@class = 'message message-success']")).shouldBe(visible).shouldHave(text("Successfully updated the test case."));
    }

    @Test(dependsOnMethods = "updateCaseTest")
    public void deleteCaseTest() {
        $(byText("Edit")).click();
        $(byText("Delete this test case")).click();
        $(By.xpath("//a[@onclick = 'this.blur(); App.Cases.confirmDeletion(false, false); return false;']")).click();
        $(By.xpath("//*[@class = 'message message-success']")).shouldBe(visible).shouldHave(text("Successfully flagged the test case as deleted."));
    }
}

