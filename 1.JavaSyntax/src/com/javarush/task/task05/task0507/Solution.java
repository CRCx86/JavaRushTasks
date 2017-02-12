package com.javarush.task.task05.task0507;

/* 
Среднее арифметическое
*/

import java.util.Scanner;

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        Integer integer = 0;
        Integer count = 0;
        Integer sum = 0;

        Scanner scanner = new Scanner(System.in);
        do {
            integer = scanner.nextInt();
            if (integer == -1) break;
            sum += integer;
            count++;
        }while (true);

        if (count > 0) {
            System.out.println((double)sum / (double)count);
        }
    }
}

