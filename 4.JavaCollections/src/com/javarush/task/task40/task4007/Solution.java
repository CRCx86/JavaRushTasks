package com.javarush.task.task40.task4007;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/* 
Работа с датами
*/

public class Solution {
    public static void main(String[] args) throws ParseException {
        printDate("4.6.2017 15:56:45");
        System.out.println();
        printDate("21.4.2014");
        System.out.println();
        printDate("17:33:40");
    }

    public static void printDate(String date) throws ParseException {

        if (date == null || date.length() == 0)
            return;
        //напишите тут ваш код
        Calendar calendar = Calendar.getInstance();

        SimpleDateFormat simpleDateFormat2 = new SimpleDateFormat("dd.MM.yy HH:mm:ss");
        SimpleDateFormat simpleDateFormat1 = new SimpleDateFormat("dd.MM.yy");
        SimpleDateFormat simpleDateFormat3 = new SimpleDateFormat("HH:mm:ss");

        Date d = null;
        boolean isDate = false;
        boolean isTime = false;
        try {

            if (date.length() < 10) {
                d = simpleDateFormat1.parse(date);
                isDate = true;
                isTime = false;
            }else {
                d = simpleDateFormat2.parse(date);
                isDate = true;
                isTime = true;
            }

        } catch (Exception e) {

            d = simpleDateFormat3.parse(date);
            isDate = false;
            isTime = true;

        }

        calendar.setTime(d);
        if (isDate) {
            System.out.println("День: " + calendar.get(Calendar.DATE));
            System.out.println("День недели: " + ((calendar.get(Calendar.DAY_OF_WEEK) - 1 == 0) ? 7 : (calendar.get(Calendar.DAY_OF_WEEK) - 1)));
            System.out.println("День месяца: " + calendar.get(Calendar.DAY_OF_MONTH));
            System.out.println("День года: " + calendar.get(Calendar.DAY_OF_YEAR));
            System.out.println("Неделя месяца: " + calendar.get(Calendar.WEEK_OF_MONTH));
            System.out.println("Неделя года: " + calendar.get(Calendar.WEEK_OF_YEAR));
            System.out.println("Месяц: " + (calendar.get(Calendar.MONTH) + 1));
            System.out.println("Год: " + calendar.get(Calendar.YEAR));
        }

        if (isTime) {
            System.out.println("AM или PM: " + (calendar.get(Calendar.AM_PM) == 0 ? "AM" : "PM"));
            System.out.println("Часы: " + calendar.get(Calendar.HOUR));
            System.out.println("Часы дня: " + calendar.get(Calendar.HOUR_OF_DAY));
            System.out.println("Минуты: " + calendar.get(Calendar.MINUTE));
            System.out.println("Секунды: " + calendar.get(Calendar.SECOND));
        }
    }
}
