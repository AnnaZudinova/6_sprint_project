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
    public void getFoodReturnsPredatorFood(){
        Feline feline=new Feline();
        Cat cat=new Cat(feline);
        List<String> expectedCatFood=List.of("Животные", "Птицы", "Рыба");

        try{assertEquals(expectedCatFood, cat.getFood());}
        catch (Exception e) {
            System.out.println(e);}
    }

    @Test
    public void getFoodInvokesFelineEatMeat() {
        Cat cat=new Cat(feline);

        try{cat.getFood();
            Mockito.verify(feline).eatMeat();}
        catch (Exception e){
            System.out.println(e);}
    }
}
