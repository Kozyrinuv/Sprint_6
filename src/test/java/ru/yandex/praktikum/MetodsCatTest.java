package ru.yandex.praktikum;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;

//Тесты для методов класса Cat
@RunWith(MockitoJUnitRunner.class)
public class MetodsCatTest {

    @Mock   // Мок для класса Feline
    private Feline feline;

    private Cat cat;

    //------------------------------------------------------------
    @Before
    public void beforeAll() {
        cat = new Cat(feline);
    }

    //---------------------------------------------------------------
    @Test
    public void getFoodTest() throws Exception {
        Mockito.when(feline.eatMeat()).thenReturn(List.of("Молоко", "Травка"));
        List<String> expectedFood = List.of("Молоко", "Травка");
        List<String> actualFood = cat.getFood();
        Assert.assertEquals(expectedFood, actualFood);
    }

    //---------------------------------------------------------------
    @Test
    public void getSoundTest() {
        String expectedSound = "Мяу";
        String actualSound = cat.getSound();
        Assert.assertEquals(expectedSound, actualSound);
    }
    //--------------------------------------------------------------
}
