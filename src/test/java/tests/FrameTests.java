package tests;

import baseEntities.BaseTest;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class FrameTests extends BaseTest {

    @Test
    public void frameTest(){
        driver.get("http://the-internet.herokuapp.com/iframe");

        driver.switchTo().frame(0);
        Assert.assertTrue(driver.findElement(By.id("tinymce")).isDisplayed());

        driver.switchTo().parentFrame();
        Assert.assertTrue(driver.findElement(By.className("tox-editor-container")).isDisplayed());

    }
}
