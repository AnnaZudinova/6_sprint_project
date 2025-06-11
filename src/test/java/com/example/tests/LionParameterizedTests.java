package com.example.tests;

import com.example.Feline;
import com.example.FelineInterface;
import com.example.Lion;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class LionParameterizedTests {
    private final String lionSex;
    private final boolean hasMane;

    public LionParameterizedTests(boolean hasMane,String lionSex) {
        this.hasMane=hasMane;
        this.lionSex=lionSex;
    }

    @Parameterized.Parameters(name="Тестовые данные:{0},{1}")
    public static Object[][] getTestData() {
        return new Object[][]{
                {true,"Самец"},
                {false,"Самка"},
        };
    }

    @Test
    public void doesHaveManeReturnsBooleanAccordingToSex() throws Exception {
                FelineInterface feline=new Feline();
               Lion lion=new Lion(lionSex, feline);
            assertEquals(hasMane,lion.doesHaveMane());
    }
}
