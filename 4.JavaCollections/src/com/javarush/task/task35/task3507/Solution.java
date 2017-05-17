package com.javarush.task.task35.task3507;

import java.io.*;
import java.lang.reflect.Constructor;
import java.lang.reflect.Modifier;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashSet;
import java.util.Set;

/* 
ClassLoader - что это такое?
*/
public class Solution {
    public static void main(String[] args) throws IOException, ClassNotFoundException, InstantiationException, IllegalAccessException {
        //Set<? extends Animal> allAnimals = getAllAnimals(Solution.class.getProtectionDomain().getCodeSource().getLocation().getPath() + Solution.class.getPackage().getName().replaceAll("[.]", "/") + "/data");
        Set<? extends Animal> allAnimals = getAllAnimals("D:" + "\\data");
        System.out.println(allAnimals);
    }

    public static Set<? extends Animal> getAllAnimals(String pathToAnimals) throws IOException, ClassNotFoundException, IllegalAccessException, InstantiationException {

        Set<Animal> set = new HashSet<>();

        if (!pathToAnimals.endsWith("\\") && !pathToAnimals.endsWith("/"))
            pathToAnimals += "/";

        File file = new File(pathToAnimals);

        String[] modules = file.list(new FilenameFilter() {
            @Override
            public boolean accept(File dir, String name) {
                return name.toLowerCase().endsWith(".class");
            }
        });


        for (String string : modules) {

            String finalPathToAnimal = pathToAnimals;

            SimpleClassLoader classLoader = new SimpleClassLoader(ClassLoader.getSystemClassLoader(), finalPathToAnimal);
            Class clazz = classLoader.loadClass(string.substring(0, string.length() - 6));
            Class[] interfaces = clazz.getInterfaces();

            for (Class i: interfaces) {
                if (i.equals(Animal.class)) {
                    Constructor[] constructors = clazz.getConstructors();
                    for (Constructor c : constructors) {
                        if (!Modifier.isAbstract(clazz.getModifiers()) && Modifier.isPublic(c.getModifiers()) && c.getParameterTypes().length == 0) {
                            set.add((Animal) clazz.newInstance());
                        }
                    }
                }
            }
        }

        return set;
    }

    public static class SimpleClassLoader extends ClassLoader {

        private String pathToDir;

        public SimpleClassLoader(ClassLoader parent, String pathToDir) {
            super(parent);
            this.pathToDir = pathToDir;
        }

        public byte[] getArrayByteInsideFromFS(String path) throws IOException {

            return Files.readAllBytes(Paths.get(path));
        }

        @Override
        protected Class<?> findClass(String name) throws ClassNotFoundException {

            try {
                byte[] bytes = getArrayByteInsideFromFS(pathToDir + name + ".class");
                return defineClass(null, bytes, 0, bytes.length);
            }catch (Exception e) {
                return super.findClass(name);
            }

        }
    }
}
