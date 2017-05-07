package com.javarush.task.task31.task3113;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.concurrent.atomic.AtomicLong;

/* 
Что внутри папки?
*/
public class Solution {



    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String string = bufferedReader.readLine();
        bufferedReader.close();

        Path path = Paths.get(string);

        if (!Files.isDirectory(path)) {
            System.out.println(path.toString() + " - не папка");
            return;
        }

        MySimpleFileVisitor mySimpleFileVisitor = new MySimpleFileVisitor();

        Files.walkFileTree(path, mySimpleFileVisitor);

        System.out.println("Всего папок - " + (mySimpleFileVisitor.getCountOfDirectories()-1));
        System.out.println("Всего файлов - " + mySimpleFileVisitor.getCountOfFiles());
        System.out.println("Общий размер - " + mySimpleFileVisitor.getCountSize());
    }


    static class MySimpleFileVisitor extends SimpleFileVisitor<Path> {

        private int countOfDirectories = 0;
        private int countOfFiles = 0;
        private AtomicLong countSize = new AtomicLong(0);

        @Override
        public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attrs) throws IOException {

            countOfDirectories++;

            return FileVisitResult.CONTINUE;
        }

        @Override
        public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {

            countOfFiles++;
            countSize.addAndGet(attrs.size());

            return FileVisitResult.CONTINUE;
        }

        public int getCountOfDirectories() {
            return countOfDirectories;
        }

        public int getCountOfFiles() {
            return countOfFiles;
        }

        public AtomicLong getCountSize() {
            return countSize;
        }
    }
}
