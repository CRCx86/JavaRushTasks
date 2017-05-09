package com.javarush.task.task30.task3012;

/* 
Получи заданное число
*/

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.createExpression(74);
        solution.createExpression(1234);
        solution.createExpression(3000);
        solution.createExpression(1000000);
        solution.createExpression(2);
    }

    public void createExpression(int number) {

        List<String> strings = get3Radix(number);
        String s = "";
        for (int i = 0; i < strings.size(); i++) {
            int result = (int) (Integer.parseInt(strings.get(i)) * Math.pow(3, i));

            if (result > 0) {
                s += "+ " + result + " ";
            }else if (result < 0){
                s += "- " + Math.abs(result) + " ";
            }
        }

        System.out.println(number + " = " +s.trim());

    }

    public List<String> get3Radix(int number) {

        List<String> strings = new ArrayList<>();
        String s = "";

        while (number > 0) {
            int q = number / 3;
            int r = number % 3;

            if (r <= 1) {
                strings.add(String.valueOf((char) (r + '0')));
                number = q;
            }else {
                r = 3 - r;
                s = "-" + ((char) (r + '0'));
                strings.add(s);
                number = q + 1;
            }
        }

        return strings;

    }
}