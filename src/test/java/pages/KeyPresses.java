package pages;

import baseEntities.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class KeyPresses extends BasePage {
    // Описание элементов страницы
    private By PAGE_OPENED_IDENTIFIER = By.xpath("//h1[@class='heading']");
    private By keyPresses = By.xpath("//*[text() = 'Key Presses']");
    private By name_Select = By.id("target");

    // Конструктор страницы

    public KeyPresses(WebDriver driver){
        super(driver);
    }
    public boolean isPageOpened(){
        return super.isPageOpened(PAGE_OPENED_IDENTIFIER);
    }


    // Реализация гетерров элементов

    public WebElement getKeyPresses(){return driver.findElement(keyPresses);}
    public WebElement getName_Select(){return driver.findElement(name_Select);}
}
