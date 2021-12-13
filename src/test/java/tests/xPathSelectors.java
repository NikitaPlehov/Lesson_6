package tests;

public class xPathSelectors {
    private static String absolutePath = "/html/body/div";

    // все элементы на странице начиная с html - тэга.
    private static String allElementsInHTMLPath = "//*";

    // элемент по тэгу.
    private static String bodyPath = "//body";

    // дочерний элемент относительно родителя.
    private static String childPath = "//form/input";

    // поиск элемента с аттрибутом.
    private static String tagWithAttPath = "//span[@id='access--1']";

    // поиск элемента по аттрибуту значение которого начинается с
    private static String searchByStartsWithAttPath = "//input[starts-with(@type, 'hi')]";

    // поиск родителя у элемента с аттрибутом и его значением.
    private static String parentPath = "//span[@id='access--1']/../../../..";
    private static String parentPath2 = "//*[@id='suite_mode_single']/parent::label";

    // поиск элемента по индексу.
    private static String elementByIndexPath = "(//form)[6]";

    // поиск элемента по полному соответсвию по тексту.
    private static String searchByTextPath = "//*[text(), 'New Widget']";
    private static String searchByTextPath1 = "//*[. ='New Widget')]";

    // поиск элемента по по подстроке в тексте.
    private static String searchBySubStringPath = "//*[contains(text(), 'New Widget')]";

    // использование логического оператора.
    private static String searchByTwoAttrPath = "//*[@class='form-control' and @type='text']";

    // использование !(логическое НЕ).
    private static String searchBySpecificAttrPath = "//input[@type != 'hidden']";

    //Axes - оси
    // Использование ancestor - все предки текущего узла.
    private static String path1 = "//*[@id='suite_mode_single_baseline']/ancestor::div";

    private static String path2_1 = "//ul/child::li";
    private static String path2_2 = "//ul/li";   //аналог только проще.

    // Использование descendant - все предки текущего узла не зависят от уровня.
    private static String path3_1 = "//ul/descendant::span";
    private static String path3_2 = "//ul//span";   //аналог только проще.

    // Использование following - выбираем всё в документе после закрытия тэга текущего узла.
    private static String path4_1 = "//label[@for='announcement']/following::div";
    private static String path4_2 = "private static String path4_2 = '(//label[@for='announcement']/following::div/*[@class='checkbox'])[1]';";

    // Использование following-sibling - выбирают все узлы  от уровня после текущего узла.
    private static String path5_1 = "//label[@for='announcement']/following::div";








}
