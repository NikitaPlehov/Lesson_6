package tests;

import baseEntities.BaseTest;
import com.tms.core.ReadProperties;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import pages.AddProjectPage;
import pages.DashboadPage;
import pages.LoginPage;

public class SmokeTest extends BaseTest {

    @Test
    public void loginTest() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login(ReadProperties.getUsername(), ReadProperties.getPassword());

        DashboadPage dashboard = new DashboadPage(driver);
        dashboard.getProjectsField().click();
    }

    @Test
    public void addProjectTest() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login(ReadProperties.getUsername(), ReadProperties.getPassword());

        AddProjectPage addProject = new AddProjectPage(driver);
        addProject.getAddProjectField().click();
        addProject.getFilenameField().sendKeys(ReadProperties.getFilename());
        addProject.getAnnouncementField().sendKeys(ReadProperties.getAnnouncement());
        addProject.getCheckField().click();
        addProject.getAddProject2Button().click();

        WebElement checkAddingProject = driver.findElement(By.xpath("//*[contains(text(), 'Successfully added the new project.')]"));
        String checkAddingProjectStr = checkAddingProject.getText();
        if (!checkAddingProjectStr.equals("Successfully added the new project.")){
            System.out.println("Error");
        }
    }
}
