package com.javarush.task.task27.task2712.kitchen;

/**
 * Created by a.zinov on 12.04.2017.
 */
public enum Dish {

    Fish(25),
    Steak(30),
    Soup(15),
    Juice(5),
    Water(3);

    private int duration;

    Dish(int duration) {
        this.duration = duration;
    }

    public static String allDishesToString() {
        StringBuffer stringBuffer = new StringBuffer();
        for (Dish dish : Dish.values()) {
            stringBuffer.append(dish.toString());
            stringBuffer.append("\n");
        }

        return new String(stringBuffer);
    }

    public int getDuration() {
        return duration;
    }
}
