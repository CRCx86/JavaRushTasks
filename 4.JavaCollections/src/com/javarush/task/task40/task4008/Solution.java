package com.javarush.task.task40.task4008;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoField;
import java.time.temporal.WeekFields;
import java.util.Locale;

/* 
Работа с Java 8 DateTime API
*/

public class Solution {
    public static void main(String[] args) {
        printDate("21.4.2014 15:56:45");
        System.out.println();
        printDate("21.4.2014");
        System.out.println();
        printDate("17:33:40");
    }

    public static void printDate(String date) {
        //напишите тут ваш код

        if (date == null || date.length() == 0)
            return;

        DateTimeFormatter formatter1 = DateTimeFormatter.ofPattern("d.M.y");
        DateTimeFormatter formatter2 = DateTimeFormatter.ofPattern("d.M.y H:m:s");
        DateTimeFormatter formatter3 = DateTimeFormatter.ofPattern("H:m:s");

        boolean isDate = false;
        boolean isTime = false;

        LocalDate localDate = null;
        LocalTime localTime = null;

        try {

            if (date.length() < 10) {
                localDate = LocalDate.parse(date, formatter1);
                isDate = true;
                isTime = false;
            }else {
                String[] dateTime = date.split(" ");
                localDate = LocalDate.parse(dateTime[0], formatter1);
                localTime = LocalTime.parse(dateTime[1], formatter3);
                isDate = true;
                isTime = true;
            }


        }catch (Exception e) {

            localTime = LocalTime.parse(date, formatter3);
            isDate = false;
            isTime = true;

        }

        if (isDate) {
            System.out.println("День: " + localDate.getDayOfMonth());
            System.out.println("День недели: " + localDate.getDayOfWeek().getValue());
            System.out.println("День месяца: " + localDate.getDayOfMonth());
            System.out.println("День года: " + localDate.getDayOfYear());
            System.out.println("Неделя месяца: " + localDate.get(WeekFields.of(Locale.getDefault()).weekOfMonth()));
            System.out.println("Неделя года: " + localDate.get(WeekFields.of(Locale.getDefault()).weekOfYear()));
            System.out.println("Месяц: " + localDate.getMonthValue());
            System.out.println("Год: " + localDate.getYear());
        }

        if (isTime) {
            System.out.println("AM или PM: " + (localTime.get(ChronoField.AMPM_OF_DAY) == 1 ? "PM" : "AM"));
            System.out.println("Часы: " + (localTime.get(ChronoField.CLOCK_HOUR_OF_AMPM)));
            System.out.println("Часы дня: " + localTime.getHour());
            System.out.println("Минуты: " + localTime.getMinute());
            System.out.println("Секунды: " + localTime.getSecond());
        }

    }
}
