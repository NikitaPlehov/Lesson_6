package tests;

import baseEntities.BaseTest;
import com.tms.core.ReadProperties;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.DashboardPage;
import pages.LoginPage;
import utils.Retry;

public class SmokeTest extends BaseTest {

    @Test
    public void loginTest() {
        LoginPage loginPage = new LoginPage(driver);

        loginPage.getEmailField().sendKeys(ReadProperties.getUsername());
        loginPage.getPasswordField().sendKeys(ReadProperties.getPassword());
        loginPage.getLoginButton().click();

        DashboardPage dashboardPage = new DashboardPage(driver);
        waits.waitForVisibility(dashboardPage.getAddProjectButton());

        Assert.assertTrue(dashboardPage.isPageOpened());
    }

    @Test(retryAnalyzer = Retry.class)
    public void flakyLoginTest() {
        LoginPage loginPage = new LoginPage(driver);

        loginPage.getEmailField().sendKeys(ReadProperties.getUsername());
        loginPage.getPasswordField().sendKeys(ReadProperties.getPassword());
        loginPage.getLoginButton().click();

        DashboardPage dashboardPage = new DashboardPage(driver);
        waits.waitForVisibility(dashboardPage.getAddProjectButton());

        Assert.assertTrue(dashboardPage.isPageOpened());
    }
}
