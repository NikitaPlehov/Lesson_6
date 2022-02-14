package tests.dbTests;

import baseEntities.BaseTest;
import dbEntries.CaseTable;
import models.CasesSelenide;
import models.Project;
import org.openqa.selenium.By;
import org.testng.annotations.Test;
import org.testng.log4testng.Logger;
import pages.AddCasesSelenide;
import pages.AddProjectPageSelenide;
import pages.LoginPageSelenide;
import java.sql.ResultSet;
import java.sql.SQLException;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;


public class DBCaseTest extends BaseTest {

    public static Logger logger = Logger.getLogger(DBCaseTest.class);

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
        addProject.setName("drdrzdr1233");

        AddProjectPageSelenide addProjectPageSelenide = new AddProjectPageSelenide();
        addProjectPageSelenide.addProject(addProject);

        $(By.xpath("//*[@class = 'message message-success']")).shouldBe(visible).shouldHave(text("Successfully added the new project."));
    }

    @Test(dependsOnMethods = {"loginTest", "addProjectTest"})
    public void addCaseTest() throws InterruptedException {

        open("/index.php?/dashboard");
        $(byText(addProject.getName())).click();
        $("#sidebar-cases-add").click();

        CaseTable caseTable = new CaseTable(dataBaseService);

        caseTable.createTable();
        caseTable.addCase("123_asssd", "kfkfkfk");
        caseTable.addCase("UPD123_asssd", "fffff");

        String title = null;
        String preconditions = null;

        ResultSet rs = caseTable.getCaseByID(1);

        try {
            while (rs.next()) {
                title = rs.getString("title");
                preconditions = rs.getString("preconditions");

                logger.info("titleTestCase: " + title);
                logger.info("preconditions: " + preconditions);

            }
        } catch (SQLException e) {
            logger.error(e.toString());
        }

        addCase = new CasesSelenide();
        addCase.setTitle(title);

        AddCasesSelenide addCasesSelenide = new AddCasesSelenide();
        addCasesSelenide.addCase(addCase);

        $(By.xpath("//*[@class = 'message message-success']")).shouldBe(visible);
        $(byText("Add another")).shouldBe(visible);
    }

    @Test(dependsOnMethods = "addCaseTest")
    public void updateCaseTest() throws InterruptedException {
        $(byText("Edit")).click();

        CaseTable caseTable = new CaseTable(dataBaseService);

        String title = null;

        ResultSet rs = caseTable.getCaseByID(2);

        try {
            while (rs.next()) {
                title = rs.getString("title");

                logger.info("titleCase: " + title);
            }
        } catch (SQLException e) {
            logger.error(e.toString());
        }

        caseTable.dropTable();

        updateCase = new CasesSelenide();
        updateCase.setTitle(title);

        AddCasesSelenide updateCasePage = new AddCasesSelenide();
        updateCasePage.updateCase(updateCase);

        $(By.xpath("//*[@class = 'message message-success']")).shouldBe(visible).shouldHave(text("Successfully updated the test case."));
    }

    @Test(dependsOnMethods = "updateCaseTest")
    public void deleteCaseTest() {
        $(byText("Edit")).click();
        $(byText("Delete this test case")).click();
        $(By.xpath("//a[@class = 'button button-left button-ok button-positive dialog-action-default' and @onclick = 'this.blur(); App.Cases.confirmDeletion(false, false); return false;']")).click();
        $(By.xpath("//*[@class = 'message message-success']")).shouldBe(visible).shouldHave(text("Successfully flagged the test case as deleted."));
    }
}
