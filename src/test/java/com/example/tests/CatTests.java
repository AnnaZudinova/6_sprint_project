package com.example.tests;

import com.example.Cat;
import com.example.Feline;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(MockitoJUnitRunner.class)
public class CatTests {

    @Mock
    Feline feline;

    @Test
    public void getSoundReturnsMeow() {
       Feline feline=new Feline();
       Cat cat=new Cat(feline);
        String expectedSound="Мяу";

        assertEquals(expectedSound,cat.getSound());
    }

    @Test
    public void getFoodReturnsPredatorFood() throws Exception{
        Feline feline=new Feline();
        Cat cat=new Cat(feline);
        List<String> expectedCatFood= List.of("Животные", "Птицы", "Рыба");

        assertEquals(expectedCatFood, cat.getFood());
    }

    @Test
    public void getFoodInvokesFelineEatMeat() throws Exception {
        Cat cat=new Cat(feline);

       cat.getFood();
       Mockito.verify(feline).eatMeat();
    }
}
