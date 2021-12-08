package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

public class HW {

    static String URL1 = "https://kermi-fko.ru/raschety/Calc-Rehau-Solelec.aspx";
    static String URL2 = "https://masterskayapola.ru/kalkulyator/laminata.html";
    static String URL3 = "https://calc.by/building-calculators/laminate.html";




    @Test
    public void homework_test2() throws InterruptedException {
        String widthValue = "5";
        String lengthValue= "7";
        String heatLossValue = "20";


        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");

        // 1. Открыть браузер и перейти на тестируемую страницу!
        ChromeDriver driver = new ChromeDriver();
        driver.get(URL1);

        // 2. Ввести ширину.
        WebElement width = driver.findElement(By.id("el_f_width"));
        width.sendKeys(widthValue);

        // 3. Ввести длину.
        WebElement length = driver.findElement(By.id("el_f_lenght"));
        length.sendKeys(lengthValue);

        // 4. Выбрать помещение.
        WebElement premisesElement = driver.findElement(By.id("room_type"));
        Select  premisesDropDown = new Select(premisesElement);

        // 4 варианта:
        // premisesDropDown.selectByIndex(1);
        premisesDropDown.selectByValue("2");
        // premisesDropDown.selectByVisibleText("Кухня или спальня");

        // 5. Выбрать типа обогрева.
        WebElement typeElement = driver.findElement(By.id("heating_type"));
        Select  typeDropDown = new Select(typeElement);

        typeDropDown.selectByValue("2");

        // 6. Ввести теплопотери.
        WebElement heatLoss = driver.findElement(By.id("el_f_losses"));
        heatLoss.sendKeys(heatLossValue);

        // 7. Нажать на кнопку 'Рассчитать'.
        WebElement calculate = driver.findElement(By.cssSelector("input[type = 'button']"));
        calculate.click();

        // 8. Проверить результат.

        WebElement resultValue = driver.findElement(By.id("floor_cable_power"));

        String resultStr = resultValue.getAttribute("value");
        if (!resultStr.equals("21")){
            System.out.println("Некорректное значение");
        }

        WebElement result1Value = driver.findElement(By.id("spec_floor_cable_power"));

        String result1Str = result1Value.getAttribute("value");
        if (!result1Str.equals("1")){
            System.out.println("Некорректное значение");
        }

        Thread.sleep(10000);
        driver.quit();

    }


    @Test
    public void homework_test1() throws InterruptedException {
            String roomLengthValue = "7,0000";
            String roomWidthValue = "4,00000";
            String laminateLengthValue = "1500,000000";
            String laminateWidthValue = "195,000000000";
            String packagesValue = "12,000";
            String priceValue = "600,000";
            String offsetValue = "320,000";
            String indentValue = "15,00000000000000";

            String expectedLam = "27.67 м2.";
            String expectedCount = "101 шт.";
            String expectedPacks = "9 шт.";
            String expectedPrice = "18954 руб.";
            String expectedOver = "7 шт.";
            String expectedTrash = "8 шт.";

            System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");

            // 1. Открыть браузер и перейти на тестируемую страницу!
            ChromeDriver driver = new ChromeDriver();
            driver.get(URL2);

           // 2. Ввести длину помещения.
            WebElement roomLength = driver.findElement(By.name("calc_roomwidth"));
            roomLength.sendKeys(roomLengthValue);

            // 3. Ввести ширину помещения.
            WebElement roomWidth = driver.findElement(By.name("calc_roomheight"));
            roomWidth.sendKeys(roomWidthValue);

            // 4. Длина ламината.
            WebElement laminateLength = driver.findElement(By.name("calc_lamwidth"));
            laminateLength.sendKeys(laminateLengthValue);

            // 5. Ширина ламината.
            WebElement laminateWidth = driver.findElement(By.name("calc_lamheight"));
            laminateWidth.sendKeys(laminateWidthValue);

            // 6. Количество штук.
            WebElement packages = driver.findElement(By.name("calc_inpack"));
            packages.sendKeys(packagesValue);

            // 7. Цена.
            WebElement price = driver.findElement(By.name("calc_price"));
            price.sendKeys(priceValue);

            // 8. Направление укладки.
            WebElement directionElement = driver.findElement(By.name("calc_direct"));
            Select  directionDropDown = new Select(directionElement);

            directionDropDown.selectByVisibleText("По ширине комнаты");

            // 9. Смещение рядов.
            WebElement offset = driver.findElement(By.name("calc_bias"));
            offset.sendKeys(offsetValue);

            // 10. Отступ от стены.
            WebElement indent = driver.findElement(By.name("calc_walldist"));
            indent.sendKeys(indentValue);

            // 11. Нажать на кнопку 'Рассчитать'.
            WebElement calculate = driver.findElement(By.xpath("//input[@type='button']"));
            calculate.click();

            // 12. Проверить результат.
            String actualLam = driver.findElement(By.id("s_lam")).getText();
            String actualCount = driver.findElement(By.id("l_count")).getText();
            String actualPacks = driver.findElement(By.id("l_packs")).getText();
            String actualPrice = driver.findElement(By.id("l_price")).getText();
            String actualOver = driver.findElement(By.id("l_over")).getText();
            String actualTrash = driver.findElement(By.id("l_trash")).getText();

            Assert.assertEquals(actualLam, expectedLam, "Различные");
            Assert.assertEquals(actualCount, expectedCount, "Различные");
            Assert.assertEquals(actualPacks, expectedPacks, "Различные");
            Assert.assertEquals(actualPrice, expectedPrice, "Различные");
            Assert.assertEquals(actualOver, expectedOver, "Различные");
            Assert.assertEquals(actualTrash, expectedTrash, "Различные");



        Thread.sleep(25000);
            driver.quit();
    }





    @Test
    public void homework_test3() throws InterruptedException {

        String roomLengthValue = "500";
        String roomWidthValue = "400";
        String panelLengthValue = "2000";
        String panelWidthValue = "200";
        String numberValue = "8";
        String minLengthValue = "250";
        String indentValue = "10";



        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");

        // 1. Открыть браузер и перейти на тестируемую страницу!
        ChromeDriver driver = new ChromeDriver();
        driver.get(URL3);
/*
        // Способ укладки ламината.
        WebElement wayElement = driver.findElement(By.xpath("calc-sel"));
        Select wayDropDown = new Select(wayElement);

        wayDropDown.selectByVisibleText("со смещение на 1/3 длины");
*/
        // 2. Ввести длину комнаты.
        WebElement roomLength = driver.findElement(By.id("ln_room_id"));
        roomLength.clear();
        roomLength.sendKeys(roomLengthValue);
/*
        // 3. Ввести ширину комнаты.
        WebElement roomWidth = driver.findElement(By.id("wd_room_id"));
        roomWidth.sendKeys(roomWidthValue);

        // 4. Длина панели ламината.
        WebElement panelLength = driver.findElement(By.id("ln_lam_id"));
        panelLength.sendKeys(panelLengthValue);

        // 5. Ширина панели ламината.
        WebElement panelWidth = driver.findElement(By.id("wd_lam_id"));
        panelWidth.sendKeys(panelWidthValue);

        // 6. Число панелей в упаковке.
        WebElement number = driver.findElement(By.id("n_packing"));
        number.sendKeys(numberValue);

        // 7. Минимальная длина обрезка.
        WebElement minLength = driver.findElement(By.id("min_length_segment_id"));
        minLength.sendKeys(minLengthValue);

        // 8. Отступ от стен.
        WebElement indent = driver.findElement(By.id("indent_walls_id"));
        indent.sendKeys(indentValue);


        // Направление укладки ламината.
        WebElement directionElement = driver.findElement(By.id("direction-laminate-id1"));
        Select directionDropDown = new Select(directionElement);
        directionDropDown.selectByValue("2");

        // 7. Нажать на кнопку 'Рассчитать'.
        WebElement calculate = driver.findElement(By.cssSelector("input[type = 'button']"));
        calculate.click();
*/

        Thread.sleep(15000);
        driver.quit();


    }

}
