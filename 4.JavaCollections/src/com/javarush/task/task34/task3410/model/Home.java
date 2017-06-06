package com.javarush.task.task34.task3410.model;

import java.awt.*;

/**
 * Created by Aleksandr on 06.06.2017.
 */
public class Home extends GameObject {

    public Home(int x, int y) {
        super(x, y, 2, 2);
    }

    @Override
    public void draw(Graphics graphics) {
        graphics.drawOval(getX(), getY(), getWidth(), getHeight());
        graphics.setColor(Color.red);
    }
}
