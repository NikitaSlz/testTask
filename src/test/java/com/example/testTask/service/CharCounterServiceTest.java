package com.example.testTask.service;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class CharCounterServiceTest {
    @BeforeEach
    void setUp() {
        System.out.println("Запущен тест:");
    }

    @ParameterizedTest
    @ValueSource(strings = {"aaadddsss","daasss", "   aadds", "     ", "123asd", "ds ds aaaa"})
    void checkStringTest(String input) {
        System.out.println(input);
        CharCounterService charCounterService = new CharCounterService();
        assertTrue(charCounterService.checkString(input));
    }

    @ParameterizedTest
    @CsvSource(value = {
            "{a=2, s=2}:aass",
            "{A=1, a=3}:Aaaa",
            "{a=1, s=1, d=1}:asd",
            "{b=1, a=2, c=1}:bbaac",
            "{a=0, s=1, b=}:asb",
            "{a=2, b=1, c=1}:abac"}, delimiter = ':')
    void createMapTest(String expected, String input) {
        CharCounterService charCounterService = new CharCounterService();
        charCounterService.createMap(input);
        System.out.println(input);
        assertEquals(expected, charCounterService.getMap().toString());
    }
}