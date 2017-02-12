package com.javarush.task.task04.task0428;

/* 
Положительное число
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        int count = 0;
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        Integer integer = Integer.parseInt(bufferedReader.readLine());
        if (integer > 0) {
            count++;
        }
        integer = Integer.parseInt(bufferedReader.readLine());
        if (integer > 0) {
            count++;
        }
        integer = Integer.parseInt(bufferedReader.readLine());
        if (integer > 0) {
            count++;
        }

        System.out.println(count);
    }
}
