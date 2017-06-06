package com.javarush.task.task34.task3410.model;

import java.nio.file.Path;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by Aleksandr on 06.06.2017.
 */
public class LevelLoader {

    private Path levels;

    public LevelLoader(Path levels) {
        this.levels = levels;
    }

    public GameObjects getLevel(int level) {



        Set<Wall> wallSet = new HashSet<>();
        wallSet.add(new Wall(20, 20));
        wallSet.add(new Wall(60, 60));

        Set<Box> boxSet = new HashSet<>();
        boxSet.add(new Box(40, 40));

        Set<Home> homeSet = new HashSet<>();
        homeSet.add(new Home(20, 40));

        Player player = new Player(40, 20);

        return new GameObjects(wallSet, boxSet, homeSet, player);
    }
}
