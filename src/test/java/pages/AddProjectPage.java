package pages;

import baseEntities.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AddProjectPage extends BasePage{
        // Описание элементов страницы
        private By PAGE_OPENED_IDENTIFIER = By.className("top-section text-ppp");
        private By addProject_Selector = By.id("sidebar-projects-add");
        private By filename_Selector = By.xpath("(//div[@class='form-group']/preceding-sibling::div[1]/*[@class='form-control '])[1]");
        private By announcement_Selector = By.xpath("//*[@id='announcement']");
        private By check_Selector = By.xpath("//*[@id='suite_mode_multi']");
        private By addProject2_Selector = By.xpath("//*[@id='accept']");

        // Конструктор страницы
        public AddProjectPage(WebDriver driver){
            super(driver);
        }
        public boolean isPageOpened(){
            return super.isPageOpened(PAGE_OPENED_IDENTIFIER);
        }

        // Реализация гетерров элементов
        public WebElement getAddProjectField(){return driver.findElement(addProject_Selector);}
        public WebElement getFilenameField(){return driver.findElement(filename_Selector);}
        public WebElement getAnnouncementField(){return driver.findElement(announcement_Selector);}
        public WebElement getCheckField(){
        return driver.findElement(check_Selector);
    }
        public WebElement getAddProject2Button(){return driver.findElement(addProject2_Selector);}
}
