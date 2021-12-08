package tests;

import org.openqa.selenium.By;

public class CssSelectors {

    private void cssSelectors(){
        By classSelector = By.cssSelector(".radio"); //поиск по классу radio
        By classSelector1 = By.className("radio"); //поиск по классу radio(динаковый с первым)

        By idSelector = By.cssSelector("#suite_mode_single"); //поиск id
        By idSelector1 = By.id("suite_mode_single"); //поиск id(динаковый с первым)

        By tagSelector = By.cssSelector("label"); //поиск tag
        By tagSelector1 = By.tagName("label"); //поиск tag(динаковый с первым)

        By tagAttributeSelector = By.cssSelector("label[for='name']"); //поиск по tag и аттрибуту с name
        By tagAttributeSelector1 = By.cssSelector("label[for]"); //поиск по tag и аттрибуту без name

        By multipleClassesSelector = By.cssSelector(".column.overflow-content"); //поиск двум классам в элементе

        By simpleHierarchicalSelector = By.cssSelector(".table .content-inner"); //поиск простого дочерного элемента

        By fullHierarchicalSelector = By.cssSelector("body .table .content-inner"); //поиск трехуровневой иерархии для поиска дочерного элемента

        By searchLikeContainsSelector = By.cssSelector("form[action*='admin']"); //поиск с вхождением подстроки в значении аттрибута
        By searchByWordSelector = By.cssSelector("form[action~='admin']"); //поиск с вхождением слова в значении аттрибуте

        By valueStartsFromSelector = By.cssSelector("a[href^='https://']"); //поиск элемента с аттрибутом значение которого начинается с
        By valueEndsWithSelector = By.cssSelector("a[href$='@gmail.com']"); //поиск элемента с аттрибутом значение которого заканчивается на

        By childRightAfterParentSelector = By.cssSelector("ul>li"); //поиск дочернего li у которого родитель ul

        By elementRightAfterElementSelector = By.cssSelector("#form+script"); // поиск элемента script который идет сразу после элемента #form
        By elementOnTheSameLevelSelector = By.cssSelector("#form~script"); // поиск элементов script которым предшествует элемент #form

        By firstChildSelector = By.cssSelector("li:first-child"); // поиск первго дочернего элемента
        By lastChildSelector = By.cssSelector("li:last-child"); // поиск последнего дочерного элемента
        By nthChildFromBeginSelector = By.cssSelector("li:nth-child(2)"); // поиск n-ого дочерного элемента с начала
        By nthChildFromEndSelector = By.cssSelector("li:nth-last-child(1)"); // поиск n-ого дочерного элемента с конца






    }
}
