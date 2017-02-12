package com.javarush.task.task04.task0429;

/* 
Положительные и отрицательные числа
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        int countPos = 0;
        int countNeg = 0;

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        Integer integer = Integer.parseInt(bufferedReader.readLine());

        if (integer > 0) {
            countPos++;
        }else if (integer < 0) {
            countNeg++;
        }
        integer = Integer.parseInt(bufferedReader.readLine());
        if (integer > 0) {
            countPos++;
        }else if (integer < 0) {
            countNeg++;
        }
        integer = Integer.parseInt(bufferedReader.readLine());
        if (integer > 0) {
            countPos++;
        }else if (integer < 0) {
            countNeg++;
        }
        System.out.println("количество отрицательных чисел: " + countNeg);
        System.out.println("количество положительных чисел: " + countPos);
    }
}
