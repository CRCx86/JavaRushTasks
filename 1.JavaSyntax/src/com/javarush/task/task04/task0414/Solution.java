package com.javarush.task.task04.task0414;

/* 
Количество дней в году
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int parseInt = Integer.parseInt(bufferedReader.readLine());

        if (parseInt % 100 == 0) {
            if (parseInt % 400 == 0) {
                System.out.println("количество дней в году: 366");
            }else {
                System.out.println("количество дней в году: 365");
            }
        }else {
            if (parseInt % 4 == 0) {
                System.out.println("количество дней в году: 366");
            }else {
                System.out.println("количество дней в году: 365");
            }
        }
    }
}