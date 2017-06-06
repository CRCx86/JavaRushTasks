package com.javarush.task.task34.task3410.controller;

import com.javarush.task.task34.task3410.model.Direction;

/**
 * Created by Aleksandr on 06.06.2017.
 */
public interface EventListener {

    void move(Direction direction);
    void restart();
    void startNextLevel();
    void levelCompleted(int level);

}
