package com.javarush.task.task36.task3602;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Collections;
import java.util.List;

/* 
Найти класс по описанию
*/
public class Solution {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException {
        System.out.println(getExpectedClass());
    }

    public static Class getExpectedClass() throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException {
        Class result = null;
        Class[] classes = Collections.class.getDeclaredClasses();
        for (Class clazz : classes) {

            if (Modifier.isPrivate(clazz.getModifiers()) && Modifier.isStatic(clazz.getModifiers())) {
                if (List.class.isAssignableFrom(clazz)){

                    if (clazz.getSimpleName().contains("List")) {

                        try {
                            Constructor constructor = clazz.getDeclaredConstructor();
                            constructor.setAccessible(true);

                            List list = (List) constructor.newInstance();
                            list.get(0);
                        }catch (IndexOutOfBoundsException e) {
                            return clazz;
                        }catch (Exception e) {
                            continue;
                        }

                    }

                }
            }
        }


        return result;
    }
}
