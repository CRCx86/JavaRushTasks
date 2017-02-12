package com.javarush.task.task07.task0712;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/* 
Самые-самые
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<String> list = new ArrayList<>();

        int count = 0;
        while (count < 10) {
            String s = bufferedReader.readLine();
            if (!s.equals(""))
                list.add(s);
            count++;
        }

        ArrayList<String> list1 = new ArrayList<>();
        list1.addAll(list);

        Collections.sort(list1, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.length() - o2.length();
            }
        });

        String lot = list1.get(0);
        String long1 = list1.get(list1.size() - 1);

        for (String s : list1) {
            if (s.length() == lot.length()){
                lot = s;
                break;
            }
        }

        for (String s : list1) {
            if (s.length() == long1.length()) {
                long1 = s;
                break;
            }
        }

        for (String s : list) {
            if (s.equals(lot)){
                System.out.println(s);
                break;
            }
            if (s.equals(long1)) {
                System.out.println(s);
                break;
            }
        }
    }
}
