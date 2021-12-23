import data.StaticProvider;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CalcTest3 extends BaseTest {
    private Calculator calc = new Calculator("CalcTest3");

    @Test(description = "Test of Multi in my Calculator",
            groups = "smoke")
    public void testMulti() {
        System.out.println("CalcTest3 -> testMulti");
    }

    @Test
    public void testMulti1() {
        System.out.println("CalcTest3 -> testMulti1");
    }

    @Test(dataProvider = "dataForMulti", dataProviderClass = StaticProvider.class)
    public void dataProviderTest(int a, int b, int expectedResult) {
        Assert.assertEquals(calc.multi(a, b), expectedResult);
    }
}
