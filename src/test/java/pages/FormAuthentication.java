package pages;

import baseEntities.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class FormAuthentication extends BasePage {
    private By PAGE_OPENED_IDENTIFIER = By.xpath("//h1[@class='heading']");
    private By formAuthentication = By.xpath("//a[@href='/login']");
    private By username_Selector = By.xpath("//input[@type='text']");
    private By password_Selector = By.xpath("//input[@type='password']");
    private By login_Put = By.className("radius");;


    // Конструктор страницы
    public FormAuthentication(WebDriver driver){
        super(driver);
    }
    public boolean isPageOpened(){
        return super.isPageOpened(PAGE_OPENED_IDENTIFIER);
    }

    // Реализация гетерров элементов
    public WebElement getFormAuthenticationField(){return driver.findElement(formAuthentication);}
    public WebElement getUsername_SelectorField(){return driver.findElement(username_Selector);}
    public WebElement getPassword_SelectorField(){return driver.findElement(password_Selector);}
    public WebElement getLogin_PutField(){return driver.findElement(login_Put);}


}
