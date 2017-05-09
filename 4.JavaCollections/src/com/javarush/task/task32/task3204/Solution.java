package com.javarush.task.task32.task3204;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/* 
Генератор паролей
*/
public class Solution {
    public static void main(String[] args) throws IOException {

        ByteArrayOutputStream password = getPassword();
        System.out.println(password.toString());

    }

    public static ByteArrayOutputStream getPassword() throws IOException {

        final String UPPER = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        final String LOWER = "abcdefghijklmnopqrstuvwxyz";
        final String DIGIT = "0123456789";
        final int length = 8;

        StringBuilder password = new StringBuilder(length);
        Random random = new Random(System.nanoTime());

        List<String> stringList = new ArrayList<>();
        stringList.add(UPPER);
        stringList.add(LOWER);
        stringList.add(DIGIT);

        for (int i = 0; i < 3; i++) {
            String charCategory = stringList.get(i);
            int position = random.nextInt(charCategory.length());
            password.append(charCategory.charAt(position));
        }

        for (int i = 0; i < 5; i++) {
            String charCategory = stringList.get(random.nextInt(stringList.size()));
            int position = random.nextInt(charCategory.length());
            password.append(charCategory.charAt(position));
        }

        InputStream inputStream = new ByteArrayInputStream(password.toString().getBytes());
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();

        executor(inputStream, byteArrayOutputStream);

        return byteArrayOutputStream;
    }

    public static void executor(InputStream inputStream, OutputStream outputStream) throws IOException {
        BufferedInputStream bis = new BufferedInputStream(inputStream);
        while (bis.available() > 0)
        {
            int data = bis.read();
            outputStream.write(data);
        }
    }
}