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
    public void eatMeatReturnsPredatorFood() {
        List<String> expectedFood = List.of("Животные", "Птицы", "Рыба");

        try {assertEquals(expectedFood, feline.eatMeat());}
        catch (Exception e) {
            System.out.print("Поймали exception:"+e);}
    }


  @Test
  public void getFamilyReturnsFeline(){
     String expectedFamily="Кошачьи";
     assertEquals(expectedFamily,feline.getFamily());
  }

    @Test
    public void getKittensNoParamsInvokesGetKittensWith1() {
      feline.getKittens();
      Mockito.verify(feline, Mockito.times(1)).getKittens(1);
    }

}
