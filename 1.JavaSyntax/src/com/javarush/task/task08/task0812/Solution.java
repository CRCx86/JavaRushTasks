package com.javarush.task.task08.task0812;

import java.io.*;
import java.util.ArrayList;

/* 
Cамая длинная последовательность
*/
public class Solution {
    public static void main(String[] args) throws IOException {
        //напишите тут ваш код
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<Integer> list = new ArrayList<>();
        for(int i = 0; i < 10; i++){
            list.add(Integer.parseInt(bufferedReader.readLine()));
        }

        Integer max = 1;
        Integer current = list.get(0);
        Integer count = 0;
        for (Integer integer : list) {
            if (integer == current) {
                count++;
                if (max < count)
                    max = count;
            }else {

                count = 1;
                current = integer;
            }
        }

        System.out.println(max);
    }
}