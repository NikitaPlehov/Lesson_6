package pages;

import baseEntities.BasePage;
import com.tms.core.ReadProperties;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import static com.sun.xml.internal.ws.api.ComponentFeature.Target.ENDPOINT;

public class LoginPage extends BasePage {
    private static String ENDPOINT = "/auth/login";

    private static final By PAGE_OPENED_IDENTIFIER = By.id("button_primary");

    protected By emailSelector = By.id("name");
    protected By passwordSelector = By.id("password");
    protected By loginSelector = By.id("button_primary");

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    @Override
    protected void openPage() {
        driver.get(BASE_URL + ENDPOINT);
    }

    @Override
    protected boolean isPageOpened() {
        return waits.waitForVisibility(PAGE_OPENED_IDENTIFIER).isDisplayed();
    }

    public WebElement getEmailField() {
        return driver.findElement(emailSelector);
    }

    public WebElement getPasswordField() {
        return driver.findElement(passwordSelector);
    }

    public WebElement getLoginButton() {
        return driver.findElement(loginSelector);
    }

    private void populateFields(String email, String psw) {
        getEmailField().sendKeys(ReadProperties.getUsername());
        getPasswordField().sendKeys(ReadProperties.getPassword());
    }

    public DashboardPage successLogin(String email, String psw) {
        populateFields(email, psw);
        getLoginButton().click();
        return new DashboardPage(driver);
    }

    public LoginPage incorrectLogin(String email, String psw) {
        populateFields(email, psw);
        getLoginButton().click();
        return new LoginPage(driver);
    }
}
