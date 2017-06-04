package com.javarush.task.task38.task3802;

/* 
Проверяемые исключения (checked exception)
*/

import java.text.SimpleDateFormat;

public class VeryComplexClass {
    public void veryComplexMethod() throws Exception {

        String s = "12.11.2017";
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat();
        simpleDateFormat.parse(s);
        //напишите тут ваш код
    }

    public static void main(String[] args) {

    }
}
