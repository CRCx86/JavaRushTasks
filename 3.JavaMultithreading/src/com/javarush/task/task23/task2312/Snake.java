package com.javarush.task.task23.task2312;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by a.zinov on 07.03.2017.
 */
public class Snake {

    private List<SnakeSection> sections;
    private boolean isAlive;
    private SnakeDirection direction;

    public Snake(int x, int y) {
        sections = new ArrayList<>();
        sections.add(new SnakeSection(x, y));
        this.isAlive = true;
    }

    public void setDirection(SnakeDirection direction) {

        this.direction = direction;
    }

    public List<SnakeSection> getSections() {

        return sections;
    }

    public boolean isAlive() {
        return isAlive;
    }

    public SnakeDirection getDirection() {
        return direction;
    }

    public int getX() {
        return sections.get(0).getX();
    }

    public int getY() {
        return sections.get(0).getY();
    }

    public void move() {
        if (!isAlive) return;

        if (direction == SnakeDirection.UP) {
            move(0, -1);
        }else if (direction == SnakeDirection.DOWN) {
            move(0, 1);
        }else if(direction == SnakeDirection.LEFT) {
            move(-1, 0);
        }else if (direction == SnakeDirection.RIGHT) {
            move(1, 0);
        }
    }

    public void move(int dx, int dy) {

        SnakeSection section = new SnakeSection(getX() + dx, getY() + dy);
        checkBorders(section);
        if (!isAlive) return;
        checkBody(section);
        if (!isAlive) return;

        if (Room.game.getMouse().getX() == getX()
                && Room.game.getMouse().getY() == getY()) {
            sections.add(0, section);
            Room.game.eatMouse();
        }else {
            sections.add(0, section);
            sections.remove(sections.size() - 1);
        }

    }

    public void checkBorders(SnakeSection head) {

        if ((head.getX() < 0 || head.getX() >= Room.game.getWidth()) || head.getY() < 0 || head.getY() >= Room.game.getHeight()) {
            isAlive = false;
        }
    }

    public void checkBody(SnakeSection head) {
        if (getSections().contains(head)) {
            isAlive = false;
        }
    }
}
