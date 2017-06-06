package com.javarush.task.task34.task3410.model;

import com.javarush.task.task34.task3410.controller.EventListener;

import javax.mail.search.SearchTerm;
import javax.swing.*;
import java.io.File;
import java.nio.file.Paths;
import java.util.Set;

/**
 * Created by a.zinov on 05.06.2017.
 */
public class Model {

    public static int FIELD_CELL_SIZE = 20;

    private EventListener eventListener;

    private GameObjects gameObjects;

    private int currentLevel = 1;

    LevelLoader levelLoader = new LevelLoader(Paths.get("./src/"
            + this.getClass().getPackage().getName().replaceAll("\\.", File.pathSeparator) + "/levels.txt"));

    public void setEventListener(EventListener eventListener) {
        this.eventListener = eventListener;
    }

    public GameObjects  getGameObjects() {
        return gameObjects;
    }

    public void restartLevel(int level) {
        gameObjects = levelLoader.getLevel(level);
    }

    public void restart() {
        restartLevel(currentLevel);
    }

    public void startNextLevel() {
        restartLevel(++currentLevel);
    }

    public void move(Direction direction) {

        Player player = getGameObjects().getPlayer();

        if (checkWallCollision(player, direction))
            return;

        if (checkBoxCollisionAndMoveIfAvaliable(direction))
            return;

        switch (direction) {
            case LEFT: player.move(- FIELD_CELL_SIZE, 0);
            break;
            case RIGHT: player.move(+ FIELD_CELL_SIZE, 0);
            break;
            case DOWN: player.move(0, + FIELD_CELL_SIZE);
            break;
            case UP: player.move(0, - FIELD_CELL_SIZE);
            break;
        }


        checkCompletion();

    }

    public boolean checkWallCollision(CollisionObject gameObject, Direction direction) {
        for (Wall wall : gameObjects.getWalls()) {
            if (gameObject.isCollision(wall, direction))
                return true;
        }

        return false;
    }

    public boolean checkBoxCollisionAndMoveIfAvaliable(Direction direction) {

        Set<Box> boxes = getGameObjects().getBoxes();
        Player player = getGameObjects().getPlayer();

        boolean isMove = true;
        Box isBox = null;
        for (Box box : boxes) {
            if (player.isCollision(box, direction)) {
                isBox = box;
            }
        }

        if (isBox == null) {
            return false;
        }

        if (checkWallCollision(isBox, direction))
            return true;

        for (Box box : boxes){
            if (isBox.isCollision(box, direction)){
                return true;
            }
        }

        switch (direction) {
            case LEFT: isBox.move(- FIELD_CELL_SIZE, 0);
                break;
            case RIGHT: isBox.move(+ FIELD_CELL_SIZE, 0);
                break;
            case DOWN: isBox.move(0, + FIELD_CELL_SIZE);
                break;
            case UP: isBox.move(0, - FIELD_CELL_SIZE);
                break;
        }


        return false;
    }

    public void checkCompletion() {

        boolean isComplete = false;
        for (Home home : getGameObjects().getHomes()) {
            boolean isDone = false;
            for (Box box : getGameObjects().getBoxes()) {
                if (home.getX() == box.getX() && home.getY() == box.getY())
                    isDone = true;
            }

            if (isDone)
                isComplete = true;
        }

        if (isComplete){
            eventListener.levelCompleted(currentLevel);
        }
    }

}
