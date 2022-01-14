package tests;

import baseEntities.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

public class WaitsDynamicLoadingTest extends BaseTest {

    @Test
    public void waitTest() throws InterruptedException {
        driver.get("http://the-internet.herokuapp.com/dynamic_loading/1");

        WebElement start = driver.findElement(By.xpath("//*[. = 'Start']"));
        start.click();

        WebElement load = driver.findElement(By.xpath("//*[. = 'Loading... ']"));
        Assert.assertTrue(load.isDisplayed());

        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//*[. = 'Loading... ']")));

        WebElement text = driver.findElement(By.xpath("//*[. = 'Hello World!']"));
        Assert.assertTrue(text.isDisplayed());

        Thread.sleep(5000);
    }
}
