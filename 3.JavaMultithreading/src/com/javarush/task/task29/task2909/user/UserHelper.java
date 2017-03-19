package com.javarush.task.task29.task2909.user;

import java.util.concurrent.atomic.AtomicInteger;

public class UserHelper extends User {
    private User userAnya = new User("Аня", "Смирнова", 10);
    private User userRoma = new User("Рома", "Виноградов", 30);

    private boolean isManAnya = false;
    private boolean isManRoma = true;

    public UserHelper(String name, String surname, int age) {
        super(name, surname, age);
    }

    public void printUsers() {
        userAnya.printInfo();
        userRoma.printInfo();

    }

    public int calculateAvarageAge() {
        int age = 28;
        User userUra = new User("Юра", "Карп", age);

        return (userAnya.getAge() + userRoma.getAge() + userUra.getAge()) / 3;
    }

    public int calculateRate(AtomicInteger base, int age, boolean hasWork, boolean hasHouse) {
        int result = (int)base.doubleValue();
        result += age / 100;
        result *= hasWork ? 1.1 : 0.9;
        result *= hasHouse ? 1.1 : 0.9;
        return (int)result;
    }

    public String getBossName(User user) {
        Work work = user.getWork();
        return work.getBoss();
    }
}