package com.example.tests;

import com.example.Feline;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(MockitoJUnitRunner.class)
public class FelineTests {
    @Spy
    Feline feline;

    @Test
    public void eatMeatReturnsPredatorFood() throws Exception {
        Feline feline=new Feline();
        List<String> expectedFood = List.of("Животные", "Птицы", "Рыба");

        assertEquals(expectedFood, feline.eatMeat());
    }

    @Test
    public void getFamilyReturnsFeline(){
      Feline feline=new Feline();
     String expectedFamily="Кошачьи";
     assertEquals(expectedFamily,feline.getFamily());
  }

    @Test
    public void getKittensNoParamsInvokesGetKittensWith1() {
      feline.getKittens();
      Mockito.verify(feline, Mockito.times(1)).getKittens(1);
    }

}
