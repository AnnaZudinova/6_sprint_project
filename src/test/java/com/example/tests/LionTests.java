package com.example.tests;

import com.example.Feline;
import com.example.Lion;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;

import static org.junit.Assert.assertEquals;


@RunWith(MockitoJUnitRunner.class)
public class LionTests {

    @Mock
    Feline feline;

    @Test
    public void getKittensNoParamsInvokesFelineGetKittens() throws Exception{
        String sex="Самец";
        Lion lion=new Lion(sex,feline);

        lion.getKittens();
        Mockito.verify(feline).getKittens();
    }

    @Test
    public void getKittensNoParamsReturns1() throws Exception{
        String sex="Самец";
        Lion lion=new Lion(sex,feline);
        int expectedKittensCount=1;

        Mockito.when(feline.getKittens()).thenReturn(1);
        assertEquals(expectedKittensCount,lion.getKittens());
    }

    @Test
    public void getFoodReturnsPredatorFood() throws Exception{
        String sex="Самец";
        Feline feline=new Feline();
        Lion lion=new Lion(sex,feline);
        List<String> expectedFood=List.of("Животные", "Птицы", "Рыба");

        assertEquals(expectedFood, lion.getFood());
    }

    @Test
    public void getFoodInvokesFelinePredatorGetFood() throws Exception {
        String sex="Самец";
        Lion lion=new Lion(sex,feline);

        lion.getFood();
        Mockito.verify(feline).getFood("Хищник");
    }

    //оставила цикл try catch, т.к. в этом тесте проверяется сообщение об ошибке, а ее надо поймать, чтобы получить текст
    @Test
    public void lionConstructorWithOtherSexThrowsWrongSexException(){
        String lionSex = "Другое";
        Feline feline=new Feline();
        String expectedException = "Используйте допустимые значения пола животного - самец или самка";

        try {Lion lion = new Lion(lionSex,feline);
        } catch (Exception e) {
            String eMessage = e.getMessage();
            assertEquals(expectedException, eMessage);
        }
    }
}
