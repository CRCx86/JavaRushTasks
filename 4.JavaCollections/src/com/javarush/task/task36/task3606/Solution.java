package com.javarush.task.task36.task3606;

import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Modifier;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

/* 
Осваиваем ClassLoader и Reflection
*/
public class Solution {
    private List<Class> hiddenClasses = new ArrayList<>();
    private String packageName;

    public Solution(String packageName) {
        this.packageName = packageName;
    }

    public static void main(String[] args) throws ClassNotFoundException {
        Solution solution = new Solution(Solution.class.getProtectionDomain().getCodeSource().getLocation().getPath() + "com/javarush/task/task36/task3606/data/second");
        solution.scanFileSystem();
        System.out.println(solution.getHiddenClassObjectByKey("hiddenclassimplse"));
        System.out.println(solution.getHiddenClassObjectByKey("hiddenclassimplf"));
        System.out.println(solution.getHiddenClassObjectByKey("packa"));
    }

    public void scanFileSystem() throws ClassNotFoundException {

        File file = new File(packageName);
        String[] modules = file.list();

        for (String string : modules) {

            final String pathToFile = packageName + File.separator;
            SimpleClassLoader simpleClassLoader = new SimpleClassLoader(pathToFile);
            Class clazz = simpleClassLoader.loadClass(string.substring(0, string.lastIndexOf(".")));
            if (HiddenClass.class.isAssignableFrom(clazz)) {
                hiddenClasses.add(clazz);
            }

        }

    }

    public HiddenClass getHiddenClassObjectByKey(String key) {

        for (Class clazz : hiddenClasses) {
            if (clazz.getSimpleName().toLowerCase().startsWith(key.toLowerCase())) {
                Constructor[] constructors = clazz.getDeclaredConstructors();
                for (Constructor constructor : constructors) {
                    if (constructor.getParameterTypes().length == 0) {
                        try {
                            constructor.setAccessible(true);
                            return (HiddenClass) constructor.newInstance(null);
                        } catch (InstantiationException e) {

                        } catch (IllegalAccessException e) {

                        } catch (InvocationTargetException e) {

                        }
                    }
                }
            }
        }

        return null;
    }

    public static class SimpleClassLoader extends ClassLoader {

        private String pathToDir;

        public SimpleClassLoader(String pathToDir) {
            super();
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

