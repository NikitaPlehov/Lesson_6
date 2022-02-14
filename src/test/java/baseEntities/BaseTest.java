package baseEntities;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import core.DataBaseService;
import io.qameta.allure.selenide.AllureSelenide;
import org.testng.annotations.*;
import utils.Listener;

@Listeners(Listener.class)
public class BaseTest {
    String url = "https://qa1507.testrail.io";
    protected String username = "atrostyanko+0401@gmail.com";
    protected String password = "QqtRK9elseEfAk6ilYcJ";
    protected DataBaseService dataBaseService;

    @BeforeSuite
    public void setupAllureReports() {
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide());

        SelenideLogger.addListener("AllureSelenide", new AllureSelenide()
                .screenshots(false)
                .savePageSource(true)
        );
    }

        @BeforeTest
        public void setupConnection() {
            org.apache.log4j.BasicConfigurator.configure();
            Configuration.baseUrl = url;
            Configuration.browser = "chrome";
            Configuration.startMaximized = true;
        }

        @BeforeClass
        public void setUp () {
            dataBaseService = new DataBaseService();
        }

        @AfterTest
        public void closeConnection() {
            dataBaseService.closeConnection();
        }
}