package com.javarush.task.task26.task2601;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Map;

/*
Почитать в инете про медиану выборки
*/
public class Solution {

    public static void main(String[] args) {

        sort(new Integer[]{13, 8, 15, 5, 17});

    }

    public static Integer[] sort(Integer[] array) {
        //implement logic here

        Arrays.sort(array);
        Integer mediana;

        if (array.length % 2 == 0) {
            Integer x1 = array[(0 + array.length - 1) / 2];
            Integer x2 = array[((0 + array.length - 1) / 2) + 1];
            mediana = (x1 + x2) / 2;
        }else {
            mediana = array[(0 + array.length - 1) / 2];
        }

        Comparator comparatorByMediana = new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {

                Integer result = Math.abs(o1 - mediana) - Math.abs(o2 - mediana);

                return result == 0 ? o1 - o2 : result;
            }
        };

        Arrays.sort(array, comparatorByMediana);

        return array;
    }
}
