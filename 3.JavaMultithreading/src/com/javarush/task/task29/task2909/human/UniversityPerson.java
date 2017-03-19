package com.javarush.task.task29.task2909.human;

/**
 * Created by Aleksandr on 12.03.2017.
 */
public class UniversityPerson extends Human{

    private University university;
    protected int age;
    protected String name;

    public University getUniversity() {
        return university;
    }

    public void setUniversity(University university) {
        this.university = university;
    }

    public UniversityPerson(String name, int age) {
        super(name, age);
        this.name = name;
        this.age = age;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
