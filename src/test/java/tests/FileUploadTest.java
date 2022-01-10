package tests;

import baseEntities.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.Waits;

import java.util.concurrent.TimeUnit;

public class FileUploadTest extends BaseTest {

    @Test
    public void fileUploadTest() throws InterruptedException {
        driver.get("http://the-internet.herokuapp.com/upload");
        driver.manage().timeouts().implicitlyWait(0, TimeUnit.MILLISECONDS);

        WebElement chooseFile = driver.findElement(By.id("file-upload"));
        WebElement uploadFile = driver.findElement(By.id("file-submit"));
        //chooseFile.click();
        chooseFile.sendKeys("C:\\Users\\Nikita\\Documents\\ViberDownloads\\0-02-0a-0c4a58f9bacc4efce5f8e33c60ff2d01553c3766c4fe866cd9693ef28c63854f_d21e57121bfbe39e.jpg");
        uploadFile.click();

        Waits waits = new Waits(driver);
        WebElement header = waits.waitForVisibility(By.xpath("//h3[.='File Uploaded!']"));
        WebElement fileName = waits.waitForVisibility(By.id("uploaded-files"));

        Assert.assertTrue(header.isDisplayed());
        //Assert.assertTrue(header != null);
        Assert.assertEquals(fileName.getText(), "0-02-0a-0c4a58f9bacc4efce5f8e33c60ff2d01553c3766c4fe866cd9693ef28c63854f_d21e57121bfbe39e.jpg");
    }
}
