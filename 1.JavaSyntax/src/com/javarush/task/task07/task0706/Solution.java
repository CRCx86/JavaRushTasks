package com.javarush.task.task07.task0706;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

/* 
Улицы и дома
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        int[] integers = new int[15];
        Scanner scanner = new Scanner(System.in);

        for (int i = 0; i < 15; i++) {
            integers[i] = scanner.nextInt();
        }

        int odd = 0;
        int even = 0;
        for (int i = 0; i < 15; i++) {
            if (i % 2 == 0) {
                even += integers[i];
            }else {
                odd += integers[i];
            }
        }

        if (even > odd) {
            System.out.println("В домах с четными номерами проживает больше жителей.");
        }

        if (odd > even) {
            System.out.println("В домах с нечетными номерами проживает больше жителей.");
        }
    }
}
