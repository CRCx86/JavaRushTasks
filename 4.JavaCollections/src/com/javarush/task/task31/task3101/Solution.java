package com.javarush.task.task31.task3101;

import java.io.*;
import java.nio.file.FileVisitResult;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/*
Проход по дереву файлов
*/
public class Solution {
    private static List<File> fileList = new ArrayList<>();

    public static void main(String[] args) throws IOException {

        File path  = new File(args[0]);
        File resultFile =  new File(args[1]);
        File destFile = new File(resultFile.getParent() + "/allFilesContent.txt");
        FileUtils.renameFile(resultFile, destFile);
        try (FileOutputStream fileOutputStream = new FileOutputStream(destFile, true)) {

            Files.walkFileTree(path.toPath(), new SimpleFileVisitor<Path>() {
                @Override
                public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
                    if (file.toFile().length() > 50) FileUtils.deleteFile(file.toFile());
                    else fileList.add(file.toFile());
                    return FileVisitResult.CONTINUE;
                }
            });

            Collections.sort(fileList, new Comparator<File>() {
                @Override
                public int compare(File o1, File o2) {
                    return o1.getName().compareTo(o2.getName());
                }
            });

            fileList.remove(destFile);

            for (File file : fileList) {
                FileInputStream fileInputStream = new FileInputStream(file);
                while (fileInputStream.available() > 0) {
                    fileOutputStream.write(fileInputStream.read());
                    fileOutputStream.flush();
                }
                fileInputStream.close();
                fileOutputStream.write(System.lineSeparator().getBytes());
            }

        }
    }


    public static void getListFiles(File path) {

        // Перебираем все папки и файлы начиная со стартового пути
        for (File file : path.listFiles()) {
            //если это каталог
            if (file.isDirectory())  {

                //если не пуст, то вызываем этот метод повторно
                if (file.listFiles().length != 0) {
                    getListFiles(file);
                }

                //если пуст - удаляем
                else {
                    file.delete();
                }
            }
            else {

                if (file.length() > 50) {
                    file.delete();
                }
                else {
                    fileList.add(file);
                }
            }
        }

    }

    public static void deleteFile(File file) {
        if (!file.delete()) System.out.println("Can not delete file with name " + file.getName());
    }
}
