package com.javarush.task.task36.task3605;

import sun.reflect.generics.tree.Tree;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Iterator;
import java.util.List;
import java.util.TreeSet;

/* 
Использование TreeSet
*/
public class Solution {
    public static void main(String[] args) throws IOException {

        if (args.length == 0)
            return;
        byte[] list = Files.readAllBytes(Paths.get(args[0]));
        TreeSet<String> treeSet = new TreeSet<>();
        for (byte b : list) {
            char c = (char) b;
            if (Character.isAlphabetic(c)) {
                String s = String.valueOf(c);
                treeSet.add(s.toLowerCase());
            }
        }

        Iterator<String> iterator = treeSet.iterator();
        int i = 0;
        while (i < 5 & iterator.hasNext()) {
            System.out.print(iterator.next());
            i++;
        }
    }
}
