package tests;

import baseEntities.BaseTest;
import com.tms.core.ReadProperties;
import org.testng.annotations.Test;
import pages.LoginPage;

public class SmokeTest extends BaseTest {

    @Test
    public void loginTest(){
        LoginPage loginPage = new LoginPage(driver);

        loginPage.login(ReadProperties.getUsername(), ReadProperties.getPassword());
    }
}
