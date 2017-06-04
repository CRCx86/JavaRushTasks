package com.javarush.task.task39.task3908;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
Возможен ли палиндром?
*/
public class Solution {
    public static void main(String[] args) {
        System.out.println(isPalindromePermutation("Mascarade"));
    }

    public static boolean isPalindromePermutation(String s) {

        if (s == null || s.length() == 0) {
            return false;
        }

        s = s.toLowerCase();
        s = s.replace(" ", "");

        // это невероятно мутное задание и это решение, с поиском полиндромов не проходит, поэтому лезем на гитхаб!

//        byte[] bytes = new byte[s.length() + 1];
//        List<String> result = new ArrayList<>();
//
//        Arrays.fill(bytes, (byte) 0);
//
//        while (bytes[s.length() - 1] != 1) {
//            int i = 0;
//            while (bytes[i] == 1) {
//                bytes[i] = 0;
//                i++;
//            }
//            bytes[i] = 1;
//            String s1 = "";
//            for (int j = 0; j < s.length() - 1; j++) {
//                if (bytes[j] == 1) {
//                    s1 += s.charAt(j + 1);
//                    if (s1.length() > 1){
//                        if (!result.contains(s1)) {
//                            result.add(s1);
//                        }
//                    }
//                }
//            }
//        }
//
//        for (String s2 : result) {
//            StringBuffer stringBuffer = new StringBuffer(s2);
//            if (s2.equals(stringBuffer.reverse().toString())){
//                return true;
//            }
//        }

        // короче, просто создаём булеву таблицу с наличием ASCII симоволов
        boolean[] isOdd = new boolean[256];

        // тут проходимся по слову и меняем переключатель каждый раз
        // когда буква снова встретится.
        // если хотя бы один тумблер - истина, значит символ встретился нечетное количество раз
        for (int i = 0; i < s.length(); i++) {
            isOdd[s.charAt(i)] = !isOdd[s.charAt(i)];
        }

        int numberOdd = 0;
        for (int i = 0; i < isOdd.length; i++) {
            if (isOdd[i]) {
                numberOdd++;
            }

            // если нашли хотя бы один, значит количества букв
            // более чем достаточно или недостаточно
            // для составления палиндрома
            if (numberOdd > 1)
                return false;
        }

        // и это значит, что если не нашли, то палиндром составить можно
        // благодарим чуваков по адресу:
        //Thanks hakimsd9
        //https://github.com/11601/CCAssignment/blob/0685fa7ce761fe292cd8ecc618f30f9e41fe0a6c/ch1/Solution04.java
        //Here is original
        // а ты, Саня, ебучая бездарность!
        return true;
    }
}
