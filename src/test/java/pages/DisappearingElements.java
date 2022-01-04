package pages;

import baseEntities.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class DisappearingElements extends BasePage {
    // Описание элементов страницы
    private By PAGE_OPENED_IDENTIFIER = By.xpath("//h1[@class='heading']");
    private By disappearingElements_Selector = By.xpath("//*[text() = 'Disappearing Elements']");
    private By about_Selector = By.xpath("//*[text() = 'About']");

    // Конструктор страницы
    public DisappearingElements(WebDriver driver){super(driver);}
    public boolean isPageOpened(){return super.isPageOpened(PAGE_OPENED_IDENTIFIER);}

    // Реализация гетерров элементов
    public WebElement getDisappearingElements_SelectorField(){return driver.findElement(disappearingElements_Selector);}
    public WebElement getAbout_SelectorField(){return driver.findElement(about_Selector);}
}
