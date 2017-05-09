package com.javarush.task.task27.task2712.kitchen;

import com.javarush.task.task27.task2712.ConsoleHelper;
import com.javarush.task.task27.task2712.Tablet;

import java.io.IOException;
import java.util.List;

/**
 * Created by a.zinov on 12.04.2017.
 */
public class Order {

    private final Tablet tablet;
    protected List<Dish> dishes;

    public Order(Tablet tablet) throws IOException {
        this.tablet = tablet;
        dishes = ConsoleHelper.getAllDishesForOrder();
    }

    @Override
    public String toString() {

        if (dishes.size() > 0) {
            return "Order{" +
                    "tablet=" + tablet +
                    ", dishes=" + dishes +
                    '}';
        } else {
            return "";
        }

    }

    public int getTotalCookingTime() {

        int sum = 0;
        for (Dish dish : dishes) {
            sum += dish.getDuration();
        }

        return sum;
    }

    public boolean isEmpty() {

        return dishes.isEmpty();

    }

    public List<Dish> getDishes() {
        return dishes;
    }

    public Tablet getTablet() {
        return tablet;
    }
}
