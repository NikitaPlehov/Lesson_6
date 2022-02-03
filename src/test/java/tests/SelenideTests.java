package tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.openqa.selenium.By;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import tests.page.LoginPage;


import java.io.File;
import java.io.FileNotFoundException;

import static com.codeborne.selenide.CollectionCondition.texts;
import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.*;

//@Listeners({ SoftAsserts.class})
public class SelenideTests {
    static String url = "https://qa1505.testrail.io";
    String username = "atrostyanko+0401@gmail.com";
    String password = "QqtRK9elseEfAk6ilYcJ";

    @BeforeSuite
    static void setupAllureReports() {
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide());

        // or for fine-tuning:
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide()
                .screenshots(false)
                .savePageSource(true)
        );

        // Настройка slf4j
        org.apache.log4j.BasicConfigurator.configure();

        // Настройка Selenide
        Configuration.baseUrl = url;
        Configuration.browser = "chrome";
        Configuration.startMaximized = false;
        Configuration.fastSetValue = true;
        Configuration.timeout = 8000;
        //Configuration.assertionMode = SOFT;
        //Configuration.headless = false;
    }


    @Test
    public void userCanLogin() {
        // Настройка slf4j
        org.apache.log4j.BasicConfigurator.configure();

        // Настройка Selenide
        Configuration.baseUrl = url;
        Configuration.browser = "chrome";
        Configuration.startMaximized = false;
        Configuration.fastSetValue = true;
        Configuration.timeout = 8000;
        //Configuration.assertionMode = SOFT;
        //Configuration.headless = false;

        // Начинаем писать тест
        open("/");

        $(By.id("name")).setValue(username);
        $("#password").val(password);
        $("#button_primary").click();

        $(".page_title").shouldBe(visible).shouldHave(text("All Projects"));

        open("/index.php?/admin/projects/overview");
        $$(By.className("hoverSensitive"))
                .shouldHaveSize(388)
                .find(text("123456"))
                .find(By.tagName("a"))
                .click();

        $("#announcement")
                .should(exist)
                .shouldBe(visible)
                .shouldHave(exactText("This is the description for the project1"));
    }

    @Test
    public void userCanLogin1() {


        // Начинаем писать тест
        open("/");

        LoginPage loginPage = new LoginPage();
        loginPage.getUsernameField().setValue(username);

        $("#password").val(password);
        $("#button_primary").click();

        $(".page_title").shouldBe(visible).shouldHave(text("All Projects"));

        open("/index.php?/admin/projects/overview");
        $$(By.className("hoverSensitive"))
                .shouldHaveSize(388)
                .find(text("123456"))
                .find(By.tagName("a"))
                .click();

        $("#announcement")
                .should(exist)
                .shouldBe(visible)
                .shouldHave(exactText("This is the description for the project1"));
    }

    @Test
    public void test1() {
        // Настройка slf4j
        org.apache.log4j.BasicConfigurator.configure();

        // Настройка Selenide
        Configuration.baseUrl = url;
        Configuration.browser = "chrome";
        Configuration.startMaximized = false;
        Configuration.fastSetValue = true;
        Configuration.timeout = 8000;
        //Configuration.assertionMode = SOFT;
        //Configuration.headless = false;

        // Начинаем писать тест
        open("/");

        $(By.id("name")).setValue(username);
        $("#password").val(password);
        $("#button_primary").click();

        $(".page_title").shouldBe(visible).shouldHave(text("All Projects"));

        $$(".chart-legend-name")
                .filter(visible)
                .shouldHave(
                        texts(
                                "123456",
                                "aaaDencheck",
                                "aaaDencheck",
                                "aaaDencheck"
                        )
                );
    }

    @Test
    public void test2() throws FileNotFoundException {
        // Настройка slf4j
        org.apache.log4j.BasicConfigurator.configure();

        // Настройка Selenide
        Configuration.baseUrl = url;
        Configuration.browser = "chrome";
        Configuration.startMaximized = false;
        Configuration.fastSetValue = true;
        Configuration.timeout = 8000;
        //Configuration.downloadsFolder = "";
        //Configuration.assertionMode = SOFT;
        //Configuration.headless = false;

        // Начинаем писать тест
        open("/");

        $(By.id("name")).setValue(username);
        $("#password").val(password);
        $("#button_primary").click();

        $(byText("ahlhtdqk")).shouldBe(visible);
        $(withText("123")).shouldBe(visible);

        SelenideElement parent = $(byText("ahlhtdqk")).parent();
        System.out.println(parent.getTagName());

        $(byText("ahlhtdqk")).innerText();
        $(byText("ahlhtdqk")).innerHtml();
        $(byText("ahlhtdqk")).scrollTo();
        $(byText("ahlhtdqk")).closest("tr");
        $(byText("ahlhtdqk")).find(By.xpath(""));
        $(byText("ahlhtdqk")).doubleClick();
        $(byText("ahlhtdqk")).contextClick();
        $(byText("ahlhtdqk")).hover();

        $(byText("ahlhtdqk")).uploadFile(new File(""));
        $(byText("ahlhtdqk")).download();

        sleep(3000);
    }

}
