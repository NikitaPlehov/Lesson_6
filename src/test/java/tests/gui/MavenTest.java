package tests.gui;

import org.testng.annotations.Test;

public class MavenTest {

    @Test
    public void parameterTest(){
        System.out.println(System.getProperty("testProb"));
    }
}
