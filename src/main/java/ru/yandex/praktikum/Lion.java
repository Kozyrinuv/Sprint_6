package ru.yandex.praktikum;

import java.util.List;

public class Lion {

    private final boolean hasMane;
    private final Feline feline;

    //Делаем инъекцию зависимости - передаем объект (ссылку) класса Feline в клвсс Lion
    public Lion(String sex, Feline feline) throws Exception {
        this.feline = feline;
        if ("Самец".equals(sex)) {
            hasMane = true;
        } else if ("Самка".equals(sex)) {
            hasMane = false;
        } else {
            throw new Exception("Используйте допустимые значения пола животного - самец или самка");
        }
    }

    //Feline feline = new Feline();// Убираем зависимость Lion от Feline

    public int getKittens() {
        return feline.getKittens();
    }

    public boolean doesHaveMane() {
        return hasMane;
    }

    public List<String> getFood() throws Exception {
        return feline.getFood("Хищник");
    }
}
