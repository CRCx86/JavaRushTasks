package com.javarush.task.task31.task3105;

import java.io.*;
import java.nio.file.Files;
import java.util.HashMap;
import java.util.Map;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import java.util.zip.ZipOutputStream;

/* 
Добавление файла в архив
*/
public class Solution {
    public static void main(String[] args) throws IOException {

        String fileName = args[0];
        String zipFile = args[1];

        Map<ZipEntry, StringBuffer> bufferedOutputStreamMap = new HashMap<>();

        try (FileInputStream fileInputStream = new FileInputStream(zipFile);
             ZipInputStream zipInputStream = new ZipInputStream(fileInputStream)) {

            ZipEntry zipEntry;
            int i = 0;
            while ((zipEntry = zipInputStream.getNextEntry()) != null) {
                StringBuffer stringBuffer = new StringBuffer();

                while ((i = zipInputStream.read()) != -1) {
                    stringBuffer.append((char) i);
                }

                bufferedOutputStreamMap.put(zipEntry, stringBuffer);
            }
        }

        File file = new File(fileName);
        try ( FileOutputStream fileOutputStream = new FileOutputStream(zipFile);
              ZipOutputStream zipOutputStream = new ZipOutputStream(fileOutputStream)) {

            zipOutputStream.putNextEntry(new ZipEntry("new/" + file.getName()));
            Files.copy(file.toPath(), zipOutputStream);

            for (Map.Entry<ZipEntry, StringBuffer> pair : bufferedOutputStreamMap.entrySet()) {
                if (pair.getKey().getName().equals(file.getName())){
                    zipOutputStream.putNextEntry(pair.getKey());
                    Files.copy(file.toPath(), zipOutputStream);
                }else {
                    zipOutputStream.putNextEntry(pair.getKey());
                    for (char c : pair.getValue().toString().toCharArray()) {
                        zipOutputStream.write(c);
                    }
                }
            }

            zipOutputStream.close();
            fileOutputStream.close();

        }catch (Exception e) {

        }

    }
}
