package com.example.testTask.service;

import lombok.NoArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;

import static java.util.Map.Entry.comparingByValue;

@Service
@NoArgsConstructor
public class CharCounterService {

    /**
     * Вычисляет частоту встречи символов в заданной строке, выводит их в порядке убывания.
     * Формат входной строки - она должна состоять из символов алфавита,
     * ее длина меньше 10 символов и она не равна нулю или пробелам.
     * Формат исходящих параметров - строка, с символами и частотой их появления во входной строке, отсортированные по убыванию.
     *
     * @param inputStr Пример входной строки: “aaaaabcccc”
     * @return Пример выходного результата: “a”: 5, “c”: 4, “b”: 1
     */
    public String charCounter(String inputStr) {
        if (checkString(inputStr)) {
            Map<Character, Integer> map;
            map = createMap(inputStr);
            map = sortMap(map);
            return toString(map);
        }
        return " ";
    }

    /**
     * Проверяет входную строку на соответсвие параметрам условия.
     *
     * @param inputStr Строка символов.
     * @return Возвращает true или false в зависимости от результата проверки.
     */
    private boolean checkString(String inputStr) {
        inputStr = inputStr.replaceAll("\\s", "");

        return !inputStr.isBlank() && inputStr.length() < 10 && inputStr.chars().allMatch(Character::isLetter);
    }

    /**
     * Создает объект map на основе входной строки, который содержит символы (Character) в качестве ключа
     * и частоту их встреч (Integer) в качестве значения.
     *
     * @param inputStr Строка символов.
     * @return Возвращает Map<Character, Integer>
     */
    private Map<Character, Integer> createMap(String inputStr) {
        char[] chars = inputStr.toCharArray();
        Map<Character, Integer> map = new HashMap<>();
        for (Character k : chars) {
            if (!map.containsKey(k))
                map.put(k, 1);
            else
                map.put(k, map.get(k) + 1);
        }
        return map;
    }

    /**
     * Сортирует map по значению ключей в порядке убывания.
     *
     * @param map Map<Character, Integer> на основе входной строки.
     * @return Возвращает отсортированную Map<Character, Integer>.
     */
    private Map<Character, Integer> sortMap(Map<Character, Integer> map) {
        return map.entrySet()
                .stream()
                .sorted(comparingByValue(Comparator.reverseOrder()))
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (oldValue, newValue) -> oldValue, HashMap::new));
    }

    /**
     * Преобразует map в строку заданного формата, согласно условию задачи.
     *
     * @param map Отсортированная Map<Character, Integer> на основе входной строки.
     * @return Возвращает строку, состоящую из ключей и значений, по убыванию.
     */
    private String toString(Map<Character, Integer> map) {
        return map.keySet().stream()
                .map(key -> "\"" + key + "\"" + ": " + map.get(key))
                .collect(Collectors.joining(", "));
    }
}
