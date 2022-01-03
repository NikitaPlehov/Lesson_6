package tests;

import baseEntities.BaseTest;
import com.tms.core.ReadProperties;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import pages.CheckBoxes;
import pages.FormAuthentication;

public class SmokeTest extends BaseTest {

    @Test
    public void checkBoxes() {
        CheckBoxes checkBoxes = new CheckBoxes(driver);
        checkBoxes.getCheckBoxes().click();
        checkBoxes.getCheckBox().click();
    }

    @Test
    public void formAuthenticationTest() {
        FormAuthentication formAuthentication = new FormAuthentication(driver);
        formAuthentication.getFormAuthenticationField().click();
        formAuthentication.getUsername_SelectorField().sendKeys(ReadProperties.getUsername());
        formAuthentication.getPassword_SelectorField().sendKeys(ReadProperties.getPassword());
        formAuthentication.getLogin_PutField().click();

        WebElement checkLogin = driver.findElement(By.xpath("//*[text() = 'You logged into a secure area!']"));
        String checkLoginStr = checkLogin.getText();
        if (!checkLoginStr.equals("You logged into a secure area!")){
            System.out.println("Error");
        }
    }
}
