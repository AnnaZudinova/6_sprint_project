package com.example.tests;

import com.example.Feline;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class FelineParameterizedTests {
    private final int kittensCount;

    public FelineParameterizedTests(int kittensCount) {
        this.kittensCount=kittensCount;
    }

    @Parameterized.Parameters(name="Тестовые данные:{0},{1},{2}")
    public static Object[][] getTestData() {
        return new Object[][]{
                {2},
                {5},
                {25},
        };}

    @Test
        public void getKittensWithParamsReturnsParams() {
            Feline feline=new Feline();

            assertEquals(kittensCount, feline.getKittens(kittensCount));
        }

}
