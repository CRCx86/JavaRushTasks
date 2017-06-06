package com.javarush.task.task34.task3410.model;

import java.awt.*;

/**
 * Created by a.zinov on 05.06.2017.
 */
public abstract class CollisionObject extends GameObject {

    public CollisionObject(int x, int y) {
        super(x, y);
    }

    @Override
    public void draw(Graphics graphics) {

    }

    public boolean isCollision(GameObject gameObject, Direction direction){

        boolean result = false;

        switch (direction) {
            case UP: if (getX() == gameObject.getX() && getY() - Model.FIELD_CELL_SIZE == gameObject.getY())
                result = true;
                break;
            case DOWN: if (getX() == gameObject.getX() && getY() + Model.FIELD_CELL_SIZE == gameObject.getY())
                result = true;
                break;
            case LEFT: if (getX() - Model.FIELD_CELL_SIZE == gameObject.getX() && getY() == gameObject.getY())
                result = true;
                break;
            case RIGHT: if (getX() + Model.FIELD_CELL_SIZE == gameObject.getX() && getY() == gameObject.getY())
                result = true;
                break;
        }

        return result;
    }
}
