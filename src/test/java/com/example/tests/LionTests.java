package com.example.tests;

import com.example.Feline;
import com.example.Lion;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;

import static org.junit.Assert.assertEquals;


@RunWith(MockitoJUnitRunner.class)
public class LionTests {
    @Spy
    Feline feline;

    @Test
    public void getKittensNoParamsInvokesFelineGetKittensWith1(){
        Lion lion=new Lion(feline);
        lion.getKittens();
        Mockito.verify(feline).getKittens(1);
    }

    @Test
    public void getKittensNoParamsReturns1() {
        Lion lion=new Lion(feline);
        int expectedKittensCount=1;

        assertEquals(expectedKittensCount,lion.getKittens());
    }

    @Test
    public void getFoodReturnsPredatorFood(){
        Lion lion=new Lion(feline);
        List<String> expectedFood=List.of("Животные", "Птицы", "Рыба");

        try{assertEquals(expectedFood, lion.getFood());}
        catch (Exception e) {
            System.out.println(e);}
    }

    @Test
    public void getFoodInvokesFelinePredatorGetFood() {
        Lion lion=new Lion(feline);

        try{lion.getFood();
            Mockito.verify(feline).getFood("Хищник");}
        catch (Exception e){
            System.out.println(e);}
    }

    @Test
    public void lionConstructorWithOtherSexThrowsWrongSexException() {
        String lionSex = "Другое";
        String expectedException = "Используйте допустимые значения пола животного - самец или самка";

        try {
            Lion lion = new Lion(lionSex);
        } catch (Exception e) {
            String eMessage = e.getMessage();
            assertEquals(expectedException, eMessage);
        }
    }
}
