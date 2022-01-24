package pages;

import baseEntities.BasePage;
import models.User;
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

    //реализация базовых методов
    private void populateFields(String email, String password) {
        getEmailField().sendKeys(email);
        getPasswordField().sendKeys(password);
    }

    public void login(String email, String password) {
        populateFields(email, password);
        getLoginButton().click();
    }

    public void loginWithValue(User user) {
        getEmailField().sendKeys(user.getEmail());
        getPasswordField().sendKeys(user.getPassword());
        getLoginButton().click();
    }

    public DashboardPage successLogin(String email, String password) {
        populateFields(email, password);
        getLoginButton().click();
        return new DashboardPage(driver);
    }

        public LoginPage incorrectLogin (String email, String password){
            populateFields(email, password);
            getLoginButton().click();
            return new LoginPage(driver);
    }
}
