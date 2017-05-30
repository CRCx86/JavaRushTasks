package com.javarush.task.task37.task3712;

/**
 * Created by a.zinov on 25.05.2017.
 */
public abstract class Game {

    public abstract void prepareForTheGame();

    public abstract void playGame();

    public abstract void congratulateWinner();

    public void run() {
        prepareForTheGame();
        playGame();
        congratulateWinner();
    }

}
