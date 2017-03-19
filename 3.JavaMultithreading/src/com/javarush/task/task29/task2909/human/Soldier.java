package com.javarush.task.task29.task2909.human;

/**
 * Created by Aleksandr on 12.03.2017.
 */
public class Soldier extends Human {

    public static int nextId = 0;
    private int id;
    protected int age;
    protected String name;

    public Soldier(String name, int age) {
        super(name, age);
        this.age = age;
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public static int getNextId() {
        return nextId;
    }

    public static void setNextId(int nextId) {
        Soldier.nextId = nextId;
    }

    protected int[] size;

    public void live() {
        fight();
    }

    public void fight() {
    }



    public void printSize() {
        System.out.println("Рост: " + size[0] + " Вес: " + size[1]);
    }
}
