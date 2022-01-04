package pages;

import baseEntities.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class NotificationMessages extends BasePage {
    // Описание элементов страницы
    private By PAGE_OPENED_IDENTIFIER = By.xpath("//h1[@class='heading']");
    private By notificationMessages = By.xpath("//*[text() = 'Notification Messages']");
    private By click_Here = By.xpath("//*[text() = 'Click here']");

    // Конструктор страницы

    public NotificationMessages(WebDriver driver){
        super(driver);
    }
    public boolean isPageOpened(){
        return super.isPageOpened(PAGE_OPENED_IDENTIFIER);
    }

    // Реализация гетерров элементов

    public WebElement getNotificationMessages(){return driver.findElement(notificationMessages);}
    public WebElement getClick_Here(){return driver.findElement(click_Here);}
}
