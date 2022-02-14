package baseEntities;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.testng.annotations.BeforeSuite;


public class BaseApiSelenideTest {

    String url = "https://qa1505.testrail.io";
    public String username = "atrostyanko+0401@gmail.com";
    public String password = "QqtRK9elseEfAk6ilYcJ";

    @BeforeSuite
    public void setupAllureReports() {
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide());

        SelenideLogger.addListener("AllureSelenide", new AllureSelenide()
                .screenshots(false)
                .savePageSource(true)
        );

        // Настройка slf4j
        org.apache.log4j.BasicConfigurator.configure();

        // Настройка Selenide
        Configuration.baseUrl = url;
        Configuration.browser = "chrome";
        Configuration.startMaximized = true;
        Configuration.fastSetValue = true;
        Configuration.timeout = 8000;
    }
}
