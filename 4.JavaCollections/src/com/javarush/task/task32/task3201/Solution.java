package com.javarush.task.task32.task3201;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

/*
Запись в существующий файл
*/
public class Solution {
    public static void main(String... args) throws IOException {

       try ( RandomAccessFile randomAccessFile = new RandomAccessFile(args[0], "rw")) {
           int number = Integer.parseInt(args[1]);
           String text = args[2];

           if (number > randomAccessFile.length())
               randomAccessFile.seek(randomAccessFile.length());
           else
               randomAccessFile.seek(number);
           randomAccessFile.write(text.getBytes());
           randomAccessFile.close();
       }catch (Exception e) {

       }
    }
}
