import data.StaticProvider;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CalcSub {

    private Calculator calc = new Calculator("CalcSub");

    @Test(dependsOnMethods = "testSub1")
    public void testSub() { Assert.assertEquals(calc.sub(6, 3), 3); }

    @Test
    public void testSub1() {
        Assert.assertEquals(calc.sub(8, 0), 8);
    }

    @Test(dataProvider = "dataForSub", dataProviderClass = StaticProvider.class)
    public void dataProviderTest(int a, int b, int expectedResult) {
        Assert.assertEquals(calc.sub(a, b), expectedResult);
    }
}