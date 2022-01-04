package data;

import org.testng.annotations.DataProvider;

public class StaticProvider {

    @DataProvider(name = "dataForSum")
    public static Object[][] dataForSumFunction(){
        return new Object[][]{
                {-2, -3, -5},
                {0, 0, 0},
                {2, 3, 5}
        };
    }
    @DataProvider(name = "dataForSub")
    public static Object[][] dataForSubFunction(){
        return new Object[][]{
                {-5, -5, 0},
                {0, 0, 0},
                {5, 5, 0}
        };
    }
    @DataProvider(name = "dataForMulti")
    public static Object[][] dataForMultiFunction(){
        return new Object[][]{
                {-5, -5, 25},
                {0, 0, 0},
                {5, 5, 25}
        };
    }
    @DataProvider(name = "dataForDiv")
    public static Object[][] dataForDivFunction(){
        return new Object[][]{
                {-10.5, -5, 2.1},
                {1, 1, 1},
                {10, 5, 2}
        };
    }
}
