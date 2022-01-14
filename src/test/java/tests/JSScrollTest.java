package tests;

import baseEntities.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class JSScrollTest extends BaseTest {

    @Test
    public void jsScrollTest() throws InterruptedException {
        driver.get("http://the-internet.herokuapp.com/floating_menu#home");

        JavascriptExecutor jse = (JavascriptExecutor)driver;
        jse.executeScript("window.scrollTo(0, document.body.scrollHeight)");

        WebElement text = driver.findElement(By.xpath("//div[@style='text-align: center;']"));
        Assert.assertTrue(text.isDisplayed());

        Thread.sleep(5000);

    }
}
