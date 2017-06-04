package com.javarush.task.task39.task3904;

import java.util.Arrays;

/* 
Лестница
*/
public class Solution {
    private static int n = 70;
    public static void main(String[] args) {
        System.out.println("Number of possible runups for " + n + " stairs is: " + countPossibleRunups(n));
    }

    public static long countPossibleRunups(int n) {

        if (n < 0) {
            return 0;
        }else if (n == 0) {
            return 1;
        }else {
            long[] map = new long[n];
            return countPossibleDP(n, map);
        }

    }

    public static long countPossibleDP(int n, long[] map) {

        if (n < 0) {
            return 0;
        }else if (n == 0){
            return 1;
        }else if (map[n - 1] > 0) {
            return map[n - 1];
        }else {
            map[n - 1] = countPossibleDP(n - 1, map) +
                    countPossibleDP(n - 2, map) +
                    countPossibleDP(n - 3, map);
            return map[n - 1];
        }

    }
}

