package com.example.testTask.model;

import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;

import static java.util.Map.Entry.*;

public class CharCounter {
    private Map<Character, Integer> map;

    public CharCounter(Map<Character, Integer> map) {
        this.map = map;
    }
    public CharCounter() {

    }

    public Map<Character, Integer> getMap() {
        return map;
    }

    public void setMap(Map<Character, Integer> map) {
        this.map = map;
    }

    public boolean checkString(String str) {
        str = str.replaceAll("\\s", "");
        if(str != null && str.chars().allMatch(Character::isLetter)) {
            createMap(str);
        } else return false;
        return true;
    }

    public void createMap(String str) {
        char[] chars = str.toCharArray();
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
