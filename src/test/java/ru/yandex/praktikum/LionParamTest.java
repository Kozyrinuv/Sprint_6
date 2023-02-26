package ru.yandex.praktikum;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.mockito.Mock;

//парраметризированный тест для класса Lion
//Проверяем наличие гривы у льва
@RunWith(Parameterized.class)
public class LionParamTest {

    private final boolean isMane;//Признак наличия гривы
    private final String sex;//Пол льва

    @Mock // Mок для класса Feline
    private Feline feline;

    private Lion lion;

    //-------Конструктор class LionParamTest---------------------
    public LionParamTest(String sex, boolean isMane) {
        this.sex = sex;
        this.isMane = isMane;
    }

    //---------------------------------------------------------------
    // Метод для передачи(получения) тестовых данных в конструктор public LionParamTest(...)
    @Parameterized.Parameters(name = "Тест LionParamTest - {0}")
    public static Object[] getParameters() {
        return new Object[][]{
                {"Самец", true},
                {"Самка", false},
                {"NOT_DEFINED", false},
        };
    }

    //----------------------------------------------------------
    @Test //Тест проверки наличия гривы у льва взависимости от пола жвотного
    public void doesHaveManeTest() {
        try {
            lion = new Lion(sex, feline);
            Boolean expectedIsMane = isMane;
            Boolean actualIsMane = lion.doesHaveMane();
            Assert.assertEquals(expectedIsMane, actualIsMane);
        } catch (Exception e) {
            System.out.println("!!! Unknown sex of the animal");
        }
    }

//---------------------------------------------------------------------------
}
