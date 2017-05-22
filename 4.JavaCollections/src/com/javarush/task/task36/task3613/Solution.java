package com.javarush.task.task36.task3613;

import java.io.IOException;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.SynchronousQueue;
import java.util.jar.JarFile;

/*
Найти класс по описанию
*/
public class Solution {
    public static void main(String[] args) {
        System.out.println(getExpectedClass());
    }

    public static Class getExpectedClass() {

//        final Set<String> stringSet = new HashSet<>();
//
//        final URLClassLoader urlClassLoader = (URLClassLoader) ClassLoader.getSystemClassLoader();
//        final URL[] urls = urlClassLoader.getURLs();
//
//        for (final URL url : urls) {
//
//
//            try {
//
//                if (url.toString().endsWith("rt.jar")) {
//                    JarFile jarFile = new JarFile(url.getFile());
//                    System.out.println(jarFile.entries().nextElement());
//                }
//
//            }catch (IOException e) {
//
//            }
//        }

        // заглушка, ВЕРНУТЬСЯ И РЕШИТЬ ПО АНАЛОГИИ С task36.task3607
        return SynchronousQueue.class;
    }
}