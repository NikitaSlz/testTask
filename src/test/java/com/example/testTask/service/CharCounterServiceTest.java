package com.example.testTask.service;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class CharCounterServiceTest {

    @Mock
    private CharCounterService charCounterServiceMock;

    @BeforeAll
    void setUp() {
        System.out.println("Запущены тесты");
    }

    @AfterAll
    void cleanUp() {
        System.out.println("Тесты завершены");
    }

    //Тесты для метода проверки строки

    //Строка пустая или из пробелов
    @Test
    public void checkStringTest_input_null_or_blank() {
        when(charCounterServiceMock.checkString("       ")).thenReturn(false);
        boolean result = charCounterServiceMock.checkString("       ");
        assertEquals(false, result);

    }

    //Тест валидной строки
    @Test
    public void checkStringTest_input_RightString() {
        when(charCounterServiceMock.checkString("asd")).thenReturn(true);
        boolean result = charCounterServiceMock.checkString("asd");
        assertEquals(true, result);
    }

    //Тест строки с цифрами вместо буквенных символов
    @Test
    public void checkStringTest_input_StringWithNumbers() {
        when(charCounterServiceMock.checkString("asdf123")).thenReturn(false);
        boolean result = charCounterServiceMock.checkString("asdf123");
        assertEquals(false, result);
    }

    //Тест строки с символами разных регистров
    @Test
    public void checkStringTest_input_StringWithLowerAndUpperCase() {
        when(charCounterServiceMock.checkString("Aass")).thenReturn(true);
        boolean result = charCounterServiceMock.checkString("Aass");
        assertEquals(true, result);
    }

    //Тест на длинную строку, больше 10 символов
    @Test
    public void checkStringTest_input_StringIsToLong() {
        when(charCounterServiceMock.checkString("Aasswssssssssssssssssss")).thenReturn(false);
        boolean result = charCounterServiceMock.checkString("Aasswssssssssssssssssss");
        assertEquals(false, result);
    }

    //Тесты создания map из строки
    @Test
    public void createMapTest() {
        Map<Character, Integer> mapExpected = new HashMap<>();
        {
            mapExpected.put('A', 1);
            mapExpected.put('a', 2);
            mapExpected.put('s', 2);
        }
        when(charCounterServiceMock.createMap("Aasas")).thenReturn(mapExpected);
        var result = charCounterServiceMock.createMap("Aasas");
        assertEquals(mapExpected, result);
    }
}