package pages;

import baseEntities.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class DynamicLoading extends BasePage {
    // Описание элементов страницы
    private By PAGE_OPENED_IDENTIFIER = By.xpath("//h1[@class='heading']");
    private By dynamicLoading_Selector = By.xpath("//*[text() = 'Dynamic Loading']");
    private By example_Selector = By.xpath("//*[contains(text(), 'Example 2')]");
    private By start_Selector = By.xpath("//*[contains(text(), 'Start')]");

    // Конструктор страницы
    public DynamicLoading(WebDriver driver){super(driver);}
    public boolean isPageOpened(){return super.isPageOpened(PAGE_OPENED_IDENTIFIER);}

    // Реализация гетерров элементов
    public WebElement getDynamicLoading_SelectorField(){return driver.findElement(dynamicLoading_Selector);}
    public WebElement getExample_SelectorField(){return driver.findElement(example_Selector);}
    public WebElement getStart_SelectorField(){return driver.findElement(start_Selector);}

}
