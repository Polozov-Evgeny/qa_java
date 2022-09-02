package com.example.tests;

import com.example.Alex;
import com.example.Feline;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

@RunWith(MockitoJUnitRunner.class)
public class AlexTest {

    @Mock
    Feline feline;

    @Test
    public void getKittensShouldReturnZero() throws Exception {

        Alex alex = new Alex(feline);
        int actualResult = alex.getKittens();
        assertEquals("Некорректный результат вызова метода", 0, actualResult);
    }

    @Test
    public void getFriendsShouldReturnFriendList() throws Exception {

        Alex alex = new Alex(feline);
        List<String> expectedResult = List.of("Марти", "Глория", "Мелман");
        List<String> actualResult = alex.getFriends();
        assertEquals("Некорректный результат вызова метода", expectedResult, actualResult);
    }

    @Test
    public void getPlaceOfLivingShouldReturnZoo() throws Exception {

        Alex alex = new Alex(feline);
        String expectedResult = "New York Zoo";
        String actualResult = alex.getPlaceOfLiving();
        assertEquals("Некорректный результат вызова метода", expectedResult, actualResult);
    }

    @Test
    public void doesHaveManeShouldReturnHasMane() throws Exception {

        Alex alex = new Alex(feline);
        boolean expectedResult = true;
        boolean actualResult = alex.doesHaveMane();
        assertEquals("Некорректный результат вызова метода", expectedResult, actualResult);
    }

    @Test
    public void getFoodShouldReturnFelineFood() throws Exception {

        Alex alex = new Alex(feline);
        Mockito.when(feline.getFood("Хищник")).thenReturn(List.of("Животные", "Птицы", "Рыба"));
        List<String> expectedResult = List.of("Животные", "Птицы", "Рыба");
        List<String> actualResult = alex.getFood();
        assertEquals("Некорректный результат вызова метода", expectedResult, actualResult);
    }

    @Test
    public void constructorAlexHasManeIsTrue() throws Exception {

        Alex alex = new Alex(feline);
        boolean actualResult = alex.doesHaveMane();
        assertTrue("Некорректое значение свойства", actualResult);
    }

}