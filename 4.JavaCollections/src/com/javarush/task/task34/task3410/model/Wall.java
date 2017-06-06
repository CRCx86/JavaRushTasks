package com.javarush.task.task34.task3410.model;

import java.awt.*;

/**
 * Created by Aleksandr on 06.06.2017.
 */
public class Wall extends CollisionObject {

    public Wall(int x, int y) {
        super(x, y);
    }

    @Override
    public void draw(Graphics graphics) {
        graphics.drawRect(getX(), getY(), getWidth(), getHeight());
        graphics.setColor(Color.BLUE);
    }
}
