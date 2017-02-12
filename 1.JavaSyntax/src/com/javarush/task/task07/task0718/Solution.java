package com.javarush.task.task07.task0718;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/* 
Проверка на упорядоченность
*/
public class Solution {
    public static void main(String[] args) throws IOException {
        //напишите тут ваш код
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<String> list = new ArrayList<String>();
        for(int i = 0; i < 10; i++){
            list.add(bufferedReader.readLine());
        }

        int length = list.get(0).length();
        for (String s : list) {
            if (s.length() < length) {
                System.out.println(list.indexOf(s));
                break;
            }else {
                length = s.length();
            }
        }

        bufferedReader.close();
    }
}

