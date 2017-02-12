package com.javarush.task.task08.task0818;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* 
Только для богачей
*/

public class Solution {
    public static HashMap<String, Integer> createMap() {
        //напишите тут ваш код
        HashMap<String, Integer> map = new HashMap<>();
        map.put("F1", 700);
        map.put("F2", 499);
        map.put("F3", 499);
        map.put("F4", 501);
        map.put("F5", 499);
        map.put("F6", 500);
        map.put("F7", 499);
        map.put("F8", 499);
        map.put("F9", 499);
        map.put("F10", 1001);

        return map;
    }

    public static void removeItemFromMap(HashMap<String, Integer> map) {
        //напишите тут ваш код

        for(Iterator<Map.Entry<String, Integer>> it = map.entrySet().iterator(); it.hasNext(); ) {
            Map.Entry<String, Integer> entry = it.next();
            if (entry.getValue() < 500) {
                it.remove();
            }
        }
    }

    public static void main(String[] args) {

        HashMap<String, Integer> map = createMap();
        removeItemFromMap(map);

        int i = 0;
    }
}