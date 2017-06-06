package com.javarush.task.task34.task3410.model;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by Aleksandr on 06.06.2017.
 */
public class GameObjects {

    private Set<Wall> walls;
    private Set<Box> boxes;
    private Set<Home> homes;
    private Player player;

    public GameObjects(Set<Wall> walls, Set<Box> boxes, Set<Home> homes, Player player) {
        this.walls = walls;
        this.boxes = boxes;
        this.homes = homes;
        this.player = player;
    }

    public Set<Wall> getWalls() {
        return walls;
    }

    public Set<Box> getBoxes() {
        return boxes;
    }

    public Set<Home> getHomes() {
        return homes;
    }

    public Player getPlayer() {
        return player;
    }

    public Set<GameObject> getAll() {

        Set<GameObject> gameObjects = new HashSet<>();

        for (Wall wall : walls) {
            gameObjects.add(wall);
        }

        for (Box box : boxes) {
            gameObjects.add(box);
        }

        for (Home home : homes) {
            gameObjects.add(home);
        }

        gameObjects.add(player);

        return gameObjects;
    }
}
