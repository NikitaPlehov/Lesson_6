package pages;

import baseEntities.BasePage;
import com.tms.core.ReadProperties;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class DashboadPage extends BasePage {
    // Описание элементов страницы
    private By PAGE_OPENED_IDENTIFIER = By.className("top-section text-ppp");
    private By projects_Selector = By.xpath("(//div[@class='table summary summary-auto']/following::div/*[@class = 'row project flex-projects-row'])[15]//a[@style='padding-left: 25px']");

    // Конструктор страницы
    public DashboadPage(WebDriver driver){
        super(driver);
    }
    public boolean isPageOpened(){
        return super.isPageOpened(PAGE_OPENED_IDENTIFIER);
    }

    // Реализация гетерров элементов
    public WebElement getProjectsField(){return driver.findElement(projects_Selector);}
}
