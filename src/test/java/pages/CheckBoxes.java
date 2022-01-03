package pages;

import baseEntities.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CheckBoxes extends BasePage {
    // Описание элементов страницы
    private By PAGE_OPENED_IDENTIFIER = By.xpath("//h1[@class='heading']");
    private By checkBoxes = By.xpath("//*[contains(text(), 'Checkboxes')]");
    private By checkBox1 = By.xpath("//input[@type='checkbox'][1]");

    // Конструктор страницы

    public CheckBoxes(WebDriver driver){
        super(driver);
    }
    public boolean isPageOpened(){
        return super.isPageOpened(PAGE_OPENED_IDENTIFIER);
    }


    // Реализация гетерров элементов

    public WebElement getCheckBoxes(){return driver.findElement(checkBoxes);}
    public WebElement getCheckBox(){return driver.findElement(checkBox1);}

}
