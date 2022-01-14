package tests;

import baseEntities.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

public class WaitsDynamic_loadingTest extends BaseTest {

    @Test
    public void explicitlyWait() throws InterruptedException {
        String expectedText = "Hello World!";
        String expectedLoad = "Loading...";

        driver.get("http://the-internet.herokuapp.com/dynamic_loading/1");

        WebElement start = driver.findElement(By.xpath("//*[. = 'Start']"));
        start.click();

        String actualLoad = driver.findElement(By.xpath("//*[. = 'Loading... ']")).getText();
        Assert.assertEquals(actualLoad, expectedLoad, "Различные");

        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("loading")));

        String actualText = driver.findElement(By.xpath("//*[. = 'Hello World!']")).getText();
        Assert.assertEquals(actualText, expectedText, "Различные");


        Thread.sleep(5000);

    }
}
    /*WebElement checkLoading = driver.findElement(By.xpath("//*[. = 'Loading... ']"));
    String checkLoadingStr = checkLoading.getText();
        if (!checkLoadingStr.equals("Loading...")) {
                System.out.println("Error");*/