package com.javarush.task.task30.task3008;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by Aleksandr on 23.03.2017.
 *
 *
 * ConsoleHelper – вспомогательный класс, для чтения или записи в консоль
 Объяви эти классы.
 *
 *
 */
public class ConsoleHelper {

    private static BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

    // статический метод writeMessage(String message), который должен выводить сообщение message в консоль
    public static void writeMessage(String message) {
        System.out.println(message);
    }

    // метод String readString(), который должен считывать строку с консоли.
    public static String readString() {

        String string = "";
        boolean isRead = false;

        do{
            try {
                string = bufferedReader.readLine();
                isRead = true;
            }catch (IOException e) {
                System.out.println("Произошла ошибка при попытке ввода текста. Попробуйте еще раз.");
            }

        }while (!isRead);

        return string;
    }

    // метод int readInt() должен возвращать введенное число и использовать метод readString().
    public static int readInt() {

        Integer integer = 0;
        boolean isRead = false;

        do{

            try{
                integer = Integer.parseInt(readString());
                isRead = true;
            }catch (NumberFormatException e) {
                System.out.println("Произошла ошибка при попытке ввода числа. Попробуйте еще раз.");
            }

        }while (!isRead);

        return integer;

    }

}
