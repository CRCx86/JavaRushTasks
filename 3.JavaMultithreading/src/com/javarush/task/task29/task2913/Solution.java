package com.javarush.task.task29.task2913;

import java.util.Random;

/* 
Замена рекурсии
*/

public class Solution {
    private static int numberA;
    private static int numberB;

    public static String getAllNumbersBetween(int a, int b) {

        String string = "";
        if (a > b) {
            for (int i = a; i >= b; i--) {
                string += i + " ";
            }
        } else {
            for (int i = a; i <= b; i++) {
                string += i + " ";
            }
        }

        return string.trim();
    }

    public static void main(String[] args) {
        Random random = new Random();
        numberA = random.nextInt() % 1_000;
        numberB = random.nextInt() % 10_000;
        System.out.println(getAllNumbersBetween(numberA, numberB));
        System.out.println(getAllNumbersBetween(numberB, numberA));
//        System.out.println(recursion(numberA, numberB));
//        System.out.println(recursion(numberB, numberA));
    }
}