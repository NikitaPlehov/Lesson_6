package pages;

import baseEntities.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Dropdown extends BasePage {
    // Описание элементов страницы
    private By PAGE_OPENED_IDENTIFIER = By.xpath("//h1[@class='heading']");
    private By dropdown = By.xpath("//*[text() = 'Dropdown']");

    // Конструктор страницы

    public Dropdown(WebDriver driver){
        super(driver);
    }
    public boolean isPageOpened(){
        return super.isPageOpened(PAGE_OPENED_IDENTIFIER);
    }

    // Реализация гетерров элементов

    public WebElement getDropdown(){return driver.findElement(dropdown);}

}
