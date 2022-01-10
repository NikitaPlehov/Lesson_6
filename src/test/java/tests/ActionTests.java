package tests;

import baseEntities.BaseTest;
import net.bytebuddy.asm.Advice;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class ActionTests extends BaseTest {

    @Test
    public void actionTest1() throws InterruptedException {
        driver.get("http://the-internet.herokuapp.com/drag_and_drop");

        WebElement source = driver.findElement(By.id("column-a"));
        WebElement target = driver.findElement(By.id("column-b"));

        Actions actions = new Actions(driver);
        actions
                .moveToElement(source)
                .clickAndHold()
                .moveToElement(target)
                .release()
                //.dragAndDrop(source, target)
                .build()
                .perform();

        Thread.sleep(15000);
    }

    @Test
    public void actionTest2() throws InterruptedException {
        driver.get("http://the-internet.herokuapp.com/context_menu");

        WebElement target = driver.findElement(By.id("hot-spot"));


        Actions actions = new Actions(driver);
        actions
                //.moveToElement(target)
                .contextClick(target)
                .build()
                .perform();

        Thread.sleep(5000);
    }
}
