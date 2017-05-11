package com.javarush.task.task32.task3206;

import java.lang.reflect.Proxy;

/*
Дженерики для создания прокси-объекта
*/
public class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();
        test(solution.getProxy(Item.class));                        //true false false
        test(solution.getProxy(Item.class, Small.class));           //true false true
        test(solution.getProxy(Item.class, Big.class, Small.class));//true true true
        test(solution.getProxy(Big.class, Small.class));            //true true true т.к. Big наследуется от Item
        test(solution.getProxy(Big.class));                         //true true false т.к. Big наследуется от Item
    }

    public  <T extends Item> T getProxy(Class <T> itemClass, Class<?> ... classes) {

        ClassLoader classLoader = itemClass.getClassLoader();
        Class<?>[] addInInterfaces = new Class[classes.length + 1];
        addInInterfaces[0] = itemClass;
        System.arraycopy(classes, 0, addInInterfaces, 1, classes.length);

        ItemInvocationHandler itemInvocationHandler = new ItemInvocationHandler();

        return (T) Proxy.newProxyInstance(classLoader, addInInterfaces, itemInvocationHandler);

    }


    private static void test(Object proxy) {
        boolean isItem = proxy instanceof Item;
        boolean isBig = proxy instanceof Big;
        boolean isSmall = proxy instanceof Small;

        System.out.format("%b %b %b\n", isItem, isBig, isSmall);
    }
}