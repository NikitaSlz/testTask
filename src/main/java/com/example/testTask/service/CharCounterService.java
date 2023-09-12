package com.example.testTask.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;

import static java.util.Map.Entry.*;
@Service
public class CharCounterService {
    private Map<Character, Integer> map;
    public CharCounterService() {

    }

    public Map<Character, Integer> getMap() {
        return map;
    }

    public void setMap(Map<Character, Integer> map) {
        this.map = map;
    }

    public boolean checkString(String inputStr) {
        inputStr = inputStr.replaceAll("\\s", "");

        if(!inputStr.isBlank() && inputStr != null && inputStr.chars().allMatch(Character::isLetter)) {
            createMap(inputStr);
        } else return false;
        return true;
    }

    public void createMap(String inputStr) {
        char[] chars = inputStr.toCharArray();
        Map<Character, Integer> map = new HashMap<>();
        for(Character k : chars) {
            if(!map.containsKey(k)) {
                map.put(k, 1);
            } else if(map.containsKey(k)) {
                map.put(k, map.get(k)+1);
            }
        }
        setMap(map);
    }

    public void sort() {
        setMap(map.entrySet()
                .stream()
                .sorted(comparingByValue(Comparator.reverseOrder()))
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (oldValue, newValue) -> oldValue, LinkedHashMap::new)));
    }

    @Override
    public String toString() {
        return map.keySet().stream()
                .map(key -> key + ":" + map.get(key))
                .collect(Collectors.joining(", "));
    }
}
