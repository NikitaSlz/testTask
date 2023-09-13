package com.example.testTask.service;

import io.swagger.v3.oas.models.security.SecurityScheme;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;

import static java.util.Map.Entry.*;

@Service
@NoArgsConstructor
public class CharCounterService {


    public String charCounter(String inputStr) {
        if (checkString(inputStr)) {
            Map<Character, Integer> map;
            map = createMap(inputStr);
            map = sortMap(map);
            return toString(map);
        }
        return " ";
    }

    //Проверка строки на валидность: состоит только из букв, не нулевая и ее длина меньше 10
    boolean checkString(String inputStr) {
        inputStr = inputStr.replaceAll("\\s", "");

        if (!inputStr.isBlank() && inputStr.length() < 10 && inputStr.chars().allMatch(Character::isLetter))
            return true;
        return false;
    }

    //Создание map на основе входной строки с подсчетом вхождения символов
    Map<Character, Integer> createMap(String inputStr) {
        char[] chars = inputStr.toCharArray();
        Map<Character, Integer> map = new HashMap<>();
        for (Character k : chars) {
            if (!map.containsKey(k))
                map.put(k, 1);
            map.put(k, map.get(k) + 1);
        }
        return map;
    }

    //Сортировка map по значению ключей
    Map<Character, Integer> sortMap(Map<Character, Integer> map) {
        return map.entrySet()
                .stream()
                .sorted(comparingByValue(Comparator.reverseOrder()))
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (oldValue, newValue) -> oldValue, LinkedHashMap::new));
    }

    //Преобразование map в строку
    String toString(Map<Character, Integer> map) {
        return map.keySet().stream()
                .map(key -> "\"" + key + "\"" + ":" + map.get(key))
                .collect(Collectors.joining(", "));
    }
}
