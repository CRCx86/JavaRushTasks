package com.javarush.task.task30.task3010;

/* 
Минимальное допустимое основание системы счисления
*/

import java.math.BigInteger;

public class Solution {
    public static void main(String[] args) {
        //напишите тут ваш код
        try {
            if (args.length > 0) {
                String s = args[0];

                int min = 37;
                if (s.matches("[A-Za-z0-9]+")) {

                    for (int i = 2; i < 37; i++) {
                        try {
                            BigInteger bigInteger = new BigInteger(s, i);
                            if (min > i) {
                                min = i;
                            }
                        } catch (NumberFormatException e) {

                        }
                    }
                    System.out.println(min);
                } else {
                    System.out.println("incorrect");
                }
            }
        } catch (Exception e) {

        }
    }
}