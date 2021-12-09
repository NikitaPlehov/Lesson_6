package tests;

import org.openqa.selenium.By;

public class HM {

    //https://teachmeskills.by/


    public class CssSelectors {

        private void cssSelectors() {
            By classSelector = By.cssSelector(".t228__leftside"); //поиск по классу t228__leftside
            By classSelector1 = By.className("t228__leftside"); //поиск по классу t228__leftside(динаковый с первым)

            By idSelector = By.cssSelector("#t-header"); //поиск id
            By idSelector1 = By.id("t-header"); //поиск id(динаковый с первым)

            By tagSelector = By.cssSelector("span"); //поиск tag
            By tagSelector1 = By.tagName("span"); //поиск tag(динаковый с первым)

            By tagAttributeSelector = By.cssSelector("span[style='border-bottom-color: rgb(255, 255, 255);']"); //поиск по tag и аттрибуту с
            By tagAttributeSelector1 = By.cssSelector("span[style]"); //поиск по tag и аттрибуту без

            By multipleClassesSelector = By.cssSelector(".t228.t228__positionfixed "); //поиск двум классам в элементе

            By simpleHierarchicalSelector = By.cssSelector(".t-body .t228__leftside"); //поиск простого дочерного элемента

            By fullHierarchicalSelector = By.cssSelector("body.t-body .t228__leftside"); //поиск трехуровневой иерархии для поиска дочерного элемента

            By searchLikeContainsSelector = By.cssSelector("img[src*='tild3065']"); //поиск с вхождением подстроки в значении аттрибута
            By searchByWordSelector = By.cssSelector("img[src~='tild3065']"); //поиск с вхождением слова в значении аттрибуте

            By valueStartsFromSelector = By.cssSelector("a[href^='https://roistat']"); //поиск элемента с аттрибутом значение которого начинается с
            By valueEndsWithSelector = By.cssSelector("a[href$='melnika']"); //поиск элемента с аттрибутом значение которого заканчивается на

            By childRightAfterParentSelector = By.cssSelector("li>a"); //поиск дочернего a у которого родитель li

            By elementRightAfterElementSelector = By.cssSelector("a+a"); // поиск элемента a который идет сразу после элемента a
            By elementOnTheSameLevelSelector = By.cssSelector("head+body"); // поиск элементов a которым предшествует элемент a

            By firstChildSelector = By.cssSelector("button:first-child"); // поиск первго дочернего элемента
            By lastChildSelector = By.cssSelector("button:last-child"); // поиск последнего дочерного элемента
            By nthChildFromBeginSelector = By.cssSelector("li:nth-child(12)"); // поиск n-ого дочерного элемента с начала
            By nthChildFromEndSelector = By.cssSelector("a:nth-last-child(4)"); // поиск n-ого дочерного элемента с конца


        }
    }
}
