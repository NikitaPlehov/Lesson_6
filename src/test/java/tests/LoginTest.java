package tests;

import baseEntities.BaseTest;
import com.tms.core.ReadProperties;
import models.Project;
import models.User;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.DashboardPage;
import pages.LoginPage;
import utils.Retry;

public class LoginTest extends BaseTest {
    Project addProject;
    Project updateProject;

    @Test
    public void loginTest() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.getEmailField().sendKeys(ReadProperties.getUsername());
        loginPage.getPasswordField().sendKeys(ReadProperties.getPassword());
        loginPage.getLoginButton().click();
        DashboardPage dashboardPage = new DashboardPage(driver, true);
        Assert.assertTrue(dashboardPage.getAddProjectButton().isDisplayed());
    }

    @Test(retryAnalyzer = Retry.class)
    public void loginTest1() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.getEmailField().sendKeys(ReadProperties.getUsername());
        loginPage.getPasswordField().sendKeys(ReadProperties.getPassword());
        loginPage.getLoginButton().click();
        driver.get("https://qa1504.testrail.io/index.php?/admin/overview");
        DashboardPage dashboardPage = new DashboardPage(driver, true);
        Assert.assertTrue(dashboardPage.getAddProjectButton().isDisplayed());
    }

    @Test
    public void chainTest() {
        Assert.assertTrue(new LoginPage(driver).successLogin(ReadProperties.getUsername(), ReadProperties.getPassword())
                .getAddProjectButton().isDisplayed());
    }
}
