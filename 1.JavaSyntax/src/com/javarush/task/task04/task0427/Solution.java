package com.javarush.task.task04.task0427;

/* 
Описываем числа
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        Integer integer = Integer.parseInt(bufferedReader.readLine());

        if (integer >= 1 && integer <= 999) {
            if (integer / 100 > 0){
                if (integer % 2 == 0){
                    System.out.println("четное трехзначное число");
                }else {
                    System.out.println("нечетное трехзначное число");
                }
            } else if (integer / 10 > 0) {
                if (integer % 2 == 0){
                    System.out.println("четное двузначное число");
                }else {
                    System.out.println("нечетное двузначное число");
                }
            } else {
                if (integer % 2 == 0){
                    System.out.println("четное однозначное число");
                }else {
                    System.out.println("нечетное однозначное число");
                }
            }
        }

    }
}
