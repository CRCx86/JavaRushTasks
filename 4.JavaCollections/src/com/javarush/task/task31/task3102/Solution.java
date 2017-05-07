package com.javarush.task.task31.task3102;

import java.io.File;
import java.io.IOException;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;

/* 
Находим все файлы
*/
public class Solution {
    public static List<String> getFileTree(String root) throws IOException {

        ArrayDeque<File> arrayDeque = new ArrayDeque<>();
        List<String> stringList = new ArrayList<>();

        File fileRoot = new File(root);

        arrayDeque.add(fileRoot);
        while (!arrayDeque.isEmpty()){

            File file = arrayDeque.poll();

            for (File file1 : file.listFiles()) {
                if (file1.isDirectory()) {
                    arrayDeque.add(file1);
                }else {
                    stringList.add(file1.getAbsolutePath());
                }
            }
        }

        return stringList;

    }

    public static void main(String[] args) throws IOException {

        String string = "C:\\Intel";
        List<String> list = getFileTree(string);
        System.out.println(list);

    }
}
