package baseEntities;


import com.tms.core.ReadProperties;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import utils.Waits;

public abstract class BasePage {
    protected WebDriver driver;
    protected String BASE_URL;
    protected Waits waits;

    public BasePage(WebDriver driver) {
        this(driver, false);
    }

    public BasePage(WebDriver driver, boolean openPageByUrl) {
        this.driver = driver;
        this.waits = new Waits(driver);
        this.BASE_URL = ReadProperties.getUrl();

        PageFactory.initElements(driver, this);

        if (openPageByUrl) {
            openPage();
        }
    }

    protected abstract void openPage();

    public boolean isPageOpened(By by) {
        return waits.waitForVisibility(by).isDisplayed();
    }
}