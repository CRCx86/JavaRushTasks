package com.javarush.task.task04.task0412;

/* 
Положительное и отрицательное число
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int parseInt = Integer.parseInt(bufferedReader.readLine());

        if(parseInt > 0) {
            System.out.println(parseInt * 2);
        }
        if (parseInt < 0) {
            System.out.println(parseInt + 1);
        }
        if (parseInt == 0) {
            System.out.println(0);
        }
    }

}