package com.javarush.task.task27.task2712;


import com.javarush.task.task27.task2712.ad.AdvertisementManager;
import com.javarush.task.task27.task2712.ad.NoVideoAvailableException;
import com.javarush.task.task27.task2712.kitchen.Order;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Created by a.zinov on 12.04.2017.
 */
public class Tablet extends java.util.Observable{

    private final int number;

    private static Logger logger = Logger.getLogger(Tablet.class.getName());

    public Tablet(int number) {
        this.number = number;
    }

    public Order createOrder() {

        Order order = null;

        try {
            order = new Order(this);
            if (!order.isEmpty()) {

                ConsoleHelper.writeMessage(order.toString());
                setChanged();
                notifyObservers(order);

                AdvertisementManager advertisementManager = new AdvertisementManager(order.getTotalCookingTime());
                try {
                    advertisementManager.processVideos();
                }catch (NoVideoAvailableException e) {
                    logger.log(Level.INFO, "No video is available for the order " + order);
                }
            }
        }catch (IOException e) {
            logger.log(Level.SEVERE, "Console is unavailable.");
        }

        return order;
    }

    @Override
    public String toString() {
        return "Tablet{" +
                "number=" + number +
                '}';
    }


}
