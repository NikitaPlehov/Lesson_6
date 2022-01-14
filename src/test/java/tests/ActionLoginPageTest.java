package tests;

import baseEntities.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ActionLoginPageTest extends BaseTest {

    @Test
    public void actionTest() throws InterruptedException {
        driver.get("http://the-internet.herokuapp.com/login");

        WebElement source = driver.findElement(By.id("username"));
        WebElement target = driver.findElement(By.id("password"));
        WebElement click = driver.findElement(By.xpath("//*[. = ' Login']"));

        Actions actions = new Actions(driver);
        actions
                .sendKeys(source, "tomsmith")
                .sendKeys(target,"SuperSecretPassword!")
                .click(click)
                .build()
                .perform();

        WebElement finish = driver.findElement(By.id("flash"));
        Assert.assertTrue(finish.isDisplayed());

        Thread.sleep(3000);
    }
}
