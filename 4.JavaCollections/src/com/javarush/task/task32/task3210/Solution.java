package com.javarush.task.task32.task3210;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

/* 
Используем RandomAccessFile
*/

public class Solution {
    public static void main(String... args) {

        try (RandomAccessFile randomAccessFile = new RandomAccessFile(args[0], "rw")) {

            randomAccessFile.seek(Long.parseLong(args[1]));

            byte[] readBytes = new byte[args[2].length()];
            randomAccessFile.read(readBytes, 0, args[2].length());
            String readText = convertByteToString(readBytes);

            randomAccessFile.seek(randomAccessFile.length());
            if (readText.equals(args[2])) {
                randomAccessFile.write(("true").getBytes());
            }else {
                randomAccessFile.write(("false").getBytes());
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static String convertByteToString(byte readBytes[]) {

        return new String(readBytes);

    }
}
