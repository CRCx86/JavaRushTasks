package com.javarush.task.task04.task0417;

/* 
Существует ли пара?
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws Exception {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String s = bufferedReader.readLine();
        Integer a, b, c;
        if (!s.equals("")) {
            a = Integer.parseInt(s);
        }else {
            a = 0;
        }
        s = bufferedReader.readLine();
        if (!s.equals("")) {
            b = Integer.parseInt(s);
        }else {
            b = 0;
        }
        s = bufferedReader.readLine();
        if (!s.equals("")) {
            c = Integer.parseInt(s);
        }else {
            c = 0;
        }

        if ((a == b) && (b == c) && (a == c)) {
            System.out.println(a + " " + b + " " + c);
        }else if (a == b) {
            System.out.println(a + " " + b);
        }else if (b == c) {
            System.out.println(b + " " + c);
        }else if (c == a) {
            System.out.println(a + " " + c);
        }

    }
}