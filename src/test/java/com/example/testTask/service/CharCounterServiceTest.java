package com.example.testTask.service;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import static org.junit.jupiter.api.Assertions.assertEquals;


@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class CharCounterServiceTest {


    private final CharCounterService charCounterService = new CharCounterService();

    @BeforeAll
    void setUp() {
        System.out.println("Запущены тесты");
    }

    @AfterAll
    void cleanUp() {
        System.out.println("Тесты завершены");
    }

    /**
     * Тесты charCounter для различных входных данных
     */
    @Test
    public void charCounterServiceTest_ValidString_One() {
        String inputStr = "aaa";
        String expected = "\"a\": 3";
        String result = charCounterService.charCounter(inputStr);
        assertEquals(expected, result);
    }

    @Test
    public void charCounterServiceTest_ValidString_Two() {
        String inputStr = "ddaaa";
        String expected = "\"a\": 3, \"d\": 2";
        String result = charCounterService.charCounter(inputStr);
        assertEquals(expected, result);
    }

    @Test
    public void charCounterServiceTest_InvalidString_WithNumbers() {
        String inputStr = "123";
        String expected = " ";
        String result = charCounterService.charCounter(inputStr);
        assertEquals(expected, result);
    }

    @Test
    public void charCounterServiceTest_InvalidString_NullOrBlank() {
        String inputStr = "      ";
        String expected = " ";
        String result = charCounterService.charCounter(inputStr);
        assertEquals(expected, result);
    }

    @Test
    public void charCounterServiceTest_InvalidString_WithDifferentCase() {
        String inputStr = "AsD";
        String expected = "\"A\": 1, \"s\": 1, \"D\": 1";
        String result = charCounterService.charCounter(inputStr);
        assertEquals(expected, result);
    }
}