package com.javarush.task.task27.task2712;

import com.javarush.task.task27.task2712.kitchen.Dish;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by a.zinov on 12.04.2017.
 */
public class ConsoleHelper {

    private static BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

    public static void writeMessage(String message) {
        System.out.println(message);
    }

    public static String readString() throws IOException {

        return bufferedReader.readLine();

    }

    public static List<Dish> getAllDishesForOrder() throws IOException {

        List<Dish> dishList = new ArrayList<>();

        ConsoleHelper.writeMessage(Dish.allDishesToString());

        while (true) {
            String stringOrder = readString();

            if (stringOrder.equals("exit")) break;

            try {
                Dish dish = Dish.valueOf(stringOrder);
                dishList.add(dish);
            }catch (IllegalArgumentException e){
                writeMessage("Такого блюда нет!");
            }
        }

        return dishList;
    }
}
