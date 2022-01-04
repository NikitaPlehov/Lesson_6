package tests;

import baseEntities.BaseTest;
import com.tms.core.ReadProperties;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;
import pages.*;

public class SmokeTest extends BaseTest {

    @Test
    public void checkBoxes() {
        CheckBoxes checkBoxes = new CheckBoxes(driver);
        checkBoxes.getCheckBoxes().click();
        checkBoxes.getCheckBox().click();
        checkBoxes.getCheckBox2().click();
    }

    @Test
    public void formAuthenticationTest() {
        FormAuthentication formAuthentication = new FormAuthentication(driver);
        formAuthentication.getFormAuthenticationField().click();
        formAuthentication.getUsername_SelectorField().sendKeys(ReadProperties.getUsername());
        formAuthentication.getPassword_SelectorField().sendKeys(ReadProperties.getPassword());
        formAuthentication.getLogin_PutField().click();

        WebElement checkLogin = driver.findElement(By.xpath("//*[contains(text(), 'Welcome to the Secure Area.')]"));
        String checkLoginStr = checkLogin.getText();
        if (!checkLoginStr.equals("Welcome to the Secure Area. When you are done click logout below.")) {
            System.out.println("Error");
        }
    }

    @Test
    public void dynamicLoadingTest() {
        DynamicLoading dynamicLoading = new DynamicLoading(driver);
        dynamicLoading.getDynamicLoading_SelectorField().click();
        dynamicLoading.getExample_SelectorField().click();
        dynamicLoading.getStart_SelectorField().click();
    }

    @Test
    public void disappearingElementsTest() {
        DisappearingElements disappearingElements = new DisappearingElements(driver);
        disappearingElements.getDisappearingElements_SelectorField().click();
        disappearingElements.getAbout_SelectorField().click();

        WebElement checkDisappearingElements = driver.findElement(By.xpath("//*[text() = 'Not Found']"));
        String checkDisappearingElementsStr = checkDisappearingElements.getText();
        if (!checkDisappearingElementsStr.equals("Not Found")) {
            System.out.println("Error");
        }
    }

    @Test
    public void keyPressesTest() {
        KeyPresses keyPresses = new KeyPresses(driver);
        keyPresses.getKeyPresses().click();
        keyPresses.getName_Select().sendKeys(Keys.SHIFT);

        WebElement checkKeyPresses = driver.findElement(By.xpath("//*[text() = 'You entered: SHIFT']"));
        String checkKeyPressesStr = checkKeyPresses.getText();
        if (!checkKeyPressesStr.equals("You entered: SHIFT")) {
            System.out.println("Error");
        }
    }

    @Test
    public void notificationMessagesTest() {
        NotificationMessages notificationMessages = new NotificationMessages(driver);
        notificationMessages.getNotificationMessages().click();
        notificationMessages.getClick_Here().click();

        WebElement checkNotificationMessages = driver.findElement(By.className("flash"));
        String checkNotificationMessagesStr = checkNotificationMessages.getText();
        if (!checkNotificationMessagesStr.equals("Action successful")) {
            System.out.println("Error, try again");
        } else {
            System.out.println("Action successful");
        }
    }

    @Test
    public void dropdownTest(){
        Dropdown dropdown = new Dropdown(driver);
        dropdown.getDropdown().click();

        WebElement dropdown1 = driver.findElement(By.id("dropdown"));
        Select typeDropDown = new Select(dropdown1);
        typeDropDown.selectByValue("2");
    }
}
