package com.javarush.task.task04.task0413;

/* 
День недели
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int parseInt = Integer.parseInt(bufferedReader.readLine());

        switch (parseInt) {
            case 1 : printWeekDay("понедельник");
                break;
            case 2 : printWeekDay("вторник");
                break;
            case 3 : printWeekDay("среда");
                break;
            case 4 : printWeekDay("четверг");
                break;
            case 5 : printWeekDay("пятница");
                break;
            case 6 : printWeekDay("суббота");
                break;
            case 7 : printWeekDay("воскресенье");
                break;
            default:
                System.out.println("такого дня недели не существует");
                break;
        }
    }

    public static void printWeekDay (String day) {
        System.out.println(day);
    }
}