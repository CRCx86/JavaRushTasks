package com.javarush.task.task04.task0426;

/* 
Ярлыки и числа
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        Integer integer = Integer.parseInt(bufferedReader.readLine());

        if (integer == 0) {
            System.out.println("ноль");
        }else if(integer > 0) {
            if (integer % 2 == 0) {
                System.out.println("положительное четное число");
            }else {
                System.out.println("положительное нечетное число");
            }
        }else if (integer < 0){
            if (integer % 2 == 0) {
                System.out.println("отрицательное четное число");
            }else {
                System.out.println("отрицательное нечетное число");
            }
        }
    }
}
