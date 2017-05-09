package com.javarush.task.task32.task3202;

import java.io.*;

/* 
Читаем из потока
*/
public class Solution {
    public static void main(String[] args) throws IOException {
        StringWriter writer = getAllDataFromInputStream(new FileInputStream("testFile.log"));
        System.out.println(writer.toString());
    }

    public static StringWriter getAllDataFromInputStream(InputStream is) throws IOException {

        StringWriter stringWriter = new StringWriter();
        final StringBuilder stringBuilder = new StringBuilder();
        try (Reader in = new InputStreamReader(is)) {

            char[] bytes = new char[1024];
            int length = 0;
            while ((length = in.read(bytes, 0, bytes.length))!= -1) {
                stringBuilder.append(bytes, 0, length);
            }
            stringWriter.write(stringBuilder.toString());
        }catch (Exception e) {

        }

        return stringWriter;
    }
}