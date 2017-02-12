package com.javarush.task.task04.task0416;

/* 
Переходим дорогу вслепую
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        Double d = Double.parseDouble(bufferedReader.readLine());

        double rem = d % 5;
        if (rem >= 0 && rem < 3){
            System.out.println("зелёный");
        }
        if (rem >= 3 && rem < 4) {
            System.out.println("желтый");
        }
        if (rem >= 4 && rem < 5) {
            System.out.println("красный");
        }
    }
}