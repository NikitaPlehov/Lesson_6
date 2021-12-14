package tests;

public class HM2 {

    //https://teachmeskills.by/

        private static String absolutePath = "/html/body/div";

        // все элементы на странице начиная с html - тэга.
        private static String allElementsInHTMLPath = "//*";

        // элемент по тэгу.
        private static String bodyPath = "//iframe"; //(находит 5 элементов).

        // дочерний элемент относительно родителя.
        private static String childPath = "//div/p"; //(находит 14 элементов)

        // поиск элемента с аттрибутом.
        private static String tagWithAttPath = "//div[@id='coverCarry83101844']";

        // поиск элемента по аттрибуту значение которого начинается с
        private static String searchByStartsWithAttPath = "//div[starts-with(@style, 'over')]";

        // поиск родителя у элемента с аттрибутом и его значением.
        private static String parentPath = "//div[@id='coverCarry83101844']//..";
        private static String parentPath2 = "//*[@id='roistat-lh-popup-iframe']/parent::div";

        // поиск элемента по индексу.
        private static String elementByIndexPath = "(//div)[150]";

        // поиск элемента по полному соответсвию по тексту.
        private static String searchByTextPath = "//*[text() = 'Сегодня разработчики стали символом финансового благополучия, но все ли они хорошо зарабатывают?']"; //(находит 1 элемент)
        private static String searchByTextPath1 = "//*[. = 'Сегодня разработчики стали символом финансового благополучия, но все ли они хорошо зарабатывают?']"; //(находит 1 элемент)

        // поиск элемента по  подстроке в тексте.
        private static String searchBySubStringPath = "//*[contains(text(), 'Сегодня разработчики стали символом финансового благополучия, но все ли они хорошо зарабатывают?')]"; //(находит 1 элемент)

        // использование логического оператора.
        private static String searchByTwoAttrPath = "//*[@class='t-submit' and @type='submit']";

        // использование !(логическое НЕ).
        private static String searchBySpecificAttrPath = "//button[@type != 'hidden']";

        //Axes - оси
        // Использование ancestor - все предки текущего узла.
        private static String path1 = "//*[@id='nav131756598marker']/ancestor::div[1]";

        private static String path2_1 = "//div/child::a";
        private static String path2_2 = "//div/a";   //аналог только проще.

        // Использование descendant - все предки текущего узла не зависимо от уровня.
        private static String path3_1 = "//div/ul/descendant::a";
        private static String path3_2 = "//div//ul//a";   //аналог только проще.

        // Использование following - выбираем всё в документе после закрытия тэга текущего узла.
        private static String path4_1 = "//a[@class='t688__link']/following::form";
        private static String path4_2 = "(//a[@class='t688__link']/following::form/*[@class = 'js-formaction-services'])[1]";

        // Использование following-sibling - Выбирает все узлы одного уровня после текущего узла.
        private static String path5_1 = "//li[@class='t228__list_item']/following-sibling::li";

        //Использование preceding - Выбирает все узлы, которые появляются перед текущим узлом в документе
        private static String path6_1 = "//li[@class='t228__list_item']/preceding::li";

        //Использование preceding-sibling - Выбирает все узлы одного уровня до текущего узла
        private static String path7_1 = "//li[@class='t228__list_item']/preceding-sibling::li";

}
